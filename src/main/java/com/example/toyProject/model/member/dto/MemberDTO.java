package com.example.toyProject.model.member.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MemberDTO implements UserDetails {
	
	private int membernum;
	private String userid;
	private String password;
	private String name;
	private String phonenum;
	private Date joindate;
	
	//사용자의 권한
	private String authority;
	
	public int getMembernum() {
		return membernum;
	}
	public void setMembernum(int membernum) {
		this.membernum = membernum;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [membernum=" + membernum + ", userid=" + userid + ", password=" + password + ", name=" + name
				+ ", phonenum=" + phonenum + ", joindate=" + joindate + "]";
	}
	
	//스프링 시큐리티에서 사용하는 메소드(UserDetails 인터페이스를 구현하면 오버라이드 해야할 메소드)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//List<GrantedAuthority> 명으로 객체 생성
		List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		//리스트에 추가할수있는 자료형은 GrantedAuthority 인터페이스를 구현하는 클래스여야하고 스프링 시큐리티에서 SimpleGrantedAuthority라는 클래스를 제공해준다. 생성자에 String으로 권한명을 받아주도록 되어있다. 
		auth.add(new SimpleGrantedAuthority(authority));
		
		return auth;
	}
	//스프링 시큐리티에서 사용하는 메소드 userid를 가져오는 메소드
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userid;
	}
	

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
	
}
