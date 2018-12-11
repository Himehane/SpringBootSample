package com.springboot.demo.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Restful接口接受参数
 * 
 * Restful recive params test controller
 */
@RestController
@RequestMapping(value="restful")
public class RestReciveParamController{
    /**
     * GET方法
     * to test get method
     */
    @GetMapping(value = "get/{id}")
    public String testGetMethod(@PathVariable String id){ 
        System.out.println(id);
        return id;
    }
    /**
     * POST方法
     * to test post method
     */
    public void testPostMethod(){

    }
    /**
     * PUT方法
     * to test put method
     */
    public void testPutMethod(){

    }
    /**
     * DELETE方法
     * to test delete method
     */
    public void testDeleteMethod(){

    }
}