package com.china.dao;

import java.util.List;

import com.china.entity.User;

/**
 * @ClassName: UserDao
 * @Description: TODO(用户管理) 
 * @author: Jiuchuan.Shi
 * @Date: 2018年7月12日 下午7:37:38
 */
public interface UserDao {
	
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
	public List<User> findUser();
	
	

}
