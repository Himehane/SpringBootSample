package com.springboot.demo.service.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.springboot.demo.service.BaseEntityService;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;
public abstract class BaseEntityServiceImpl<T> implements BaseEntityService<T>{

    @Autowired
	private Mapper<T> mapper;
	
	@SuppressWarnings("unused")
    private Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public BaseEntityServiceImpl(){
		/* 获取类上面泛型参数类型  */
		ParameterizedType  parameterizedType = (ParameterizedType )this.getClass()
					.getGenericSuperclass();
        /* 获取所有的实际类型参数，取第一个*/
		this.entityClass = (Class<T>)parameterizedType.getActualTypeArguments()[0];
    }

    /** 分页查询 */
	public List<T> findByPage(Integer pageNum, Integer pageSize){
		/** 设置分页查询条件 */
		PageHelper.startPage(pageNum, pageSize);
		return mapper.selectAll();
	}

}