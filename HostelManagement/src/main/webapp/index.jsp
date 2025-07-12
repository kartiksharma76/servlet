
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>🔐 Login</title></head>
<body>
    <h2>Student Login</h2>
    <form action="portal/login" method="post">
        <input type="text" name="enrollment" required placeholder="Enrollment No"><br>
        <input type="password" name="password" required placeholder="Password"><br>
        <input type="submit" value="Login">
    </form>

    <!-- ✅ Success message and name after registration -->
    <%
        String message = request.getParameter("message");
        String registeredName = (String) session.getAttribute("registeredName");

        if (message != null) {
    %>
        <p style="color:green;"><%= message %></p>
        <% if (registeredName != null) { %>
            <p>Welcome, <%= registeredName %>! 🎉</p>
        <% } %>
    <%
        }
    %>

    <!-- Link to registration -->
    <hr>
    <p>
        📝 New user?
        <a href="portal/newUser">Register here</a>
    </p>
</body>
</html>
