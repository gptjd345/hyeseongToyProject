package com;

import java.io.IOException;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.example.toyProject.service.member.MemberServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;

@Service
public class grpcServerRunner implements ApplicationListener<ContextRefreshedEvent>{

	private static final int PortNum = 8099;
	private static final Server grpcServer = ServerBuilder.forPort(PortNum)
			.addService(new MemberServiceImpl())
			.build();
			   
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			
			grpcServer.start();
			
			System.out.println("Server 구동됨");
			
			//grpcServer.awaitTermination();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	
}
