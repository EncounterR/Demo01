package com.hwua.biz;

import java.util.List;

import com.hwua.bean.HwuaCart;


public interface IHwuaCartBiz {
	
	/**
	 * 添加购物车  
	 * @param cart
	 * @return 购物车总数
	 */
	int addToCart(HwuaCart cart);
	
	
	
	
	/**
	 * 查询指定用户的购物车数量
	 * @param userId
	 * @return
	 */
	int checkCartCount(Long userId);
	
	/**
	 * 查询某个用户的所有购物车对象
	 * @param userId
	 * @return
	 */
	List<HwuaCart> usersCarts(Long userId);
	
	/**
	 * 清空购物车
	 * @param userId
	 * @return
	 */
	int emptyCarts(Long userId);
	
	/**
	 * 根据购物车ID删除购物车
	 * 
	 * @param ID
	 * @return
	 */
	int deleteCartById(long id);
	
	
	
	/**
	 * 修改指定产品的数量
	 * @param id
	 * @param quantity
	 * @return
	 */
	int alertCartQuantity(long id,int quantity);
	
	
}
