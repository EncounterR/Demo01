package com.hwua.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hwua.bean.HwuaComment;
import com.hwua.bean.HwuaProduct;
import com.hwua.bean.HwuaUser;
import com.hwua.biz.IHwuaCommentBiz;
import com.hwua.biz.IHwuaProductBiz;
import com.hwua.biz.IHwuaUserBiz;
import com.hwua.biz.impl.CommentBizImpl;
import com.hwua.biz.impl.IHwuaProductBizImpl;
import com.hwua.biz.impl.IHwuaUserBizImpl;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
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
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		String org=request.getParameter("org");
		IHwuaCommentBiz ihcb=new CommentBizImpl();
		IHwuaUserBiz ihub=new IHwuaUserBizImpl();
		IHwuaProductBiz ihpb = new IHwuaProductBizImpl();
		HwuaUser user=(HwuaUser)request.getSession().getAttribute("user");
		HwuaUser user1=ihub.findUserByName(user.getHu_user_name());
		if(org.equals("list")){
			System.out.println(user1.getHu_nick_name());
			List<HwuaComment> list=ihcb.getallCommentsByUserId(user1.getHu_nick_name());
			session.setAttribute("comments", list);
			response.sendRedirect("guestbook.jsp");
		}else if(org.equals("add")){
			String nickName=user1.getHu_nick_name();
			long pid=Long.parseLong(request.getParameter("pid"));
			String title=request.getParameter("guestTitle");
			String content=request.getParameter("guestContent");
			Date date=new Date();
			HwuaComment comment=new HwuaComment(nickName,date,content,pid);
			int row=ihcb.addComment(comment);
			if (row > 0) {
				pw.println("<script>alert('评论成功');</script>");
				HwuaProduct prodouct = ihpb.findProductById(pid);
				List<HwuaComment> list=ihcb.getAllCommentsByProdctId(pid);
				session.setAttribute("comments", list);
				session.setAttribute("prodouct", prodouct);
				response.sendRedirect("product_view.jsp");
			} else {
				pw.println("<script>alert('评论失败');location.href='comment.jsp'</script>");
			}
		}
	}

}
