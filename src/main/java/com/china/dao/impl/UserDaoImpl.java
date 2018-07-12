package com.china.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.china.dao.UserDao;
import com.china.entity.User;

/**
 * @ClassName: UserDaoImpl
 * @Description: TODO(用户管理实现类) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月12日 下午7:44:33
 */
@Component
public class UserDaoImpl implements UserDao{

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("添加用户。。。" + user);
		return 0;
	}

	@Override
	public int updateUser(long id, User user) {
		// TODO Auto-generated method stub
		System.out.println("修改用户。。。");
		return 0;
	}

	@Override
	public int deleteUser(long id, String name) {
		// TODO Auto-generated method stub
		System.out.println("删除用户。。。");
		return 0;
	}

	@Override
	public User findUser(long id) {
		// TODO Auto-generated method stub
		System.out.println("查询用户。。。");
		return null;
	}

	@Override
	public List<User> findUser() {
		// TODO Auto-generated method stub
		System.out.println("查询全部用户。。。");
		return null;
	}

}
