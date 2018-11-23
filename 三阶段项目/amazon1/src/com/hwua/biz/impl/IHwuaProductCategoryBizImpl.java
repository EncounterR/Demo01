package com.hwua.biz.impl;

import java.util.List;

import com.hwua.bean.HwuaProductCategory;
import com.hwua.bean.Page;
import com.hwua.biz.IHwuaProductCategoryBiz;
import com.hwua.dao.IHwuaProductCategoryDao;
import com.hwua.dao.impl.IHwuaProductCategoryDaoImpl;

public class IHwuaProductCategoryBizImpl implements IHwuaProductCategoryBiz {
	IHwuaProductCategoryDao ihpcd = new IHwuaProductCategoryDaoImpl();

	@Override
	public List<HwuaProductCategory> findCategoryById(Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HwuaProductCategory> findCategoryByParentid(int hpc_parent_id) {
		List<HwuaProductCategory> list = ihpcd.findCategoryByParentid(hpc_parent_id);
		return list;
	}

	@Override
	public HwuaProductCategory getCategoryById(int hpc_id) {
		HwuaProductCategory category = ihpcd.getCategoryById(hpc_id);
		return category;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCategory(HwuaProductCategory category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delCategory(int hpc_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addCategory(HwuaProductCategory category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HwuaProductCategory> getAllCategory() {
		List<HwuaProductCategory> list = ihpcd.getAllCategory();
		return list;
	}

	@Override
	public List<HwuaProductCategory> getAll() {
		List<HwuaProductCategory> list = ihpcd.getAllParent();
		for (HwuaProductCategory p : list) {
			List<HwuaProductCategory> categorys = ihpcd.findCategoryByParentid(p.getHpc_id());
			p.setCategory(categorys);
		}

		return list;
	}

}
