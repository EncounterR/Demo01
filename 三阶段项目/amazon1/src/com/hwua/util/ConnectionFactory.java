package com.hwua.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 工厂类 来生产Connection
 * 
 * @author Administrator
 *
 */
public class ConnectionFactory {
	private static String driver; // 驱动类所在的位置
	private static String url;// 连接数据库地址��ַ
	private static String uname;// 访问数据库用户名
	private static String upwd;// 密码

	//静态代码块  只执行一次
	static{
		InputStream in = ConnectionFactory.class.getResourceAsStream("jdbcoracle.properties");
		// 获取properties对象
		Properties properties = new Properties();
		// 将文件流加载到properties
		try {
			properties.load(in);
			//获取jdbcoracle.properties值ֵ
			driver=(String) properties.get("driver");
			url=(String) properties.get("url");
			uname=(String) properties.get("uname");
			upwd=(String) properties.get("upwd");
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	/**
	 * 获取连接对象
	 * 
	 * @return 连接对象
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, upwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
