package com.sesame.service;

import com.sesame.bean.User;

public interface UserService extends BaseService<User> {
	void add(User user) throws Exception;
}
