/**
 * 
 */
package com.yusys.test.service.impl;

import org.springframework.stereotype.Service;

import com.yusys.test.service.UserService;

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
