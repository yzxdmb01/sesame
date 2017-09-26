package com.sesame.serviceImp;

import com.sesame.bean.Student;
import com.sesame.dao.StudentDao;
import com.sesame.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("testService")
public class TestServiceImp implements TestService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public void testSth() {
		List<Student> list = studentDao.findAll();
		for (Student s : list) {
			System.out.println(s);
		}
		System.out.println("there is testServiceImp testSth");
	}

	@Override
	public int errorAdd() {
		Student student = new Student("测试b", 12, 1);
//		int count = studentDao.add(student);
		return 1;
	}


}
