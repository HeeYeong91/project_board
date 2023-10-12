package com.ezen.springmvc.web.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.springmvc.domain.board.dto.ArticleDTO;
import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.service.ArticleService;
import com.ezen.springmvc.domain.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 게시물 세부 컨트롤러 (2023-08-21)
 * @author 이희영
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

	private final ArticleService articleService;
	private final BoardService boardService;
	
	// 공통 데이터(게시판 정보) Model에 담아 모든 메소드에 전달
	@ModelAttribute("board")
	public BoardDTO list(@PathVariable int id, Model model) {
		BoardDTO board = boardService.read(id);
		model.addAttribute("board", board);
		return board;
	}

	// 게시글 등록
	@PostMapping("/{id}")
	public String register(@PathVariable int id, @ModelAttribute ArticleDTO articleDTO, Model model) {
//		BoardDTO board = boardService.read(id);
//		model.addAttribute("board", board);
		
		articleDTO.setBoardId(id);
		// log.info("게시글 테스트 : {}", articleDTO);
		articleService.create(articleDTO);
		return "redirect:/board/{id}";
	}

	// 게시글 읽기
	@GetMapping("/{id}/read/{articleId}")
	public String read(@PathVariable int id, @PathVariable int articleId, Model model) {
//		BoardDTO board = boardService.read(id);
//		model.addAttribute("board", board);
		
//		List<BoardDTO> list = boardService.findAll();
//		model.addAttribute("list", list);
		
		ArticleDTO article = articleService.readArticle(articleId);
		model.addAttribute("article", article);
		return "board/read";
	}

	// 게시글 수정화면
	@GetMapping("/{id}/change/{articleId}")
	public String changeView(@PathVariable int id, @PathVariable int articleId, Model model) {
//		BoardDTO board = boardService.read(id);
//		model.addAttribute("board", board);
		
//		List<BoardDTO> list = boardService.findAll();
//		model.addAttribute("list", list);
		ArticleDTO article = articleService.find(articleId);
		model.addAttribute("article", article);
		return "board/change";
	}

	// 게시글 수정
	@PostMapping("/{id}/update/{articleId}")
	public String update(@PathVariable int id, @PathVariable int articleId, @ModelAttribute ArticleDTO articleDTO,
			Model model) {
//		BoardDTO board = boardService.read(id);
//		model.addAttribute("board", board);
		
//		List<BoardDTO> list = boardService.findAll();
//		model.addAttribute("list", list);
		
		ArticleDTO article = articleService.find(articleId);
		model.addAttribute("article", article);
		String passwd = article.getPasswd();
		String inputPasswd = articleDTO.getPasswd();
		String subject = articleDTO.getSubject();
		String content = articleDTO.getContent();
		log.info("입력값 : {}", articleDTO);
		article.setSubject(subject);
		article.setContent(content);
		log.info("업데이트 : {}", article);

		if (passwd.equals(inputPasswd)) {
			articleService.update(article);
			return "redirect:/article/{id}/read/{articleId}";
		} else {
			return "board/error";
		}
	}

	// 게시글 삭제
	@PostMapping("/{id}/delete/{articleId}")
	public String delete(@PathVariable int id, @PathVariable int articleId, @ModelAttribute ArticleDTO articleDTO,
			Model model) {
//		BoardDTO board = boardService.read(id);
//		model.addAttribute("board", board);
		
//		List<BoardDTO> list = boardService.findAll();
//		model.addAttribute("list", list);
		
		ArticleDTO article = articleService.find(articleId);
		model.addAttribute("article", article);
		String passwd = article.getPasswd();
		// log.info(passwd);
		String inputPasswd = articleDTO.getPasswd();
		// log.info(inputPasswd);

		if (passwd.equals(inputPasswd)) {
			articleService.delete(article);
			return "redirect:/board/{id}";
		} else {
			return "board/error";
		}
	}
	
	// 게시글 답글 화면 요청
	@GetMapping("/{id}/reply/{articleId}")
	public String replyView(@PathVariable int id, @PathVariable int articleId, Model model) {
//		BoardDTO board = boardService.read(id);
//		model.addAttribute("board", board);
		
//		List<BoardDTO> list = boardService.findAll();
//		model.addAttribute("list", list);
		
		log.info("테스트 : {}", articleId);
		model.addAttribute("topArticleId", articleId);
		return "board/replyRegister";
	}
	
	// 게시글 답글 작성
	@PostMapping("/{id}/reply/{articleId}")
	public String reply(@PathVariable int id, @PathVariable int articleId, @ModelAttribute ArticleDTO articleDTO, Model model) {
//		BoardDTO board = boardService.read(id);
//		model.addAttribute("board", board);
		
//		List<BoardDTO> list = boardService.findAll();
//		model.addAttribute("list", list);
		
		articleDTO.setBoardId(id);
		ArticleDTO topArticle = articleService.find(articleId);
		articleService.createReply(articleDTO, topArticle);
		return "redirect:/board/{id}";
	}
}