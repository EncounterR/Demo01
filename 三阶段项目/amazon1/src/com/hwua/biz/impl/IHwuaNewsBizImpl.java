package com.hwua.biz.impl;

import java.util.List;

import com.hwua.bean.HwuaNews;
import com.hwua.biz.IHwuaNewsBiz;
import com.hwua.dao.IHwuaNewsDao;
import com.hwua.dao.impl.IHwuaNewsDaoImpl;

public class IHwuaNewsBizImpl implements IHwuaNewsBiz{
	IHwuaNewsDao ihnd=new IHwuaNewsDaoImpl();
	@Override
	public List<HwuaNews> getNews(int rownum) {
		List<HwuaNews> list =ihnd.getNews(rownum);
		return list;
	}

	@Override
	public HwuaNews getNewsById(long hn_id) {
		HwuaNews news=ihnd.getNewsById(hn_id);
		return news;
	}

}
