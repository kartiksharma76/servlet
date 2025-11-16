<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ATM Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #4facfe, #00f2fe);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background: white;
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
            width: 350px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        input[type=text], input[type=password] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 15px 0;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        input[type=submit] {
            width: 100%;
            padding: 10px;
            background: #4facfe;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type=submit]:hover {
            background: #00f2fe;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 15px;
            color: #4facfe;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover {
            color: #00f2fe;
        }
        .msg {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Login</h2>
    <c:if test="${not empty msg}">
        <p class="msg">${msg}</p>
    </c:if>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="login"/>
        Account Number: <input type="text" name="account_no" required/><br/>
        PIN: <input type="password" name="pin" required/><br/>
        <input type="submit" value="Login"/>
    </form>
    <a href="register.jsp">Don't have an account? Register</a>
</div>
</body>
</html>
