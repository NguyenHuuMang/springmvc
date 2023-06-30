package vn.oitsstar.dao.impl;



import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.oitstar.connection.DBConnect;
import vn.oitstar.dao.CartDao;
import vn.oitstar.model.AccountModel;
import vn.oitstar.model.CartModel;
import vn.oitstar.service.UserService;
import vn.oitstar.service.impl.UserServiceIplm;

public class CartDaoImpl extends DBConnect implements CartDao{
	UserService userS = new UserServiceIplm();

	@Override
	public void insert(CartModel cart) {
		String sql = "INSERT INTO Carts(id, u_id, buyDate) VALUES(?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cart.getId());
			ps.setInt(2, cart.getBuyer().getUid());
			ps.setDate(3, (java.sql.Date) new Date(cart.getBuydate().getTime()));
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(CartModel cart) {
		String sql = "UPDATE Carts SET id_user =?, buyDate =? where id =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cart.getBuyer().getUid());
			ps.setDate(2, (java.sql.Date) new Date(cart.getBuydate().getTime()));
			ps.setString(3, cart.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public CartModel get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartModel get(int id) {
		String sql = "SELECT Carts.id Carts.buyDate, User.email, User.username, user.id as user_id" + 
	"FROM Carts INNER JOIN user" + "ON Carts.id_user= user.id where carts.id=? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			AccountModel user = userS.get(rs.getInt("user_id"));
			CartModel cart = new CartModel();
			cart.setId(rs.getString("id"));
			cart.setBuydate(rs.getDate("buyDate"));
			cart.setBuyer(user);
			return cart;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CartModel> getAll() {
		List<CartModel> cartList = new ArrayList<CartModel>();
		String sql = "SELECT Carts.id, Carts.buyDate, User.email, user.username, user.id as user.id" + "FROM Carts inner join user" +"on Carts.id_user = user.id";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			AccountModel user = userS.get(rs.getInt("user_id"));
			CartModel cart = new CartModel();
			cart.setId(rs.getString("id"));
			cart.setBuydate(rs.getDate("buyDate"));
			cart.setBuyer(user);
			}} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public List<CartModel> search(String name) {
		List<CartModel> cartList = new ArrayList<CartModel>();
		String sql ="SELECT Carts.id, Carts.buyDate, User.email, user.username, user.id as user.id" + "From Carts inner join user" + "on Carts.id_user = user.id like User.email";
		
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			AccountModel user = userS.get(rs.getInt("user_id"));
			CartModel cart = new CartModel();
			cart.setId(rs.getString("id"));
			cart.setBuydate(rs.getDate("buyDate"));
			cart.setBuyer(user);
			cartList.add(cart);
	
		}} catch (Exception e) {
			e.printStackTrace();
		}
		return cartList;
	}

	@Override
	public void delete(int id) {
			String sql = "DELETE FROM Carts where id =?";
			try {
				Connection con = super.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}

		
	}

