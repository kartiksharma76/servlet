package com.servlet.lifecycle;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class PrinceFilter
 */
@WebFilter(urlPatterns = {"/twinkle.do","/kartik.do"})
public class PrinceFilter extends HttpFilter implements Filter {

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public PrinceFilter() {
		System.out.println("PrinceFilter constructor");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("PrinceFilter Distroyed");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("PrinceFilter preprocessing");
		chain.doFilter(request, response);
		System.out.println("PrinceFilter postprocessing");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("princeFilter Initilize");
	}

}
