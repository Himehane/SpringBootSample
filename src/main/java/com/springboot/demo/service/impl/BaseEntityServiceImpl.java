package com.springboot.demo.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.springboot.demo.service.BaseEntityService;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
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

	public void saveSelective(T entity){
		mapper.insertSelective(entity);
	}
	public void updateSelective(T entity){
		mapper.updateByPrimaryKeySelective(entity);
	}
	public void delete(Serializable id){
		mapper.deleteByPrimaryKey(id);
	}
	public void deleteAll(String idField, Serializable[] ids){
		Example example = new Example(entityClass);
		Criteria criteria = example.createCriteria();
		criteria.andIn(idField, Arrays.asList(ids));
		mapper.deleteByExample(example);
	}
	public T findOne(Serializable id){
		return mapper.selectByPrimaryKey(id);
	}
	public List<T> findAll(){
		return mapper.selectAll();
	}
	
	
	public int countByWhere(T entity){
		return mapper.selectCount(entity);
	}
	public List<T> findAllByWhere(T entity){
		return mapper.select(entity);
	}

    /** 分页查询 */
	public List<T> findByPage(Integer pageNum, Integer pageSize){
		/** 设置分页查询条件 */
		PageHelper.startPage(pageNum, pageSize);
		return mapper.selectAll();
	}

}