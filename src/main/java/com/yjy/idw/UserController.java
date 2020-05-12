package com.yjy.idw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	UserServiceImpl userService; 
	
	@RequestMapping("/")
	public String printHello() {
		return "Hello";
	}
	
	@RequestMapping("/getUser") 
	public UserVO getUser() {
		return userService.getUser();
	}
	
	@RequestMapping("getUserList") 
	public List<UserVO> getUserList() {
		return userService.getUserList();
	}
}
