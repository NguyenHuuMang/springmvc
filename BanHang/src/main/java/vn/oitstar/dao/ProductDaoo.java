package vn.oitstar.dao;

import java.util.List;

import vn.oitstar.model.ProductModel;

public interface ProductDaoo {
	int countAll();
	List<ProductModel> getAllProduct();
	List<ProductModel> getAllProductByCID(String cid);
	List<ProductModel> pagingProduct(int index);
	
	
}
