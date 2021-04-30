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
	public String logout(HttpSession session,ModelAndView mav)
	{
		memberService.logout(session);
		
		return "redirect:/member/login.do";
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
		//최대 몇 행까지 뽑을지  이부분은 나중에 언제든지 바꿀수 있도록 pager에서 받아서 쓴다. (10 고정)
		int end = pager.PAGE_SCALE;
		
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
	public ModelAndView manage(@RequestParam int curBlock)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("curBlock",curBlock);
		mav.setViewName("/member/manage");
		
		return mav;
	}
	
	//회원 관리 창에서 회원 등록 및 수정 처리
	@RequestMapping("/registModify.do")
	public String regist(@ModelAttribute MemberDTO dto , @RequestParam int curBlock)
	{
		System.out.print("등록전: "+ dto.toString()); 
		System.out.println("curBlock : "+curBlock);
		
		//회원가입시 사용했던 것을 사용
		memberService.registModify(dto);
		
		return "redirect:/member/list.do?curBlock="+curBlock;
	}
	
	//회원 수정 창 가져오기 GET
	@RequestMapping(value="/modify.do", method = RequestMethod.GET)
	public ModelAndView modify(@RequestParam String userid, @RequestParam int curBlock)
	{
		//수정할 회원 정보 가져오기
		MemberDTO dto = memberService.getModifyInfo(userid);
		ModelAndView mav = new ModelAndView();
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		//수정창은 해당 아이디와 수정창으로 넘어오기전 블록 번호를 가지고있다.
		map.put("dto", dto);
		map.put("curBlock", curBlock);
		
		mav.setViewName("/member/manage");
		mav.addObject("map",map);
		
		return mav;
	}
	
	
	
}
