package com.sesame;

import com.sesame.http.ResponseObj;
import com.sesame.utils.JsonUtils;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class SimpleTest {

	@Test
	public void testStrEmpty() {
		String a = "a";
		String b = "";
		String c = null;
		System.out.println("a:" + StringUtils.isEmpty(a));
		System.out.println("b:" + StringUtils.isEmpty(b));
		System.out.println("c:" + StringUtils.isEmpty(c));
	}

	@Test
	public void testJsonUtils() {
		ResponseObj<Map> responseObj = new ResponseObj();
		responseObj.setCode(ResponseObj.SUCCESS);
		responseObj.setMsg("测试成功");
		Map map = new HashMap();
		map.put("k", "v");
		responseObj.setData(map);
		String result = JsonUtils.toJson(responseObj);

		System.out.println("result:" + result);
	}
}
