package vn.oitstar.dao;

import java.util.ArrayList;
import java.util.List;

import vn.oitstar.connection.DBConnect;
import vn.oitstar.model.ProductModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDaoImpl implements ProductDaoo {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	
	//hiển thị all sản phẩm
	public List<ProductModel> getAllProduct(){
		//khai báo list để lưu danh sách sp
		List<ProductModel> list = new ArrayList<ProductModel>();
		//Khai báo chuỗi truy vấn
		String sql= "select * from Product \r\n"
				+ "order by Price ASC";
		try {
			//mở kết nối dtb
			conn = new DBConnect().getConnection();
			//đưa câu query  
			ps = conn.prepareStatement(sql);
			//run query
			rs = ps.executeQuery();
			//lấy từ resultset đưa vào list
			while (rs.next() ) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6),rs.getInt(7),rs.getInt(8)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return list;		
	}	
	
	//hiển thị all sản phẩm theo category
		public List<ProductModel> getAllProductByCID(String cid){
			//khai báo list để lưu danh sách sp
			List<ProductModel> list = new ArrayList<ProductModel>();
			//Khai báo chuỗi truy vấn
			String sql= "select * from Product\r\n"
					+ "where CategoryID = ?";
			try {
				//mở kết nối dtb
				conn = new DBConnect().getConnection();
				//đưa câu query  
				ps = conn.prepareStatement(sql);
				//gán gái trị cho dấu hỏi
				ps.setString(1, cid);
				//run query
				
				rs = ps.executeQuery();
				//lấy từ resultset đưa vào list
				while (rs.next() ) {
					list.add(new ProductModel(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6),rs.getInt(7),rs.getInt(8)));
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}	
			return list;		
		}	
	
	//Hiển thị 4 sp mới nhất
	public List<ProductModel> getTop4Product(){
		//khai báo list để lưu danh sách sp
		List<ProductModel> list = new ArrayList<ProductModel>();
		//Khai báo chuỗi truy vấn
		String sql= "select TOP 4 * from Product \r\n"
				+ "order by ProductID DESC";
		try {
			//mở kết nối dtb
			conn = new DBConnect().getConnection();
			//đưa câu query  
			ps = conn.prepareStatement(sql);
			//run query
			rs = ps.executeQuery();
			//lấy từ resultset đưa vào list
			while (rs.next() ) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6),rs.getInt(7),rs.getInt(8)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return list;		
	}	
	
		
	public static void main(String [] args) {
		ProductDaoImpl dao = new ProductDaoImpl();
		List<ProductModel> list = dao.getTop4Product();
		System.out.println(list);
		}

	public ProductModel getProductByID(String id) {
	
		String sql ="select * from Product\r\n"
				+ "where ProductID = ? ";
		try {
			//mở kết nối dtb
			conn = new DBConnect().getConnection();
			//đưa câu query  
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			//run query
			rs = ps.executeQuery();
			//lấy từ resultset đưa vào list
			while (rs.next()) 
			{
				return new ProductModel(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getString(5), rs.getInt(6),rs.getInt(7),rs.getInt(8));
			}
			

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<ProductModel> searchByProductName(String txtSearch){
		List<ProductModel> list = new ArrayList<ProductModel>();
		//Khai báo chuỗi truy vấn
		String sql= "select * from Product where ProductName like ? ";
		try {
			
			conn = new DBConnect().getConnection();
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,"%" + txtSearch + "%");
	
			rs = ps.executeQuery();
		
			while (rs.next() ) {
				list.add(new ProductModel(rs.getInt(1), 
						rs.getString(2),
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5),
						rs.getInt(6),rs.getInt(7),rs.getInt(8)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return list;	
		
	}

	@Override
	public int countAll() {
		String sql = "SELECT count(*)\r\n"
				+ "  FROM Product";
		
		try {
	conn = new DBConnect().getConnection();
			
			ps = conn.prepareStatement(sql);	
			rs = ps.executeQuery();
		
			while (rs.next() ) {
				return rs.getInt(1);
			}
		} catch (Exception e) {				
		}	
		return 0;
	}

	public List<ProductModel> pagingProduct(int index) {
		String sql = "select * from Product order by ProductID OFFSET ? Row fetch next 6 rows only";
		List<ProductModel> list = new ArrayList<ProductModel>();
		try {
			//mở kết nối dtb
			conn = new DBConnect().getConnection();
			//đưa câu query  
			ps = conn.prepareStatement(sql);
			//run query
			ps.setInt(1, (index-1)*6);
			rs = ps.executeQuery();
			//lấy từ resultset đưa vào list
			while (rs.next() ) {
				list.add(new ProductModel(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6),rs.getInt(7),rs.getInt(8)));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return list;
	}
	
}
