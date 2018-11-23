package com.hwua.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.bean.HwuaUser;
import com.hwua.biz.IHwuaUserBiz;
import com.hwua.biz.impl.IHwuaUserBizImpl;

/**
 * Servlet implementation class RetrievePwdServlet
 */
@WebServlet("/RetrievePwdServlet")
public class RetrievePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RetrievePwdServlet() {
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
		IHwuaUserBiz ihub = new IHwuaUserBizImpl();
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String org = request.getParameter("org");
		if (org.equals("ret")) {
			String userName = request.getParameter("userName");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			HwuaUser user = ihub.fingUser(userName, email, mobile);
			if (user.getHu_user_name() == null) {
				pw.println("<script>alert('信息输入有误，请重新输入！');location.href='retrieve_password.jsp'</script>");
			} else {
				session.setAttribute("user", user);
				response.sendRedirect("modify-password.jsp");
			}
		}else if(org.equals("mod")){
			String userName = request.getParameter("userName");
			String pwd=request.getParameter("passWord");
			HwuaUser user=ihub.findUserByName(userName);
			user.setHu_password(pwd);
			int row=ihub.updateUser(user);
			if(row>0){
				pw.println("<script>alert('密码修改成功！');location.href='login.jsp'</script>");
			}else {
				session.setAttribute("user", user);
				pw.println("<script>alert('密码修改失败');location.href='modify-password.jsp'</script");
			}
		}

	}

}
