package com.hwua.biz.impl;

import java.util.List;

import com.hwua.bean.HwuaOrder;
import com.hwua.bean.HwuaOrderDetail;
import com.hwua.bean.HwuaProduct;
import com.hwua.biz.IHwuaOrderBiz;
import com.hwua.dao.IHwuaProductDao;
import com.hwua.dao.IOrderDao;
import com.hwua.dao.IOrderDetailDao;
import com.hwua.dao.impl.IHwuaProductDaoImpl;
import com.hwua.dao.impl.OrderDaoImpl;
import com.hwua.dao.impl.OrderDetailDaoImpl;

public class OrderBizImpl implements IHwuaOrderBiz{
	private IOrderDao iod=new OrderDaoImpl();
	private IOrderDetailDao iodd=new OrderDetailDaoImpl();
	private IHwuaProductDao ihpd=new IHwuaProductDaoImpl();
	@Override
	public int addOrder(HwuaOrder order) {
		return iod.addOrder(order);
	}

	@Override
	public List<HwuaOrder> searchAllOrder(Long hoUserId) {
		List<HwuaOrder> orders=iod.searchAllOrder(hoUserId);
		for(HwuaOrder order:orders){
			List<HwuaOrderDetail> details=iodd.getOrderDetailByHoid(order.getHo_id());
			for(HwuaOrderDetail detail:details){
				HwuaProduct product=ihpd.findProductById(detail.getHp_id());
				detail.setProduct(product);
			}
			order.setDetails(details);
		}
		return orders;
	}
	@Override
	public int updateOrder(Long hoId, Long hoStatus) {
		
		return iod.updateOrder(hoId, hoStatus);
	}

	@Override
	public int deleteOrder(Long hoId) {
		
		return iod.deleteOrder(hoId);
	}

	@Override
	public HwuaOrder findHwuaOrderByUid(long id) {
		// TODO Auto-generated method stub
		return iod.findHwuaOrderByUid(id);
	}

	@Override
	public List<HwuaOrder> getAllOrder(long hoUserId) {
		// TODO Auto-generated method stub
		return iod.getAllOrder(hoUserId);
	}

}
