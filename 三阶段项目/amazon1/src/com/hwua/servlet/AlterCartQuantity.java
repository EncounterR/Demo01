package com.hwua.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hwua.bean.HwuaUser;
import com.hwua.biz.impl.CartBizImpl;
/**
 * 更改购物车产品数量的servlet
 * @author Administrator
 *
 */
@WebServlet("/alterQuantity")
public class AlterCartQuantity extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] split =  req.getQueryString().split("_");
		long id=Long.parseLong(split[0]);
		int quantity=Integer.parseInt(split[1]);
		int alertCartQuantity = new CartBizImpl().alertCartQuantity(id, quantity);
		if(alertCartQuantity>0){
			int checkCartCount = new CartBizImpl().checkCartCount(((HwuaUser)req.getSession().getAttribute("user")).getHu_user_id());
			resp.getWriter().print(checkCartCount);
			
		}
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
	
	
	

}
