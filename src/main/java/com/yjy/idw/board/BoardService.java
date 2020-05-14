package com.yjy.idw.board;


import java.util.List;
import com.yjy.idw.board.BoardVO;
import com.yjy.idw.comment.CommentVO;

public interface BoardService {

	void insertBoard(BoardVO vo);


	void updateBoard(BoardVO vo);


	void deleteBoard(BoardVO vo);


	BoardVO getBoard(BoardVO vo);


	List<BoardVO> getBoardList(BoardVO vo);
	
	List<CommentVO> getCommentList(BoardVO vo);

}