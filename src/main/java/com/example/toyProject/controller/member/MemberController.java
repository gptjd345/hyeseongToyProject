package com.example.toyProject.controller.member;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public @ResponseBody String login_check(@ModelAttribute MemberDTO dto, HttpSession session)
	{
		//로그인 성공시 만들어진 객체가 null 이 아닌 경우 
		if(memberService.login_Check(dto, session) != null)
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
	
	@RequestMapping(value="signUp.do", method = RequestMethod.GET)
	public String signUp()
	{
		return "member/signUp";
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
		
//		기본적으로 	ArrayList 를 사용한다. 	
//		System.out.println(list instanceof ArrayList);
//		System.out.println(list instanceof LinkedList);
		
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
	public @ResponseBody int idCheck(@RequestParam String userid)
	{
		System.out.println("Controller: userid = "+userid);
		//json 형태로 데이터를 받아야하니 Map 객체로 받아서 전달한다. 
		int result = memberService.idCheck(userid);
		System.out.println("result : " + result);
		
		return result;
	}
	
	//회원가입 처리
	@RequestMapping(value="/signUp.do", method = RequestMethod.POST)
	public String signUp(@ModelAttribute MemberDTO dto)
	{
		dto.toString();
		
		memberService.signUp(dto);
		
		return "member/login";
		
	}
	
	//회원 관리용 창 요청 처리
	@RequestMapping(value="/manage.do", method = RequestMethod.GET)
	public String manage()
	{
		return "/member/managebox";
	}
	
	//회원 관리 창에서 회원 등록 처리
	@RequestMapping("/regist.do")
	public String regist(@ModelAttribute MemberDTO dto , @RequestParam int curBlock)
	{
		System.out.print("등록전: "+ dto.toString()); 
		System.out.println("curBlock : "+curBlock);
		
		//회원가입시 사용했던 것을 사용
		memberService.signUp(dto);
		
		return "redirect:/member/list.do?curBlock="+curBlock;
	}
	
	
	
}
