package com.hwua.biz.impl;

import com.hwua.bean.HwuaUser;
import com.hwua.biz.IHwuaUserBiz;
import com.hwua.dao.IHwuaUserDao;
import com.hwua.dao.impl.IHwuaUserDaoImpl;

public class IHwuaUserBizImpl implements IHwuaUserBiz{
	IHwuaUserDao ihud=new IHwuaUserDaoImpl();
	@Override
	public long checkName(String name) {
		HwuaUser user=ihud.findUserByName(name);
		if(user==null){
			return 0;
		}else{
			return user.getHu_user_id();
		}
		
	}

	@Override
	public long checkEmail(String email) {
		HwuaUser user=ihud.findUserByEmail(email);
		if(user==null){
			return 0;
		}else{
			return user.getHu_user_id();
		}
	}

	@Override
	public HwuaUser doLogin(String name, String password) {
		HwuaUser user=ihud.fingUser(name, password);
		return user;
	}

	@Override
	public int register(HwuaUser user) {
		int row=ihud.addUser(user);
		return row;
	}

	@Override
	public HwuaUser findUserByName(String name) {
		HwuaUser user =ihud.findUserByName(name);
		return user;
	}

	@Override
	public HwuaUser fingUser(String name, String email, String mobile) {
		HwuaUser user=ihud.fingUser(name, email, mobile);
		return user;
	}

	@Override
	public int updateUser(HwuaUser user) {

		return ihud.updateUser(user);
	}

	@Override
	public long findUserByNickName(String nickName) {
		HwuaUser user=ihud.findUserByNickName(nickName);
		if(user==null){
			return 0;
		}else{
			return user.getHu_user_id();
		}
	}

}
