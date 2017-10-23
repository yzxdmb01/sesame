package com.sesame.controller;

import com.sesame.bean.User;
import com.sesame.http.ResponseObj;
import com.sesame.service.TestService;
import com.sesame.utils.JsonUtils;
import com.sesame.utils.L;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@Autowired
	TestService testService;

	@ResponseBody
	@RequestMapping(value = "test")
	public String testStr(@RequestParam(required = false) String s) {
		testService.testSth();
		L.i("杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭杭");
		L.e("eeeeeeeeeeeeeeeeeeeee");
		return "{\"key\":\"123abc小明\"}";
	}

	@ResponseBody
	@RequestMapping(value = "result")
	public String testJson(){
		User user = new User();
		user.setName("小李子");
		user.setLoginId("a0000001");
		user.setPwd("000000");
		ResponseObj<User> responseObj = new ResponseObj<>();
		responseObj.setCode(ResponseObj.SUCCESS);
		responseObj.setMsg("测试成功");
		String result = JsonUtils.toJson(responseObj);
		return result;
	}

	@RequestMapping("abc")
	public String testABC() {
		System.out.println("these's abc method");
		return "abc";
	}

	@RequestMapping("testUpload")
	public String toUpload(){
		return "test_upload";
	}


}
