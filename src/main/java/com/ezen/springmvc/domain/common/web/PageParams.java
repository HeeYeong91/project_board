package com.ezen.springmvc.domain.common.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 페이지 계산에 필요한 정보들 포장 (2023-08-09)
 * @author 이희영
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PageParams {
	
	private int elementSize;    /** 페이지에 보여지는 목록 갯수 */
	private int pageSize;       /** 페이지에 보여지는 페이지 갯수 */
	private int requestPage;    /** 사용자 요청 페이지 */
	private int rowCount;       /** 테이블 목록 갯수 */
	private int boardId;		/** 게시판 식별번호 */
	private String keyword;		/** 검색값 */
}