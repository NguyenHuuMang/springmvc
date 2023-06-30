package vn.oitstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.oitstar.connection.DBConnect;
import vn.oitstar.model.CategoryModel;
import vn.oitstar.model.ProductModel;

public class CategoryDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<CategoryModel> getALLCategory(){
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		String sql ="select * from Category";
		try {
			//mở kết nối dtb
			conn = new DBConnect().getConnection();
			//đưa câu query  
			ps = conn.prepareStatement(sql);
			//run query
			rs = ps.executeQuery();
			//lấy từ resultset đưa vào list
			while (rs.next()){
				list.add(new CategoryModel(rs.getInt(1), rs.getString(2),rs.getString(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<ProductModel> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}
}
