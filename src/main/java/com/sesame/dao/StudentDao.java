package com.sesame.dao;

import com.sesame.bean.Student;

import java.util.List;

public interface StudentDao extends Dao<Student> {

	@Override
	int add(Student student);

	@Override
	int del(Student student);

	@Override
	int update(Student student);

	@Override
	Student findOneById(String id);

	@Override
	List<Student> findAll();
}
