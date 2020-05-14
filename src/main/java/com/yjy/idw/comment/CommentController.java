package com.yjy.idw.comment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {
	
	@RequestMapping("/insertComment.do") 
	public String insertComment(CommentVO vo) {
		return "getBoard.do";
	}
	
	@RequestMapping("/deleteComment.do")
	public String deleteComment(CommentVO vo) {
		return "getBoard.do";
	}
	
	
	
}
