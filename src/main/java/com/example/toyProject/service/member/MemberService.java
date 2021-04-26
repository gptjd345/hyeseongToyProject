package com.example.toyProject.service.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.toyProject.model.member.dto.MemberDTO;

public interface MemberService {
	
	String login_Check(MemberDTO dto, HttpSession session);
	
	void logout(HttpSession session);
	
	List<MemberDTO> list(int start,int end);
	
	//회원정보 레코드 수를 센다. 
	int count();
	
	//아이디 중복확인
	int idCheck(String userid);
	
	//회원 가입
	void signUp(MemberDTO dto);
}
