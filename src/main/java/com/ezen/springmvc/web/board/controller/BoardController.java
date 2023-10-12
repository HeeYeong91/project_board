package com.ezen.springmvc.web.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.service.ArticleService;
import com.ezen.springmvc.domain.board.service.BoardService;
import com.ezen.springmvc.domain.common.web.PageParams;
import com.ezen.springmvc.domain.common.web.Pagination;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 게시판 세부 컨트롤러 (2023-08-18 ~ 2023-08-21)
 * @author 이희영
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private final ArticleService articleService;
	private final BoardService boardService;
	
	private static final int ELEMENT_SIZE = 5;
	private static final int PAGE_SIZE = 5;
	
	// 공통 데이터(게시판 정보) Model에 담아 모든 메소드에 전달
	@ModelAttribute("board")
	public BoardDTO list(@PathVariable int id, Model model) {
		BoardDTO board = boardService.read(id);
		model.addAttribute("board", board);
		return board;
	}
	
	// 게시판 화면
	@GetMapping("/{id}")
	public String boardList(@PathVariable int id, @PathParam("page") String page, @PathParam("keyword") String keyword, Model model) {
//		ModelAttribute를 이용해 같은 Controller에 있는 모든 메소드에 적용
//		BoardDTO board = boardService.read(id);
//		model.addAttribute("board", board);
		
//		AOP를 이용해 web패키지 하위 모든 Controller에 있는 모든 메소드에 적용
//		List<BoardDTO> list = boardService.findAll();
//		model.addAttribute("list", list);
		
		int count = articleService.getCountAll(id, keyword);
		// log.info("리스트 : {}", count);
		if (page == null || page.equals("")) {
			page = "1";
		}
		
		int selectPage = Integer.parseInt(page);
		PageParams pageParams = PageParams.builder()
										  .elementSize(ELEMENT_SIZE)
										  .pageSize(PAGE_SIZE)
										  .requestPage(selectPage)
										  .rowCount(count)
										  .boardId(id)
										  .keyword(keyword)
										  .build();
		Pagination pagination = new Pagination(pageParams);
		model.addAttribute(pagination);
		List<ArticleDTO> articleList = articleService.findByAll(pageParams);
		// log.info(articleList.toString());
		model.addAttribute("articleList", articleList);
		return "board/list";
	}
	
	// 게시물 쓰기 화면
	@GetMapping("/{id}/register")
	public String register(@PathVariable int id, Model model) {
//		BoardDTO board = boardService.read(id);
//		model.addAttribute("board", board);
		
//		List<BoardDTO> list = boardService.findAll();
//		model.addAttribute("list", list);
		return "board/register";
	}
}