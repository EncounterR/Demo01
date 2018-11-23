package com.hwua.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言
 * @author oracleOAEC
 *
 */
public class HwuaComment implements Serializable{
	private long hc_id;//留言编号
	private String hc_reply;//回复内容
	private String hc_content;//留言内容
	private Date hc_create_time;//留言创建时间
	private Date hc_reply_time;//回复时间
	private String hc_nick_name;//昵称
	private int hc_state;//状态
	private long hp_id;//商品id
	
	public HwuaComment() {
		super();
	}
	
	public HwuaComment(String hc_nick_name, Date hc_create_time,String hc_content,long hp_id) {
		super();
		this.hc_content = hc_content;
		this.hc_create_time = hc_create_time;
		this.hc_nick_name = hc_nick_name;
		this.hp_id = hp_id;
	}

	public HwuaComment(long hc_id, String hc_reply, String hc_content, Date hc_create_time, Date hc_reply_time,
			String hc_nick_name, int hc_state) {
		super();
		this.hc_id = hc_id;
		this.hc_reply = hc_reply;
		this.hc_content = hc_content;
		this.hc_create_time = hc_create_time;
		this.hc_reply_time = hc_reply_time;
		this.hc_nick_name = hc_nick_name;
		this.hc_state = hc_state;
	}

	public HwuaComment(String hc_reply, String hc_content, Date hc_create_time, Date hc_reply_time, String hc_nick_name,
			int hc_state) {
		super();
		this.hc_reply = hc_reply;
		this.hc_content = hc_content;
		this.hc_create_time = hc_create_time;
		this.hc_reply_time = hc_reply_time;
		this.hc_nick_name = hc_nick_name;
		this.hc_state = hc_state;
	}
	
	public HwuaComment(String hc_reply, String hc_content, Date hc_create_time, Date hc_reply_time, String hc_nick_name,
			int hc_state, long hp_id) {
		super();
		this.hc_reply = hc_reply;
		this.hc_content = hc_content;
		this.hc_create_time = hc_create_time;
		this.hc_reply_time = hc_reply_time;
		this.hc_nick_name = hc_nick_name;
		this.hc_state = hc_state;
		this.hp_id = hp_id;
	}

	public long getHc_id() {
		return hc_id;
	}

	public void setHc_id(long hc_id) {
		this.hc_id = hc_id;
	}

	public String getHc_reply() {
		return hc_reply;
	}

	public void setHc_reply(String hc_reply) {
		this.hc_reply = hc_reply;
	}

	public String getHc_content() {
		return hc_content;
	}

	public void setHc_content(String hc_content) {
		this.hc_content = hc_content;
	}

	public Date getHc_create_time() {
		return hc_create_time;
	}

	public void setHc_create_time(Date hc_create_time) {
		this.hc_create_time = hc_create_time;
	}

	public Date getHc_reply_time() {
		return hc_reply_time;
	}

	public void setHc_reply_time(Date hc_reply_time) {
		this.hc_reply_time = hc_reply_time;
	}

	public String getHc_nick_name() {
		return hc_nick_name;
	}

	public void setHc_nick_name(String hc_nick_name) {
		this.hc_nick_name = hc_nick_name;
	}

	public int getHc_state() {
		return hc_state;
	}

	public void setHc_state(int hc_state) {
		this.hc_state = hc_state;
	}

	public long getHp_id() {
		return hp_id;
	}

	public void setHp_id(long hp_id) {
		this.hp_id = hp_id;
	}
	
	
}
