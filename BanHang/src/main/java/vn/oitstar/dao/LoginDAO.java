package vn.oitstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import vn.oitstar.connection.DBConnect;
import vn.oitstar.model.AccountModel;

public class LoginDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public AccountModel login(String user, String pass) {
		String sql = " select * from Users where UserName =? and Password =?";
		try {
			//mở kết nối dtb
			conn = new DBConnect().getConnection();
			//đưa câu query  
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			//run query
			rs = ps.executeQuery();
			
			while (rs.next()) 
			{
				return new AccountModel(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getInt(5));
						
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
			
		
		
		
	}

}
