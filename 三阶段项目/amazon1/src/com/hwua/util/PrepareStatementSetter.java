package com.hwua.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PrepareStatementSetter {
	/**
	 * 用于给预编译sql语句的占位符赋值
	 * @param pstmt
	 * @throws SQLException
	 */
	public void setValues(PreparedStatement pstmt) throws SQLException;
}
