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

import com.hwua.bean.HwuaOrder;
import com.hwua.bean.HwuaOrderDetail;
import com.hwua.bean.HwuaUser;
import com.hwua.biz.IHwuaOrderBiz;
import com.hwua.biz.IHwuaOrderDetailBiz;
import com.hwua.biz.impl.OrderBizImpl;
import com.hwua.biz.impl.OrderDetailBizImpl;

/**
 * Servlet implementation class OrderDetallServlet
 */
@WebServlet("/OrderDetallServlet")
public class OrderDetallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		IHwuaOrderBiz ihob=new OrderBizImpl();
		IHwuaOrderDetailBiz ihodb=new OrderDetailBizImpl();
		PrintWriter pw=response.getWriter();
		String org=request.getParameter("org");
		HwuaUser user=(HwuaUser)request.getSession().getAttribute("user");
		if(org.equals("list")){
			List<HwuaOrder> list=ihob.searchAllOrder(user.getHu_user_id());
			session.setAttribute("orders", list);
			response.sendRedirect("orders_detall_view.jsp");
		}else if(org.equals("del")){
			long did=Long.parseLong(request.getParameter("did"));
			int row=ihodb.delDetailById(did);
			pw.print(row);
			pw.close();
		}else if(org.equals("dell")){
			long hid=Long.parseLong(request.getParameter("hid"));
			List<HwuaOrderDetail> list=ihodb.getOrderDetailByHoid(hid);
			session.setAttribute("details", list);
			response.sendRedirect("order_detail.jsp");
		}
	}

}
