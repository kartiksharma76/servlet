package com.session.upload;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/file-list")
public class FileListServlet extends HttpServlet {

    private static final String FILE_DIR = "C:\\image";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        File dir = new File(FILE_DIR);

        // DEBUG OUTPUT to console
        System.out.println("Looking in: " + dir.getAbsolutePath());
        if (!dir.exists()) {
            System.out.println("Directory does not exist.");
        }

        List<String> fileNames = new ArrayList<>();

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        fileNames.add(file.getName());
                    }
                }
            }
        }

        // Debug output
        System.out.println("Files found: " + fileNames);

        request.setAttribute("files", fileNames);
        RequestDispatcher rd = request.getRequestDispatcher("download.jsp");
        rd.forward(request, response);
    }
}
