package com.hwua.bean;

import java.io.Serializable;

/**
 * 购物车
 * @author oracleOAEC
 *
 */
public class HwuaCart implements Serializable{
	private long id;//购物车编号
	private long pid;//产品编号
	private int quantity;//产品数量
	private long  userid;//购买人id
	private String pname;//商品的名字
	private double price;//商品的价格
	private String hp_file_name;//图片地址路径
	private int hp_stock;//产品库存
	
	public String getHp_file_name() {
		return hp_file_name;
	}

	public void setHp_file_name(String hp_file_name) {
		this.hp_file_name = hp_file_name;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public HwuaCart() {
		super();
	}

	public HwuaCart(long pid, int quantity, long userid) {
		super();
		this.pid = pid;
		this.quantity = quantity;
		this.userid = userid;
	}

	public HwuaCart(long id, long pid, int quantity, long userid) {
		super();
		this.id = id;
		this.pid = pid;
		this.quantity = quantity;
		this.userid = userid;
	}

	public int getHp_stock() {
		return hp_stock;
	}

	public void setHp_stock(int hp_stock) {
		this.hp_stock = hp_stock;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}
	
}
