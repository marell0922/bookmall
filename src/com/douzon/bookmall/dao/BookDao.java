package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.BookVo;

public class BookDao {
	
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

	public boolean insert(BookVo bookVo) {
		boolean result=false;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			if(conn==null)System.out.println("conn");
			
			String sql="insert into book"
					+ " values ( null, ?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, bookVo.getTitle());
			stmt.setInt(2, bookVo.getPrice());
			stmt.setInt(3, bookVo.getCategory_no());
			
			int count=stmt.executeUpdate();
			result=count==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(conn!=null&&!conn.isClosed())
						conn.close();
					
					if(stmt!=null&&stmt.isClosed())
						stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return result;
	}

	public List<BookVo> getList() {
		// TODO Auto-generated method stub
		List<BookVo> list=new ArrayList<BookVo>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			
			String sql="select a.no, a.title, b.type, a.price " + 
					"from book a, category b " + 
					"where a.category_no=b.no order by no";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int no=rs.getInt(1);
				String title=rs.getString(2);
				String type=rs.getString(3);
				int price=rs.getInt(4);
				
				BookVo bookVo=new BookVo();
				bookVo.setNo(no);
				bookVo.setTitle(title);
				bookVo.setCategory_name(type);
				bookVo.setPrice(price);
				
				list.add(bookVo);
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
				
				if(rs!=null&&!rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		
		return list;
	}

	public boolean update(BookVo bookVo) {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			String sql="update book "
					+ "set title=?, price=?, category_no=? "
					+ "where no=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, bookVo.getTitle());
			stmt.setInt(2, bookVo.getPrice());
			stmt.setInt(3, bookVo.getCategory_no());
			stmt.setInt(4, bookVo.getNo());
			
			int count=stmt.executeUpdate();
			
			result=count==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public boolean delete(int no) {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			String sql="delete from book "
					+ "where no=?";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, no);
			int count=stmt.executeUpdate();
			
			result=count==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
}
