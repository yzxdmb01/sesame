package com.sesame;

import com.sesame.http.ResponseObj;
import com.sesame.utils.JsonUtils;
import com.sesame.utils.L;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.util.*;

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
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
		for (int i : newArray) {
			System.out.println(i);
		}
	}

	@Test
	public void testProperties() {
		String path = "test";
		ResourceBundle resourceBundle = ResourceBundle.getBundle(path);

		System.out.println(resourceBundle.getString("redis.port"));
	}

	@Test
	public void testConsoleInput() {
		System.out.println("请输入：");
		Scanner scaner = new Scanner(System.in);
		System.out.println("输入的内容是：");
	}

	public static void main(String[] args) {
		System.out.println("请输入：");
		Scanner scaner = new Scanner(System.in);
		String read = scaner.nextLine();
		System.out.println("输入的内容是：" + read);
	}


}
