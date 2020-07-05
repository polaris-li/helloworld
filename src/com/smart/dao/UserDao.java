package com.smart.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.smart.domain.User;

@Repository
public class UserDao {
	private JdbcTemplate jdbcTemplate;

	private final static String MATCH_COUNT_SQL = "SELECT count(*) from t_user WHERE user_name = ? and password = ?";
	private final static String FIND_USER_SQL = "SELECT user_id,credits from t_user WHERE user_name = ?";
	private final static String UPDATE_LOGIN_INFO_SQL = "UPDATE t_user SET last_visit = ? ,last_ip = ? ,credits = ? WHERE user_id = ?";
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int getMatchCount(String userName,String password) {

		return (int)jdbcTemplate.queryForObject(MATCH_COUNT_SQL,new Object[] {userName,password},Integer.class);
	
	}
	public User findUserByUserName(String userName) {
		
		User user = new User();
		jdbcTemplate.query(FIND_USER_SQL, new Object[] {userName}, 
				new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						user.setUserId(rs.getInt("user_id"));
						user.setUserName(userName);
						user.setCredits(rs.getInt("credits"));
					}
		});
		
		return user;
	}
	public void updateLoginInfo(User user) {
		jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,new Object[] {user.getLastVisit(),
				user.getLastIp(),user.getCredits(),user.getUserId()}
		);
	}
	

}
