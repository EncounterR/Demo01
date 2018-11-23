package com.hwua.dao;

import java.util.List;

import com.hwua.bean.HwuaUser;
import com.hwua.bean.Page;

/**
 * 用户接口类
 * @author oracleOAEC
 *
 */
public interface IHwuaUserDao {
	/**
	 * 分页查询用户
	 * @param page
	 */
	public List<HwuaUser> findUserByPage(Page page);
	/**
	 * 根据用户id查询
	 * @param id
	 * @return
	 */
	public HwuaUser findUserById(long id);
	/**
	 * 根据用户名查询
	 * @param name
	 * @return
	 */
	public HwuaUser findUserByName(String name);
	/**
	 * 查询所有用户
	 * @return
	 */
	public List<HwuaUser> getAllUser();
	/**
	 * 增加用户信息
	 * @param user
	 * @return
	 */
	public int addUser(HwuaUser user );
	/**
	 * 根据用户id删除用户
	 * @param id
	 * @return
	 */
	public int delUser(long id);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(HwuaUser user);
	/**
	 * 根据用户名和密码查询用户
	 * @param name
	 * @param passpord
	 * @return
	 */
	public HwuaUser fingUser(String name,String passpord);
	/**
	 * 根据邮箱名查询用户
	 * @param email
	 * @return
	 */
	public HwuaUser findUserByEmail(String email);
	/**
	 * 根据用户名，邮箱，手机号查找用户
	 * @param name
	 * @param email
	 * @param mobile
	 * @return
	 */
	public HwuaUser fingUser(String name,String email,String mobile);
	/**
	 * 根据昵称查询用户
	 * @param nickName
	 * @return
	 */
	public HwuaUser findUserByNickName(String nickName);
}
