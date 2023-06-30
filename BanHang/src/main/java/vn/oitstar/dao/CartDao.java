package vn.oitstar.dao;

import java.util.List;
import vn.oitstar.model.CartModel;

public interface CartDao {
	void insert(CartModel cartItem);
	void edit(CartModel cartItem);
	void delete(int id);
	CartModel get(String name);
	CartModel get(int id);
	List<CartModel> getAll();
	List<CartModel> search(String name);
}
