package com.session.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/addToCart.do")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// Accessing the existing session object
		HttpSession session = request.getSession(false);
		if(session==null) {
			request.setAttribute("message", "session is destroyed");
		}else {
			String book = request.getParameter("bookName");
			session.setAttribute(book, book);
			request.setAttribute("added", book +"book is added to cart");
		}
		request.getRequestDispatcher("showBooks.jsp").forward(request, response);
	}

}
