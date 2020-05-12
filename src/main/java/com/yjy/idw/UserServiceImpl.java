package com.yjy.idw;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO dao; 
	
	@Override
	public UserVO getUser() {
		return dao.getUser();
	}

	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}

}
