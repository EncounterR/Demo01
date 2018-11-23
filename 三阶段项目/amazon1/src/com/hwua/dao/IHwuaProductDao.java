package com.hwua.dao;

import java.util.List;

import com.hwua.bean.HwuaProduct;
import com.hwua.bean.Page;

/**
 * 商品接口
 * @author oracleOAEC
 *
 */
public interface IHwuaProductDao {
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	public List<HwuaProduct> findProductByPage(Page page);
	/**
	 * 根据id查询商品
	 * @param ep_id
	 * @return
	 */
	public HwuaProduct findProductById(long hp_id);
	/**
	 * 根据大分类编号分页查询
	 * @param hpc_id
	 * @return
	 */
	public List<HwuaProduct> findProductByHpcid(Page page,long hpc_id);
	/**
	 * 根据小分类编号分页查询
	 * @param hpc_id
	 * @return
	 */
	public List<HwuaProduct> findProductByHpcChildId(Page page,long hpc_child_id);
	/**
	 * 更新商品信息
	 * @param product
	 * @return
	 */
	public int updateProduct(HwuaProduct product);
	/**
	 * 增加商品信息
	 * @param product
	 * @return
	 */
	public int addProduct(HwuaProduct product);
	/**
	 * 根据id删除商品信息
	 * @param ep_id
	 * @return
	 */
	public int delProduct(int hp_id);
	/**
	 * 商品信息总条数
	 * @return
	 */
	public int count();
	/**
	 * 查询所有商品信息
	 * @return
	 */
	public List<HwuaProduct> getAll();
	
	/**
	 * 
	 * 指定父级目录产品数量
	 * @param parentId
	 * @return
	 */
	int productByParentCategory(long parentId);
	
	
	/**
	 * 指定子级目录商品数量
	 * @param childId
	 * @return
	 */
	int productByChildCategory(long childId);
	
	/**
	 * 更新指定产品库存
	 * @param hpStock
	 * @return
	 */
	int changeStock(int hpStock,long hpId);
	
	/**
	 * 根据商品名模糊查询产品
	 * @param qname
	 * @return
	 */
	
	List<HwuaProduct> queryProducts(String qname,Page page);
	
	/**
	 * 根据商品名模糊查询产品数量
	 * @param qname
	 * @return
	 */
	int countQueryProducts(String qname);
	/**
	 * 根据分类查询商品
	 * @param id
	 * @return
	 */
	List<HwuaProduct> getProductsByid(long id);
}
