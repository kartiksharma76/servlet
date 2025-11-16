<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("enrollment") == null) {
        response.sendRedirect("../login.jsp?error=Please login first");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
    <style>
        body { font-family: Arial; background: #f5f7fa; padding: 30px; }
        h2 { color: #333; }
        .menu { margin: 30px 0; }
        .menu a { 
            display: inline-block; 
            margin: 10px; 
            padding: 15px 30px; 
            background: #007bff; 
            color: white; 
            text-decoration: none; 
            border-radius: 5px; 
        }
        .menu a:hover { background: #0056b3; }
        .logout { background: #dc3545; }
        .logout:hover { background: #c82333; }
    </style>
</head>
<body>
    <h2>Welcome, <%= session.getAttribute("enrollment") %>!</h2>
    
    <div class="menu">
        <a href="room-allocation.jsp">🏠 Room Allocation</a>
        <a href="feedback.jsp">🗣 Feedback</a>
        <a href="complain.jsp">📣 Lodge Complaint</a>
        <a href="water-monitoring.jsp">🚰 Water Monitoring</a>
        <a href="${pageContext.request.contextPath}/LogoutServlet" class="logout">🚪 Logout</a>
    </div>
</body>
</html>