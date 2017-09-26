package com.sesame.dao;

import java.util.List;

public interface Dao<T> {
	/**
	 * 添加一个对象
	 * @param t
	 * @return
	 */
	int add(T t);

	int del(T t);

	int update(T t);

	T findOneById(String id);

	List<T> findAll();
}
