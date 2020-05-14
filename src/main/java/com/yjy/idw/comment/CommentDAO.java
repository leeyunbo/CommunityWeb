package com.yjy.idw.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yjy.idw.board.BoardVO;
import com.yjy.idw.common.JDBCUtil;

public class CommentDAO {
	
	// JDBC 관련 변수 
		private Connection conn = null; 
		private PreparedStatement stmt = null; 
		private ResultSet rs = null;

	// 쿼리 문
	private final String COMMENT_INSERT =
			"insert into comment(seq,writer,content,board_seq)"
			+ " values((select nvl(max(seq),0)+1 from comment),?,?,?)";
	private final String COMMENT_GET_LIST = 
			"select * from comment where board_seq=?";
	private final String COMMENT_DELETE = 
			"delete comment where seq=?";
	
	//댓글 등록 
	public void insertComment(CommentVO vo) {
		System.out.println("===> JDBC로 insertComment() 기능 처리"); 
		try {
			conn = JDBCUtil.getConnection(); 
			stmt = conn.prepareStatement(COMMENT_INSERT);
			stmt.setString(1, vo.getWriter());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getBoard_seq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	//댓글 목록 조회 
	public List<CommentVO> getCommentList(BoardVO vo) {
		System.out.println("===> JDBC로 getCommentList() 기능 처리"); 
		List<CommentVO> commentList = new ArrayList<>(); 
		try {
			conn = JDBCUtil.getConnection(); 
			stmt.setInt(1, vo.getSeq()); 
			rs = stmt.executeQuery(); 
			while(rs.next()) {
				CommentVO comment = new CommentVO(); 
				comment.setSeq(rs.getInt("SEQ"));
				comment.setWriter(rs.getString("WRITER"));
				comment.setContent(rs.getString("CONTENT")); 
				comment.setRegDate(rs.getDate("REGDATE"));
				comment.setCnt(rs.getInt("CNT"));
				comment.setBoard_seq(rs.getInt("BOARD_SEQ"));
				commentList.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return commentList;  
	}
	
	//댓글 삭제 
	public void deleteComment(CommentVO vo) {
		System.out.println("===> JDBC로 deleteComment() 기능 처리"); 
		try {
			conn = JDBCUtil.getConnection(); 
			stmt = conn.prepareStatement(COMMENT_DELETE); 
			stmt.setInt(1, vo.getSeq()); 
			stmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
}
