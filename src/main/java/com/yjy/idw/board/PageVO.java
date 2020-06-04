package com.yjy.idw.board;

public class PageVO {
	private int currentPage; 
	private int pageCnt;
	private int boardStartIndex;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCnt() {
		return pageCnt;
	}
	public void setPageCnt(int boardCnt) {
		if(boardCnt%10 > 0) this.pageCnt = boardCnt / 10 + 1;
		else this.pageCnt = boardCnt / 10;
	}
	public int getBoardStartIndex() {
		return boardStartIndex;
	}
	public void setBoardStartIndex(int boardStartIndex) {
		this.boardStartIndex = boardStartIndex;
	}
	
}
