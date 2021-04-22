package com.example.toyProject.service.member;

import javax.servlet.http.HttpSession;

import com.example.toyProject.model.member.dto.MemberDTO;

public interface MemberService {
	String login_Check(MemberDTO dto, HttpSession session);
	void logout(HttpSession session);
}
