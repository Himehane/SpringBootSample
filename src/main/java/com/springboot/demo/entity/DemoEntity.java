package com.springboot.demo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Table(name ="demo")
@SolrDocument(solrCoreName = "demo")
public class DemoEntity {

    @Id
    private String id;
    @Column
    private String dateBase;
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
     * @return the dateBase
     */
    public String getDateBase() {
        return dateBase;
    }

    /**
     * @param dateBase the dateBase to set
     */
    public void setDateBase(String dateBase) {
        this.dateBase = dateBase;
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