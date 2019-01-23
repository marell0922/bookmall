package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.OrderBookDao;
import com.douzon.bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {
	public static void main(String[] args) {
		// 책 번호, 책 제목, 주문번호
		//책번호, 수량, 주문번호
		//insertTest(1);
		//insertTest();
		getListTest();
	}

	private static void getListTest() {
		// TODO Auto-generated method stub
		List<OrderBookVo> list =new OrderBookDao().getList();
		for(OrderBookVo orderBookVo : list) {
			System.out.println(orderBookVo);
		}
	}

	private static void insertTest() {
		// TODO Auto-generated method stub
		new OrderBookDao().insert();
	}

	private static void insertTest(int member_no) {
		// TODO Auto-generated method stub
		new OrderBookDao().insert(member_no);
	}

}
