package com.douzon.bookmall.vo;

public class BookVo {
	private int no;
	private String title;
	private int price;
	private int category_no;
	private String category_name;
	public BookVo() {}
	public BookVo(String title, int price, int category_no) {
		this.title=title;
		this.price=price;
		this.category_no=category_no;
	}
	public void setCategory_name(String category_name) {
		this.category_name=category_name;
	}
	public String getCategory_name(){
		return category_name;
	}
	public void setCategory_no(int category_no) {
		this.category_no=category_no;
	}
	public int getCategory_no() {
		return category_no;
	}
	public void setNo(int no) {
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return no+". " + title + ", " +category_name+", "+ price;
	}
	
	
	
	
	
}
