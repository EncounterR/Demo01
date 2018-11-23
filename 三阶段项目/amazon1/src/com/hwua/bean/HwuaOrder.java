package com.hwua.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单类
 * @author oracleOAEC
 *
 */
public class HwuaOrder implements Serializable{
	private long ho_id;//订单编号
	private long ho_user_id;//下单用户
	private String ho_user_name;//下单用户名
	private String ho_user_address;//下单地址
	private Date ho_create_time;//下单时间
	private double ho_cost;//订单金额
	private long ho_status;//订单状态
	private long ho_type;//订单类型
	private List<HwuaOrderDetail> details;//订单详情集合
	public HwuaOrder() {
		super();
	}
	public HwuaOrder(long ho_user_id, String ho_user_name, String ho_user_address, Date ho_create_time, double ho_cost,
			long ho_status, long ho_type) {
		super();
		this.ho_user_id = ho_user_id;
		this.ho_user_name = ho_user_name;
		this.ho_user_address = ho_user_address;
		this.ho_create_time = ho_create_time;
		this.ho_cost = ho_cost;
		this.ho_status = ho_status;
		this.ho_type = ho_type;
	}
	public HwuaOrder(long ho_id, long ho_user_id, String ho_user_name, String ho_user_address, Date ho_create_time,
			double ho_cost, long ho_status, long ho_type) {
		super();
		this.ho_id = ho_id;
		this.ho_user_id = ho_user_id;
		this.ho_user_name = ho_user_name;
		this.ho_user_address = ho_user_address;
		this.ho_create_time = ho_create_time;
		this.ho_cost = ho_cost;
		this.ho_status = ho_status;
		this.ho_type = ho_type;
	}
	
	
	public List<HwuaOrderDetail> getDetails() {
		return details;
	}
	public void setDetails(List<HwuaOrderDetail> details) {
		this.details = details;
	}
	public long getHo_id() {
		return ho_id;
	}
	public void setHo_id(long ho_id) {
		this.ho_id = ho_id;
	}
	public long getHo_user_id() {
		return ho_user_id;
	}
	public void setHo_user_id(long ho_user_id) {
		this.ho_user_id = ho_user_id;
	}
	public String getHo_user_name() {
		return ho_user_name;
	}
	public void setHo_user_name(String ho_user_name) {
		this.ho_user_name = ho_user_name;
	}
	public String getHo_user_address() {
		return ho_user_address;
	}
	public void setHo_user_address(String ho_user_address) {
		this.ho_user_address = ho_user_address;
	}
	public Date getHo_create_time() {
		return ho_create_time;
	}
	public void setHo_create_time(Date ho_create_time) {
		this.ho_create_time = ho_create_time;
	}
	public double getHo_cost() {
		return ho_cost;
	}
	public void setHo_cost(double ho_cost) {
		this.ho_cost = ho_cost;
	}
	public long getHo_status() {
		return ho_status;
	}
	public void setHo_status(long ho_status) {
		this.ho_status = ho_status;
	}
	public long getHo_type() {
		return ho_type;
	}
	public void setHo_type(long ho_type) {
		this.ho_type = ho_type;
	}
	
}
