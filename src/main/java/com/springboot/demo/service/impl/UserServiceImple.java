package com.springboot.demo.service.impl;

import com.springboot.demo.service.UserService;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: Himehane Ryuu
 * @createDate: 2018年1月31日
 * @version
 */
@Service
public class UserServiceImple implements UserService {

	@Override
	public void say() {
		System.out.println("===========say============");
	}

}
