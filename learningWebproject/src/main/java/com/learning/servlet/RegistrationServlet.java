package com.learning.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration.do")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String course = request.getParameter("course");
		String[] courses = request.getParameterValues("course");
		String timing = request.getParameter("timing");
		System.out.println(name + " " + email + " " + phone + " " + gender);
		System.out.println(course);
		System.out.println(timing);
	//	Arrays.asList(courses).stream().forEach(System.out::println);
//send response to browser
		PrintWriter writer = response.getWriter();
		String message = "<html><body><ul>" + "<li>" + name + "</li>" + "<li>" + email + "</li>" + "<li>" + phone
				+ "</li>" + "<li>" + gender + "</li>" + "<li>" + course + "</li>" + "<li>" + timing + "</li>"
				+ "</ul></body></html>";
		writer.write(message);
		

	}

}
