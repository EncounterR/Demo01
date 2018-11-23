package com.hwua.biz;

import java.util.List;

import com.hwua.bean.HwuaProductCategory;
import com.hwua.bean.Page;

/**
 * 产品逻辑分类接口
 * @author oracleOAEC
 *
 */
public interface IHwuaProductCategoryBiz {
	/**
	 * 分页查询一级分类
	 * @return
	 */
	public List<HwuaProductCategory> findCategoryById(Page page);
	/**
	 * 查询二级分类
	 * @return
	 */
	public List<HwuaProductCategory> findCategoryByParentid(int hpc_parent_id);
	/**
	 * 指定分类编号查询分类对象
	 */
	public HwuaProductCategory getCategoryById(int hpc_id);
	/**
	 * 总条数
	 * @return
	 */
	public int count();
	/**
	 * 修改分类信息
	 * @return
	 */
	public int updateCategory(HwuaProductCategory category);
	/**
	 * 删除分类信息
	 * @param epc_id
	 * @return
	 */
	public int delCategory(int hpc_id);
	/**
	 * 增加分类信息
	 * @param category
	 * @return
	 */
	public int addCategory(HwuaProductCategory category);
	/**
	 * 查询所有的分类信息
	 * @return
	 */
	public List<HwuaProductCategory> getAllCategory();
	/**
	 * 得到所有的分类信息
	 * @return
	 */
	public List<HwuaProductCategory> getAll();
}
