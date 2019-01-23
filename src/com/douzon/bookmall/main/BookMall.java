package com.douzon.bookmall.main;

import java.util.List;

import com.douzon.bookmall.dao.BookDao;
import com.douzon.bookmall.dao.CartDao;
import com.douzon.bookmall.dao.CategoryDao;
import com.douzon.bookmall.dao.MemberDao;
import com.douzon.bookmall.dao.OrderBookDao;
import com.douzon.bookmall.dao.OrderDao;
import com.douzon.bookmall.vo.BookVo;
import com.douzon.bookmall.vo.CartVo;
import com.douzon.bookmall.vo.CategoryVo;
import com.douzon.bookmall.vo.MemberVo;
import com.douzon.bookmall.vo.OrderBookVo;
import com.douzon.bookmall.vo.OrderVo;

public class BookMall {
	public static void main(String[] args) {
		// 회원 리스트 -2 + insert등의 행위롤 통해 갯수 충족 + primary key 1부터 시작할 것. 
		// 카테고리 리스트 -3 :번호, 이름
		// 상품 리스트 -3 : 제목, 가격, 카테고리
		// 카트 리스트 -2 : 도서 제목, 수량, 가격
		// 주문 리스트 -1 : insert -> 카드에 있는 아이를 주문. : 주문번호, 주문자, 배송지, 결제 금액
		// 주문 도서 리스트 -2 :도서 제목, 도서 번호, 수량
		
		// =========== 사용자 ===========  // ============== 카테고리 =================
		// =========== 책=========== : 구분해서 명시 할 것!
		
		MemberDao memberDao=new MemberDao();
		CategoryDao categoryDao=new CategoryDao();
		BookDao bookDao=new BookDao();
		CartDao cartDao=new CartDao();
		OrderDao orderDao=new OrderDao();
		OrderBookDao orderBookDao=new OrderBookDao();
		
		System.out.println("회원 정보");
		memberDao.insert(new MemberVo("디디","010-000-000","loli@gmail.com","lali"));
		memberDao.insert(new MemberVo("타타","010-020-030","data@gmail.com","pw"));
		List<MemberVo> memberlist=memberDao.getList();
		for(MemberVo memberVo : memberlist) {
			System.out.println(memberVo);
		}
		System.out.println("=================================================");
		
		System.out.println("카테고리 리스트");
		categoryDao.insert("소설");
		categoryDao.insert("수필");
		categoryDao.insert("컴퓨터/IT");
		categoryDao.insert("예술");
		List<CategoryVo> categorylist=categoryDao.getList();
		for(CategoryVo categoryVo : categorylist) {
			System.out.println(categoryVo);
		}
		System.out.println("=================================================");
		
		System.out.println("상품 리스트");
		bookDao.insert(new BookVo("이것이 자바다", 20000, 3));
		bookDao.insert(new BookVo("서양 미술사", 13000, 4));
		bookDao.insert(new BookVo("안드로이드 완전정복", 40000, 3));
		bookDao.insert(new BookVo("아큐정전", 10000, 1));
		List<BookVo> booklist=bookDao.getList();
		for(BookVo bookVo : booklist) {
			System.out.println(bookVo);
		}
		System.out.println("=================================================");
		
		System.out.println("카트 리스트");
		cartDao.insert(new CartVo(2,1,1));
		cartDao.insert(new CartVo(1,1,2));
		cartDao.insert(new CartVo(3,2,2));
		cartDao.insert(new CartVo(4,2,2));
		List<CartVo> cartlist=cartDao.getList();
		for(CartVo cartVo : cartlist) {
			System.out.println(cartVo);
		}
		System.out.println("=================================================");
		
		System.out.println("주문 리스트");
		orderDao.insert(new OrderVo(1, "부산시 해운대구 우동 센텀벤처타운 7층", cartDao.getTotalMoney(1)));
		orderDao.insert(new OrderVo(2,"대구광역시 중구", cartDao.getTotalMoney(2)));
		List<OrderVo> orderlist = orderDao.getList();
		for(OrderVo orderVo : orderlist) {
			System.out.println(orderVo);
		}
		System.out.println("=================================================");
		
		System.out.println("주문 도서 리스트");
		orderBookDao.insert();
		List<OrderBookVo> orderBooklist=orderBookDao.getList();
		for(OrderBookVo orderBookVo:orderBooklist) {
			System.out.println(orderBookVo);
		}
	}
}
