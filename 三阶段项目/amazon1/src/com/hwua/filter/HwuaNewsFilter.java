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

import com.hwua.bean.HwuaNews;
import com.hwua.biz.IHwuaNewsBiz;
import com.hwua.biz.impl.IHwuaNewsBizImpl;

/**
 * Servlet Filter implementation class HwuaNewsFilter
 */
@WebFilter("/index.jsp")
public class HwuaNewsFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HwuaNewsFilter() {
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
		IHwuaNewsBiz ihnb=new IHwuaNewsBizImpl();
		List<HwuaNews> list=ihnb.getNews(5);
		session.setAttribute("news", list);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
