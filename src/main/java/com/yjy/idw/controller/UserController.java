package com.yjy.idw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yjy.idw.user.UserDAO;
import com.yjy.idw.user.UserVO;

@Controller
public class UserController {
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "login.jsp";
	}
	
	@RequestMapping(value = "/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		if(vo.getId() == null | vo.getId().equals("")) {
			throw new IllegalArgumentException("로그인할 수 없습니다.");
		}
		
		UserVO user = userDAO.getUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}	
	}
	
	@RequestMapping(value = "/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}
}
