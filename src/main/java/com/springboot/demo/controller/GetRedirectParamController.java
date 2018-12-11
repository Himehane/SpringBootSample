package com.springboot.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;

@RestController
public class GetRedirectParamController {

    protected static final Logger log = LoggerFactory.getLogger(GetRedirectParamController.class);
    /***
     * Test getFlashAttribute from redirected method
     * 
     * @param param
     * @return
     */
    @GetMapping("/redirect/getParam")
    public Map<Object, String> getRedirectParam(@ModelAttribute("param") String param 
                                                /*Add annotation and param name on a variable with ModelAttribute*/
                                                ,HttpServletRequest request) {
        log.info("enter getRedirectParam method");
        String flashParam = request.getParameter("param");//Direct get from request.getParameter();
        Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);//Get FlashParam from RequestContextUtils
        Map<Object, String> params = new HashMap<>();
        params.put("param", param);
        params.put("flashParam", flashParam);
        params.put("flashParam from flashMap", flashMap.get("param").toString());
        return params;
    }
}