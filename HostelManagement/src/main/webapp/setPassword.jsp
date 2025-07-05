<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>🔐 Set Password</title>
    <style>
        body {
            font-family: Arial;
            background: #f3e5f5;
        }
        .box {
            width: 400px;
            background: white;
            padding: 30px;
            margin: auto;
            margin-top: 100px;
            border-radius: 10px;
            box-shadow: 0 0 15px #7b1fa2;
        }
        h2 {
            text-align: center;
            color: #7b1fa2;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 15px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            background: #7b1fa2;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }
        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="box">
        <h2>🔐 Set Your Password</h2>
        <form action="SetPasswordServlet" method="post">
            <label>Enrollment No:</label>
            <input type="text" name="enrollment" value="<%= request.getAttribute("enrollment") %>" readonly>

            <label>Password:</label>
            <input type="password" name="password" required>

            <label>Confirm Password:</label>
            <input type="password" name="confirm_password" required>

            <input type="submit" value="Set Password">
        </form>

        <% String error = request.getParameter("error");
           String success = (String) request.getAttribute("success");
           if (error != null) { %>
            <div class="error"><%= error %></div>
        <% } else if (success != null) { %>
            <div style="color:green; text-align:center;"><%= success %></div>
        <% } %>
    </div>
</body>
</html>
