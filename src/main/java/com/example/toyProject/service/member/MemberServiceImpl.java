package com.example.toyProject.service.member;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.toyProject.model.member.dao.MemberDAO;
import com.example.toyProject.model.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDAO memberDAO;
	
	@Override
	public String login_Check(MemberDTO dto, HttpSession session) {
		// TODO Auto-generated method stub
		//쿼리 성공시 이름이 반환됨
		String name = memberDAO.login_Check(dto);
		if(name != null)
		{
			session.setAttribute("name", name);
			return name;
		}
		return null;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public List<MemberDTO> list(int start, int end) {
		
		return memberDAO.list(start,end);
	}
	
	//멤버 수를 찾아온다. 
	@Override
	public int count() {
		return memberDAO.count();
	}
	
	

}
