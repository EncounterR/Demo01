package com.hwua.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 定义一个接口,里面的方法用户处理结果集
 * 
 * @author cqmaple
 */
public interface ResultSetHandler {
	/**
	 * 处理结果集方法
	 * @param rs ResultSet 重写该方法可以对从数据库中查询到的数据 进行处理
	 * @throws SQLException
	 */
	public void handleRS(ResultSet rs) throws SQLException;
}
