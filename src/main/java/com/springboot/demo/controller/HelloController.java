package com.springboot.demo.controller;

import com.springboot.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/hello") // == @RequestMapping(path="/hello",method = {RequestMethod.GET} )
	public String hello() {
		this.userService.say();
		return "Hello SpringBoot!";
	}
}
