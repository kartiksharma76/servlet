<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
    <title>Available Downloads</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: "Segoe UI", Tahoma, Geneva, Verdana, sans-serif;
            background: #e9f1f7;
            padding: 30px;
        }

        h1 {
            text-align: center;
            color: #222;
            margin-bottom: 20px;
        }

        .container {
            max-width: 700px;
            margin: auto;
            background: #fff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 6px 12px rgba(0,0,0,0.15);
        }

        .file-entry {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: #f5faff;
            padding: 12px 20px;
            margin: 10px 0;
            border-radius: 8px;
            transition: background 0.2s ease;
        }

        .file-entry:hover {
            background: #e0f0ff;
        }

        .file-name {
            color: #333;
            font-size: 16px;
            font-weight: 500;
        }

        .download-link {
            background: #28a745;
            color: white;
            text-decoration: none;
            padding: 6px 12px;
            border-radius: 4px;
            font-size: 14px;
            transition: background-color 0.2s ease;
        }

        .download-link:hover {
            background: #218838;
        }

        .no-files {
            text-align: center;
            color: #d9534f;
            font-size: 18px;
            padding: 20px;
        }
    </style>
</head>
<body>

<h1>Available Downloads from C:\image</h1>
<div class="container">
    <c:choose>
        <c:when test="${empty files or fn:length(files) == 0}">
            <p class="no-files">No files available for download.</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="name" items="${files}">
                <div class="file-entry">
                    <span class="file-name">${name}</span>
                    <a class="download-link" href="download.do?filename=${fn:escapeXml(name)}">Download</a>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
