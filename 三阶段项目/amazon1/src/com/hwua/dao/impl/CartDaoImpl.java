package com.hwua.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hwua.bean.HwuaCart;
import com.hwua.dao.ICartDao;
import com.hwua.util.JDBCTemplate;

public class CartDaoImpl extends JDBCTemplate implements ICartDao{

	@Override
	public int addCart(HwuaCart cart) {
		int row=0;
		String sql="INSERT INTO HWUA_HWUA_CART VALUES(SEQ_CART.NEXTVAL,?,?,?)";
		row=update(sql, pstmt->{
			pstmt.setLong(1, cart.getPid());
			pstmt.setInt(2, cart.getQuantity());
			pstmt.setLong(3, cart.getUserid());
		});
		return row;
	}

	@Override
	public int updateCart(HwuaCart cart) {
		int row=0;
		String sql="UPDATE HWUA_HWUA_CART SET QUANTITY=? WHERE ID=?";
		row=update(sql, pstmt->{
			pstmt.setInt(1, cart.getQuantity());
			pstmt.setLong(2, cart.getId());
		});
		return row;
	}

	@Override
	public HwuaCart checkCart(HwuaCart cart) {
		HwuaCart car=new HwuaCart();
		String sql="SELECT * FROM HWUA_HWUA_CART WHERE PID=? AND USERID=?";
		query(sql, pstmt->{
			pstmt.setLong(1, cart.getPid());
			pstmt.setLong(2, cart.getUserid());
		}, rs->{
			while(rs.next()){
				car.setId(rs.getLong("ID"));
				car.setPid(rs.getLong("PID"));
				car.setQuantity(rs.getInt("QUANTITY"));
				car.setUserid(rs.getLong("USERID"));
			}
		});
		return car;
	}

	@Override
	public List<Integer> updateCartCount(Long userId) {
		String sql="SELECT QUANTITY FROM HWUA_HWUA_CART WHERE USERID=?";
		List<Integer> list=new ArrayList<Integer>();
		query(sql, pstmt->{
			pstmt.setLong(1, userId);
		},rs->{
			while(rs.next()){
				int s=rs.getInt(1);
				list.add(s);
			}
		} );
		return list;
	}

	@Override
	public List<HwuaCart> usersCarts(Long userId) {
		List<HwuaCart> list=new ArrayList<HwuaCart>();
		String sql="select * from HWUA_HWUA_CART where USERID=?";
		query(sql, pstmt->{
			pstmt.setLong(1, userId);
		}, rs->{
			while(rs.next()){
				HwuaCart car=new HwuaCart();
				car.setId(rs.getLong("ID"));
				car.setPid(rs.getLong("PID"));
				car.setQuantity(rs.getInt("QUANTITY"));
				car.setUserid(rs.getLong("USERID"));
				list.add(car);
			}
		});
		return list;
	}

	@Override
	public int deleteCarts(Long userId) {
		String sql="DELETE FROM HWUA_HWUA_CART WHERE USERID=?";
		int row=update(sql, pstmt->{
			pstmt.setLong(1, userId);
		});
		return row;
	}

	@Override
	public int deleteCartById(long id) {
		int row=0;
		String sql="delete from HWUA_HWUA_CART where id=?";
		row=update(sql, pstmt->{
			pstmt.setLong(1, id);
		});
		return row;
	}

	@Override
	public int alertCartQuantity(long id, int quantity) {
		int row=0;
		String sql="UPDATE HWUA_HWUA_CART SET QUANTITY=? WHERE ID=?";
		row=update(sql, pstmt->{
			pstmt.setInt(1, quantity);
			pstmt.setLong(2, id);
		});
		return row;
	}
	

}
