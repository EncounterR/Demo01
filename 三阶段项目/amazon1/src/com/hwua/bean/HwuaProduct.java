package com.hwua.bean;

import java.io.Serializable;

/**
 * 产品类
 * @author oracleOAEC
 *
 */
public class HwuaProduct implements Serializable{
	private long hp_id;//产品编号
	private String hp_name;//产品名
	private String hp_description;//产品描述
	private double hp_price;//产品价格
	private int hp_stock;//产品库存
	private long hpc_id;//产品大分类编号
	private long hpc_child_id;//产品小分类编号 
	private String hp_file_name;//图片地址路径
	
	public HwuaProduct() {
		super();
	}

	public HwuaProduct(String hp_name, String hp_description, double hp_price, int hp_stock, long hpc_id,
			long hpc_child_id, String hp_file_name) {
		super();
		this.hp_name = hp_name;
		this.hp_description = hp_description;
		this.hp_price = hp_price;
		this.hp_stock = hp_stock;
		this.hpc_id = hpc_id;
		this.hpc_child_id = hpc_child_id;
		this.hp_file_name = hp_file_name;
	}

	public HwuaProduct(long hp_id, String hp_name, String hp_description, double hp_price, int hp_stock, long hpc_id,
			long hpc_child_id, String hp_file_name) {
		super();
		this.hp_id = hp_id;
		this.hp_name = hp_name;
		this.hp_description = hp_description;
		this.hp_price = hp_price;
		this.hp_stock = hp_stock;
		this.hpc_id = hpc_id;
		this.hpc_child_id = hpc_child_id;
		this.hp_file_name = hp_file_name;
	}

	public long getHp_id() {
		return hp_id;
	}

	public void setHp_id(long hp_id) {
		this.hp_id = hp_id;
	}

	public String getHp_name() {
		return hp_name;
	}

	public void setHp_name(String hp_name) {
		this.hp_name = hp_name;
	}

	public String getHp_description() {
		return hp_description;
	}

	public void setHp_description(String hp_description) {
		this.hp_description = hp_description;
	}

	public double getHp_price() {
		return hp_price;
	}

	public void setHp_price(double hp_price) {
		this.hp_price = hp_price;
	}

	public int getHp_stock() {
		return hp_stock;
	}

	public void setHp_stock(int hp_stock) {
		this.hp_stock = hp_stock;
	}

	public long getHpc_id() {
		return hpc_id;
	}

	public void setHpc_id(long hpc_id) {
		this.hpc_id = hpc_id;
	}

	public long getHpc_child_id() {
		return hpc_child_id;
	}

	public void setHpc_child_id(long hpc_child_id) {
		this.hpc_child_id = hpc_child_id;
	}

	public String getHp_file_name() {
		return hp_file_name;
	}

	public void setHp_file_name(String hp_file_name) {
		this.hp_file_name = hp_file_name;
	}
	
}
