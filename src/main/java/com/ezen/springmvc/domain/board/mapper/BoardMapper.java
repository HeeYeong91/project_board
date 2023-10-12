package com.ezen.springmvc.domain.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ezen.springmvc.domain.board.dto.BoardDTO;

/**
 * board 테이블 관련 명세 (2023-08-09)
 * @author 이희영
 */
@Mapper
public interface BoardMapper {
	
	/** 신규 게시판 생성 */
	public void create(BoardDTO boardDTO);
	
	/** 전체 게시판 목록 반환 */
	public List<BoardDTO> findAll();
	
	/** 게시판 번호로 게시판 조회 */
	public BoardDTO read(int boardId);
}