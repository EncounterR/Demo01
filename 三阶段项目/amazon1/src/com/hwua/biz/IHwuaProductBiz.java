package com.hwua.biz;

import java.util.List;

import com.hwua.bean.HwuaProduct;
import com.hwua.bean.Page;
import com.hwua.bean.PageModel;
/**
 * 业务逻辑产品接口
 * @author oracleOAEC
 *
 */
public interface IHwuaProductBiz {
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
	 * 迷糊查询商品
	 * @param qname
	 * @param page
	 * @return
	 */
	public List<HwuaProduct> queryProducts(String qname, Page page);
	/**
	 * 根据商品名模糊查询产品数量
	 * @param qname
	 * @return
	 */
	public int countQueryProducts(String qname);
	/**
	 * 更新指定产品库存
	 * @param hpStock
	 * @return
	 */
	public int changeStock(int hpStock,long hpId);
	/**
	 * 根据父分类分页查询商品
	 * @param page
	 * @return
	 */
	public List<HwuaProduct> getProductByPagep(Page page,long hpc_id);

	/**
	 * 
	 * 指定父级目录产品数量
	 * @param parentId
	 * @return
	 */
	int productByParentCategory(long parentId);
	/**
	 * 根据子分类分页查询商品
	 * @param page
	 * @return
	 */
	public List<HwuaProduct> getProductByPagec(Page page,long hpc_child_id);
	/**
	 * 指定子级目录商品数量
	 * @param childId
	 * @return
	 */
	int productByChildCategory(long childId);
	/**
	 * 根据分类查询商品
	 * @param id
	 * @return
	 */
	List<HwuaProduct> getProductsByid(long id);
}
