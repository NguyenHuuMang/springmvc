package vn.oitstar.service;

import vn.oitstar.model.AccountModel;

public interface UserService {

	void insert(AccountModel user);

	AccountModel get(int int1);
	
}
