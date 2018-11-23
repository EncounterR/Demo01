package com.hwua.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.hwua.bean.HwuaProduct;
import com.hwua.bean.HwuaUser;
import com.hwua.biz.IHwuaUserBiz;
import com.hwua.biz.impl.IHwuaProductBizImpl;
import com.hwua.biz.impl.IHwuaUserBizImpl;

/**
 * Servlet implementation class HwuaUserServlet
 */
@WebServlet("/HwuaUserServlet")
public class HwuaUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HwuaUserServlet() {
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
		IHwuaUserBiz ihub = new IHwuaUserBizImpl();
		if (org == null) {
			org = "index";
		}
		if (org.equals("index")) {
			response.sendRedirect("index.jsp");
		} else if (org.equals("login")) {
			String username = request.getParameter("userName");
			String upwd = request.getParameter("passWord");
			HwuaUser user = ihub.doLogin(username, upwd);
			if (user.getHu_user_name() != null) {
				session.setAttribute("user", user);
				// 遍历cookie 找出最近浏览商品的pID记录
				Cookie[] cookies = request.getCookies();
				List<Cookie> cookieList = null;
				if (cookies != null && cookies.length > 0) {// 取出用户的cookie
					cookieList = new ArrayList<>();
					for (Cookie cookie : cookies) {
						if (cookie.getName().startsWith("" + user.getHu_user_id())) {
							cookieList.add(cookie);
							if (cookieList.size() > 5) {
								cookieList.remove(0);
							}
						}
					}
					if (cookieList.size() > 0) {// 存在当前用户的cookie
						List<HwuaProduct> viewedProduct = new ArrayList<HwuaProduct>();

						for (Cookie cookie : cookieList) {
							HwuaProduct product = new IHwuaProductBizImpl()
									.findProductById(Long.parseLong(cookie.getValue()));
							viewedProduct.add(product);
						}
						session.setAttribute("viewedProduct", viewedProduct);
					}
					pw.println("<script>location.href='HwuaUserServlet?org=index'</script>");
				}
			}else {
				pw.println("<script>alert('用户或密码错误');location.href='login.jsp'</script>");

			}
			} else if (org.equals("reg")) {
				String username1 = request.getParameter("userName");
				String nickname=request.getParameter("nickName");
				String pwd = request.getParameter("passWord");
				int sex = Integer.parseInt(request.getParameter("sex"));
				String birthday = request.getParameter("birthday");
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				try {
					date = dateFormat.parse(birthday);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String identity = request.getParameter("identity");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				String address = request.getParameter("address");
				int status = 1;
				HwuaUser user1 = new HwuaUser(username1, pwd, sex, date, identity, email, mobile, address, status,nickname);
				int row = ihub.register(user1);
				if (row > 0) {
					response.sendRedirect("reg-result.jsp");
				} else {
					response.sendRedirect("UserServlet?org=reg");
				}
			} else if (org.equals("checkName")) {
				String name = request.getParameter("userName");
				long id = ihub.checkName(name);
				if (id > 0) {
					pw.print(1);
				} else {
					pw.print(2);
				}
				pw.close();
			} else if (org.equals("checkEmail")) {
				String email = request.getParameter("email");
				long id = ihub.checkEmail(email);
				if (id > 0) {
					pw.print(1);
				} else {
					pw.print(2);
				}
				pw.close();
			}else if(org.equals("CheckNickname")){
				String nickName=request.getParameter("nickName");
				long id = ihub.findUserByNickName(nickName);
				if (id > 0) {
					pw.print(1);
				} else {
					pw.print(2);
				}
			}
		}
	}

