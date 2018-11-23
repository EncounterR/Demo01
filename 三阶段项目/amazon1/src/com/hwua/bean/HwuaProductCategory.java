package com.hwua.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 产品分类
 * @author oracleOAEC
 *
 */
public class HwuaProductCategory implements Serializable{
	private long hpc_id;//分类编号
	private String hpc_name;//分类名
	private long hpc_parent_id;//指定 父类编号
	private List<HwuaProductCategory> category;//子类的产品分类
	
	public HwuaProductCategory() {
		super();
	}

	public HwuaProductCategory(String hpc_name, long hpc_parent_id) {
		super();
		this.hpc_name = hpc_name;
		this.hpc_parent_id = hpc_parent_id;
	}
	
	public HwuaProductCategory(long hpc_id, String hpc_name) {
		super();
		this.hpc_id = hpc_id;
		this.hpc_name = hpc_name;
	}

	public HwuaProductCategory(long hpc_id, String hpc_name, long hpc_parent_id) {
		super();
		this.hpc_id = hpc_id;
		this.hpc_name = hpc_name;
		this.hpc_parent_id = hpc_parent_id;
	}
	
	public HwuaProductCategory(long hpc_id, String hpc_name, long hpc_parent_id, List<HwuaProductCategory> category) {
		super();
		this.hpc_id = hpc_id;
		this.hpc_name = hpc_name;
		this.hpc_parent_id = hpc_parent_id;
		this.category = category;
	}
	
	public List<HwuaProductCategory> getCategory() {
		return category;
	}

	public void setCategory(List<HwuaProductCategory> category) {
		this.category = category;
	}

	public long getHpc_id() {
		return hpc_id;
	}

	public void setHpc_id(long hpc_id) {
		this.hpc_id = hpc_id;
	}

	public String getHpc_name() {
		return hpc_name;
	}

	public void setHpc_name(String hpc_name) {
		this.hpc_name = hpc_name;
	}

	public long getHpc_parent_id() {
		return hpc_parent_id;
	}

	public void setHpc_parent_id(long hpc_parent_id) {
		this.hpc_parent_id = hpc_parent_id;
	}
	
}
