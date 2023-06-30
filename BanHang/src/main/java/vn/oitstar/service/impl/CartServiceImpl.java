package vn.oitstar.service.impl;

import java.util.List;
import vn.oitsstar.dao.impl.CartDaoImpl;
import vn.oitstar.dao.CartDao;
import vn.oitstar.model.CartModel;
import vn.oitstar.service.CartService;

public class CartServiceImpl implements CartService {

	CartDao cartDao = new CartDaoImpl();


	@Override
	public void insert(CartModel cart) {
		cartDao.insert(cart);
		
	}

	@Override
	public void edit(CartModel newCart) {
		CartModel oldCart = cartDao.get(newCart.getId());
		oldCart.setBuydate(newCart.getBuydate());
		oldCart.setBuyer(newCart.getBuyer());
		cartDao.edit(oldCart);
	}

	@Override
	public void delete(int id) {
		cartDao.delete(id);
		
	}

	@Override
	public CartModel get(int id) {
		return cartDao.get(id);
	}

	@Override
	public List<CartModel> getAll() {
		return cartDao.getAll();
	}

	@Override
	public List<CartModel> search(String name) {
		return cartDao.search(name);
	}
}
