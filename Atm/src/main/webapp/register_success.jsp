<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Created</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #43e97b, #38f9d7);
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
            width: 400px;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        b {
            color: #38f9d7;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #43e97b;
            font-weight: bold;
        }
        a:hover {
            color: #38f9d7;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Registration Successful!</h2>
    <p>Your Account Number: <b>${account_no}</b></p>
    <p>Your PIN: <b>${pin}</b></p>
    <p>Note: Please save your PIN securely. You will need it to login.</p>
    <a href="login.jsp">Go to Login</a>
</div>
</body>
</html>
