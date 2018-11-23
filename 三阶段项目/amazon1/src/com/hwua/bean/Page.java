package com.hwua.bean;

import java.io.Serializable;

public class Page implements Serializable{
	private int pageSize;
	private int totalSize;
	private int totalPageSize;
	private int current;
	private int pageType;
	public Page(int pageSize, int totalSize, int totalPageSize, int current) {
		super();
		this.pageSize = pageSize;
		this.totalSize = totalSize;
		this.totalPageSize = totalPageSize;
		this.current = current;
	}
	public Page() {
		
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
		this.totalPageSize=totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
	}
	public int getTotalPageSize() {
		return totalPageSize;
	}
	public void setTotalPageSize(int totalPageSize) {
		this.totalPageSize = totalPageSize;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getPageType() {
		return pageType;
	}
	public void setPageType(int pageType) {
		this.pageType = pageType;
	}
	
	
}
