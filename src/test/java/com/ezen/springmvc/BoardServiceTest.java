package com.ezen.springmvc;


import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.mapper.BoardMapper;
import com.ezen.springmvc.domain.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

/**
 * ServiceTest (2023-08-18)
 * @author 이희영
 */
@Slf4j
@SpringBootTest
public class BoardServiceTest {
	
	@Autowired
	BoardService boardService;
	
	@Test
	@DisplayName("게시판 등록")
	@Disabled
	public void createTest() {
		BoardDTO boardDTO = BoardDTO.builder()
							  .category(3)
							  .title("토론방")
							  .description("자유롭게 토론하세요.")
							  .build();
		
		boardService.create(boardDTO);
		log.info("게시판 등록 완료 : {}", boardDTO);
	}
	
	@Test
	@DisplayName("전체 게시판 조회")
	@Disabled
	public void findByAllTest() {
		List<BoardDTO> boardDTOs = boardService.findAll();
		log.info("{}", boardDTOs);
	}
	
	@Test
	@DisplayName("게시판 번호로 게시판 조회")
	@Disabled
	public void readTest() {
		BoardDTO boardDTO = boardService.read(10);
		log.info("{}", boardDTO);
	}
}