package com.ezen.springmvc.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ezen.springmvc.domain.member.dto.Member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/**
 * 홈 컨트롤러 (2023-08-18)
 * @author 이희영
 */
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

//	private final BoardService boardService;

	// 메인 화면
	@GetMapping("")
	public String home(@SessionAttribute(name = "loginMember", required = false) Member loginMember, Model model,
			HttpSession session) {
		if (loginMember != null) {
			session.setAttribute("loginMember", loginMember);
		}
//		AOP를 이용해 web패키지 하위 모든 Controller에 있는 모든 메소드에 적용
//		List<BoardDTO> list = boardService.findAll();
//		model.addAttribute("list", list);

		return "board/index";
	}
}