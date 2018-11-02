package com.yusys.test.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.yusys.test.service.RedisService;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImple implements RedisService{

	
	@Override
	@CachePut(value="test",key="#id")
    public String writerRedis(String id) {
		StringBuffer sb = new StringBuffer();
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		sb.append(format.format(now));
		return sb.toString();
    }
	@Override
	@Cacheable(value="test",key="#id")
	public String ReadRedis(String id) {
		return new String();
	}

}