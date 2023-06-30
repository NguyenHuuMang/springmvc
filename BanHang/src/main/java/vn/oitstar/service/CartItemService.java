package vn.oitstar.service;

import java.util.List;

import vn.oitstar.model.CartItemModel;

public interface CartItemService {

	void insert(CartItemModel cartItem);
	void edit(CartItemModel cartItem);
	void delete(String id);
	CartItemModel get(int id);
	List<CartItemModel> getAll();
	List<CartItemModel> search(String keyword);
} 
