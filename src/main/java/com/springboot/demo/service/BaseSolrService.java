package com.springboot.demo.service;

import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;

public interface BaseSolrService<T> {

	void saveOrUpdate(List<T> solrItems);

	List<T> getList(SolrQuery query);

	QueryResponse getResponse(SolrQuery query);

	void deleteAll();
}