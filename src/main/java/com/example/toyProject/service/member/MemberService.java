package com.example.toyProject.service.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.toyProject.model.member.dto.MemberDTO;

public interface MemberService {
	
	MemberDTO login_Check(MemberDTO dto, HttpSession session);
	
	void logout(HttpSession session);
	
	List<MemberDTO> list(int start, String searchOption, String searchKey);
	
	//회원정보 레코드 수를 센다. 
	int count(String searchOption, String searchKey);
	
	//아이디 중복확인
	int idCheck(String userid);
	
	//회원 가입
	void signUp(MemberDTO dto);
	
	//회원 수정창에 가져올 정보
	MemberDTO getModifyInfo(String userid);
	
	//회원 등록수정처리
	void registModify(MemberDTO dto);
	
	//회원 삭제 처리
	void delete(List<String> selectedRow);
	
	
}
