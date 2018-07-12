package com.china.controller;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.china.entity.User;
import com.china.service.UserService;

/**
 * @ClassName: UserController
 * @Description: TODO(用户路由处理) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月12日 下午7:52:15
 */
@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Test
	public void addUsers(){
		
		logger.info("----------------------开始执行------------------------");
		
		try {
			User user = new User();
			int result = userService.addUser(user);
			System.out.println("信息：" + result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		logger.info("----------------------------------------------");
	}
	
	

}
