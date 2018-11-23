package com.hwua.biz.impl;

import java.util.List;

import com.hwua.bean.HwuaProduct;
import com.hwua.bean.Page;
import com.hwua.bean.PageModel;
import com.hwua.biz.IHwuaProductBiz;
import com.hwua.dao.IHwuaProductDao;
import com.hwua.dao.impl.IHwuaProductDaoImpl;


public class IHwuaProductBizImpl implements IHwuaProductBiz{
	IHwuaProductDao ihpd=new IHwuaProductDaoImpl();
	@Override
	public List<HwuaProduct> findProductByPage(Page page) {
		List<HwuaProduct> list =ihpd.findProductByPage(page);
		return list;
	}

	@Override
	public HwuaProduct findProductById(long hp_id) {
		HwuaProduct product=ihpd.findProductById(hp_id);
		return product;
	}

	@Override
	public int updateProduct(HwuaProduct product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addProduct(HwuaProduct product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delProduct(int hp_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count() {
		int count =ihpd.count();
		return count;
	}

	@Override
	public List<HwuaProduct> getAll() {
		List<HwuaProduct> list =ihpd.getAll();
		return list;
	}
	public HwuaProduct findProductById(Long hpId) {
		return ihpd.findProductById(hpId);
	}

	@Override
	public List<HwuaProduct> queryProducts(String qname, Page page) {
		List<HwuaProduct> list =ihpd.queryProducts(qname, page);
		
		return list;
	}

	@Override
	public int countQueryProducts(String qname) {
		int count =ihpd.countQueryProducts(qname);
		return count;
	}

	@Override
	public int changeStock(int hpStock, long hpId) {
		return ihpd.changeStock(hpStock, hpId);
	}

	@Override
	public List<HwuaProduct> getProductByPagep(Page page,long hpc_id) {
		List<HwuaProduct> list=ihpd.findProductByHpcid(page,hpc_id);
		return list;
	}

	@Override
	public List<HwuaProduct> getProductByPagec(Page page,long hpc_child_id) {
		List<HwuaProduct> list=ihpd.findProductByHpcChildId(page, hpc_child_id);
		return list;
	}

	@Override
	public int productByParentCategory(long parentId) {
		// TODO Auto-generated method stub
		return ihpd.productByParentCategory(parentId);
	}

	@Override
	public int productByChildCategory(long childId) {
		// TODO Auto-generated method stub
		return ihpd.productByChildCategory(childId);
	}

	@Override
	public List<HwuaProduct> getProductsByid(long id) {
		List<HwuaProduct> list=ihpd.getProductsByid(id);
		return list;
	}
	

}
