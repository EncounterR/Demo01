package com.hwua.dao;

import java.util.List;

import com.hwua.bean.HwuaNews;

/**
 * 新闻接口
 * @author oracleOAEC
 *
 */
public interface IHwuaNewsDao {
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
	/**
	 * 增加新闻信息
	 * @param news
	 * @return
	 */
	public int addNews(HwuaNews news);
	/**
	 * 删除新闻信息
	 * @param hn_id
	 * @return
	 */
	public int delNews(long hn_id);
	/**
	 * 修改新闻信息
	 * @param news
	 * @return
	 */
	public int updateNews(HwuaNews news);
}
