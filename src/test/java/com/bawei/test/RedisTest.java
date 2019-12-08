package com.bawei.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bawei.entity.User;
import com.rui.common.utils.RandomUtils;
import com.rui.common.utils.StringUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-redis.xml")
public class RedisTest {

	@Resource
	private RedisTemplate redisTemplate;
	
	@Test
	public void testJDK() {
		
		ArrayList<User> list = new ArrayList();
		
		//生成数据
		for (int i = 1; i <= 50000; i++) {
			//随机名字
			String name = StringUtil.randomChineseString(3);
			
			//随机手机号
			String phone = "13" + RandomUtils.randomString(9);
			
			User user = new User(i, name, phone);
			list.add(user);
		}
		
		//存入数据
		ListOperations opsForList = redisTemplate.opsForList();
		
		//获取开始时间的毫秒值
		long l1 = System.currentTimeMillis();
		
		opsForList.leftPush("user_jdk", list);
		
		//结束
		long l2 = System.currentTimeMillis();
		System.out.println("消耗时间"+(l2-l1));
	}
	
	@Test
	public void testJson() {
		
		ArrayList<User> list = new ArrayList();
		
		//生成数据
		for (int i = 1; i <= 50000; i++) {
			//随机名字
			String name = StringUtil.randomChineseString(3);
			
			//随机手机号
			String phone = "13" + RandomUtils.randomString(9);
			
			User user = new User(i, name, phone);
			list.add(user);
		}
		
		//存入数据
		ListOperations opsForList = redisTemplate.opsForList();
		
		//获取开始时间的毫秒值
		long l1 = System.currentTimeMillis();
		
		opsForList.leftPushAll("user_json", list);
		
		//结束
		long l2 = System.currentTimeMillis();
		System.out.println("消耗时间"+(l2-l1));
	}
	
	@Test
	public void testHash() {
		
		HashMap<String, User> hashMap = new HashMap<String, User>();
		
		//生成数据
		for (int i = 1; i <= 50000; i++) {
			//随机名字
			String name = StringUtil.randomChineseString(3);
			
			//随机手机号
			String phone = "13" + RandomUtils.randomString(9);
			
			User user = new User(i, name, phone);
			hashMap.put(i+"", user);
		}
		
		HashOperations opsForHash = redisTemplate.opsForHash();
		//获取开始时间的毫秒值
		long start = System.currentTimeMillis();
		
		opsForHash.putAll("user_hash", hashMap);
		
		//获取结束时间的毫秒值
		long end = System.currentTimeMillis();
		
		System.out.println(end-start);
	}
}
