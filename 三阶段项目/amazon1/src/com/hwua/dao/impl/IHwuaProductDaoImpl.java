package com.hwua.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.hwua.bean.HwuaProduct;
import com.hwua.bean.Page;
import com.hwua.dao.IHwuaProductDao;
import com.hwua.util.JDBCTemplate;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class IHwuaProductDaoImpl extends JDBCTemplate implements IHwuaProductDao {
	DataSource dataSource = new ComboPooledDataSource("oracle");

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	@Override
	public List<HwuaProduct> findProductByPage(Page page) {
		List<HwuaProduct> list = new ArrayList<HwuaProduct>();
		String sql = "select * from (select rownum r,u.* from HWUA_PRODUCT u) us where us.r between ? and ?";
		System.out.println((page.getCurrent() - 1) * page.getPageSize() + 1);
		query(sql, pstmt -> {
			pstmt.setInt(1, (page.getCurrent() - 1) * page.getPageSize() + 1);
			pstmt.setInt(2, page.getCurrent() * page.getPageSize());
		}, rs -> {
			while (rs.next()) {
				HwuaProduct product = new HwuaProduct();
				product.setHp_id(rs.getLong("hp_id"));
				product.setHp_name(rs.getString("hp_name"));
				product.setHp_description(rs.getString("hp_description"));
				product.setHp_price(rs.getDouble("hp_price"));
				product.setHp_stock(rs.getInt("hp_stock"));
				product.setHpc_id(rs.getLong("hpc_id"));
				product.setHpc_child_id(rs.getLong("hpc_child_id"));
				product.setHp_file_name(rs.getString("hp_file_name"));
				list.add(product);
			}
		});
		return list;
	}

	@Override
	public HwuaProduct findProductById(long hp_id) {
		HwuaProduct product = new HwuaProduct();
		String sql = "select * from HWUA_PRODUCT where HP_ID=?";
		query(sql, pstmt -> {
			pstmt.setLong(1, hp_id);
		}, rs -> {
			while (rs.next()) {
				product.setHp_id(rs.getLong("hp_id"));
				product.setHp_name(rs.getString("hp_name"));
				product.setHp_description(rs.getString("hp_description"));
				product.setHp_price(rs.getDouble("hp_price"));
				product.setHp_stock(rs.getInt("hp_stock"));
				product.setHpc_id(rs.getLong("hpc_id"));
				product.setHpc_child_id(rs.getLong("hpc_child_id"));
				product.setHp_file_name(rs.getString("hp_file_name"));
			}
		});
		return product;
	}

	@Override
	public int updateProduct(HwuaProduct product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProduct(HwuaProduct product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delProduct(int hp_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count() {
		int temp = 0;
		String sql = "select count(1) from HWUA_PRODUCT";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return temp;

	}

	@Override
	public List<HwuaProduct> getAll() {
		List<HwuaProduct> list = new ArrayList<HwuaProduct>();
		String sql = "select * from HWUA_PRODUCT";
		query(sql, null, rs -> {
			while (rs.next()) {
				HwuaProduct product = new HwuaProduct();
				product.setHp_id(rs.getLong("hp_id"));
				product.setHp_name(rs.getString("hp_name"));
				product.setHp_description(rs.getString("hp_description"));
				product.setHp_price(rs.getDouble("hp_price"));
				product.setHp_stock(rs.getInt("hp_stock"));
				product.setHpc_id(rs.getLong("hpc_id"));
				product.setHpc_child_id(rs.getLong("hpc_child_id"));
				product.setHp_file_name(rs.getString("hp_file_name"));
				list.add(product);
			}
		});
		return list;
	}

	@Override
	public int productByParentCategory(long parentId) {
		int temp = 0;
		String sql = "select count(1) from HWUA_PRODUCT where HPC_ID=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,parentId );
			rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return temp;
	}

	@Override
	public int productByChildCategory(long childId) {
		int temp = 0;
		String sql = "select count(1) from HWUA_PRODUCT where HPC_CHILD_ID=?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1,childId );
			rs = pstmt.executeQuery();
			while (rs.next()) {
				temp = rs.getInt(1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return temp;
	}

	
	@Override
	public List<HwuaProduct> queryProducts(String qname, Page page) {
		List<HwuaProduct> list = new ArrayList<HwuaProduct>();
		String sql = "select * from (SELECT ROWNUM AS r,p.* FROM HWUA_PRODUCT p WHERE HP_NAME LIKE ?) us where us.r between ? and ?";
		query(sql, pstmt -> {
			pstmt.setString(1, "%"+qname+"%");
			pstmt.setInt(2, (page.getCurrent() - 1) * page.getPageSize() + 1);
			pstmt.setInt(3, page.getCurrent() * page.getPageSize());
		}, rs -> {
			while (rs.next()) {
				HwuaProduct product = new HwuaProduct();
				product.setHp_id(rs.getLong("hp_id"));
				product.setHp_name(rs.getString("hp_name"));
				product.setHp_description(rs.getString("hp_description"));
				product.setHp_price(rs.getDouble("hp_price"));
				product.setHp_stock(rs.getInt("hp_stock"));
				product.setHpc_id(rs.getLong("hpc_id"));
				product.setHpc_child_id(rs.getLong("hpc_child_id"));
				product.setHp_file_name(rs.getString("hp_file_name"));
				list.add(product);
			}
		});
		return list;
	}

	@Override
	public int countQueryProducts(String qname) {
		int count=0;
		List<HwuaProduct> list = new ArrayList<HwuaProduct>();
		String sql="SELECT p.* FROM HWUA_PRODUCT p WHERE HP_NAME LIKE ?";
		query(sql, pstmt -> {
			pstmt.setString(1, "%"+qname+"%");
		}, rs -> {
			while (rs.next()) {
				HwuaProduct product = new HwuaProduct();
				product.setHp_id(rs.getLong("hp_id"));
				product.setHp_name(rs.getString("hp_name"));
				product.setHp_description(rs.getString("hp_description"));
				product.setHp_price(rs.getDouble("hp_price"));
				product.setHp_stock(rs.getInt("hp_stock"));
				product.setHpc_id(rs.getLong("hpc_id"));
				product.setHpc_child_id(rs.getLong("hpc_child_id"));
				product.setHp_file_name(rs.getString("hp_file_name"));
				list.add(product);
			}
		});
		count=list.size();
		return count;
	}

	@Override
	public List<HwuaProduct> findProductByHpcid(Page page,long hpc_id) {
		List<HwuaProduct> list = new ArrayList<HwuaProduct>();
		String sql = "select * from (select rownum r,u.* from HWUA_PRODUCT u where HPC_ID=?) us where us.r between ? and ?";
		query(sql, pstmt -> {
			pstmt.setLong(1, hpc_id);
			pstmt.setInt(2, (page.getCurrent() - 1) * page.getPageSize() + 1);
			pstmt.setInt(3, page.getCurrent() * page.getPageSize());
		}, rs -> {
			while (rs.next()) {
				HwuaProduct product = new HwuaProduct();
				product.setHp_id(rs.getLong("hp_id"));
				product.setHp_name(rs.getString("hp_name"));
				product.setHp_description(rs.getString("hp_description"));
				product.setHp_price(rs.getDouble("hp_price"));
				product.setHp_stock(rs.getInt("hp_stock"));
				product.setHpc_id(rs.getLong("hpc_id"));
				product.setHpc_child_id(rs.getLong("hpc_child_id"));
				product.setHp_file_name(rs.getString("hp_file_name"));
				list.add(product);
			}
		});
		return list;
	}

	@Override
	public int changeStock(int hpStock, long hpId) {
		String sql="UPDATE HWUA_PRODUCT SET HP_STOCK=? WHERE HP_ID=?";
		int row=update(sql, pstmt->{
			pstmt.setInt(1, hpStock);
			pstmt.setLong(2, hpId);
		});
		return row;
		
	}

	@Override
	public List<HwuaProduct> findProductByHpcChildId(Page page,long hpc_child_id) {
		List<HwuaProduct> list = new ArrayList<HwuaProduct>();
		String sql = "select * from (select rownum r,u.* from HWUA_PRODUCT u where HPC_CHILD_ID=?) us where us.r between ? and ?";
		query(sql, pstmt -> {
			pstmt.setLong(1, hpc_child_id);
			pstmt.setInt(2, (page.getCurrent() - 1) * page.getPageSize() + 1);
			pstmt.setInt(3, page.getCurrent() * page.getPageSize());
		}, rs -> {
			while (rs.next()) {
				HwuaProduct product = new HwuaProduct();
				product.setHp_id(rs.getLong("hp_id"));
				product.setHp_name(rs.getString("hp_name"));
				product.setHp_description(rs.getString("hp_description"));
				product.setHp_price(rs.getDouble("hp_price"));
				product.setHp_stock(rs.getInt("hp_stock"));
				product.setHpc_id(rs.getLong("hpc_id"));
				product.setHpc_child_id(rs.getLong("hpc_child_id"));
				product.setHp_file_name(rs.getString("hp_file_name"));
				list.add(product);
			}
		});
		return list;
	}

	@Override
	public List<HwuaProduct> getProductsByid(long id) {
		List<HwuaProduct> list =new ArrayList<HwuaProduct>();
		String sql="select * from HWUA_PRODUCT where HPC_ID=? or HPC_CHILD_ID=?";
		query(sql, pstmt -> {
			pstmt.setLong(1, id);
			pstmt.setLong(2, id);
		}, rs -> {
			while (rs.next()) {
				HwuaProduct product = new HwuaProduct();
				product.setHp_id(rs.getLong("hp_id"));
				product.setHp_name(rs.getString("hp_name"));
				product.setHp_description(rs.getString("hp_description"));
				product.setHp_price(rs.getDouble("hp_price"));
				product.setHp_stock(rs.getInt("hp_stock"));
				product.setHpc_id(rs.getLong("hpc_id"));
				product.setHpc_child_id(rs.getLong("hpc_child_id"));
				product.setHp_file_name(rs.getString("hp_file_name"));
				list.add(product);
			}
		});
		return list;
	}

}
