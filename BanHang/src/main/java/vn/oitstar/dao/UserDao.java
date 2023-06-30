package vn.oitstar.dao;

import vn.oitstar.model.AccountModel;

public interface UserDao {
	
	void insert(AccountModel user);

	AccountModel get(int u_id);
}
