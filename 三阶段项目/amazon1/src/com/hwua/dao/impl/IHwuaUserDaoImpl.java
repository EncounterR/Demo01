package com.hwua.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;



import com.hwua.bean.HwuaUser;
import com.hwua.bean.Page;
import com.hwua.dao.IHwuaUserDao;
import com.hwua.util.JDBCTemplate;

public class IHwuaUserDaoImpl extends JDBCTemplate implements IHwuaUserDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	@Override
	public List<HwuaUser> findUserByPage(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HwuaUser findUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HwuaUser findUserByName(String name) {
		HwuaUser user = new HwuaUser();
		String sql = "select * from HWUA_USER where HU_USER_NAME=?";
		query(sql, pstmt -> {
			pstmt.setString(1, name);
		}, rs -> {
			while (rs.next()) {
				user.setHu_user_id(rs.getLong("hu_user_id"));
				user.setHu_user_name(rs.getString("hu_user_name"));
				user.setHu_password(rs.getString("hu_password"));
				user.setHu_sex(rs.getInt("hu_sex"));
				user.setHu_birthday(rs.getDate("hu_birthday"));
				user.setHu_identity_code(rs.getString("hu_identity_code"));
				user.setHu_email(rs.getString("HU_EMAIL"));
				user.setHu_mobel(rs.getString("HU_MOBILE"));
				user.setHu_address(rs.getString("HU_ADDRESS"));
				user.setHu_status(rs.getInt("hu_status"));
				user.setHu_nick_name(rs.getString("HU_NICK_NAME"));
			}
		});
		return user;
	}

	@Override
	public List<HwuaUser> getAllUser() {
		List<HwuaUser> list = new ArrayList<HwuaUser>();
		String sql = "select * from HWUA_USER";
		query(sql, null, rs -> {
			HwuaUser user = new HwuaUser();
			user.setHu_user_id(rs.getLong("hu_user_id"));
			user.setHu_user_name(rs.getString("hu_user_name"));
			user.setHu_password(rs.getString("hu_password"));
			user.setHu_sex(rs.getInt("hu_sex"));
			user.setHu_birthday(rs.getDate("hu_birthday"));
			user.setHu_identity_code(rs.getString("hu_identity_code"));
			user.setHu_email(rs.getString("hu_email"));
			user.setHu_mobel(rs.getString("hu_mobel"));
			user.setHu_address(rs.getString("hu_address"));
			user.setHu_status(rs.getInt("hu_status"));
			user.setHu_nick_name(rs.getString("HU_NICK_NAME"));
			list.add(user);
		});
		return list;
	}

	@Override
	public int addUser(HwuaUser user) {
		String sql = "insert into HWUA_USER values(SEQ_USER.nextval,?,?,?,?,?,?,?,?,?,?)";
		int row = update(sql, pstmt -> {
			pstmt.setString(1, user.getHu_user_name());
			pstmt.setString(2, user.getHu_password());
			pstmt.setInt(3, user.getHu_sex());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date = formatter.format(user.getHu_birthday());
			java.sql.Date sdate = java.sql.Date.valueOf(date);
			pstmt.setDate(4, sdate);
			pstmt.setString(5, user.getHu_identity_code());
			pstmt.setString(6, user.getHu_email());
			pstmt.setString(7, user.getHu_mobel());
			pstmt.setString(8, user.getHu_address());
			pstmt.setInt(9, user.getHu_status());
			pstmt.setString(10, user.getHu_nick_name());
		});
		return row;
	}

	@Override
	public int delUser(long id) {

		String sql = "delete from HWUA_USER where HU_USER_ID=?";
		int row = update(sql, pstmt -> {
			pstmt.setLong(1, id);
		});
		return row;
	}

	@Override
	public int updateUser(HwuaUser user) {

		String sql = "update HWUA_USER set HU_USER_NAME=?,HU_PASSWORD=?,HU_SEX=?,HU_BIRTHDAY=?,HU_IDENTITY_CODE=?,HU_EMAIL=?,HU_MOBILE=?,HU_ADDRESS=?,HU_STATUS=? where HU_USER_ID=?";
		int row = update(sql, pstmt -> {
			pstmt.setString(1, user.getHu_user_name());
			pstmt.setString(2, user.getHu_password());
			pstmt.setInt(3, user.getHu_sex());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String date = formatter.format(user.getHu_birthday());
			java.sql.Date sdate = java.sql.Date.valueOf(date);
			pstmt.setDate(4, sdate);
			pstmt.setString(5, user.getHu_identity_code());
			pstmt.setString(6, user.getHu_email());
			pstmt.setString(7, user.getHu_mobel());
			pstmt.setString(8, user.getHu_address());
			pstmt.setInt(9, user.getHu_status());
			pstmt.setLong(10, user.getHu_user_id());
		});
		return row;
	}

	@Override
	public HwuaUser fingUser(String name, String passpord) {
		HwuaUser user = new HwuaUser();
		String sql = "select * from HWUA_USER where HU_USER_NAME=? and HU_PASSWORD=?";
		query(sql, pstmt -> {
			pstmt.setString(1, name);
			pstmt.setString(2, passpord);
		}, rs -> {
			while (rs.next()) {
				user.setHu_user_id(rs.getLong("HU_USER_ID"));
				user.setHu_user_name(rs.getString("HU_USER_NAME"));
				user.setHu_password(rs.getString("HU_PASSWORD"));
				user.setHu_sex(rs.getInt("HU_SEX"));
				user.setHu_birthday(rs.getDate("HU_BIRTHDAY"));
				user.setHu_identity_code(rs.getString("HU_IDENTITY_CODE"));
				user.setHu_email(rs.getString("HU_EMAIL"));
				user.setHu_mobel(rs.getString("HU_MOBILE"));
				user.setHu_address(rs.getString("HU_ADDRESS"));
				user.setHu_status(rs.getInt("HU_STATUS"));
			}
		});
		return user;
	}

	@Override
	public HwuaUser findUserByEmail(String email) {
		HwuaUser user = new HwuaUser();
		String sql = "select * from HWUA_USER where HU_EMAIL=?";
		query(sql, pstmt -> {
			pstmt.setString(1, email);
		}, rs -> {
			while (rs.next()) {
				user.setHu_user_id(rs.getLong("hu_user_id"));
				user.setHu_user_name(rs.getString("hu_user_name"));
				user.setHu_password(rs.getString("hu_password"));
				user.setHu_sex(rs.getInt("hu_sex"));
				user.setHu_birthday(rs.getDate("hu_birthday"));
				user.setHu_identity_code(rs.getString("hu_identity_code"));
				user.setHu_email(rs.getString("hu_email"));
				user.setHu_mobel(rs.getString("HU_MOBILE"));
				user.setHu_address(rs.getString("hu_address"));
				user.setHu_status(rs.getInt("hu_status"));
			}
		});
		return user;
	}

	@Override
	public HwuaUser fingUser(String name, String email, String mobile) {
		String sql="select * from HWUA_USER where HU_USER_NAME=? and HU_EMAIL=? and HU_MOBILE=?";
		HwuaUser user=new HwuaUser();
		query(sql, pstmt->{
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, mobile);
		}, rs->{
			while(rs.next()){
				user.setHu_user_id(rs.getLong("hu_user_id"));
				user.setHu_user_name(rs.getString("hu_user_name"));
				user.setHu_password(rs.getString("hu_password"));
				user.setHu_sex(rs.getInt("hu_sex"));
				user.setHu_birthday(rs.getDate("hu_birthday"));
				user.setHu_identity_code(rs.getString("hu_identity_code"));
				user.setHu_email(rs.getString("hu_email"));
				user.setHu_mobel(rs.getString("HU_MOBILE"));
				user.setHu_address(rs.getString("hu_address"));
				user.setHu_status(rs.getInt("hu_status"));
			}
		});
		return user;
	}

	@Override
	public HwuaUser findUserByNickName(String nickName) {
		String sql="select * from HWUA_USER where HU_NICK_NAME=?";
		HwuaUser user=new HwuaUser();
		query(sql, pstmt->{
			pstmt.setString(1, nickName);
		}, rs->{
			while(rs.next()){
				user.setHu_user_id(rs.getLong("hu_user_id"));
				user.setHu_user_name(rs.getString("hu_user_name"));
				user.setHu_password(rs.getString("hu_password"));
				user.setHu_sex(rs.getInt("hu_sex"));
				user.setHu_birthday(rs.getDate("hu_birthday"));
				user.setHu_identity_code(rs.getString("hu_identity_code"));
				user.setHu_email(rs.getString("hu_email"));
				user.setHu_mobel(rs.getString("HU_MOBILE"));
				user.setHu_address(rs.getString("hu_address"));
				user.setHu_status(rs.getInt("hu_status"));
			}
		});
		return user;
	}

}
