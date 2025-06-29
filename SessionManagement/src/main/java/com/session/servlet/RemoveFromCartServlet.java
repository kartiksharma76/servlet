package com.session.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class RemoveFromCartServlet
 */
@WebServlet("/removeFromCart.do")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session==null) {
			request.setAttribute("message", "session is destroyed");
			request.getRequestDispatcher("showBooks.jsp").forward(request, response);
		}else {
			String bookName=request.getParameter("bookName");
			List<String> javaBooklist  = (List<String>) session.getAttribute("cart");
			javaBooklist.remove(bookName);
			session.setAttribute("cart", javaBooklist);
		}
		request.getRequestDispatcher("showCart.jsp").forward(request, response);
	}

}
