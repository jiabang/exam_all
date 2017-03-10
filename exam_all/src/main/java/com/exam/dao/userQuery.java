package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exam.entity.userEntity;

public class userQuery {
	
	
	
	Connection conn =null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	public userEntity getUser(String name ,String pass) throws Exception{
		userEntity user=new userEntity();
		String sql="SELECT u.user_name,u.user_pass FROM mytest.muser u where user_name=? and user_pass=? ;";
		    
		    	Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","root");
				ps=conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, pass);
				rs=ps.executeQuery();
				if(rs.next()){
					user.setName(rs.getString("user_name"));
					user.setPass(rs.getString("user_pass"));
					System.out.println(rs.getString("user_name"));
					System.out.println(rs.getString("user_pass"));
				}else{
					return null;
				}			
					    
		return user;
	}

}
