package com.springboot.demo.service;

import java.io.Serializable;
import java.util.List;

public interface BaseEntityService<T> {

    void saveSelective(T entity);

    void updateSelective(T entity);

    void delete(Serializable id);

    void deleteAll(String idField, Serializable[] ids);

    T findOne(Serializable id);

    List<T> findAll();

    List<T> findAllByWhere(T entity);

    int countByWhere(T entity);

    /** 分页查询 */
    List<T> findByPage(Integer pageNum, Integer pageSize);
}