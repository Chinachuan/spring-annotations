package com.china.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.china.dao.UserDao;
import com.china.entity.User;
import com.china.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO(用户管理业务处理实现类) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月12日 下午7:46:44
 */

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		int data = userDao.addUser(user.getName(), "", "", "", 23, user.getEmail(), "", "");
		return data;
	}

	@Override
	public int updateUser(long id, User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(id, user);
	}

	@Override
	public int deleteUser(long id, String name) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id, name);
	}

	@Override
	public User findUser(long id) {
		// TODO Auto-generated method stub
		return userDao.findUser(id);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}

}
