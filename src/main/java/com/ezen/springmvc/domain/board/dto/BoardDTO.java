package com.ezen.springmvc.domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 게시판 DTO (2023-08-09)
 * @author 이희영
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class BoardDTO {
	int boardId;			/** 게시판 식별번호 */
	int category;			/** 게시판 카테고리 */
	String title;			/** 게시판 이름 */
	String description;		/** 게시판 상세설명 */
}