package com.springboot.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Table(name ="demo")
@SolrDocument(collection = "demo")
public class DemoEntity {

    @Id
    @Field("id")
    private String id;
    @Column
    private String dateBaseField;
    @Field
    private String solrField;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the dateBaseField
     */
    public String getDateBaseField() {
        return dateBaseField;
    }

    /**
     * @param dateBaseField the dateBaseField to set
     */
    public void setDateBaseField(String dateBaseField) {
        this.dateBaseField = dateBaseField;
    }

    /**
     * @return the solrField
     */
    public String getSolrField() {
        return solrField;
    }

    /**
     * @param solrField the solrField to set
     */
    public void setSolrField(String solrField) {
        this.solrField = solrField;
    }

}