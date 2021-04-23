package com.example.toyProject.model.member.dao;

import java.util.List;

import com.example.toyProject.model.member.dto.MemberDTO;

public interface MemberDAO {
	 
	 String login_Check(MemberDTO dto);
	
	 List<MemberDTO> list(int start, int end);
	
	 //멤버 레코드 수를 받아옴 
	 int count();
}
