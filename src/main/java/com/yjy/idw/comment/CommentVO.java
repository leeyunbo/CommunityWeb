package com.yjy.idw.comment;

import java.sql.Date;

public class CommentVO {
	private int seq;
	private String writer; 
	private String content; 
	private Date regDate; 
	private int cnt;
	private int board_seq; 
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	@Override 
	public String toString() {
		return "[" + seq + "," + board_seq + "," + content + "," + writer + "]";
	}
}
