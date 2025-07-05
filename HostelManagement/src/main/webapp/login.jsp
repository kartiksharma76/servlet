<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>🔐 Login</title>
    <style>
        body { font-family: Arial; background: #e0f7fa; }
        .box { max-width: 400px; margin: auto; background: white; padding: 20px; border-radius: 10px; margin-top: 100px; box-shadow: 0 0 10px #00838f; }
        h2 { text-align: center; color: #00838f; }
        input[type="text"], input[type="password"] {
            width: 100%; padding: 10px; margin: 10px 0; border-radius: 5px; border: 1px solid #ccc;
        }
        input[type="submit"] {
            background: #00838f; color: white; border: none; padding: 10px 20px; width: 100%; border-radius: 5px;
        }
        input[type="submit"]:hover { background: #006064; }
        .error { color: red; text-align: center; }
    </style>
</head>
<body>
    <div class="box">
        <h2>🔐 Student Login</h2>
        <form action="LoginServlet" method="post">
            <input type="text" name="enrollment" placeholder="Enrollment No" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="Login">
        </form>

        <% String error = request.getParameter("error");
           if (error != null) { %>
            <div class="error"><%= error %></div>
        <% } %>

        <div style="text-align:center; margin-top:15px;">
            <a href="registration.jsp">📝 New Student? Register Now</a>
        </div>
    </div>
</body>
</html>
