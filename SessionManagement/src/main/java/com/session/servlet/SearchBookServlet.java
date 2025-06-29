package com.session.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/searchBook.do")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> javaBooklist = new ArrayList<>(Arrays.asList("java", "jdbc", "SpringFramework", "Servlet"));
	     String category = request.getParameter("category");
     
	  if(category!=null && "java".equalsIgnoreCase(category)) {
		  HttpSession session = request.getSession();
		  session.setAttribute("books", javaBooklist);
		  
	  }else {
		  request.setAttribute("message", "No books foond with category"+category);
		  
	  }
	  request.getRequestDispatcher("showBooks.jsp").forward(request, response);
	}

}
