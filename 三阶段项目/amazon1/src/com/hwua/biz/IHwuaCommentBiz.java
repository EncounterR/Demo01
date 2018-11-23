package com.hwua.biz;

import java.util.List;

import com.hwua.bean.HwuaComment;



public interface IHwuaCommentBiz {

	/**
	 * 客户留言 插入数据
	 * @param comment
	 * @return
	 */
	int addComment(HwuaComment comment);
	
	

	
	/**
	 * 查看所有留言
	 * @return
	 */
	List<HwuaComment> allComments();
	/**
	 * 通过用户昵称查询本发送的所有留言
	 * @param id
	 * @return
	 */
	List<HwuaComment> getallCommentsByUserId(String nickName);
	/**
	 * 通过商品id查询到该商品的所有留言
	 * @param id
	 * @return
	 */
	List<HwuaComment> getAllCommentsByProdctId(long id);
	
	
	
}
