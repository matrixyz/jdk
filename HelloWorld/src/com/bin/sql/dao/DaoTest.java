package com.bin.sql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoTest implements tt{
	
public void dao() throws Exception{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/eshop", "root","a");
	
	String sql="select * from users where unam=? and pwd=?";
	PreparedStatement ps=conn.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		System.out.println(rs.getString("name"));
	}
	rs.close();
	ps.close();
	conn.close();
}
public void dao(int a){
	
	
}


}
interface tt{}