package com.douzon.bookmall.test;

import java.sql.SQLException;
import java.util.List;

import com.douzon.bookmall.dao.BookDao;
import com.douzon.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		//getConnection();
		//insertTest("젊은그닐", 20000,1);
		//getListTest();
		//updateTest(1, "최수림", 23000, 1);
		//deleteTest(1);
		
		/*
		 * 1, 이것이 자바다, 컴퓨터/IT, 20000
2, 서양 미술사,   예술, 13000
3, 안드로이드 완전정복, 컴퓨터/IT, 40000
4. 아큐정전, 소설, 10000

		 * */
		insertTest("이것이 자바다", 20000, 3);
		insertTest("서양 미술사", 13000, 4);
		insertTest("안드로이드 완전 정복", 40000, 3);
		insertTest("아큐정전", 10000, 1);
	}


	private static void deleteTest(int no) {
		// TODO Auto-generated method stub
		boolean result=new BookDao().delete(no);
		if(!result) System.out.println("deleteTest fail");
	}


	private static void updateTest(int no, String title, int price, int category_no) {
		// TODO Auto-generated method stub
		BookVo bookVo=new BookVo();
		bookVo.setNo(no);
		bookVo.setTitle(title);
		bookVo.setPrice(price);
		bookVo.setCategory_no(category_no);
		
		boolean result=new BookDao().update(bookVo);
		if(!result) System.out.println("updateTest fail");
	}


	private static void getListTest() {
		// TODO Auto-generated method stub
		List<BookVo> list= new BookDao().getList();
		
		for(BookVo bookVo : list) {
			System.out.println(bookVo);
		}
	}


	private static void insertTest(String title, int price, int category_no) {
		// TODO Auto-generated method stub
		BookVo bookVo= new BookVo();
		bookVo.setTitle(title);
		bookVo.setPrice(price);
		bookVo.setCategory_no(category_no);
		boolean result=new BookDao().insert(bookVo);
		if(!result) System.out.println("insertTest fail");
		
	}


	public static void getConnection() {
		try {
			new BookDao().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
