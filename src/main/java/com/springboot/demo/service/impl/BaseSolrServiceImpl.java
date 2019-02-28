package com.springboot.demo.service.impl;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.springboot.demo.service.BaseSolrService;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.mapping.SolrDocument;


public abstract class BaseSolrServiceImpl<T> implements BaseSolrService<T> {

	private final Logger logger = LoggerFactory.getLogger(BaseSolrServiceImpl.class);
	@Autowired
	public SolrClient solrClient;

	private Class<T> entityClass;

	private String collection;

	@SuppressWarnings("unchecked")
	public BaseSolrServiceImpl() {
		/* 获取类上面泛型参数类型  */
		ParameterizedType  parameterizedType = (ParameterizedType )this.getClass()
					.getGenericSuperclass();
        /* 获取所有的实际类型参数，取第一个*/
		this.entityClass = (Class<T>)parameterizedType.getActualTypeArguments()[0];
		SolrDocument annotation =  this.entityClass.getAnnotation(SolrDocument.class);
		this.collection = annotation.solrCoreName();
	}
	

	/**
	 * 批量添加或修改索引
	 * 
	 * @param           <?>
	 * @param solrItems 集合
	 */
	public void saveOrUpdate(List<T> solrItems) {
		try {
			/** 批量添加，返回修改响应对象 */
			UpdateResponse response = solrClient.addBeans(collection,solrItems);
			/** 判断状态码: 0 代表成功 */
			if (response.getStatus() == 0) {
				/** 提交事务 */
				solrClient.commit(collection);
				logger.info(solrItems.size() +  " items save or updated");
			} else {
				/** 回滚事务 */
				solrClient.rollback(collection);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public List<T> getList(SolrQuery query) {
		QueryResponse response = null;
		try {
			response = solrClient.query(collection, query);
		} catch (SolrServerException e) {
			e.printStackTrace();
			logger.error(e.toString());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return response.getBeans(entityClass);
	}

	public QueryResponse getResponse(SolrQuery query){
		QueryResponse response = null;
		try {
			response = solrClient.query(collection, query);
		} catch (SolrServerException e) {
			e.printStackTrace();
			logger.error(e.toString());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		return response;
	}

	public void deleteAll(){
		try {
			solrClient.deleteByQuery(collection, "*:*");
		} catch (SolrServerException e) {
			e.printStackTrace();
			logger.error(e.toString());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
	}
}
