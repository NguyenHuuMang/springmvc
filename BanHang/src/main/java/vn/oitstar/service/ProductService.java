package vn.oitstar.service;

import java.util.List;

import vn.oitstar.model.ProductModel;

public interface ProductService {
	int countAll ();
	List<ProductModel> getAllProduct();
	List<ProductModel> getAllProductByCID(String cid);
	List<ProductModel> pagingProduct(int index);
}