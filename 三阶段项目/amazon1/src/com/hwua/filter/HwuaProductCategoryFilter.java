package com.hwua.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hwua.bean.HwuaProductCategory;
import com.hwua.biz.IHwuaProductCategoryBiz;
import com.hwua.biz.impl.IHwuaProductCategoryBizImpl;

/**
 * Servlet Filter implementation class HwuaProductCategoryFilter
 */
@WebFilter("/index.jsp")
public class HwuaProductCategoryFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public HwuaProductCategoryFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		IHwuaProductCategoryBiz ihpcb = new IHwuaProductCategoryBizImpl();
		List<HwuaProductCategory> list = ihpcb.getAll();
		session.setAttribute("list", list);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
