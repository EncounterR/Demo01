package com.hwua.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻类
 * @author oracleOAEC
 *
 */
public class HwuaNews implements Serializable{
	private long hn_id;//新闻编号
	private String hn_title;//新闻标题
	private String hn_content;//新闻内容
	private Date hn_create_time;//新闻创建时间
	public HwuaNews() {
		super();
	}
	public HwuaNews(String hn_title, String hn_content, Date hn_create_time) {
		super();
		this.hn_title = hn_title;
		this.hn_content = hn_content;
		this.hn_create_time = hn_create_time;
	}
	public HwuaNews(long hn_id, String hn_title, String hn_content, Date hn_create_time) {
		super();
		this.hn_id = hn_id;
		this.hn_title = hn_title;
		this.hn_content = hn_content;
		this.hn_create_time = hn_create_time;
	}
	public long getHn_id() {
		return hn_id;
	}
	public void setHn_id(long hn_id) {
		this.hn_id = hn_id;
	}
	public String getHn_title() {
		return hn_title;
	}
	public void setHn_title(String hn_title) {
		this.hn_title = hn_title;
	}
	public String getHn_content() {
		return hn_content;
	}
	public void setHn_content(String hn_content) {
		this.hn_content = hn_content;
	}
	public Date getHn_create_time() {
		return hn_create_time;
	}
	public void setHn_create_time(Date hn_create_time) {
		this.hn_create_time = hn_create_time;
	}
	
}
