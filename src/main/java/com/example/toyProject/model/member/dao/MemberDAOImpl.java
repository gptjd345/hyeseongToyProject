package com.example.toyProject.model.member.dao;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.toyProject.model.member.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	
	@Inject
	SqlSession sqlSession;  
	
	@Override
	public String login_Check(MemberDTO dto) {
		
		
		return sqlSession.selectOne("member.login_check",dto);
	}

	@Override
	public List<MemberDTO> list(int start, int end) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start",start);
		map.put("end", end);
		return sqlSession.selectList("member.list",map);
	}

	//멤버 레코드 수를 알아온다. 
	@Override
	public int count() {
		return sqlSession.selectOne("member.count");
	}
	
	
}
