package com.learning.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RedirectServlet
 */
@WebServlet("/RedirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Request headers
		Enumeration<String> headerNames = request.getHeaderNames();
	//	Iterator<String> asIterator = headerNames.asIterator();
		while(headerNames.hasMoreElements()) {
			String headername = headerNames.nextElement();
			System.out.println(headername+" "+request.getHeader(headername));
		}
		// Some other information from request
		System.out.println("locale "+request.getLocale()); 
		System.out.println("method "+request.getMethod());
		System.out.println("AuthType "+request.getAuthType());
		System.out.println("ContextPath "+request.getContextPath());
		System.out.println("content type "+request.getContentType());
		System.out.println("locale addr "+request.getLocalAddr());
		System.out.println("locale name "+request.getLocalName());
		System.out.println("localeport "+request.getLocalPort());
		//System.out.println("locale cookies "+request.getCookies());
		System.out.println(" protocol "+request.getProtocol());
		System.out.println("pathinfo "+request.getPathInfo());
		System.out.println("remotehost "+request.getRemoteHost());
		System.out.println("remoteadder "+request.getRemoteAddr());
		System.out.println("portremote "+request.getRemotePort());
		System.out.println("remoteuser "+request.getRemoteUser());
		System.out.println("requesturi "+request.getRequestURI());
		System.out.println("user principle "+request.getUserPrincipal());
		System.out.println("TrailerFields "+request.getTrailerFields());
		System.out.println("ServletContext "+request.getServletContext());
		System.out.println("About Cookies");
		Cookie[] cookies = request.getCookies();
		System.out.println(cookies.length);
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getComment());
			System.out.println(cookie.getDomain());
			System.out.println(cookie.getMaxAge());
			System.out.println(cookie.getName());
			System.out.println(cookie.getPath());
			System.out.println(cookie.getSecure());
			System.out.println(cookie.getValue());
			System.out.println(cookie.getVersion());
			
		}
		System.out.println("About Session*********");
		HttpSession session = request.getSession();
		System.out.println(session.getCreationTime());
		System.out.println(session.getId());
		System.out.println(session.getLastAccessedTime());
		System.out.println(session.getMaxInactiveInterval());
		System.out.println(session.isNew());
		System.out.println("servlet Context:");
		ServletContext servletContext = session.getServletContext();
		System.out.println(servletContext.getContextPath());
		System.out.println(servletContext.getEffectiveMajorVersion());
		System.out.println(servletContext.getEffectiveMinorVersion());
	//	System.out.println(servletContext.getMajorVersion());
		System.out.println(servletContext.getSessionTimeout());
		String url="https://www.google.com/";
		response.sendRedirect(url);
	}

}
