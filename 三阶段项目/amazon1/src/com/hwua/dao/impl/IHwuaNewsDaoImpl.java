package com.hwua.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.hwua.bean.HwuaNews;
import com.hwua.dao.IHwuaNewsDao;
import com.hwua.util.JDBCTemplate;

public class IHwuaNewsDaoImpl extends JDBCTemplate implements IHwuaNewsDao{
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	@Override
	public List<HwuaNews> getNews(int rownum) {
		List<HwuaNews> list=new ArrayList<HwuaNews>();
		String sql="select * from (SELECT * FROM HWUA_NEWS order by HN_CREATE_TIME desc) where rownum<=?";
		query(sql, pstmt->{
			pstmt.setInt(1, rownum);
		}, rs->{
			while(rs.next()){
				long hn_id=rs.getLong("hn_id");
				String hn_title=rs.getString("hn_title");
				String hn_content=rs.getString("hn_content");
				Date hn_create_time=rs.getDate("hn_create_time");
				HwuaNews news=new HwuaNews(hn_id,hn_title,hn_content,hn_create_time);
				list.add(news);
			}
		});
		return list;
	}

	@Override
	public HwuaNews getNewsById(long hn_id) {
		HwuaNews news=new HwuaNews();
		String sql="SELECT * FROM HWUA_NEWS WHERE hn_id=?";
		query(sql, pstmt->{
			pstmt.setLong(1, hn_id);
		}, rs->{
			while(rs.next()){
				long hn_id1=rs.getLong("hn_id");
				String hn_title=rs.getString("hn_title");
				String hn_content=rs.getString("hn_content");
				Date hn_create_time=rs.getDate("hn_create_time");
				news.setHn_id(hn_id1);
				news.setHn_title(hn_title);
				news.setHn_content(hn_content);
				news.setHn_create_time(hn_create_time);
			}
		});
		return news;
	}

	@Override
	public int addNews(HwuaNews news) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delNews(long hn_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateNews(HwuaNews news) {
		// TODO Auto-generated method stub
		return 0;
	}

}
