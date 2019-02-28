package com.springboot.demo.service;

import java.util.List;

public interface BaseEntityService<T> {
    /** 分页查询 */
	List<T> findByPage(Integer pageNum, Integer pageSize);
}