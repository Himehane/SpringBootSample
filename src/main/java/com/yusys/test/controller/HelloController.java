/**
 * 
 */
package com.yusys.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yusys.test.service.UserService;

/**
 * @Description:
 * @author: Himehane Ryuu
 * @createDate: 2018年1月31日
 * @version
 */
@RestController // == @Controller + @ResponseBody

public class HelloController {

	@Autowired
	private UserService userService;
	// 一次性加载定义文件
	@Autowired
	private Environment environment;
	@Value("${name}")
	private String name;
	@Value("${url}")
	private String url;

	@GetMapping("/hello") // == @RequestMapping(path="/hello",method = {RequestMethod.GET} )
	public String hello() {
		System.out.println("name=" + environment.getProperty("name"));
		System.out.println("url=" + environment.getProperty("url"));
		System.out.println("name" + "\t" + name);
		System.out.println("url" + "\t" + url);
		this.userService.say();
		return "Hello SpringBoot!";
	}
}
