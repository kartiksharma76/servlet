<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>👤 Student Login</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #f1f8e9, #e0f7fa);
            margin: 0; padding: 0;
        }
        .container {
            max-width: 400px;
            margin: 100px auto;
            background-color: #ffffff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #00796b;
            margin-bottom: 25px;
            font-size: 24px;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #004d40;
        }
        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border-radius: 8px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            font-size: 14px;
        }
        input[type="submit"] {
            background-color: #00796b;
            color: #fff;
            border: none;
            margin-top: 25px;
            padding: 12px;
            font-size: 16px;
            border-radius: 8px;
            cursor: pointer;
            width: 100%;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #004d40;
        }
        .error {
            color: red;
            text-align: center;
            font-weight: bold;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>👤 Student Login</h2>
        <form action="LoginServlet" method="post">
            <label for="enrollment">Enrollment No:</label>
            <input type="text" name="enrollment" id="enrollment" required>

            <label for="password">Password:</label>
            <input type="password" name="password" id="password" required>

            <input type="submit" value="Login">
        </form>

        <% String error = request.getParameter("error");
           if (error != null) { %>
            <div class="error"><%= error %></div>
        <% } %>
    </div>
</body>
</html>
