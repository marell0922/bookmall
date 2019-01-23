package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.OrderBookVo;
import com.douzon.bookmall.vo.OrderVo;

public class OrderBookDao {
	public static Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url="jdbc:mysql://localhost:3306/bookmall";
			conn=DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

	public void insert(int member_no) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=getConnection();
			
			String sql="insert into order_book\r\n" + 
					"select c.book_no, a.no, c.count\r\n" + 
					"from orderlist a, member b, cart c\r\n" + 
					"where a.member_no=b.no and b.no=c.member_no"
					+ " and c.member_no=?";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, member_no);
			int count=stmt.executeUpdate();
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(conn!=null&&!conn.isClosed())
					conn.close();
				if(stmt!=null&&!stmt.isClosed())
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	}
	
	public void insert() {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=getConnection();
			
			String sql="insert into order_book\r\n" + 
					"select c.book_no, a.no, c.count\r\n" + 
					"from orderlist a, member b, cart c\r\n" + 
					"where a.member_no=b.no and b.no=c.member_no";
			stmt=conn.prepareStatement(sql);
			int count=stmt.executeUpdate();
			//System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(conn!=null&&!conn.isClosed())
					conn.close();
				if(stmt!=null&&!stmt.isClosed())
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
	}

	public List<OrderBookVo> getList() {
		// TODO Auto-generated method stub
		List<OrderBookVo> list=new ArrayList<OrderBookVo>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			
			String sql="select c.book_no, b.title, d.count\r\n" + 
					"from orderlist a, book b, order_book c, cart d\r\n" + 
					"where a.no=c.order_no and b.no=c.book_no and b.no=d.book_no;";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int book_no=rs.getInt(1);
				String book_title=rs.getString(2);
				int count=rs.getInt(3);
				
				OrderBookVo orderBookVo=new OrderBookVo();
				orderBookVo.setBook_no(book_no);
				orderBookVo.setBook_title(book_title);
				orderBookVo.setCount(count);
				
				list.add(orderBookVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(conn!=null&&!conn.isClosed())
					conn.close();
				if(stmt!=null&&!stmt.isClosed())
					stmt.close();
				if(rs!=null&& !rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		
		return list;
	}


}
