package com.sesame.serviceImp;

import com.sesame.bean.User;
import com.sesame.exception.UserCanNotBeNullException;
import com.sesame.exception.UserNameCanNotBeNullException;
import com.sesame.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("userService")
public class UserServiceImp implements UserService {
	@Override
	public void add(User user) throws UserCanNotBeNullException {

		if (null == user)
			throw new UserCanNotBeNullException("User can not be null");
		if (StringUtils.isEmpty(user.getPwd()))
			throw new UserNameCanNotBeNullException("User name can not be null");


	}
}
