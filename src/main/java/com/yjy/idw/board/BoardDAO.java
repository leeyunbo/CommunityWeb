package com.yjy.idw.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yjy.idw.comment.CommentVO;
import com.yjy.idw.common.JDBCUtil;


@Repository("boardDAO")
public class BoardDAO {
	// JDBC 관련 변수 
	private Connection conn = null; 
	private PreparedStatement stmt = null; 
	private ResultSet rs = null;

	//SQL 명령어 
	private final String BOARD_INSERT = 
			"insert into board(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE =
			"update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = 
			"delete board where seq=?";
	private final String BOARD_GET = 
			"select * from board where seq=?";
	private final String BOARD_LIST_T = 
			"select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C =
			"select * from board where content like '%'||?||'%' order by seq desc";
	private final String COMMENT_GET_LIST = 
			"select * from comment where board_seq=?";
	
	//CRUD 메소드 구현 
	//글 등록 
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	//글 수정 
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	//글 삭제 
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}

	//글 상세 조회 
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		BoardVO board = vo; 
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, board.getSeq());
			rs = stmt.executeQuery(); 
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn); 
		}
		return board; 
	}

	//글 목록 조회 
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList = new ArrayList<>();
		try {
			conn = JDBCUtil.getConnection();
			if(vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BOARD_LIST_T);
			} else if(vo.getSearchCondition().equals("CONTENT")) {
				stmt = conn.prepareStatement(BOARD_LIST_C);
			}
			stmt.setString(1, vo.getSearchKeyword());
			rs = stmt.executeQuery(); 
			while(rs.next()) {
				BoardVO board = new BoardVO(); 
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
	
	//댓글 목록 조회 
	public List<CommentVO> getCommentList(BoardVO vo) {
		System.out.println("===> JDBC로 getCommentList() 기능 처리"); 
		List<CommentVO> commentList = new ArrayList<>(); 
		try {
			conn = JDBCUtil.getConnection(); 
			stmt = conn.prepareStatement(COMMENT_GET_LIST);
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
}