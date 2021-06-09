package com.example.toyProject.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import com.example.toyProject.model.member.dto.MemberDTO;

public class TestSerialize {
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		//자바직렬화 핧 대상 MemberDTO 객체 생성 후 값 대입
	    MemberDTO memberDTO = new MemberDTO();
	    memberDTO.setMembernum(1234);
	    memberDTO.setUserid("gptjd345");
	    memberDTO.setName("김혜성");
	    
	    
	    byte[] serializedMember;
	    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
	        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
	            oos.writeObject(memberDTO);
	            // serializedMember -> 직렬화된 member 객체
	            serializedMember = baos.toByteArray();
	        }
	    }
	    // 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
	    String base64MemberDTO = Base64.getEncoder().encodeToString(serializedMember);
	    
	    System.out.println("base64MemberDTO : "+base64MemberDTO);
	    
	    byte[] serializedMember1 = Base64.getDecoder().decode(base64MemberDTO);
	    try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember1)) {
	        try (ObjectInputStream ois = new ObjectInputStream(bais)) {
	            // 역직렬화된 Member 객체를 읽어온다.
	            Object objectMember = ois.readObject();
	            MemberDTO member = (MemberDTO) objectMember;
	            System.out.println("MemberDTO : "+ member);
	        }
	    }
	}
}
