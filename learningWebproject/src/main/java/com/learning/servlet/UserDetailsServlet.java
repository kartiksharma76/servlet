package com.learning.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbcUtil.RegisteredUser;
import jdbcUtil.Student;

/**
 * Servlet implementation class UserDetailsServlet
 */
@WebServlet("/user.do")
public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("UserDetailsServlet.service() method is called");
		List<Student> stuList = RegisteredUser.getAll();
		request.setAttribute("stu", stuList);
	//	request.getRequestDispatcher("mytable.jsp").forward(request, response);
		RequestDispatcher rd1 = request.getRequestDispatcher("/WEB-INF/header.jsp");
		rd1.include(request, response);
		RequestDispatcher rd2 = request.getRequestDispatcher("/WEB-INF/mytable.jsp");
		rd2.include(request, response);
		RequestDispatcher rd3 = request.getRequestDispatcher("/WEB-INF/footer.jsp");
		rd3.include(request, response);
	}

}
