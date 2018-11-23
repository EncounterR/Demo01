package com.hwua.bean;

public class Shopping {
	
	private long hcId;//购物车对象Id
	private long hpId;//商品的ID
	private String hpFileName;//图片路径
	private String hpName;//商品名
	private int quantity;//购买数量
	private double price;//商品价格
	private int hp_stock;//商品库存
	
	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Shopping(long hcId, long hpId, String hpFileName, String hpName, int quantity, double price) {
		super();
		this.hcId = hcId;
		this.hpId = hpId;
		this.hpFileName = hpFileName;
		this.hpName = hpName;
		this.quantity = quantity;
		this.price = price;
	}

	

	public int getHp_stock() {
		return hp_stock;
	}



	public void setHp_stock(int hp_stock) {
		this.hp_stock = hp_stock;
	}



	public Shopping(long hcId, long hpId, String hpFileName, String hpName, int quantity, double price, int hp_stock) {
		super();
		this.hcId = hcId;
		this.hpId = hpId;
		this.hpFileName = hpFileName;
		this.hpName = hpName;
		this.quantity = quantity;
		this.price = price;
		this.hp_stock = hp_stock;
	}



	public Shopping(long hcId, long hpId, String hpFileName, String hpName, int quantity) {
		super();
		this.hcId = hcId;
		this.hpId = hpId;
		this.hpFileName = hpFileName;
		this.hpName = hpName;
		this.quantity = quantity;
	}



	public Shopping(long hpId, String hpFileName, String hpName) {
		super();
		this.hpId = hpId;
		this.hpFileName = hpFileName;
		this.hpName = hpName;
	}



	public Shopping() {
		super();
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public Shopping(long hcId, long hpId, String hpFileName, String hpName) {
		super();
		this.hcId = hcId;
		this.hpId = hpId;
		this.hpFileName = hpFileName;
		this.hpName = hpName;
	}

	

	public long getHcId() {
		return hcId;
	}



	public void setHcId(long hcId) {
		this.hcId = hcId;
	}



	public long getHpId() {
		return hpId;
	}



	public void setHpId(long hpId) {
		this.hpId = hpId;
	}



	public String getHpFileName() {
		return hpFileName;
	}



	public void setHpFileName(String hpFileName) {
		this.hpFileName = hpFileName;
	}



	public String getHpName() {
		return hpName;
	}



	public void setHpName(String hpName) {
		this.hpName = hpName;
	}



	@Override
	public String toString() {
		return "Shopping [hcId=" + hcId + ", hpId=" + hpId + ", hpFileName=" + hpFileName + ", hpName=" + hpName + "]";
	}



	
	
	
	
	
	
}
