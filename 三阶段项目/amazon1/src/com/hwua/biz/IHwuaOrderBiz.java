package com.hwua.biz;

import java.util.List;

import com.hwua.bean.HwuaOrder;



public interface IHwuaOrderBiz {
	/**
	 * 添加订单
	 * @param order
	 * @return
	 */
	public int addOrder(HwuaOrder order);
	
	/**
	 * 查询指定用户所有订单
	 * @return
	 */
	public List<HwuaOrder> searchAllOrder(Long hoUserId);
	
	
	/**
	 * 修改指定的订单状态
	 * @param eoId
	 * @param eoStatus
	 * @return
	 */
	public int updateOrder(Long hoId, Long hoStatus);
	
	/**
	 * 删除指定Id的订单
	 * @param eoId
	 * @return
	 */
	public int deleteOrder(Long hoId);
	/**
	 * 根据用户id查询该用户最新一条购物订单记录
	 * @param id
	 * @return
	 */
	public HwuaOrder findHwuaOrderByUid(long id);
	/**
	 * 查询指定用户的正在发货的所有订单
	 * @return
	 */
	public List<HwuaOrder> getAllOrder(long hoUserId);
}
