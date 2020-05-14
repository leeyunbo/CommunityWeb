package com.yjy.idw.comment;

public interface CommentService {
	//댓글 등록 
	public void insertComment(CommentVO vo); 
	
	//댓글 삭제 
	public void deleteComment(CommentVO vo);

}
