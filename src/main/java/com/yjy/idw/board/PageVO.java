package com.yjy.idw.board;

public class PageVO {
	private int currentPage; 
	private int pageCnt;
	private int viewFirstPageNumber;
	private int boardStartIndex;
	private int nextClickCnt;
	private int beforeClickCnt;
	
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
	public int getViewFirstPageNumber() {
		return viewFirstPageNumber;
	}
	public void setViewFirstPageNumber(int viewFirstPageNumber) {
		this.viewFirstPageNumber = viewFirstPageNumber;
	}
	public int getNextClickCnt() {
		return nextClickCnt;
	}
	public void setNextClickCnt(int nextClickCnt) {
		this.nextClickCnt = nextClickCnt;
	}
	public int getBeforeClickCnt() {
		return beforeClickCnt;
	}
	public void setBeforeClickCnt(int beforeClickCnt) {
		this.beforeClickCnt = beforeClickCnt;
	}
	
}
