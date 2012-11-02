package com.aowin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	private final String driver="com.mysql.jdbc.Driver";
	
	private String url="jdbc:mysql://localhost:3306/box";
	private String user="root";
	private String password = "";
	
	private Connection conn = null;
	private Statement st = null;
	private PreparedStatement pst=null;
	private String sql=null;
	private ResultSet rs = null;
	
	
	DBConnection(){
		init();
	}	
	
	private void getConnection(){
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败。。。。。。");
		}
	}
	
	public void insert(){
		this.getConnection();
		try {
			st = conn.createStatement();
			sql="insert into computer (name,id,price) value(\"ibm\",8,4)";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("插入的sql："+sql);
		}
		this.close();
	} 
	public void insert(int id, String name, int price){
		this.getConnection();
		try {
			st = conn.createStatement();
			sql="insert into computer (name,id,price) value(\""+name+"\","+id+","+price+")";
			st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("插入的sql："+sql);
		}
		this.close();
	} 
	public void pinsert(int id, String name, int price){
		this.getConnection();
		try {
			sql="insert into computer(name,id,price)values(?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1,name);
			pst.setInt(2, id);
			pst.setInt(3, price);
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("插入的sql："+sql);
		}
		this.close();
	} 
	public void pinsert(Computer com){
		this.getConnection();
		try {
			sql="insert into computer(name,id,price)values(?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1,com.getName());
			pst.setInt(2, com.getId());
			pst.setInt(3, com.getPrice());
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("插入的sql："+sql);
		}
		this.close();
	} 
	public void delete(Computer com){
		this.getConnection();
		try {
			st=conn.createStatement();
			sql="delete from computer";
			st.executeUpdate(sql);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("删除的sql："+sql);
		}
		this.close();
	}
	public void update(Computer com){
		this.getConnection();
		try {
			sql="update computer set name=? price =? where id =?";
			pst=conn.prepareStatement(sql);
			pst.setString(1,com.getName());
			pst.setInt(2, com.getPrice());
			pst.setInt(3, com.getId());
			
			
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("修改的sql："+sql);
		}
		this.close();
	}
	
	
	private void close(){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(st != null){
				st.close();
				st= null;
			}	
			if(pst!=null){
				pst.close();
				pst=null;
			}
			if(conn != null){
			  conn.close();
			  conn = null;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				
				
	}
	
	
	
	/**
	 * 初始化
	 */
	private void init(){
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
