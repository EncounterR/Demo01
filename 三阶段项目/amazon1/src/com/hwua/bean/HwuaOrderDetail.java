package com.hwua.bean;

import java.io.Serializable;

/**
 * 订单详情
 * @author oracleOAEC
 *
 */
public class HwuaOrderDetail implements Serializable{
	private long hod_id;//订单详细编号
	private long ho_id;//订单编号
	private long hp_id;//产品编号
	private int hod_quantity;//数量
	private double hod_cost;//总金额
	private HwuaProduct product;//产品对象
	public HwuaOrderDetail() {
		super();
	}

	public HwuaOrderDetail(long ho_id, long hp_id, int hod_quantity, double hod_cost) {
		super();
		this.ho_id = ho_id;
		this.hp_id = hp_id;
		this.hod_quantity = hod_quantity;
		this.hod_cost = hod_cost;
	}

	public HwuaOrderDetail(long hod_id, long ho_id, long hp_id, int hod_quantity, double hod_cost) {
		super();
		this.hod_id = hod_id;
		this.ho_id = ho_id;
		this.hp_id = hp_id;
		this.hod_quantity = hod_quantity;
		this.hod_cost = hod_cost;
	}
	
	public HwuaProduct getProduct() {
		return product;
	}

	public void setProduct(HwuaProduct product) {
		this.product = product;
	}

	public long getHod_id() {
		return hod_id;
	}

	public void setHod_id(long hod_id) {
		this.hod_id = hod_id;
	}

	public long getHo_id() {
		return ho_id;
	}

	public void setHo_id(long ho_id) {
		this.ho_id = ho_id;
	}

	public long getHp_id() {
		return hp_id;
	}

	public void setHp_id(long hp_id) {
		this.hp_id = hp_id;
	}

	public int getHod_quantity() {
		return hod_quantity;
	}

	public void setHod_quantity(int hod_quantity) {
		this.hod_quantity = hod_quantity;
	}

	public double getHod_cost() {
		return hod_cost;
	}

	public void setHod_cost(double hod_cost) {
		this.hod_cost = hod_cost;
	}
	
}
