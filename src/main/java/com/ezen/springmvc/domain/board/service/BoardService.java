package com.ezen.springmvc.domain.board.service;

import java.util.List;

import com.ezen.springmvc.domain.board.dto.BoardDTO;

/**
 * 게시판 관련 비즈니스 로직 처리 및 트랜잭션 관리 (2023-08-18)
 * @author 이희영
 */
public interface BoardService {
	
	/** 신규 게시판 생성 */
	public void create(BoardDTO boardDTO);
	
	/** 전체 게시판 목록 반환 */
	public List<BoardDTO> findAll();
	
	/** 게시판 번호로 게시판 조회 */
	public BoardDTO read(int boardId);
}