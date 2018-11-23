package com.hwua.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowCallBackHandler {
	/**
	 * 用于处理结果集
	 * @param rs
	 * @throws SQLException
	 */
	public void Handlers(ResultSet rs) throws SQLException;
}
