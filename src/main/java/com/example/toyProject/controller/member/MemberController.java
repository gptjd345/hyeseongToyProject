package com.example.toyProject.controller.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.toyProject.model.member.dto.MemberDTO;
import com.example.toyProject.service.member.MemberService;
import com.example.toyProject.util.Pager;

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
	
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue = "1") int curBlock)
	{
		
		//전체 레코드 수 알아옴
		int totalPage = memberService.count();
		
		Pager pager = new Pager(totalPage,curBlock);
		
		int start = pager.getPageBegin();
		int end = pager.getPageEnd();
		
		System.out.println("totalPage = "+totalPage);
		System.out.println("endBlock = "+pager.getendBlock());
		System.out.println("start = "+start);
		System.out.println("end = "+end);
		
		List<MemberDTO> list = memberService.list(start,end);
		System.out.println("list:"+list);
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("list", list);
		map.put("pager", pager);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/list");
		mav.addObject("map",map);
		return mav;
		
	}
	
	//회원가입시 아이디 중복 확인 
	@RequestMapping("/idCheck.do")
	public @ResponseBody int idCheck(@RequestBody Map<String,String> map)
	{
		System.out.println("Controller: userid = "+map.get("userid"));
		//json 형태로 데이터를 받아야하니 Map 객체로 받아서 전달한다. 
		int result = memberService.idCheck(map.get("userid"));
		System.out.println("result : " + result);
		
		return result;
	}
	
	//회원가입 처리 끝나면 로그인 화면으로 이동
	@RequestMapping("/signUp.do")
	public String signUp(@ModelAttribute MemberDTO dto)
	{
		dto.toString();
		
		memberService.signUp(dto);
		
		return "member/login";
		
	}
	
}
