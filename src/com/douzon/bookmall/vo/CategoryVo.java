package com.douzon.bookmall.vo;

public class CategoryVo {
	private int no;
	private String type;
	public void setNo(int no) {
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return no+". " + type;
	}
}
