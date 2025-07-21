package com.session.upload;

import java.io.*;
import java.net.URLEncoder;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/download.do")
public class DownloadServlet extends HttpServlet {

    // Change this to your actual absolute directory where files are stored
    private static final String FILE_DIR = "C:\\image";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("filename");

        if (fileName == null || fileName.trim().isEmpty()) {
            response.setContentType("text/html");
            response.getWriter().println("<h3>Filename parameter is missing.</h3>");
            return;
        }

        // Secure filename to avoid path traversal attacks
        fileName = new File(fileName).getName();

        File file = new File(FILE_DIR, fileName);

        if (!file.exists() || file.isDirectory()) {
            response.setContentType("text/html");
            response.getWriter().println("<h3>File not found: " + file.getAbsolutePath() + "</h3>");
            return;
        }

        String mimeType = getServletContext().getMimeType(file.getAbsolutePath());
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }

        response.setContentType(mimeType);
        response.setContentLengthLong(file.length());

        String encodedFileName = URLEncoder.encode(file.getName(), "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedFileName + "\"");

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream())) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
