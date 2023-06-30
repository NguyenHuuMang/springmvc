package vn.oitstar.service.impl;

import java.util.List;

import vn.oitstar.dao.ProductDaoImpl;
import vn.oitstar.dao.ProductDaoo;
import vn.oitstar.model.ProductModel;
import vn.oitstar.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDaoo productDao= new ProductDaoImpl();

	public int countAll() {
		// TODO Auto-generated method stub
		return productDao.countAll();
	}

	public List<ProductModel> getAllProduct() {
		// TODO Auto-generated method stub
		return productDao.getAllProduct();
	}

	@Override
	public List<ProductModel> getAllProductByCID(String cid) {
		// TODO Auto-generated method stub
		return productDao.getAllProductByCID(cid);
	}

	@Override
	public List<ProductModel> pagingProduct(int index) {
		// TODO Auto-generated method stub
		return productDao.pagingProduct(index);
	}

}
