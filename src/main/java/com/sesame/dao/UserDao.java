package com.sesame.dao;

import com.sesame.bean.User;

import java.util.List;

public interface UserDao extends Dao<User> {

	@Override
	int add(User user);

	@Override
	int del(User user);

	@Override
	int update(User user);

	@Override
	User findOneById(String id);

	@Override
	List<User> findAll();
}
