package com.china.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.china.entity.User;
import com.china.service.UserService;

/**
 * @ClassName: UserController
 * @Description: TODO(用户路由处理) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月12日 下午7:52:15
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/addUser",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String addUsers(){
		
		logger.info("----------------------开始执行------------------------");
		User user = new User();
		user.setEmail("602030912@qq.com");
		userService.addUser(user);
		
		userService.findAllUser();
		
		return "user/userInfo";
	}
	
	

}
