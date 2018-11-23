package com.hwua.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.hwua.bean.HwuaOrderDetail;
import com.hwua.bean.HwuaProduct;
import com.hwua.biz.IHwuaOrderDetailBiz;
import com.hwua.dao.IHwuaProductDao;
import com.hwua.dao.IOrderDetailDao;
import com.hwua.dao.impl.IHwuaProductDaoImpl;
import com.hwua.dao.impl.OrderDetailDaoImpl;


public class OrderDetailBizImpl implements IHwuaOrderDetailBiz{

	IOrderDetailDao iodd=new OrderDetailDaoImpl();
	IHwuaProductDao ihpd=new IHwuaProductDaoImpl();
	@Override
	public int addOrderDetail(HwuaOrderDetail orderDetail) {
		
		return iodd.addOrderDetail(orderDetail);
	}

	@Override
	public List<HwuaProduct> hotProducts(int rownum) {
		List<Long> hotPids= iodd.hotProducts(rownum);//获得热门商品id
		List<HwuaProduct> list=new ArrayList<>();
		for (Long pid : hotPids) {
			HwuaProduct product = new IHwuaProductDaoImpl().findProductById(pid);//查询热门商品
			list.add(product);
		}
		return list;
	}

	@Override
	public Long getOrderId() {
		return iodd.getOrderId();
	}

	@Override
	public List<HwuaOrderDetail> getOrderDetailByHoid(long ho_id) {
		List<HwuaOrderDetail> details=iodd.getOrderDetailByHoid(ho_id);
		for(HwuaOrderDetail d:details){
			HwuaProduct product=ihpd.findProductById(d.getHp_id());
			d.setProduct(product);
		}
		return details;
	}

	@Override
	public int delDetailById(long id) {
		// TODO Auto-generated method stub
		return iodd.delDetailById(id);
	}
	
}
