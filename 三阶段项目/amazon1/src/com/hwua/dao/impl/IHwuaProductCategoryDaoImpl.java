package com.hwua.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hwua.bean.HwuaProductCategory;
import com.hwua.bean.Page;
import com.hwua.dao.IHwuaProductCategoryDao;
import com.hwua.util.JDBCTemplate;

public class IHwuaProductCategoryDaoImpl extends JDBCTemplate implements IHwuaProductCategoryDao {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	@Override
	public List<HwuaProductCategory> findCategoryById(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HwuaProductCategory> findCategoryByParentid(long hpc_parent_id) {
		List<HwuaProductCategory> list = new ArrayList<>();
		String sql = "select * from HWUA_PRODUCT_CATEGORY where HPC_PARENT_ID=? and HPC_PARENT_ID!=HPC_ID";
		query(sql, pstmt -> {
			pstmt.setLong(1, hpc_parent_id);
		}, rs -> {
			while (rs.next()) {
				long hpc_id = rs.getLong("hpc_id");
				String hpc_name = rs.getString("hpc_name");
				long hpc_parent_id1=rs.getLong("hpc_parent_id");
				HwuaProductCategory cate = new HwuaProductCategory(hpc_id,hpc_name,hpc_parent_id1);
				list.add(cate);
			}
		});
		return list;
	}

	@Override
	public HwuaProductCategory getCategoryById(long hpc_id) {
		HwuaProductCategory category = new HwuaProductCategory();
		String sql = "select * from HWUA_PRODUCT_CATEGORY where HPC_ID=?";
		query(sql, pstmt -> {
			pstmt.setLong(1, hpc_id);
		}, rs -> {
			while (rs.next()) {
				long hpc_id1 = rs.getLong("hpc_id");
				String hpc_name = rs.getString("hpc_name");
				long hpc_parent_id1 = rs.getLong("hpc_parent_id");
				category.setHpc_id(hpc_id1);
				category.setHpc_name(hpc_name);
				category.setHpc_parent_id(hpc_parent_id1);
			}
		});
		return category;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCategory(HwuaProductCategory category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delCategory(long hpc_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addCategory(HwuaProductCategory category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HwuaProductCategory> getAllCategory() {
		List<HwuaProductCategory> list = new ArrayList<HwuaProductCategory>();
		String sql = "select * from HWUA_PRODUCT_CATEGORY";
		query(sql, null, rs -> {
			while (rs.next()) {
				long hpc_id = rs.getLong("hpc_id");
				String hpc_name = rs.getString("hpc_name");
				long hpc_parent_id1 = rs.getLong("hpc_parent_id");
				HwuaProductCategory cate = new HwuaProductCategory(hpc_name, hpc_parent_id1);
				list.add(cate);
			}
		});
		return list;
	}

	@Override
	public List<HwuaProductCategory> getAllParent() {
		List<HwuaProductCategory> list = new ArrayList<HwuaProductCategory>();
		String sql = "select * from HWUA_PRODUCT_CATEGORY where HPC_ID=HPC_PARENT_ID";
		query(sql, null, rs -> {
			while (rs.next()) {
				long hpc_id = rs.getLong("hpc_id");
				String hpc_name = rs.getString("hpc_name");
				long hpc_parent_id1 = rs.getLong("hpc_parent_id");
				HwuaProductCategory cate = new HwuaProductCategory(hpc_id,hpc_name, hpc_parent_id1);
				list.add(cate);
			}
		});
		return list;
	}

}
