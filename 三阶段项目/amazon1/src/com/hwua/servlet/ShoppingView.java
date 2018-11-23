package com.hwua.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.bean.HwuaCart;
import com.hwua.bean.HwuaProduct;
import com.hwua.bean.HwuaUser;
import com.hwua.bean.Shopping;
import com.hwua.biz.impl.CartBizImpl;
import com.hwua.biz.impl.IHwuaProductBizImpl;

public class ShoppingView extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 根据用户ID便利购物车获得所有的购物车对象
		req.setAttribute("shoppingList", ShoppingView.getShopingList(req, resp));
		req.getRequestDispatcher("shopping.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	/**
	 * 获得shoppinglist的静态封装方法
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	public static List<Shopping> getShopingList(HttpServletRequest req, HttpServletResponse resp) {
		HwuaUser user = (HwuaUser) req.getSession().getAttribute("user");
		int number=Integer.parseInt(req.getParameter("number"));
		List<HwuaCart> carts = new CartBizImpl().usersCarts(user.getHu_user_id());
		List<Shopping> shoppingList = new ArrayList<>();
		if (carts != null) {
			// 根据购物车对象的pid查询相关商品的信息
			for (HwuaCart c : carts) {
				HwuaProduct product = new IHwuaProductBizImpl().findProductById(c.getPid());
				Shopping shoping = new Shopping(c.getId(), product.getHp_id(), product.getHp_file_name(),
						product.getHp_name(), number,product.getHp_price(),product.getHp_stock());
				shoppingList.add(shoping);
			}
		}

		return shoppingList;

	}

}
