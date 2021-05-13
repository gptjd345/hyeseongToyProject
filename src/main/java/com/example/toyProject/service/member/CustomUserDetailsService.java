package com.example.toyProject.service.member;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.toyProject.model.member.dao.MemberDAO;
import com.example.toyProject.model.member.dto.MemberDTO;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Inject
	MemberDAO memberDAO;
	
	 
	    @Override
	    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
	        MemberDTO dto = memberDAO.getUserById(userid);
	        if(dto==null) {
	            throw new UsernameNotFoundException(userid);
	        }
	        return dto;
	    }
	 
	
	

}
