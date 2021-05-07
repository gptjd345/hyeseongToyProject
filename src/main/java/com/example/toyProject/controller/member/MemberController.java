package com.example.toyProject.controller.member;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
import com.example.toyProject.model.member.dto.PageDTO;
import com.example.toyProject.service.member.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("login")
	public String login()
	{
		return "member/login";
	}
	
	@RequestMapping(value="login.do", method= RequestMethod.GET)
	public String preventLoginDo()
	{
		return "redirect:/member/login";
	}
	
	@RequestMapping(value="login.do" ,method = RequestMethod.POST)
	public @ResponseBody String login_check(@ModelAttribute MemberDTO dto, HttpSession session)
	{
		System.out.println("dto: "+dto);
		MemberDTO result = memberService.login_Check(dto, session);
		//로그인 성공시 만들어진 객체가 null 이 아닌 경우 
		if(result != null)
			return "success";
		else
			return "fail";
	}
	
	@RequestMapping("logout.do")
	public String logout(HttpSession session,ModelAndView mav)
	{
		memberService.logout(session);
		
		return "redirect:/member/login";
	}
	
	@RequestMapping("signUp")
	public String signUp()
	{
		return "member/signUp";
	}
	
	
	@RequestMapping("list.do")
	public ModelAndView list(@ModelAttribute PageDTO pageDTO)
	{
		
		//전체 레코드 수 알아옴
		int totalPage = memberService.count(pageDTO.getSearchOption(),pageDTO.getSearchKey());
		
		//찾아올 시작 레코드 = 현재 블록 * 10 - 10 이다. 10은 한블록에 있는 레코드 수 
		//offset은 쓰여진 숫자 다음 레코드를 가져오니 9가 아닌 10을 빼준다.
		int start = (pageDTO.getCurBlock() * 10) - 10;
		
		//해당 블록에 레코드가 없다면 0부터 찾고 curBlock은 1로 한다.  
		if(start > totalPage)
		{	
			start = 0;
			pageDTO.setCurBlock(1);
		}
		
		List<MemberDTO> list = memberService.list(start,pageDTO.getSearchOption(),pageDTO.getSearchKey());
		
		System.out.println("totalPage = "+totalPage);
		System.out.println("curBlock:"+pageDTO.getCurBlock());
		System.out.println("searchOption:"+pageDTO.getSearchOption());
		System.out.println("searchKey:"+pageDTO.getSearchKey());
		System.out.println("start:"+start);
		System.out.println("list:"+list);
		
//		기본적으로 	ArrayList 를 사용한다. 	
//		System.out.println(list instanceof ArrayList);
//		System.out.println(list instanceof LinkedList);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("member/list");
		mav.addObject("list",list);
		mav.addObject("totalPage",totalPage);
		mav.addObject("pageDTO",pageDTO);
		
		return mav;
		
	}
	
	//회원가입시 아이디 중복 확인 
	@RequestMapping("/idCheck.do")
	public @ResponseBody int idCheck(@RequestParam String userid)
	{
		System.out.println("Controller: userid = "+userid); 
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
		
		return "redirect:/member/login";
		
	}
	
	//회원 등록 창 요청 처리
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView manage(@ModelAttribute PageDTO pageDTO)
	{
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageDTO",pageDTO);
		mav.setViewName("/member/registration");
		
		return mav;
	}
	
	//회원 관리 창에서 회원 등록 및 수정 처리
	@RequestMapping("/registModify.do")
	public String regist(@ModelAttribute MemberDTO dto , @ModelAttribute PageDTO pageDTO) throws UnsupportedEncodingException
	{
		System.out.print("등록전: "+ dto.toString()); 
		System.out.println("PageDTO : "+pageDTO);
		
		//회원가입시 사용했던 것을 사용
		memberService.registModify(dto);
		//URL에 한글이 입력되는 경우 에러가 발생한다. UTF-8 로 인코딩해야한다. 
		String searchKey = URLEncoder.encode(pageDTO.getSearchKey(), "UTF-8");
		
		return "redirect:/member/list.do?curBlock="+pageDTO.getCurBlock()+
					"&searchOption="+pageDTO.getSearchOption()+"&searchKey="+searchKey;
		
	}
	
	//회원 수정 창 가져오기 GET
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public ModelAndView modify(@RequestParam String userid, @ModelAttribute PageDTO pageDTO)
	{
		//수정할 회원 정보 가져오기
		MemberDTO dto = memberService.getModifyInfo(userid);
		ModelAndView mav = new ModelAndView();
			
		mav.setViewName("/member/modify");
		//수정창은 해당 아이디와 수정창으로 넘어오기전 블록 번호를 가지고있다.
		mav.addObject("dto",dto);
		mav.addObject("pageDTO",pageDTO);
		
		
		return mav;
	}
	
	//회원 삭제 수행
	@RequestMapping("/delete.do")
	public @ResponseBody String delete(@RequestParam List<String> selectedRow)
	{
		System.out.println("selectedRow : "+selectedRow);
		memberService.delete(selectedRow);
		
		return "success";
	}
	
	
}
