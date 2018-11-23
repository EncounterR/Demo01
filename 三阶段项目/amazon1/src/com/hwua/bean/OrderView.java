package com.hwua.bean;


import java.util.List;

public class OrderView {
	private HwuaOrder oder;
	private List<Shopping> shoppinglist;
	
	
	public OrderView() {

	}
	

	

	public OrderView(HwuaOrder oder, List<Shopping> shoppinglist) {
		super();
		this.oder = oder;
		this.shoppinglist = shoppinglist;
	}




	public HwuaOrder getOder() {
		return oder;
	}




	public void setOder(HwuaOrder oder) {
		this.oder = oder;
	}




	public List<Shopping> getShoppinglist() {
		return shoppinglist;
	}


	public void setShoppinglist(List<Shopping> shoppinglist) {
		this.shoppinglist = shoppinglist;
	}
	
	
	
	
	
}
