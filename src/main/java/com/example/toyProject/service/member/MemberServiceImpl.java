package com.example.toyProject.service.member;

import java.util.ArrayList;
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
	public MemberDTO login_Check(MemberDTO dto, HttpSession session) {
		//쿼리 성공시 DTO 완성된 객체가 반환된다. 변수를 굳이 만든건 찍어보기 위해서이다.  
		MemberDTO resultDTO = memberDAO.login_Check(dto);
		
		if(resultDTO != null)
		{
			session.setAttribute("resultDTO", resultDTO);
			System.out.println("Service name: "+resultDTO);
			return resultDTO;
		}
		
		return null;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public List<MemberDTO> list(int start) {
		
		return memberDAO.list(start);
	}
	
	//멤버 수를 찾아온다. 
	@Override
	public int count() {
		return memberDAO.count();
	}
	
	//아이디 중복 확인
	@Override
	public int idCheck(String userid)
	{
		return memberDAO.idCheck(userid);
	}
	
	//회원가입
	@Override
	public void signUp(MemberDTO dto)
	{
		memberDAO.signUp(dto);
	}
	
	//회원정보 수정 창에 가져다 놓은 데이터가져옴
	@Override
	public MemberDTO getModifyInfo(String userid)
	{
		return memberDAO.getModifyInfo(userid);
	}
	
	//회원 정보 등록 수정처리
	@Override
	public void registModify(MemberDTO dto)
	{
		memberDAO.registModify(dto);
		
	}
	
	//회원 정보 삭제 처리 
	@Override
	public void delete(List<String> selectedRow) {
		memberDAO.delete(selectedRow);
		
	}

}
