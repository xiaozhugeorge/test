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
			String driver="com.mysql.jdbc.Driver";//������·��
			
		    String url ="jdbc:mysql://localhost:3306/box";
		    String user="root";
		    String password="";
		    //���sql�ĳ���
		    Statement st = null;
		    String sql = null;
		    //��Ž����
		    ResultSet rs = null;
		    //-----
		    Class.forName(driver);//�������������ص�java�������jvm��
		    Connection conn = DriverManager.getConnection(url,user,password);
			st=conn.createStatement();
			sql="insert into computer (id,name,price) value(3,\"ibm\",3)";
			int i = st.executeUpdate(sql);//ִ�и��£����룬ɾ��������
			
			System.out.println("�޸ĵĺ����� "+ i);
		    
		    conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
