package com;

import org.springframework.context.annotation.Bean;

import com.example.toyProject.service.member.MemberServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;


//public class grpcServerConfig {
//	
//	//포트는 value 어노테이션으로 받고 포트정보는 properties에 저장 할예정
//	//서비스impl을 매개변수로 넘겨주면 좋을것 같지만 어차피 하나의 serviceimpl에 하나의 서버가 할당될것같다. 
//	@Bean
//	public Server grpcServerRun(){
//		return ServerBuilder.forPort(8099)
//				.addService(new MemberServiceImpl())
//				.build();
//				
//
//
//	}
//
//}
