package com.hwua.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.bean.HwuaProduct;
import com.hwua.bean.Page;
import com.hwua.biz.IHwuaProductBiz;
import com.hwua.biz.IHwuaProductCategoryBiz;
import com.hwua.biz.impl.IHwuaProductBizImpl;
import com.hwua.biz.impl.IHwuaProductCategoryBizImpl;

/**
 * Servlet implementation class HwuaProductCategoryServlrt
 */
@WebServlet("/HwuaProductCategoryServlrt")
public class HwuaProductCategoryServlrt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HwuaProductCategoryServlrt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String org = request.getParameter("org");
		HttpSession session = request.getSession();
		IHwuaProductCategoryBiz ihpcb = new IHwuaProductCategoryBizImpl();
		IHwuaProductBiz ihpb=new IHwuaProductBizImpl();
		long hpc_id=0;
		Page page = new Page();
		if(org.equals("list1")){
			hpc_id=Long.parseLong(request.getParameter("hpcId1"));
			if (request.getParameter("current") != null) {
				page.setCurrent(Integer.parseInt(request.getParameter("current")));
			} else {
				page.setCurrent(1);
			}
			page.setPageSize(12);
			int count = ihpb.productByParentCategory(hpc_id);
			page.setTotalSize(count);
			page.setPageType(2);
			List<HwuaProduct> list = ihpb.getProductByPagep(page, hpc_id);
			session.setAttribute("hid", hpc_id);
			session.setAttribute("page", page);
			session.setAttribute("products", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(org.equals("list2")){
			hpc_id=Long.parseLong(request.getParameter("hpcId2"));
			if (request.getParameter("current") != null) {
				page.setCurrent(Integer.parseInt(request.getParameter("current")));
			} else {
				page.setCurrent(1);
			}
			page.setPageSize(12);
			int count = ihpb.productByChildCategory(hpc_id);
			page.setTotalSize(count);
			page.setPageType(2);
			List<HwuaProduct> list = ihpb.getProductByPagec(page, hpc_id);
			session.setAttribute("hid", hpc_id);
			session.setAttribute("page", page);
			session.setAttribute("products", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
