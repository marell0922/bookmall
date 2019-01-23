package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.OrderVo;

public class OrderDao {

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
	
	public boolean insert(OrderVo orderVo) {
		// TODO Auto-generated method stub
		boolean result =false;
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=getConnection();
			
			String sql="insert into orderlist "
					+ "values (null,?, ?,?)";
			
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1,orderVo.getMember_no());
			stmt.setInt(2, orderVo.getTotal_price());
			stmt.setString(3, orderVo.getDestination());
			
			int count = stmt.executeUpdate();
			
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

	public List<OrderVo> getList(int no) {
		// TODO Auto-generated method stub
		List<OrderVo> list=new ArrayList<OrderVo>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			//, 안대혁/kickscar@gmail.com, 53000, 서울시 은평구 진관동 구파발 래미안 APT
			String sql="select b.name, b.email, a.total_price, a.destination " + 
					"from orderlist a, member b " + 
					"where a.member_no =b.no and a.member_no="+no;
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name=rs.getString(1);
				String email=rs.getString(2);
				int total_price=rs.getInt(3);
				String destination = rs.getString(4);
				
				OrderVo orderVo=new OrderVo();
				orderVo.setMember_name(name);
				orderVo.setMember_email(email);
				orderVo.setTotal_price(total_price);
				orderVo.setDestination(destination);
				
				list.add(orderVo);
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
				
				if(rs!=null&&!rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return list;
	}

	public List<OrderVo> getList() {
		// TODO Auto-generated method stub
		List<OrderVo> list=new ArrayList<OrderVo>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			//, 안대혁/kickscar@gmail.com, 53000, 서울시 은평구 진관동 구파발 래미안 APT
			String sql="select b.name, b.email, a.total_price, a.destination " + 
					"from orderlist a, member b " + 
					"where a.member_no =b.no";
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				String name=rs.getString(1);
				String email=rs.getString(2);
				int total_price=rs.getInt(3);
				String destination = rs.getString(4);
				
				OrderVo orderVo=new OrderVo();
				orderVo.setMember_name(name);
				orderVo.setMember_email(email);
				orderVo.setTotal_price(total_price);
				orderVo.setDestination(destination);
				
				list.add(orderVo);
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
				
				if(rs!=null&&! rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return list;
	}

	public boolean update(OrderVo orderVo) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=getConnection();
			
			String sql="update orderlist "
					+ "set destination=? "
					+ "where member_no=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, orderVo.getDestination());
			stmt.setInt(2, orderVo.getMember_no());
			
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
			
			String sql="delete from orderlist "
					+ "where no=?";
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
