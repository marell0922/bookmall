package com.douzon.bookmall.test;

import java.util.List;

import com.douzon.bookmall.dao.CartDao;
import com.douzon.bookmall.dao.OrderDao;
import com.douzon.bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
		//번호, 고객 번호, 결제 금액,  배송지
		//insertTest(1, "부산시 해운대구 우동 센텀벤처타운 7층");
		//insertTest(2, "부산광역시 연산동 ");
		//getListNoTest(1);
		//getListTest();
		//updateTest(2,"대구광역시 중구");
		//deleteTest(2);
	}

	private static void deleteTest(int no) {
		// TODO Auto-generated method stub
		boolean result=new OrderDao().delete(no);
		if(!result) System.out.println("deleteTest fail");
	}

	private static void updateTest(int member_no, String destination) {
		// TODO Auto-generated method stub
		OrderVo orderVo=new OrderVo();
		orderVo.setMember_no(member_no);
		orderVo.setDestination(destination);
		boolean result=new OrderDao().update(orderVo);
		if(!result) System.out.println("updateTest fail");
	}

	private static void getListTest() {
		// TODO Auto-generated method stub
		List<OrderVo> list =new OrderDao().getList();
		
		for(OrderVo orderVo : list) {
			System.out.println(orderVo);
		}
	}

	private static void getListNoTest(int no) {
		// TODO Auto-generated method stub
		List<OrderVo> list =new OrderDao().getList(no);
		
		for(OrderVo orderVo : list) {
			System.out.println(orderVo);
		}
	}

	private static void insertTest(int member_no, String destination) {
		// TODO Auto-generated method stub
		int total_price=new CartDao().getTotalMoney(member_no);
		OrderVo orderVo=new OrderVo();
		orderVo.setMember_no(member_no);
		orderVo.setDestination(destination);
		orderVo.setTotal_price(total_price);
		boolean result=new OrderDao().insert(orderVo);
		if(!result) System.out.println("insertTest fail");
	}
}
