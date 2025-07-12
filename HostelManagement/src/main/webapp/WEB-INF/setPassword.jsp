<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Set Password</title><style>/* styles omitted */</style></head>
<body>
    <div class="box">
        <h2>🔐 Set Your Password</h2>
        <form action="${pageContext.request.contextPath}/SetPasswordServlet" method="post">
            <input type="text" name="enrollment" value="<%= request.getParameter("enrollment") %>" readonly>
            <input type="password" name="password" placeholder="New Password" required>
            <input type="password" name="confirm_password" placeholder="Confirm Password" required>
            <input type="submit" value="Set Password">
        </form>
        <% String error = request.getParameter("error"); String success = (String) request.getAttribute("success");
           if (error != null) { %><div class="error"><%= error %></div><% } else if (success != null) { %>
            <div style="color:green; text-align:center;"><%= success %></div><% } %>
    </div>
</body>
</html>