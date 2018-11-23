package com.hwua.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class JDBCTemplate {
	/**
	 * 增删改的操作
	 * @param sql
	 * @param setter
	 * @return
	 */
	public int update(String sql,PrepareStatementSetter setter){
		int row=0;
		Connection conn=ConnectionFactory.getConn();
		PreparedStatement pstmt=null;
		try {
			conn.setAutoCommit(false);//取消自动提交
			pstmt=conn.prepareStatement(sql);
			if(setter!=null){
				setter.setValues(pstmt);// 抽象方法 谁调用 谁实现
			}
			row=pstmt.executeUpdate();
			conn.commit();//提交事务
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}//发生异常就回滚
			e.printStackTrace();
		}finally{
			DBUtil.closeAll(pstmt, conn);
		}
		return row;
	}
	/**
	 * 查询的操作
	 * @param sql
	 * @param setter
	 * @param handler
	 */
	public void query(String sql, PrepareStatementSetter setter, RowCallBackHandler handler) {
		// 1 先获取连接对象
		Connection conn = ConnectionFactory.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn.setAutoCommit(false);//取消自动提交
			// 2 预编译SQL语句
			pstmt = conn.prepareStatement(sql);
			// 3给占位符赋值
			if (setter != null) {
				// 定义要调用的抽象方法 (给占位符赋值)
				setter.setValues(pstmt);
			}
			// 4 执行sql语句
			rs = pstmt.executeQuery();
			// 5 处理结果集
			if (handler != null) {
				// 定义要调用的抽象方法 (处理结果集)
				handler.Handlers(rs);
			}
			conn.commit();//提交事务
		} catch (SQLException e) {
			try {
				conn.rollback();//发生异常就回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
	}
}
