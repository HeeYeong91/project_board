package com.ezen.springmvc.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 회원 조회 검색 조건 클래스 (2023-08-17)
 * @author 이희영
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class MemberSearchCondition {
	private String memberId;
	private String name;
	private String email;
}