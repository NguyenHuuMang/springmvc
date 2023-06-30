package vn.oitstar.service;

import java.util.List;

import vn.oitstar.model.CartModel;

public interface CartService {
	void insert(CartModel cart);
	void edit(CartModel newCart);
	void delete(int id);
	CartModel get(int id);
	List<CartModel> getAll();
	List<CartModel> search(String keyword);
}
