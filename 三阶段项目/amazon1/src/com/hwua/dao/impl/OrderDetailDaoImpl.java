package com.hwua.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hwua.bean.HwuaOrderDetail;
import com.hwua.dao.IOrderDetailDao;
import com.hwua.util.JDBCTemplate;
import com.mchange.v2.c3p0.ComboPooledDataSource;


public class OrderDetailDaoImpl extends JDBCTemplate implements IOrderDetailDao{
	DataSource dataSource = new ComboPooledDataSource("oracle");

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	@Override
	public int addOrderDetail(HwuaOrderDetail orderDetail) {
		int row=0;
		String sql="INSERT INTO HWUA_ORDER_DETAIL VALUES(SEQ_DETAIL.NEXTVAL,?,?,?,?)";
		row=update(sql, pstmt->{
			pstmt.setLong(1, orderDetail.getHo_id());
			pstmt.setLong(2, orderDetail.getHp_id());
			pstmt.setInt(3, orderDetail.getHod_quantity());
			pstmt.setDouble(4, orderDetail.getHod_cost());
		});
		return row;
	}

	@Override
	public List<Long> hotProducts(int rownum) {
		String sql="SELECT HP_ID FROM (SELECT  HP_ID,COUNT(HP_ID)TIMES  FROM HWUA_ORDER_DETAIL GROUP BY HP_ID ORDER BY TIMES  DESC) WHERE ROWNUM<=?";
		List<Long> list=new ArrayList<Long>();
		query(sql, pstmt->{
			pstmt.setLong(1, rownum);
		}, rs->{
			while(rs.next()){
				long pid=rs.getLong("HP_ID");
				list.add(pid);
			}
		});
		return list;
	}

	@Override
	public Long getOrderId() {
		String sql="SELECT SEQ_ORDER.NEXTVAL-1 FROM DUAL";
		long orderId=0;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				orderId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderId;
	}

	@Override
	public List<HwuaOrderDetail> getOrderDetailByHoid(long ho_id) {
		List<HwuaOrderDetail> list=new ArrayList<HwuaOrderDetail>();
		String sql="select * from HWUA_ORDER_DETAIL where HO_ID=?";
		query(sql, pstmt->{
			pstmt.setLong(1, ho_id);
		}, rs->{
			while(rs.next()){
				HwuaOrderDetail detail=new HwuaOrderDetail();
				detail.setHod_id(rs.getLong("HOD_ID"));
				detail.setHo_id(rs.getLong("HO_ID"));
				detail.setHp_id(rs.getLong("HP_ID"));
				detail.setHod_quantity(rs.getInt("HOD_QUANTITY"));
				detail.setHod_cost(rs.getDouble("HOD_COST"));
				list.add(detail);
			}
		});
		return list;
	}

	@Override
	public int delDetailById(long id) {
		String sql="delete from HWUA_ORDER_DETAIL where hod_id=?";
		int row=update(sql, pstmt->{
			pstmt.setLong(1, id);
		});
		return row;
	}

}
