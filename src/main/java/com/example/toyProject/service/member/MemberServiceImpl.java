package com.example.toyProject.service.member;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.toyProject.controller.member.CustomHttpRequestServlet;
import com.example.toyProject.model.member.dao.MemberDAO;
import com.example.toyProject.model.member.dto.MemberDTO;
import com.grpctest.HelloServiceGrpc;
import com.grpctest.HelloWorldRequest;
import com.grpctest.HelloWorldResponse;

import io.grpc.stub.StreamObserver;

@Service
public class MemberServiceImpl extends HelloServiceGrpc.HelloServiceImplBase implements MemberService {
	
	@Inject
	MemberDAO memberDAO;
	

    @Override
    public void helloWorldPrint(HelloWorldRequest request, StreamObserver<HelloWorldResponse> responseObserver) {
       
    	HelloWorldResponse helloWorldResponse = HelloWorldResponse.newBuilder()
                .setMsg(request.getMsg()+"WellCome TO the Hell")
                .build();
 
        responseObserver.onNext(helloWorldResponse);
        responseObserver.onCompleted();
    }



	
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
	public List<MemberDTO> list(int start, String searchOption, String searchKey) {
		
		return memberDAO.list(start, searchOption, searchKey);
	}
	
	//멤버 수를 찾아온다. 
	@Override
	public int count(String searchOption, String searchKey) {
		return memberDAO.count(searchOption,searchKey);
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
	
	//회원 정보 등록처리
	@Override
	public void regist(MemberDTO dto)
	{
		memberDAO.regist(dto);
		
	}
	
	//회원 정보 수정처리
	@Override
	public void modify(MemberDTO dto)
	{
		memberDAO.modify(dto);
		
	}
	
	
	//회원 정보 삭제 처리 
	@Override
	public void delete(List<String> list) {
		memberDAO.delete(list);
		
	}
	
	//HttpServletRequest 객체 직렬화 가능한지 체크 해시코드 반환 
	@Override
	public int CanISerialize(CustomHttpRequestServlet req) {
		// TODO Auto-generated method stub
		return req.hashCode();
	}
	
	

}
