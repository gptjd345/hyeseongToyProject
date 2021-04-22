package com.example.toyProject.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.toyProject.model.member.dto.MemberDTO;
import com.example.toyProject.service.member.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("login.do")
	public String login()
	{
		return "member/login";
	}
	
	@RequestMapping(value="login_check.do" ,method = RequestMethod.POST)
	public @ResponseBody String login_check(@RequestBody MemberDTO dto, HttpSession session)
	{
		//로그인의 결과가 이름임 
		String name = memberService.login_Check(dto, session);
		if(name != null)
			return "success";
		else
		return "fail";
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session,ModelAndView mav)
	{
		memberService.logout(session);
		mav.setViewName("member/login");
		return mav;
	}
	
	@RequestMapping("registration.do")
	public String register()
	{
		return "member/registration";
	}
	
}
