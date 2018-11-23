package com.hwua.biz;

import com.hwua.bean.HwuaUser;

/**
 * 用户业务逻辑
 * @author oracleOAEC
 *
 */
public interface IHwuaUserBiz {
	/**
	 * 检验用户名是否已经被注册
	 * @param name
	 * @return 返回id id>0则已被注册
	 */
	public long checkName(String name);
	/**
	 * 检验邮箱是否已经被注册
	 * @param email
	 * @return 返回id id>0则已被注册
	 */
	public long checkEmail(String email);
	/**
	 * 用户登录
	 * @param name
	 * @param password
	 * @return
	 */
	public HwuaUser doLogin(String name,String password);
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public int register(HwuaUser user);
	/**
	 * 通过用户名查找用户
	 * @param name
	 * @return
	 */
	public HwuaUser findUserByName(String name);
	/**
	 * 根据用户名，邮箱，手机号查找用户
	 * @param name
	 * @param email
	 * @param mobile
	 * @return
	 */
	public HwuaUser fingUser(String name,String email,String mobile);
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int updateUser(HwuaUser user);
	/**
	 * 检验昵称是否重名
	 * @param nickName
	 * @return
	 */
	public long findUserByNickName(String nickName);
	
}
