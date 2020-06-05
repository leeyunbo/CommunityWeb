package com.yjy.idw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjy.idw.board.BoardService;
import com.yjy.idw.board.BoardVO;
import com.yjy.idw.board.PageVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/")
	public String getHomepage() {
		return "index";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	  
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model, HttpServletRequest request) {
		if(request.getAttribute("board") != null) vo = (BoardVO) request.getAttribute("board");
		
		model.addAttribute("board", boardService.getBoard(vo));
		model.addAttribute("commentList", boardService.getCommentList(vo));
		return "getBoard";
	}
	
	// @RequestParam(value="searchCondition", defaultValue="TITLE",required=false) String condition
	// @RequestParam(value="searchKeyword", defaultValue="",required=false) String keyword
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, PageVO page, Model model) {
		int boardLastIndex = 0, boardListSize = 0;
			
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		if(page.getCurrentPage() < 1) {
			page.setCurrentPage(1);
			page.setViewFirstPageNumber(1); // 1 ~ 5 출력, 만약 다음을 클릭하면 + 5 할  것  
		}
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		boardListSize = boardList.size();
		page.setPageCnt(boardListSize/10);
		page.setBoardStartIndex((page.getCurrentPage()-1) * 10);
		
		if(page.getBoardStartIndex() + 10 > boardListSize) boardLastIndex = boardListSize;
		else boardLastIndex = page.getBoardStartIndex() + 10;
		
		model.addAttribute("page", page);
		model.addAttribute("boardList", boardList.subList(page.getBoardStartIndex(), boardLastIndex));
		return "getBoardList";
	}
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		boardService.insertBoard(vo); 
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}

	@RequestMapping("/dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo) {
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
}
