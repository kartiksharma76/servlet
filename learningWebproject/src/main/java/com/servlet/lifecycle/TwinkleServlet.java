package com.servlet.lifecycle;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TwinkleServlet
 */
@WebServlet(urlPatterns = { "/twinkle.do" }, loadOnStartup = 1,initParams = {
		@WebInitParam(name="email",value="kartiksharma768976"),
		@WebInitParam(name="phone",value="7828201241"),
		@WebInitParam(name="college",value="SIRT")
})
public class TwinkleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private ServletConfig cfg;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TwinkleServlet() {
		System.out.println("Twinke Servlet Constructor");
		// TODO Auto-generated constructor stub
	}
	public void init(ServletConfig cfg) {
		this.cfg=cfg;
		String email = cfg.getInitParameter("email");
		String phone = cfg.getInitParameter("phone");
		String college = cfg.getInitParameter("college");
		System.out.println(email+" "+phone+" "+college);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TwinkleServlet Service Started");
		System.out.println("TwinkleServlet service started");
		ServletContext servletContext = request.getServletContext();
		String website = servletContext.getInitParameter("website");
		System.out.println(website);
		String email = cfg.getInitParameter("email");
		String phone = cfg.getInitParameter("phone");
		String college = cfg.getInitParameter("college");
		System.out.println(email+" "+phone+" "+college);
	}

}
