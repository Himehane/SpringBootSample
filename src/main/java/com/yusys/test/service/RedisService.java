package com.yusys.test.service;


/**
 * @author Himehane
 * @createDate 11/2/2018
 */
public interface RedisService{

   String writerRedis(String id);
   String ReadRedis(String id);
}