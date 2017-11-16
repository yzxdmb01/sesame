package com.sesame.controller;

import com.sesame.http.ResponseObj;
import com.sesame.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	private ResponseObj responseObj;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String toLogin() {
		return "singnin";
	}

	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	@ResponseBody
	public String doLogin() {
		responseObj = new ResponseObj();
		responseObj.setCode(ResponseObj.SUCCESS);
		responseObj.setMsg("登录成功");
		return JsonUtils.toJson(responseObj);
	}



}
