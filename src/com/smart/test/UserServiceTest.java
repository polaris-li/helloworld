package com.smart.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.annotation.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.springframework.context.support.StaticApplicationContext; 

//@ContextConfiguration("classpath*:/smart-context.xml")
public class UserServiceTest {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public static void main(String [] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "smart-context.xml" });
		UserService userSer = (UserService)context.getBean("userService");
		
	}
	
	
	public void hasMatchUser() {
		boolean b1 = userService.hasMatchUser("admin", "123456");
		boolean b2 = userService.hasMatchUser("admin", "111");
		
		assertTrue(b1);
		assertTrue(b2);
	}
	
	
	public void findUserByUserName() {
		User user = userService.findUserByUserName("admin");
		assertEquals(user.getUserName(),"admin");
	}
	
	
}
