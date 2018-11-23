package com.hwua.biz;

import java.util.List;

import com.hwua.bean.HwuaNews;

/**
 * 新闻接口
 * @author oracleOAEC
 *
 */
public interface IHwuaNewsBiz {
	/**
	 * 查询最新的rownum条消息
	 * @param rownum
	 * @return
	 */
	public List<HwuaNews> getNews(int rownum);
	/**
	 * 通过新闻id查询新闻信息
	 * @param hn_id
	 * @return
	 */
	public HwuaNews getNewsById(long hn_id);
}
