package com.ezen.springmvc.web.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ezen.springmvc.domain.board.dto.BoardDTO;
import com.ezen.springmvc.domain.board.service.BoardService;
import com.ezen.springmvc.domain.member.dto.LoginForm;
import com.ezen.springmvc.domain.member.dto.Member;
import com.ezen.springmvc.domain.member.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 회원 세부 컨트롤러 (2023-08-18)
 * @author 이희영
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
	
	private final MemberService memberService;
	private final BoardService boardService;
	
	@GetMapping("/register")
	public String registerForm(Model model) {
		List<BoardDTO> list = boardService.findAll();
		model.addAttribute("list", list);
		
		Member member = Member.builder().build();
		model.addAttribute("member", member);
		return "member/register";
	}

	// 회원 데이터 검증 - #3. Bean Validation 사용
	@PostMapping("/register")
	public String register(@Validated @ModelAttribute Member member, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model model) {

		// 데이터 검증 실패 시 회원가입 화면으로 Forward
		if (bindingResult.hasErrors()) {
			return "member/register";
		}
		
		String memberId = member.getId();
		if (memberService.getMember(memberId) != null) {
			bindingResult.reject("alreadyRegistered", "이미 가입된 아이디 입니다.");
			return "member/register";
		}

		memberService.register(member);

		return "redirect:/member/" + member.getId();
	}

	@GetMapping("/{id}")
	public String read(@PathVariable("id") String id, Model model) {
		log.info("회원 상세 요청");
		Member member = memberService.getMember(id);
		model.addAttribute("member", member);
		return "member/read";
	}

	@GetMapping("")
	public String list(Model model) {
		log.info("회원 목록 요청");
		List<Member> list = memberService.getMemberList();
		model.addAttribute("list", list);
		return "member/list";
	}

	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable("id") String id, Model model) {
		Member member = memberService.getMember(id);
		model.addAttribute("member", member);
		return "member/edit";
	}

	@PostMapping("/edit")
	public String edit(@ModelAttribute Member member, Model model) {
		log.info(member.toString());
		memberService.editMember(member);
		return "redirect:/member/" + member.getId();
	}

	@GetMapping("/login")
	public String loginForm(Model model) {
//		List<BoardDTO> list = boardService.findAll();
//		model.addAttribute("list", list);
		
		LoginForm loginForm = LoginForm.builder().build();
		model.addAttribute("loginForm", loginForm);
		return "member/login";
	}

	@PostMapping("/login") 
	public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request, Model model) {
		if (bindingResult.hasErrors()) {
			return "member/login";
		}
		
		Member loginMember = memberService.isMember(loginForm.getLoginId(), loginForm.getPasswd());
		
		// 회원이 아닌 경우
		if (loginMember == null) {
			bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
			return "member/login";
		}
		// 회원인 경우
		HttpSession session =  request.getSession();
		session.setAttribute("loginMember", loginMember);
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")  
	public String logout(HttpServletRequest request, Model model) {
		// 세션이 있으면 기존 세션 반환, 없으면 생성하지 않고 null 반환
		HttpSession session =  request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}