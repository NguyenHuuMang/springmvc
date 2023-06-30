package vn.oitsstar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale.Category;

import vn.oitstar.connection.DBConnect;
import vn.oitstar.dao.CategoryDaoo;
import vn.oitstar.model.CategoryModel;

public class CategoryDAOImpl extends DBConnect implements CategoryDaoo {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

		public void insert(Category category) {
			String sql = "INSERT INTO Category(cate_name, icons) values(?,?)";
			try {
				conn= new DBConnect().getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, category.getName());
				ps.setString(2,  category.getIcon());
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void edit(Category category) {
			String sql ="UPDATE category SET cate_name =?, icons=? WHERE cate_id=?";
			try {
				conn= new DBConnect().getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, category.getName());
				ps.setString(2,  category.getIcon());
				ps.setInt(3, category.getId());
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void delete(int id) {
			String sql ="DELETE FROM category where cate_id=?";
			try {
				conn= new DBConnect().getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public Category get(int id) {
			String sql ="SELECT * FROM Category Where cate_id=?";
			try {
				conn= new DBConnect().getConnection();
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("cate_id"));
				category.setName(rs.getString("cate_name"));
				category.setIcons(rs.getString("icons"));
				return category;
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}


