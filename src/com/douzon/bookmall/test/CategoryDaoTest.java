package com.douzon.bookmall.test;

import java.sql.SQLException;
import java.util.List;

import com.douzon.bookmall.dao.CategoryDao;
import com.douzon.bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
		getConnection();
		//insertTest("소설");
		//insertTest("수필");
		//insertTest("컴퓨터/IT");
		//insertTest("예슬");
		//updateTest(1, "컴퓨터/IT");
		getListTest();
		//deleteTest(1);
	}
	
	private static void deleteTest(int no) {
		// TODO Auto-generated method stub
		boolean result=new CategoryDao().delete(no);
		if(!result) System.out.println("deleteTest fail");
	}

	private static void getListTest() {
		// TODO Auto-generated method stub
		List<CategoryVo> list=new CategoryDao().getList();
		
		for(CategoryVo categoryVo : list) {
			System.out.println(categoryVo);
		}
	}

	private static void updateTest(int no,String type) {
		// TODO Auto-generated method stub
		CategoryVo categoryVo =new CategoryVo();
		categoryVo.setNo(no);
		categoryVo.setType(type);
		
		boolean result=new CategoryDao().update(categoryVo);
		if(!result) System.out.println("updateTest fail");
	}

	private static void insertTest(String type) {
		// TODO Auto-generated method stub
		boolean result=new CategoryDao().insert(type);
		if(!result) System.out.println("insertTest fail");
	}

	public static void getConnection() {
		try {
			new CategoryDao().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}	
