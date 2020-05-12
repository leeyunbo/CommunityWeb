package com.yjy.idw;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDAO{
	

	public UserVO getUser() {
		UserVO vo = new UserVO(1, "leeyunbo", "leeyunbo"); 
		return vo; 
	}
	

	public List<UserVO> getUserList() {
		List<UserVO> userList = new ArrayList<>(); 
		userList.add(new UserVO(1, "leeyunbo", "leeyunbo")); 
		userList.add(new UserVO(2, "leeyunbo", "leeyunbo")); 
		userList.add(new UserVO(3, "leeyunbo", "leeyunbo")); 
		return userList;
	}
}
