package com.douzon.bookmall.vo;

public class CartVo {
	private int no;
	private int book_no;
	private String book_title;
	private int book_price;
	private int count;
	private int member_no;
	public CartVo() {}
	public CartVo(int book_no, int member_no, int count) {
		this.book_no=book_no;
		this.member_no=member_no;
		this.count=count;
	}
	public void setBook_no(int book_no) {
		this.book_no=book_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setMember_no(int member_no) {
		this.member_no=member_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setNo(int no) {
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return no+". "+ book_title + ", " + count + ", "+ book_price ;
	}
	
	
}
