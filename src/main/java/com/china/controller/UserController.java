package com.china.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String addUsers(Model model){
		
		logger.info("----------------------添加用户------------------------");
		
		User user = new User();
		user.setName("小李");
		user.setShowName("越努力越幸运");
		user.setCardID("52212693466353X");
		user.setPhone("18753527732");
		user.setEmail("18753527732@163.com");
		user.setSex("男");
		user.setAge(24);
		user.setAddress("山西大同");
		
		userService.addUser(user);
		List<User> listUser = userService.findAllUser();
		model.addAttribute("listUser", listUser);
		
		return "user/userInfo";
	}
	
	@RequestMapping(value = "/findAllUsers",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String findAllUsers(Model model){
		
		logger.info("----------------------查询所有的用户信息------------------------");
		
		List<User> listUser = userService.findAllUser();
		model.addAttribute("listUser", listUser);
		
		return "user/userInfo";
	}
	
	

}
