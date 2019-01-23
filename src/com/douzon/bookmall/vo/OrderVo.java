package com.douzon.bookmall.vo;

public class OrderVo {
	private int no;
	private int member_no;
	private String member_name;
	private String member_email;
	private int total_price;
	private String destination;
	public OrderVo() {}
	public OrderVo(int member_no, String destination, int total_price) {
		this.member_no=member_no;
		this.destination=destination;
		this.total_price=total_price;
	}
	public void setMember_no(int member_no) {
		this.member_no=member_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@Override
	public String toString() {
		return member_name + ", " + member_email
				+ ", " + total_price + ", " + destination;
	}
}
