package com.springboot.demo.controller;

import com.springboot.demo.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	/***
	 * Test redirect addFlashAttribute to another url
	 * 
	 * @param attributes
	 * @return
	 */
	@GetMapping("/test/redirect")
	public ModelAndView redirectModelAndView(RedirectAttributes attributes) {
		ModelAndView mav = new ModelAndView("redirect:/redirect/getParam");
		attributes.addFlashAttribute("param", "Hello StringBoot!");
		return mav;
	}
}
