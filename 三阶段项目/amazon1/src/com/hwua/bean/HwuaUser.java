package com.hwua.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户类
 * @author oracleOAEC
 *
 */
public class HwuaUser implements Serializable{
	private long hu_user_id;//用户编号
	private String hu_user_name;//用户名
	private String hu_password;//密码
	private int hu_sex;//性别1男 0女
	private Date hu_birthday;//生日
	private String hu_identity_code;//身份证号
	private String hu_email;//邮箱
	private String hu_mobel;//手机号
	private String hu_address;//地址
	private int hu_status;//状态
	private String  hu_nick_name;
	public HwuaUser() {
		super();
	}

	public HwuaUser(long hu_user_id, String hu_user_name, String hu_password, int hu_sex, Date hu_birthday,
			String hu_identity_code, String hu_email, String hu_mobel, String hu_address, int hu_status) {
		super();
		this.hu_user_id = hu_user_id;
		this.hu_user_name = hu_user_name;
		this.hu_password = hu_password;
		this.hu_sex = hu_sex;
		this.hu_birthday = hu_birthday;
		this.hu_identity_code = hu_identity_code;
		this.hu_email = hu_email;
		this.hu_mobel = hu_mobel;
		this.hu_address = hu_address;
		this.hu_status = hu_status;
	}

	public HwuaUser(String hu_user_name, String hu_password, int hu_sex, Date hu_birthday, String hu_identity_code,
			String hu_email, String hu_mobel, String hu_address, int hu_status) {
		super();
		this.hu_user_name = hu_user_name;
		this.hu_password = hu_password;
		this.hu_sex = hu_sex;
		this.hu_birthday = hu_birthday;
		this.hu_identity_code = hu_identity_code;
		this.hu_email = hu_email;
		this.hu_mobel = hu_mobel;
		this.hu_address = hu_address;
		this.hu_status = hu_status;
	}
	
	public HwuaUser(String hu_user_name, String hu_password, int hu_sex, Date hu_birthday, String hu_identity_code,
			String hu_email, String hu_mobel, String hu_address, int hu_status, String hu_nick_name) {
		super();
		this.hu_user_name = hu_user_name;
		this.hu_password = hu_password;
		this.hu_sex = hu_sex;
		this.hu_birthday = hu_birthday;
		this.hu_identity_code = hu_identity_code;
		this.hu_email = hu_email;
		this.hu_mobel = hu_mobel;
		this.hu_address = hu_address;
		this.hu_status = hu_status;
		this.hu_nick_name = hu_nick_name;
	}

	public long getHu_user_id() {
		return hu_user_id;
	}

	public void setHu_user_id(long hu_user_id) {
		this.hu_user_id = hu_user_id;
	}

	public String getHu_user_name() {
		return hu_user_name;
	}

	public void setHu_user_name(String hu_user_name) {
		this.hu_user_name = hu_user_name;
	}

	public String getHu_password() {
		return hu_password;
	}

	public void setHu_password(String hu_password) {
		this.hu_password = hu_password;
	}

	public int getHu_sex() {
		return hu_sex;
	}

	public void setHu_sex(int hu_sex) {
		this.hu_sex = hu_sex;
	}

	public Date getHu_birthday() {
		return hu_birthday;
	}

	public void setHu_birthday(Date hu_birthday) {
		this.hu_birthday = hu_birthday;
	}

	public String getHu_identity_code() {
		return hu_identity_code;
	}

	public void setHu_identity_code(String hu_identity_code) {
		this.hu_identity_code = hu_identity_code;
	}

	public String getHu_email() {
		return hu_email;
	}

	public void setHu_email(String hu_email) {
		this.hu_email = hu_email;
	}

	public String getHu_mobel() {
		return hu_mobel;
	}

	public void setHu_mobel(String hu_mobel) {
		this.hu_mobel = hu_mobel;
	}

	public String getHu_address() {
		return hu_address;
	}

	public void setHu_address(String hu_address) {
		this.hu_address = hu_address;
	}

	public int getHu_status() {
		return hu_status;
	}

	public void setHu_status(int hu_status) {
		this.hu_status = hu_status;
	}
	
	public String getHu_nick_name() {
		return hu_nick_name;
	}

	public void setHu_nick_name(String hu_nick_name) {
		this.hu_nick_name = hu_nick_name;
	}

	@Override
	public String toString() {
		return "HwuaUser [hu_user_id=" + hu_user_id + ", hu_user_name=" + hu_user_name + ", hu_password=" + hu_password
				+ ", hu_sex=" + hu_sex + ", hu_birthday=" + hu_birthday + ", hu_identity_code=" + hu_identity_code
				+ ", hu_email=" + hu_email + ", hu_mobel=" + hu_mobel + ", hu_address=" + hu_address + ", hu_status="
				+ hu_status + "]";
	}
	
	
}
