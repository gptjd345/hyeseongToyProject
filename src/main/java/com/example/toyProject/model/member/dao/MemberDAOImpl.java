package com.example.toyProject.model.member.dao;



import java.util.List;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.toyProject.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	
	@Inject
	SqlSession sqlSession;  
	
	@Override
	public MemberDTO login_Check(MemberDTO dto) {
		
		return sqlSession.selectOne("member.login_check",dto);
	}

	@Override
	public List<MemberDTO> list(int start) {
		//offset 0  은 0번째 이후의 행을 가져온다. 컨트롤러에서 0을 빼서 넘겨주었음
		return sqlSession.selectList("member.list",start);
	}

	//멤버 레코드 수를 알아온다. 
	@Override
	public int count() {
		return sqlSession.selectOne("member.count");
	}
	
	//아이디 중복 여부 확인 
	@Override
	public int idCheck(String userid)
	{
		return sqlSession.selectOne("member.idCheck",userid);
	}
	
	//회원 가입
	@Override
	public void signUp(MemberDTO dto)
	{
		sqlSession.selectOne("member.signUp",dto);
	}
	
	//수정할 회원 정보 가져오기
	@Override
	public MemberDTO getModifyInfo(String userid) {
		
		return sqlSession.selectOne("member.getModifyInfo",userid);
	}
	
	//회원 등록 및 수정 처리
	@Override
	public void registModify(MemberDTO dto)
	{
		sqlSession.selectOne("member.registModify",dto);
	}
	
	//회원 삭제 처리
	@Override
	public void delete(List<String> selectedRow) {
		//DAO까지 잘가나 확인 
		System.out.println("listDAO: "+selectedRow);
		sqlSession.selectOne("member.delete",selectedRow);
	}
	
	
}
