package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.CategoryVo;

public class CategoryDao {
	
	public boolean insert(String category) {
		boolean result=false;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			if(conn==null)System.out.println("conn");
			
			String sql="insert into category"
					+ " values ( null, ?);";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, category);
			
			int count=stmt.executeUpdate();
			
			result=count ==1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(conn!=null&&!conn.isClosed())
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return result;
	}
	
	public boolean update(CategoryVo categoryVo) {
		boolean result= false;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			String sql="update category"
					+ " set type=?"
					+ "where no=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, categoryVo.getType());
			stmt.setInt(2, categoryVo.getNo());
			
			int count= stmt.executeUpdate();
			result= count==1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(conn!=null&&! conn.isClosed())
						conn.close();
					
					if(stmt!=null &&! stmt.isClosed())
						stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return result;
	}
	
	
	
	public List<CategoryVo> getList() {
		// TODO Auto-generated method stub
		List<CategoryVo> list=new ArrayList<CategoryVo>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			
			stmt=conn.createStatement();
			
			String sql="select no, type from category";
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				int no=rs.getInt(1);
				String type=rs.getString(2);
				
				CategoryVo categoryVo=new CategoryVo();
				categoryVo.setNo(no);
				categoryVo.setType(type);
				list.add(categoryVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				if(conn!=null&&! conn.isClosed())
					conn.close();
				
				if(stmt!=null &&! stmt.isClosed())
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

	public boolean delete(int no) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			String sql="delete from category "
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
