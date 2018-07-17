package com.china.dev.service;

import java.util.List;

import com.china.dev.entity.User;

/**
 * @ClassName: UserService
 * @Description: TODO(用户管理业务处理) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月12日 下午7:46:07
 */
public interface UserService {
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	/**
	 * 修改用户的信息
	 * @param id
	 * @param name
	 * @return
	 */
	public int updateUser(long id, User user);
	/**
	 * 删除用户的信息
	 * @param id
	 * @param name
	 * @return
	 */
	public int deleteUser(long id, String name);
	/**
	 * 通过ID查询用户的信息
	 * @param id
	 * @return
	 */
	public User findUser(long id);
	/**
	 * 查询用户的全部信息
	 * @return
	 */
	public List<User> findAllUser();

}
