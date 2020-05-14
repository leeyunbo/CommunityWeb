package com.yjy.idw.comment;

import org.springframework.beans.factory.annotation.Autowired;

public class CommentServiceImpl implements CommentService {
	@Autowired 
	CommentDAO commentDAO;
	
	@Override
	public void insertComment(CommentVO vo) {
		commentDAO.insertComment(vo);
	}

	@Override
	public void deleteComment(CommentVO vo) {
		commentDAO.deleteComment(vo);
	}

}
