package com.smart.domain;
import java.io.Serializable;
import java.util.Date;
//import org.apache.commons.dbcp.BasicDataSource
public class LoginLog implements Serializable{
	
	private int loginLogId;
	private int userId;
	private String Ip;
	private Date loginDate;
	
	
	public int getLoginLogId() {
		return loginLogId;
	}
	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIp() {
		return Ip;
	}
	public void setIp(String ip) {
		Ip = ip;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	
}
