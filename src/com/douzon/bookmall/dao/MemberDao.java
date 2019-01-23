package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.MemberVo;

public class MemberDao {
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

	public boolean insert(MemberVo memberVo) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			String sql="insert into member"
					+ " values(null, ?,?,?,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, memberVo.getName());
			stmt.setString(2, memberVo.getPhone_number());
			stmt.setString(3, memberVo.getEmail());
			stmt.setString(4, memberVo.getPasswd());
			
			int count = stmt.executeUpdate();
			result = count ==1;
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
	

	public List<MemberVo> getList() {
		// TODO Auto-generated method stub
		List<MemberVo> list=new ArrayList<MemberVo>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			
			String sql="select name, phone_number, email, password from member";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name=rs.getString(1);
				String phone_number=rs.getString(2);
				String email=rs.getString(3);
				String password=rs.getString(4);
				
				MemberVo memberVo=new MemberVo();
				memberVo.setName(name);
				memberVo.setPhone_number(phone_number);
				memberVo.setEmail(email);
				memberVo.setPasswd(password);
				
				list.add(memberVo);
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



	public boolean update(MemberVo memberVo) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			String sql="update member "
					+ "set name=?, email=?, password=?, phone_number=?"
					+ "where no=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, memberVo.getName());
			stmt.setString(2, memberVo.getEmail());
			stmt.setString(3, memberVo.getPasswd());
			stmt.setString(4, memberVo.getPhone_number());
			stmt.setInt(5, memberVo.getNo());
			int count=stmt.executeUpdate();
			
			result=count==1;
			
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

	public boolean delete(int no) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			String sql="delete from member"
					+ " where no=?";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, no);
			int count=stmt.executeUpdate();
			
			result=count==1;
			
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

	
}
