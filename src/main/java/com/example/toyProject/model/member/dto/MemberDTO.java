package com.example.toyProject.model.member.dto;

public class MemberDTO {
	
	private String userid;
	private String password;
	private String name;
	private String phoneNumber;
	
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
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "memberDTO [userid=" + userid + ", password=" + password + ", name=" + name + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
	
}
