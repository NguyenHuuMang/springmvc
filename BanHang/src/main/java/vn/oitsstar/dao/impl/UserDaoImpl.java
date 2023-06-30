package vn.oitsstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.oitstar.connection.DBConnect;
import vn.oitstar.dao.UserDao;
import vn.oitstar.model.AccountModel;

public class UserDaoImpl implements UserDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public void insert(AccountModel user) {
	
		String sql = "INSERT INTO [User] (username,password, isSeller, isAdmin) VALUES (?,?,?,?)";
		
		try {
			
			conn= new DBConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUser());
			ps.setString(2,  user.getPass());
			
			ps.setInt(3, user.getIsSell());
			ps.setInt(4, user.getIsAdmin());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public AccountModel get(int u_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
