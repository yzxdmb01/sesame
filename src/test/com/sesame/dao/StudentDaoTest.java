package com.sesame.dao;

import com.sesame.BaseTest;
import com.sesame.bean.Student;
import com.sesame.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

public class StudentDaoTest extends BaseTest {

	@Autowired
	StudentDao studentDao;
	@Autowired
	TestService testService;

	@Test
	public void testFind() {
		List<Student> list = studentDao.findAll();

		for (Student s : list) {
			System.out.println(s);
		}
	}

	@Test
	public void testAdd() {
		int count = testService.errorAdd();
		System.out.println("成了:" + count);
	}
}
