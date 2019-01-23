package com.douzon.bookmall.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.douzon.bookmall.dao.CartDao;
import com.douzon.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
		getConnectionTest();
		//서적 , 고객, 수량
		//insertTest(2,1,1);
		//insertTest(1,1,2);
		//insertTest(3,2,2);
		//insertTest(4,2,1);
		//getListTest(1);
		//updateTest(2,1,1,2);
		//getListTest(1);
		
		//deleteTest(2);
		//getListTest();
		getTotal_Money(2);
	}
	

	private static void getTotal_Money(int no) {
		// TODO Auto-generated method stub
		int count=new CartDao().getTotalMoney(no);
		System.out.println(count);
		if(count ==-1) System.out.println("getTotal_Money fail");
	}


	private static void getListTest() {
		// TODO Auto-generated method stub
		List<CartVo> list=new CartDao().getList();
		
		for(CartVo cartVo : list) {
			System.out.println(cartVo);
		}
	}

	private static void deleteTest(int no) {
		// TODO Auto-generated method stub
		boolean result=new CartDao().delete(no);
		if(!result) System.out.println("deleteTest fail");
	}

	private static void updateTest(int no,int book_no, int member_no, int count) {
		// TODO Auto-generated method stub
		CartVo cartVo=new CartVo();
		cartVo.setNo(no);
		cartVo.setBook_no(book_no);
		cartVo.setMember_no(member_no);
		cartVo.setCount(count);
		boolean result=new CartDao().update(cartVo);
		if(!result) System.out.println("updateTest fail");
	}

	private static void getListTest(int no) {
		// TODO Auto-generated method stub
		List<CartVo> list=new CartDao().getList(no);
		
		for(CartVo cartVo : list) {
			System.out.println(cartVo);
		}
	}

	private static void insertTest(int book_no, int member_no, int count) {
		// TODO Auto-generated method stub
		CartVo cartVo=new CartVo();
		cartVo.setBook_no(book_no);
		cartVo.setMember_no(member_no);
		cartVo.setCount(count);
		
		boolean result=new CartDao().insert(cartVo);
		if(!result) System.out.println("insertTest fail");
	}

	private static void getConnectionTest() {
		// TODO Auto-generated method stub
		try {
			Connection conn=CartDao.getConnection();
			if(conn==null) System.out.println("disconnect");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
