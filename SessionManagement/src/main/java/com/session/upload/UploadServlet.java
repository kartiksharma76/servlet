package com.session.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 * fileSizeThreshold:Max size of each file
 */
@WebServlet("/upload.do")
@MultipartConfig(location ="C:\\image",fileSizeThreshold = 1024*1024*10,maxFileSize = 1024*1024*50)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //getParts():related to uploaded files or images
     Collection<Part> parts = request.getParts();
     parts.forEach(part->{
    	 String name = part.getName();
    	 System.out.println("Name "+name);
    	 Collection<String> headerNames = part.getHeaderNames();
    	 headerNames.forEach(headerName->{
    		 String header = part.getHeader(headerName);
    		 System.out.println("header "+header);
    	 });
    	 String fileInformation = part.getHeader("content-disposition");
    	 System.out.println("File information "+fileInformation);
    	 String contentType = part.getContentType();
    	 System.out.println("SubmittedFileName "+part.getSubmittedFileName());
    	
    	 String[] fileNames = fileInformation.split("\"");
    	String fileName= fileNames[fileNames.length-1];
    	System.out.println("file size "+part.getSize());
    	try {
			part.write(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
     } );
    
     
    PrintWriter writer = response.getWriter();
    writer.write("<h1>File uploaded to C:\\image</h1>");
	}

}