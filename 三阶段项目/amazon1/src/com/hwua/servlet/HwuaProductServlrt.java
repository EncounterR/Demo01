package com.hwua.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.bean.HwuaCart;
import com.hwua.bean.HwuaComment;
import com.hwua.bean.HwuaOrder;
import com.hwua.bean.HwuaOrderDetail;
import com.hwua.bean.HwuaProduct;
import com.hwua.bean.HwuaUser;
import com.hwua.bean.Page;
import com.hwua.biz.IHwuaCartBiz;
import com.hwua.biz.IHwuaCommentBiz;
import com.hwua.biz.IHwuaOrderBiz;
import com.hwua.biz.IHwuaOrderDetailBiz;
import com.hwua.biz.IHwuaProductBiz;
import com.hwua.biz.IHwuaUserBiz;
import com.hwua.biz.impl.CartBizImpl;
import com.hwua.biz.impl.CommentBizImpl;
import com.hwua.biz.impl.IHwuaProductBizImpl;
import com.hwua.biz.impl.IHwuaUserBizImpl;
import com.hwua.biz.impl.OrderBizImpl;
import com.hwua.biz.impl.OrderDetailBizImpl;

/**
 * Servlet implementation class HwuaProductServlrt
 */
@WebServlet("/HwuaProductServlrt")
public class HwuaProductServlrt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HwuaProductServlrt() {
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
		PrintWriter pw = response.getWriter();
		IHwuaProductBiz ihpb = new IHwuaProductBizImpl();
		IHwuaCartBiz ihcb = new CartBizImpl();
		IHwuaOrderBiz ihob = new OrderBizImpl();
		IHwuaUserBiz ihub = new IHwuaUserBizImpl();
		IHwuaOrderDetailBiz idodb = new OrderDetailBizImpl();
		IHwuaCommentBiz icb = new CommentBizImpl();
		if (org == null) {
			org = "list";
		}
		if (org.equals("list")) {
			Page page = new Page();
			if (request.getParameter("current") != null) {
				page.setCurrent(Integer.parseInt(request.getParameter("current")));
			} else {
				page.setCurrent(1);
			}
			page.setPageSize(12);
			int count = ihpb.count();
			page.setTotalSize(count);
			page.setPageType(1);
			System.out.println("asdasd"+page.getPageType());
			List<HwuaProduct> list = ihpb.findProductByPage(page);
			session.setAttribute("products", list);
			session.setAttribute("page", page);
			//session.setAttribute("pageType", 1);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			//response.sendRedirect("index.jsp");
		} else if (org.equals("det")) {
			String pid1 = request.getParameter("pid");
			long pid = 0;
			HwuaProduct prodouct = null;
			HwuaUser user = (HwuaUser) session.getAttribute("user");
			if (user != null) {
				Cookie cookieViewed = new Cookie("" + user.getHu_user_id() + pid1, pid1);
				pid = Long.parseLong(pid1);
				prodouct = ihpb.findProductById(pid);
				cookieViewed.setMaxAge(60 * 60 * 24 * 7);
				response.addCookie(cookieViewed);
				List<Cookie> cookieList = new ArrayList<>();
				Cookie[] cookies = request.getCookies();
				if (cookies != null && cookies.length > 0) {// 获取浏览器所有的cookie
					for (Cookie cookie : cookies) {
						if (cookie.getName().startsWith("" + user.getHu_user_id())) {
							cookieList.add(cookie);// 遍历cookie 把当前用户的cookie取出
													// 用List<Cookie>保存
							if (cookieList.size() > 5) {
								cookie.setMaxAge(0);
								;// 当前用户的cookie超过了5个，删除最早的那个
							}
						}
					}
				}
			} else {
				pid = Long.parseLong(pid1);
				prodouct = ihpb.findProductById(pid);
			}
			List<HwuaComment> list = icb.getAllCommentsByProdctId(pid);
			session.setAttribute("comments", list);
			session.setAttribute("prodouct", prodouct);
			response.sendRedirect("product_view.jsp");
		} else if (org.equals("query")) {
			String qname = request.getParameter("qname");
			Page page1 = new Page();
			if (request.getParameter("current") != null) {
				page1.setCurrent(Integer.parseInt(request.getParameter("current")));
			} else {
				page1.setCurrent(1);
			}
			page1.setPageSize(12);
			int count = ihpb.countQueryProducts(qname);
			page1.setTotalSize(count);
			page1.setPageType(4);
			List<HwuaProduct> list = ihpb.queryProducts(qname, page1);
			session.setAttribute("products", list);
			session.setAttribute("qname",qname);
			session.setAttribute("page", page1);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else if (org.equals("toBuy")) {
			long pid = Long.parseLong(request.getParameter("pid"));
			int count = Integer.parseInt(request.getParameter("count"));
			HwuaProduct product = ihpb.findProductById(pid);
			double totalPrice = product.getHp_price() * count;
			HwuaUser user1 = (HwuaUser) session.getAttribute("user");
			HwuaUser user = ihub.findUserByName(user1.getHu_user_name());
			Date date = new Date();
			HwuaOrder order = new HwuaOrder(user.getHu_user_id(), user.getHu_user_name(), user.getHu_address(), date,
					totalPrice, 1, 1);
			int row = ihob.addOrder(order);
			if (row > 0) {
				HwuaOrder order1 = ihob.findHwuaOrderByUid(user.getHu_user_id());
				ihpb.changeStock(product.getHp_stock() - count, pid);
				session.setAttribute("order", order1);
				response.sendRedirect("shopping-result.jsp");
				HwuaOrderDetail detail = new HwuaOrderDetail(order1.getHo_id(), pid, count, totalPrice);
				int re = idodb.addOrderDetail(detail);
			} else {
				pw.println("<script>alert('刚刚网络出现一点小波动，购买失败！');");
				response.sendRedirect("product_view.jsp");
			}
		} else if (org.equals("addToCart")) {
			long pid = Long.parseLong(request.getParameter("pid"));
			int count = Integer.parseInt(request.getParameter("count"));
			HwuaProduct product = ihpb.findProductById(pid);
			HwuaUser user1 = (HwuaUser) session.getAttribute("user");
			HwuaUser user = ihub.findUserByName(user1.getHu_user_name());
			HwuaCart cart = new HwuaCart(pid, count, user.getHu_user_id());
			int row = ihcb.addToCart(cart);
			pw.print(row);
			pw.close();
		} else if (org.equals("shopping")) {
			HwuaUser user = (HwuaUser) session.getAttribute("user");
			List<HwuaCart> list = ihcb.usersCarts(user.getHu_user_id());
			session.setAttribute("carts", list);
			response.sendRedirect("shopping.jsp");
		} else if (org.equals("del")) {
			long id = Long.parseLong(request.getParameter("cid"));
			int row = ihcb.deleteCartById(id);
			pw.print(row);
			pw.close();
		} else if (org.equals("toComment")) {
			long pid = Long.parseLong(request.getParameter("pid"));
			HwuaProduct product = ihpb.findProductById(pid);
			session.setAttribute("product", product);
			response.sendRedirect("comment.jsp");
		}
	}

}
