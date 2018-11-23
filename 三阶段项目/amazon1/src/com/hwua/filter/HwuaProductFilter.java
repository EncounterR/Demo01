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

import com.hwua.bean.HwuaProduct;
import com.hwua.bean.Page;
import com.hwua.biz.IHwuaProductBiz;
import com.hwua.biz.impl.IHwuaProductBizImpl;

/**
 * Servlet Filter implementation class HwuaProductFilter
 */
@WebFilter("/index.jsp")
public class HwuaProductFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HwuaProductFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		IHwuaProductBiz ihpz=new IHwuaProductBizImpl();
		Page page = new Page();
		if (request.getParameter("current") != null) {
			page.setCurrent(Integer.parseInt(request.getParameter("current")));
		} else {
			page.setCurrent(1);
		}
		page.setPageSize(12);
		int count = ihpz.count();
		page.setTotalSize(count);
		page.setPageType(1);
		List<HwuaProduct> list =ihpz.findProductByPage(page);
		session.setAttribute("products", list);
		session.setAttribute("page", page);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
