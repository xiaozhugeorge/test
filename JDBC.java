package com.aowin.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String driver="com.mysql.jdbc.Driver";//驱动的路径
			
		    String url ="jdbc:mysql://localhost:3306/box";
		    String user="root";
		    String password="";
		    //存放sql的抽屉
		    Statement st = null;
		    String sql = null;
		    //存放结果集
		    ResultSet rs = null;
		    //-----
		    Class.forName(driver);//加载驱动，加载到java虚拟机（jvm）
		    Connection conn = DriverManager.getConnection(url,user,password);
			st=conn.createStatement();
			sql="insert into computer (id,name,price) value(3,\"ibm\",3)";
			int i = st.executeUpdate(sql);//执行更新：插入，删除，更新
			
			System.out.println("修改的函数： "+ i);
		    
		    conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
