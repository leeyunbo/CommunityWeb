package com.yjy.idw.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentService")
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
