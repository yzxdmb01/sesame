package com.sesame.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

@Component("redisCache")
public class RedisCacheUtil {
	@Resource
	public StringRedisTemplate redisTemplate;

	/**
	 * 向hash中添加值
	 *
	 * @param key
	 * @param field
	 * @param value
	 */
	public void hset(String field, String key, String value) {

		Jedis jedis = new Jedis("127.0.0.1", 6379);

		jedis.set(key, value);
//		jedis.hset(key,field,value);
	}

	/**
	 * 从redis中取值
	 *
	 * @param key
	 * @param field
	 * @return
	 */
	public String hget(String key, String field) {
		if (StringUtils.isEmpty(key))
			return null;

		String value = (String) redisTemplate.opsForHash().get(key, field);
		return value;
	}

	/**
	 * 判断redis是否有值
	 *
	 * @param key
	 * @param field
	 * @return
	 */
	public boolean hexists(String key, String field) {
		if (StringUtils.isEmpty(key))
			return false;
		return redisTemplate.opsForHash().hasKey(key, field);
	}

	/**
	 * 查询key对应多少条数据
	 *
	 * @param key
	 * @param field
	 * @return
	 */
	public long e(String key, String field) {
		if (StringUtils.isEmpty(key))
			return 0L;
		return redisTemplate.opsForHash().size(key);
	}

	/**
	 * 删除
	 *
	 * @param key
	 * @param field
	 * @return
	 */
	public long hdel(String key, String field) {
		if (StringUtils.isEmpty(key))
			return -1L;
		return redisTemplate.opsForHash().delete(key, field);
	}


}
