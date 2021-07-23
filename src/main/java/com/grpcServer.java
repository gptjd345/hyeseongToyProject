package com;

import java.io.IOException;

import com.example.toyProject.service.member.MemberServiceImpl;

import io.grpc.Server;
import io.grpc.ServerBuilder;


public class grpcServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(8099)
				.addService(new MemberServiceImpl())
				.build();
				
		System.out.println("Listening port 8099");
		
		server.start();
		server.awaitTermination();

	}

}
