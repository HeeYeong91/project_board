package com.ezen.springmvc.domain.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

/**
 * BoardService 구현체 (2023-08-18)
 * @author 이희영
 */
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper boardMapper;

	@Override
	public void create(BoardDTO boardDTO) {
		boardMapper.create(boardDTO);
	}

	@Override
	public List<BoardDTO> findAll() {
		return boardMapper.findAll();
	}

	@Override
	public BoardDTO read(int boardId) {
		return boardMapper.read(boardId);
	}
}