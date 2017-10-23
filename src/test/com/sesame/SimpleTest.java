package com.sesame;

import com.sesame.http.ResponseObj;
import com.sesame.utils.JsonUtils;
import com.sesame.utils.L;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

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
	public void testLog() {
		L.i("这是一条测试log");
		L.e("error");
	}

	/**
	 * 数据结构学习
	 */
	@Test
	public void testArray() {
		int[] oldArray = new int[10];
		for (int i = 0; i < 10; i++) {
			oldArray[i] = i;
		}
		int[] newArray = new int[20];
		System.arraycopy(oldArray,0,newArray,0,oldArray.length);
		for (int i : newArray) {
			System.out.println(i);
		}
	}

	@Test
	public void testProperties(){
		String path = "test";
		ResourceBundle resourceBundle = ResourceBundle.getBundle(path);

		System.out.println(resourceBundle.getString("redis.port"));
	}


}
