package vn.oitstar.service.impl;

import vn.oitsstar.dao.impl.UserDaoImpl;
import vn.oitstar.dao.UserDao;
import vn.oitstar.model.AccountModel;
import vn.oitstar.service.UserService;

public class UserServiceIplm implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public void insert(AccountModel user) {
	
			userDao.insert(user);
			
	}
	@Override
	public AccountModel get(int int1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
