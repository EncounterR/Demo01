package com.hwua.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.bean.HwuaOrder;
import com.hwua.bean.HwuaOrderDetail;
import com.hwua.bean.HwuaUser;
import com.hwua.bean.OrderView;
import com.hwua.bean.Shopping;
import com.hwua.biz.IHwuaOrderBiz;
import com.hwua.biz.IHwuaOrderDetailBiz;
import com.hwua.biz.impl.CartBizImpl;
import com.hwua.biz.impl.IHwuaProductBizImpl;
import com.hwua.biz.impl.OrderBizImpl;
import com.hwua.biz.impl.OrderDetailBizImpl;
@WebServlet("/doBuy")
public class DoBuy extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HwuaUser user=(HwuaUser)req.getSession().getAttribute("user");
		HwuaOrder order = new HwuaOrder();
		order.setHo_user_id(user.getHu_user_id());
		order.setHo_user_name(user.getHu_user_name());
		order.setHo_user_address(user.getHu_address());
		order.setHo_create_time(new java.sql.Date(new Date().getTime()));
		order.setHo_status(1);
		order.setHo_type(1);
		
		List<Shopping> shopingList = ShoppingView.getShopingList(req, resp);
		Double hoCost=0.0;
		IHwuaOrderBiz ihob=new OrderBizImpl();
		IHwuaOrderDetailBiz iodb=new OrderDetailBizImpl();
		
		for (Shopping s : shopingList) {
			hoCost=s.getQuantity()*s.getPrice()+hoCost;
		}
		
		System.out.println("订单总额:"+hoCost);
		order.setHo_cost(hoCost);
		
		int addOrder = new OrderBizImpl().addOrder(order);
		OrderView orderView = new OrderView();
		if(addOrder>0){//下单成功  添加订单明细  修改商品库存
			Long orderId = iodb.getOrderId();//获得订单的Id
			order.setHo_id(orderId);
			orderView.setOder(order);//设置订单值
			orderView.setShoppinglist(shopingList );//设置购买时的shoppinglist
			for (Shopping s : shopingList) {
				iodb.addOrderDetail(new HwuaOrderDetail(orderId,s.getHpId(),s.getQuantity(),s.getPrice()*s.getQuantity()));
				new IHwuaProductBizImpl().changeStock(s.getHp_stock()-s.getQuantity(),s.getHpId());
			}
			int emptyCarts = new CartBizImpl().emptyCarts(user.getHu_user_id());
			if(emptyCarts>0){
				req.getSession().setAttribute("cartCount", "");
				HwuaOrder order1=ihob.findHwuaOrderByUid(user.getHu_user_id());
				req.getSession().setAttribute("order", order1);
			}
			
			//req.getRequestDispatcher("shopping-result.jsp").forward(req, resp);
			resp.sendRedirect("shopping-result.jsp");
		}else{
			resp.getWriter().println("alert('下单失败！即将跳转到首页！')");
			resp.sendRedirect("index.jsp");
		}
		req.getSession().setAttribute("orderView", orderView);
		
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	
	}
	
	
	
	
	
	
	
	

}
