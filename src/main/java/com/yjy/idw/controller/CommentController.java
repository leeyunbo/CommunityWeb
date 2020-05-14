package com.yjy.idw.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjy.idw.board.BoardVO;
import com.yjy.idw.comment.CommentService;
import com.yjy.idw.comment.CommentVO;

@Controller
public class CommentController {
	@Autowired 
	CommentService service;
	
	/**
	 * comment 추가 후, getBoard.jsp로 이동 
	 * @param commentVO : 추가 할 commentVO
	 * @param boardVO : 추가 할 comment를 가지고 있는 boardVO
	 * @param request : getBoard를 요청할 때, boardVO를 포함하여 Forward로 넘겨주기 위함
	 * @return : 이동 할 화면
	 */
	
	@RequestMapping("/insertComment.do") 
	public String insertComment(CommentVO commentVO, BoardVO boardVO, HttpServletRequest request) {
		commentVO.setBoard_seq(boardVO.getSeq());
		service.insertComment(commentVO);
		request.setAttribute("board", boardVO);
		return "forward:/getBoard.do";
	}
	
	/**
	 * comment 제거 후, getBoard.jsp로 이동 
	 * @param vo 제거 할 commentVO
	 * @param boardVO 제거 할 comment를 가지고 있는 boardVO
	 * @param request getBoard 요청할 때, boardVO를 포함하여 Forward하기 위함
	 * @return 이동 할 화면
	 */
	
	@RequestMapping("/deleteComment.do")
	public String deleteComment(CommentVO vo, BoardVO boardVO, HttpServletRequest request) {
		service.deleteComment(vo);
		request.setAttribute("board", boardVO);
		return "forward:/getBoard.do";
	}
	
	
	
}
