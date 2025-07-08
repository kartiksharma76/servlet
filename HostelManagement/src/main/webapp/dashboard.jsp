<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("enrollment") == null) {
        response.sendRedirect("../index.jsp?error=Please login first");
        return;
    }
%>
<html>
<head><title>Dashboard</title></head>
<body>
    <h2>Welcome, <%= session.getAttribute("enrollment") %></h2>
    <a href="room-allocation.jsp">🏠 Room Allocation</a>
    <a href="feedback.jsp">🗣 Feedback</a>
    <a href="${pageContext.request.contextPath}/LogoutServlet">Logout</a>
</body>
</html>
