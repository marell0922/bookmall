package com.douzon.bookmall.vo;

public class OrderBookVo {
//도서번호, 도서제목, 수량
	private int book_no;
	private String book_title;
	private int count;
	private int orderlist_no;
	public void setOrderlist_no(int orderlist_no) {
		this.orderlist_no=orderlist_no;
	}
	public int getOrderlist_no() {
		return orderlist_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return  book_no + ". " + book_title + ", " + count;
	}
	
}
