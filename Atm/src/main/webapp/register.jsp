<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ATM Registration</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #ffecd2, #fcb69f);
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
        input[type=text] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 15px 0;
            border: 1px solid #ccc;
            border-radius: 8px;
        }
        input[type=submit] {
            width: 100%;
            padding: 10px;
            background: #ff7e5f;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type=submit]:hover {
            background: #feb47b;
        }
        a {
            display: block;
            text-align: center;
            margin-top: 15px;
            color: #ff7e5f;
            text-decoration: none;
            font-weight: bold;
        }
        a:hover {
            color: #feb47b;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Register New Account</h2>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="register"/>
        Name: <input type="text" name="name" required/><br/>
        <input type="submit" value="Create Account"/>
    </form>
    <a href="login.jsp">Already have an account? Login</a>
</div>
</body>
</html>
