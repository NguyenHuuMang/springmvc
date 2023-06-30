package vn.oitstar.service.impl;

import java.util.List;
import vn.oitsstar.dao.impl.CartItemDaoImpl;
import vn.oitstar.dao.CartItemDao;
import vn.oitstar.model.CartItemModel;
import vn.oitstar.service.CartItemService;

public class CartItemServiceImpl implements CartItemService {

	CartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public void insert(CartItemModel cartItem) {
		cartItemDao.insert(cartItem);

	}

	@Override
	public void edit(CartItemModel newCartItem) {
		CartItemModel oldCartItem = cartItemDao.get(newCartItem.getId());
		oldCartItem.setCart(newCartItem.getCart());
		oldCartItem.setProduct(newCartItem.getProduct());
		oldCartItem.setQuantity(newCartItem.getQuantity());
		oldCartItem.setUnitPrice(newCartItem.getUnitPrice());
		cartItemDao.edit(oldCartItem);
	}

	@Override
	public void delete(String id) {
		cartItemDao.delete(id);

	}

	/*
	 * @Override public CartItemModel get(String name) { // TODO Auto-generated
	 * method stub return null;
	 * 
	 * }
	 */

	@Override
	public CartItemModel get(int id) {
		return cartItemDao.get(id);
	}

	@Override
	public List<CartItemModel> getAll() {
		return cartItemDao.getAll();
	}

	@Override
	public List<CartItemModel> search(String keyword) {
		return cartItemDao.search(keyword);
	}
}
