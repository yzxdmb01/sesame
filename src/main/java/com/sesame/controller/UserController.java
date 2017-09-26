package com.sesame.controller;

import com.sesame.bean.User;
import com.sesame.http.ResponseObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("userAction")
public class UserController {
	private ResponseObj<User> responseObj;

	@RequestMapping("login")
	@ResponseBody
	public Object login(User user, HttpServletResponse response) {
		System.out.println("user:" + user);
		responseObj = new ResponseObj<>();
		responseObj.setCode(ResponseObj.SUCCESS);
		responseObj.setMsg("123登录成功abc");
		Map<String, String> map = new HashMap<>();
		map.put("nextUrl", "/home");
		responseObj.setData(map);
		return responseObj;
	}

	@ResponseBody
	@RequestMapping(value = "test")
	public String testStr(@RequestParam(required = false) String s) {
		System.out.println("接收到的参数：" + s);
		return "abc小明123:" + s;
	}

}
