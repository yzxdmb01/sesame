package com.sesame.dao;

import com.sesame.BaseTest;
import com.sesame.utils.RedisCacheUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisTest extends BaseTest {
	@Autowired
	private RedisCacheUtil redisCacheUtil;
	private final static String REDIS_KEY = "test_user";
	private final static String REDIS_FIELD = "test_name";


	@Test
	public void testRedis() {
		System.out.println("redis添加==========");
		redisCacheUtil.hset("ffffffffffffff2","kkkk2","vvv2");
	}

}
