package com.springboot.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description:
 * @author: Himehane Ryuu
 * @createDate: 2018年1月31日
 * @version
 */
@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(basePackages = "com.springboot.demo.mapper")
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 第一种方式，运行SpringBoot项目
		// SpringApplication.run(Application.class, args);
		// 第二种方式，运行SpringBoot项目
		SpringApplication springApplication = new SpringApplication(Application.class);
		// 设置Banner横幅
		springApplication.setBannerMode(Banner.Mode.CONSOLE);
		springApplication.run(args);
	}

}
