package com.hwua.biz;

import java.util.List;

import com.hwua.bean.HwuaOrderDetail;
import com.hwua.bean.HwuaProduct;


public interface IHwuaOrderDetailBiz {
	/**
	 * 根据订单生成订单详细表
	 * @param orderDetail
	 * @return
	 */
	int addOrderDetail(HwuaOrderDetail orderDetail);
	
	
	
	/**
	 * 查询热门商品
	 * @param rownum 热门商品数量
	 * @return
	 */
	List<HwuaProduct> hotProducts(int rownum);
	
	
	
	/**
	 * 查询当前order表中的序列值
	 * @return
	 */
	Long getOrderId();
	/**
	 * 根据订单编号查询订单详情
	 * @param ho_id
	 * @return
	 */
	public List<HwuaOrderDetail> getOrderDetailByHoid(long ho_id);
	/**
	 * 根据订单详情编号删除订单详情
	 * @param id
	 * @return
	 */
	public int delDetailById(long id);
	
	
}
