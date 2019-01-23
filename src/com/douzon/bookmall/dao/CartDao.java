package com.douzon.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.douzon.bookmall.vo.CartVo;

public class CartDao {
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

	public boolean insert(CartVo cartVo) {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			String sql="insert into cart"
					+ " values ( null, ?,?,?) ";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, cartVo.getCount());
			stmt.setInt(2, cartVo.getBook_no());
			stmt.setInt(3, cartVo.getMember_no());
			
			int count = stmt.executeUpdate();
			
			result= count==1;
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
		return result;
	}

	public List<CartVo> getList(int no) {
		// TODO Auto-generated method stub
		List<CartVo> list=new ArrayList<CartVo>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			
			stmt=conn.createStatement();
			String sql="select c.no, a.title, c.count, a.price*c.count " + 
					"from book a, member b, cart c " + 
					"where a.no=c.book_no and b.no=c.member_no and b.no="+no;
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				int cart_no=rs.getInt(1);
				String book_title=rs.getString(2);
				int count=rs.getInt(3);
				int book_price =rs.getInt(4);
				
				CartVo cartVo=new CartVo();
				cartVo.setNo(cart_no);
				cartVo.setBook_title(book_title);
				cartVo.setBook_price(book_price);
				cartVo.setCount(count);
				
				list.add(cartVo);
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

	public boolean update(CartVo cartVo) {
		// TODO Auto-generated method stub
		boolean result=false;
		
		Connection conn=null;
		PreparedStatement stmt=null;
		try {
			conn=getConnection();
			
			String sql="update cart "
					+ "set count=?, book_no=?, member_no=?"
					+ " where no=?";
			stmt=conn.prepareStatement(sql);
			stmt.setInt(1, cartVo.getCount());
			stmt.setInt(2, cartVo.getBook_no());
			stmt.setInt(3, cartVo.getMember_no());
			stmt.setInt(4, cartVo.getNo());
			
			int count =stmt.executeUpdate();
			
			result=count==1;
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
		return result;
	}

	public boolean delete(int no) {
		// TODO Auto-generated method stub
		boolean result=false;
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			conn=getConnection();
			
			String sql="delete from cart"
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
				if(conn!=null&&!conn.isClosed())
					conn.close();
				if(stmt!=null&&!stmt.isClosed())
					stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return result;
	}

	public List<CartVo> getList() {
		// TODO Auto-generated method stub
		List<CartVo> list=new ArrayList<CartVo>();
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			
			stmt=conn.createStatement();
			String sql="select c.no, a.title, c.count, a.price*c.count " + 
					"from book a, member b, cart c " + 
					"where a.no=c.book_no and b.no=c.member_no";
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				int cart_no=rs.getInt(1);
				String book_title=rs.getString(2);
				int count=rs.getInt(3);
				int book_price =rs.getInt(4);
				
				CartVo cartVo=new CartVo();
				cartVo.setNo(cart_no);
				cartVo.setBook_title(book_title);
				cartVo.setBook_price(book_price);
				cartVo.setCount(count);
				
				list.add(cartVo);
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

	public int getTotalMoney(int no) {
		// TODO Auto-generated method stub
		int count=-1;
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			conn=getConnection();
			stmt=conn.createStatement();
			String sql="select sum( b.price * a.count) " + 
					"from cart a, book b " + 
					"where a.book_no=b.no " + 
					"group by a.member_no " + 
					"having a.member_no="+no;
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				count=rs.getInt(1);
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
		return count;
	}
}
