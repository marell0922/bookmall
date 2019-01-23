package com.douzon.bookmall.test;

import java.sql.SQLException;
import java.util.List;

import com.douzon.bookmall.dao.MemberDao;
import com.douzon.bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		//getConnectionTest();
		//insertTest("디디","010-000-000","loli@gmail.com","lali");
		//insertTest("타타","010-020-030","data@gmail.com","pw");
		//getListTest();
		//updateTest(1,"data","111-111-111","dada@gmail.com","pw");
		//deleteTest(1);
	}
	
	

	private static void deleteTest(int no) {
		// TODO Auto-generated method stub
		boolean result=new MemberDao().delete(no);
		if(!result) System.out.println("deleteTest fail");
	}



	private static void updateTest(int no,String name,  String phone_number, String email,String pw) {
		// TODO Auto-generated method stub
		MemberVo memberVo=new MemberVo();
		memberVo.setName(name);
		memberVo.setEmail(email);
		memberVo.setPhone_number(phone_number);
		memberVo.setPasswd(pw);
		memberVo.setNo(no);
		
		boolean result=new MemberDao().update(memberVo);
		if(!result) System.out.println("updateTest fail");
	}

	private static void getListTest() {
		// TODO Auto-generated method stub
		List<MemberVo> list=new MemberDao().getList();
		
		for(MemberVo memberVo:list) {
			System.out.println(memberVo);
		}
		
	}

	private static void insertTest(String name, String phone_number, String email, String pw) {
		// TODO Auto-generated method stub
		MemberVo memberVo=new MemberVo();
		memberVo.setName(name);
		memberVo.setPhone_number(phone_number);
		memberVo.setEmail(email);
		memberVo.setPasswd(pw);
		
		boolean result=new MemberDao().insert(memberVo);
		
		if(!result) System.out.println("insertTest fail");
	}

	public static void getConnectionTest() {
		try {
			new MemberDao().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
