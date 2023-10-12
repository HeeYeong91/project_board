package com.ezen.springmvc.domain.board.aspect;

import java.security.Signature;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 게시판 관련 공통 기능을 위한 AOP 클래스 (2023-08-24)
 * 개인 공부 후 적용
 */
@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class BoardAOP {
	
	private final BoardService boardService;
	
	/**
	 * 게시판 관련 공통 기능
	 * 모든 컨트롤러 메소드 실행 시 model에 게시판과 게시판 리스트 전달
	 * @param joinpoint 공통기능을 적용할 위치(메소드)
	 */
	@Before("execution(* com.ezen.springmvc.web..*(..))")
	public void boardListAOP(JoinPoint joinpoint) {
		List<BoardDTO> list = boardService.findAll();
		Object params[] = joinpoint.getArgs();
		for (Object param : params) {
//			log.info("파람들 : {}", param);
			if (param instanceof Model && !(param instanceof RedirectAttributes)) {
//				log.info("boardList 테스트 : {}", list);
				((Model) param).addAttribute("list", list);
			}
		}
	}
	
	@Before("execution(* com.ezen.springmvc.web..*(..))")
	public void logInfoAOP(JoinPoint joinPoint) {
		log.info(joinPoint.getTarget().getClass().getSimpleName() + " 의 " + joinPoint.getSignature().getName() + " 메소드 실행");
	}
}