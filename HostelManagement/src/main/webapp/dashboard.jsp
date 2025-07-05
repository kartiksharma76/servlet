<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>🏨 Smart Hostel Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 700px;
            margin: auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 0 20px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #1e88e5;
        }
        ul {
            list-style: none;
            padding: 0;
        }
        li {
            margin: 15px 0;
            text-align: center;
        }
        a {
            text-decoration: none;
            background-color: #1e88e5;
            color: white;
            padding: 12px 24px;
            border-radius: 8px;
            display: inline-block;
            font-size: 16px;
        }
        a:hover {
            background-color: #0d47a1;
        }
        p {
            text-align: center;
            color: green;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%
    if (session.getAttribute("enrollment") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    String name = (String) session.getAttribute("name");
%>
    <div class="container">
        <h2>🏨 Welcome to Our Smart Hostel Management 👋</h2>

        <% String message = (String) request.getAttribute("message");
           if (message != null) { %>
            <p><%= message %></p>
        <% } %>

        <ul>
            <li><a href="<%= request.getContextPath() %>/registration.jsp">📝 Student Registration</a></li>
            <li><a href="<%= request.getContextPath() %>/setPassword.jsp">🔐 Set Password</a></li>
            <li><a href="<%= request.getContextPath() %>/hostel.jsp">🛏️ Room Allocation & 🍽️ Food Feedback</a></li>
            <li><a href="<%= request.getContextPath() %>/water_monitor.jsp">🚰 Water Supply Monitoring</a></li>
            <li><a href="<%= request.getContextPath() %>/complaint.jsp">📣 Lodge a Complaint</a></li>
            <li><a href="LogoutServlet">🚪 Logout</a></li>
        </ul>
    </div>
</body>
</html>
