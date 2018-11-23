package com.hwua.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.hwua.bean.HwuaOrder;
import com.hwua.dao.IOrderDao;
import com.hwua.util.JDBCTemplate;

public class OrderDaoImpl extends JDBCTemplate implements IOrderDao {

	@Override
	public int addOrder(HwuaOrder order) {
		int row = 0;
		String sql = "INSERT INTO HWUA_ORDER VALUES (SEQ_ORDER.NEXTVAL,?,?,?,?,?,?,?)";
		row = update(sql, pstmt -> {
			pstmt.setLong(1, order.getHo_user_id());
			pstmt.setString(2, order.getHo_user_name());
			pstmt.setString(3, order.getHo_user_address());
			pstmt.setDate(4, new java.sql.Date(order.getHo_create_time().getTime()));
			pstmt.setDouble(5, order.getHo_cost());
			pstmt.setLong(6, order.getHo_status());
			pstmt.setLong(7, order.getHo_type());
		});
		return row;
	}

	@Override
	public List<HwuaOrder> searchAllOrder(Long hoUserId) {
		List<HwuaOrder> list = new ArrayList<HwuaOrder>();
		String sql = "select * from HWUA_ORDER where HO_USER_ID=?";
		query(sql, pstmt -> {
			pstmt.setLong(1, hoUserId);
		}, rs -> {
			while (rs.next()) {
				HwuaOrder order = new HwuaOrder();
				long ho_id = rs.getLong("HO_ID");
				long uid = rs.getLong("HO_USER_ID");
				String uname = rs.getString("HO_USER_NAME");
				String address = rs.getString("HO_USER_ADDRESS");
				Date date = rs.getDate("HO_CREATE_TIME");
				double price = rs.getDouble("HO_COST");
				int status = rs.getInt("HO_STATUS");
				int type = rs.getInt("HO_TYPE");
				order.setHo_id(ho_id);
				order.setHo_user_id(uid);
				order.setHo_user_name(uname);
				order.setHo_user_address(address);
				order.setHo_create_time(date);
				order.setHo_cost(price);
				order.setHo_status(status);
				order.setHo_type(type);
				list.add(order);
			}
		});
		return list;
	}


	@Override
	public int updateOrder(Long hoId, Long hoStatus) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder(Long hoId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HwuaOrder findHwuaOrderByUid(long id) {
		HwuaOrder order = new HwuaOrder();
		String sql = "select * from (select u.* from hwua_order u where ho_user_id =? order by ho_id desc)  where rownum=1";
		query(sql, pstmt -> {
			pstmt.setLong(1, id);
		}, rs -> {
			while (rs.next()) {
				long ho_id = rs.getLong("HO_ID");
				long uid = rs.getLong("HO_USER_ID");
				String uname = rs.getString("HO_USER_NAME");
				String address = rs.getString("HO_USER_ADDRESS");
				Date date = rs.getDate("HO_CREATE_TIME");
				double price = rs.getDouble("HO_COST");
				int status = rs.getInt("HO_STATUS");
				int type = rs.getInt("HO_TYPE");
				order.setHo_id(ho_id);
				order.setHo_user_id(uid);
				order.setHo_user_name(uname);
				order.setHo_user_address(address);
				order.setHo_create_time(date);
				order.setHo_cost(price);
				order.setHo_status(status);
				order.setHo_type(type);
			}
		});
		return order;
	}

	@Override
	public List<HwuaOrder> getAllOrder(long hoUserId) {
		List<HwuaOrder> list = new ArrayList<HwuaOrder>();
		String sql = "select * from hwua_order where HO_USER_ID=?";
		query(sql, pstmt -> {
			pstmt.setLong(1, hoUserId);
		}, rs -> {
			while (rs.next()) {
				HwuaOrder order = new HwuaOrder();
				long ho_id = rs.getLong("HO_ID");
				long uid = rs.getLong("HO_USER_ID");
				String uname = rs.getString("HO_USER_NAME");
				String address = rs.getString("HO_USER_ADDRESS");
				Date date = rs.getDate("HO_CREATE_TIME");
				double price = rs.getDouble("HO_COST");
				int status = rs.getInt("HO_STATUS");
				int type = rs.getInt("HO_TYPE");
				order.setHo_id(ho_id);
				order.setHo_user_id(uid);
				order.setHo_user_name(uname);
				order.setHo_user_address(address);
				order.setHo_create_time(date);
				order.setHo_cost(price);
				order.setHo_status(status);
				order.setHo_type(type);
				list.add(order);
			}
		});
		return list;
	}

}
