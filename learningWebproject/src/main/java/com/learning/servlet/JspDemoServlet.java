package com.learning.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JspDemoServlet
 */
@WebServlet("/test.do")
public class JspDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JspDemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		if(name!=null) {
			request.setAttribute("username", name);
			List<String>list=new ArrayList<>();
			list.add("Kartik");
			list.add("Prince");
			list.add("Twinkle");
			list.add("Kirtan");
			list.add("Aman");
			request.setAttribute("AL", list);
			Map<Integer, String>map= new HashMap<>();
			map.put(1, "Kartik");
			map.put(2, "Prince");
			map.put(3, "Twinkle");
			map.put(4, "Kirtan");
			map.put(5, "Aman");
			request.setAttribute("map", map);
			
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}
	}

}
