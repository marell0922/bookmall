package com.douzon.bookmall.vo;

public class MemberVo {
	private int no;
	private String name;
	private String phone_number;
	private String email;
	private String passwd;
	public MemberVo() {}
	public MemberVo(String name, String phone_number, String email, String passwd) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.phone_number=phone_number;
		this.email=email;
		this.passwd=passwd;
	}
	public void setNo(int no) {
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return name + ", " + phone_number + ", " + email + ", " + passwd;
	}
	
	
}
