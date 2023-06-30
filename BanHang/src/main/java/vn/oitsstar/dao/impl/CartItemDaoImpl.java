package vn.oitsstar.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.oitstar.connection.DBConnect;
import vn.oitstar.dao.CartItemDao;
import vn.oitstar.dao.UserDao;
import vn.oitstar.model.AccountModel;
import vn.oitstar.model.CartItemModel;
import vn.oitstar.model.CartModel;
import vn.oitstar.model.ProductModel;
import vn.oitstar.service.CartService;
import vn.oitstar.service.ProductService;
import vn.oitstar.service.impl.CartServiceImpl;
import vn.oitstar.service.impl.ProductServiceImpl;

public class CartItemDaoImpl extends DBConnect implements CartItemDao {
	CartService cartService = new CartServiceImpl(); 
	ProductService productService = new ProductServiceImpl();
	UserDao userDao = new UserDaoImpl();
	@Override
	public void insert(CartItemModel cartItem) {
		String sql = "INSERT into CartItem(id, cat_id, pro_id, quantity, unitPrice) values (?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cartItem.getId());
			ps.setString(2, cartItem.getCart().getId());		
			ps.setInt(3, cartItem.getProduct().getId());
			ps.setInt(4, cartItem.getQuantity());
			ps.setDouble(5, cartItem.getUnitPrice());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void edit(CartItemModel cartItem) {
		String sql ="update CartItem set cat_id =?, pro_id =?, quantity =?. unitPrice=? where id =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cartItem.getCart().getId());
			ps.setInt(2, cartItem.getProduct().getId());		
			ps.setInt(3, cartItem.getQuantity());
			ps.setDouble(4, cartItem.getUnitPrice());
			ps.setString(5, cartItem.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void delete(String id) {
		String sql = "delete from CartItem where id =?";
		try {
		Connection con = super.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.executeUpdate();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Override
	public CartItemModel get(int id) {
		String sql = "select "+"CartItem.id, "+"CartItem.quantity,"+"CartItem.unitPrice,"+"Carts.u_id," 
	+ "Carts.buyDate," +"Product.name," +"Product.price" +"from CartItem" + "inner join Carts" 
	+ "on CartItem.cart_id = carts.id" + "inner join Product" + "on CartItem.pro_id = Product.id" 
	+"where CartItem.id =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userDao.get(rs.getInt("u_id"));
				CartModel cart = new CartModel();
				cart.setBuyer(user);
				cart.setBuydate(rs.getDate("buyDate"));
				ProductModel product = new ProductModel();
				product.setName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));
				CartItemModel cartItem = new CartItemModel();
				cartItem.setCart(cart);
				cartItem.setProduct(product);
				
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getLong("unitPrice"));
				return cartItem;
				}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<CartItemModel> getAll() {
		List<CartItemModel> cartItemList = new ArrayList<CartItemModel>();
		String sql = "select" +"CartItem.id, "+"CartItem.quantity,"+"CartItem.unitPrice,"
				+ ""+"Carts.u_id," + "Carts.buyDate," +"product.name," +"product.price"
				+"from CartItem" + "inner join Cart" + "on CartItem.cart_id = cart.id" 
				+ "inner join Product" + "on CartItem.pro_id = Product.id";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				AccountModel user = userDao.get(rs.getInt("u_id"));
				CartModel cart = new CartModel();
				cart.setBuyer(user);
				cart.setBuydate(rs.getDate("buyDate"));
				ProductModel product = new ProductModel();
				product.setName(rs.getString("name"));
				product.setPrice(rs.getLong("price"));
				CartItemModel cartItem = new CartItemModel();
				cartItem.setId(rs.getString("id"));
				cartItem.setCart(cart);
				cartItem.setProduct(product);				
				cartItem.setQuantity(rs.getInt("quantity"));
				cartItem.setUnitPrice(rs.getLong("unitPrice"));
				cartItemList.add(cartItem);
		}} catch (Exception e) {
			e.printStackTrace();
		}
				return cartItemList;
	}
	@Override
	public List<CartItemModel> search(String name) {
		return null;
	}
	@Override
	public CartItemModel get(String name) {
		return null;
	}
}
