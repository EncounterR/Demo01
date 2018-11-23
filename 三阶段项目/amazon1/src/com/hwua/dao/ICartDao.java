package com.hwua.dao;

import java.util.List;

import com.hwua.bean.HwuaCart;

public interface ICartDao {
	/**
	 * 添加购物车
	 * @param cart
	 * @return
	 */
	int addCart(HwuaCart cart);
	
	/**
	 * 更新购物车 
	 * @param cart
	 * @return
	 */
	int updateCart(HwuaCart cart);
	
	
	/**
	 * 是否已经添加到购物车
	 * @param cart pid userid
	 * @return
	 */
	HwuaCart checkCart(HwuaCart cart);
	
	List<Integer> updateCartCount(Long userId);
	
	
	/**
	 * 查询某个用户的所有购物车对象
	 * @param userId
	 * @return
	 */
	List<HwuaCart> usersCarts(Long userId);
	
	
	/**
	 * 删除指定用户的购物车对象
	 * @param userId
	 * @return
	 */
	int deleteCarts(Long userId);
	
	/**
	 * 根据购物车ID删除购物车
	 * 
	 * @param ID
	 * @return
	 */
	int deleteCartById(long  id);
	
	
	
	
	
	/**
	 * 修改指定产品的数量
	 * @param id
	 * @param quantity
	 * @return
	 */
	int alertCartQuantity(long id,int quantity);
	
	
	
	
	
	
	
}
