package com.session.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShowCartServlet
 */
@WebServlet("/showCart.do")
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
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
			Enumeration<String> names = session.getAttributeNames();
			ArrayList<String> selectedList = Collections.list(names);
			selectedList.remove("cart");
			selectedList.remove("books");
			if(selectedList.size()==0) {
				request.setAttribute("message","no book selected");
			}else {
				session.setAttribute("cart", selectedList);
			}
			request.getRequestDispatcher("showCart.jsp").forward(request, response);
		}
	}

}
