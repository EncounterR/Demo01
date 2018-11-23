package com.hwua.biz.impl;

import java.util.List;

import com.hwua.bean.HwuaCart;
import com.hwua.bean.HwuaProduct;
import com.hwua.biz.IHwuaCartBiz;
import com.hwua.dao.ICartDao;
import com.hwua.dao.IHwuaProductDao;
import com.hwua.dao.impl.CartDaoImpl;
import com.hwua.dao.impl.IHwuaProductDaoImpl;

public class CartBizImpl implements IHwuaCartBiz {
	ICartDao icd = new CartDaoImpl();
	IHwuaProductDao ihpd=new IHwuaProductDaoImpl();
	@Override
	public int addToCart(HwuaCart cart) {
		HwuaCart checkCart = icd.checkCart(cart);
		int row=0;
		if (checkCart.getId() == 0) {
			row=icd.addCart(cart);
		} else {
			checkCart.setId(checkCart.getId());
			checkCart.setPid(checkCart.getPid());
			checkCart.setQuantity(checkCart.getQuantity() + cart.getQuantity());
			checkCart.setUserid(checkCart.getUserid());
			row=icd.updateCart(checkCart);
		}
		return row;
	}

	@Override
	public List<HwuaCart> usersCarts(Long userId) {
		List<HwuaCart> list=icd.usersCarts(userId);
		for(HwuaCart c: list){
			HwuaProduct product=ihpd.findProductById(c.getPid());
			c.setPname(product.getHp_name());
			c.setPrice(product.getHp_price());
			c.setHp_file_name(product.getHp_file_name());
			c.setHp_stock(product.getHp_stock());
		}
		return list;
	}

	@Override
	public int checkCartCount(Long userId) {
		int sum = 0;
		List<Integer> count = icd.updateCartCount(userId);
		for (Integer i : count) {
			sum += i;
		}
		return sum;
	}

	@Override
	public int emptyCarts(Long userId) {

		return icd.deleteCarts(userId);
	}

	@Override
	public int deleteCartById(long  id) {

		return icd.deleteCartById(id);
	}

	@Override
	public int alertCartQuantity(long id, int quantity) {

		return icd.alertCartQuantity(id, quantity);
	}

}
