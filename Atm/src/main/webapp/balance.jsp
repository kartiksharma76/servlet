<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>ATM - Balance</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #2980b9, #6dd5fa, #ffffff);
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            background-color: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
            width: 350px;
            text-align: center;
            animation: fadeIn 0.8s ease-in;
        }
        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
            color: #34495e;
        }
        .balance {
            font-size: 24px;
            font-weight: bold;
            color: #27ae60;
            margin-top: 10px;
        }
        .error {
            color: #e74c3c;
            font-weight: bold;
        }
        a {
            display: inline-block;
            margin-top: 25px;
            text-decoration: none;
            background-color: #3498db;
            color: white;
            padding: 10px 20px;
            border-radius: 8px;
            transition: 0.3s;
        }
        a:hover {
            background-color: #2980b9;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: scale(0.95); }
            to { opacity: 1; transform: scale(1); }
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Your Account Balance</h2>
    <%
        if (request.getAttribute("error") != null) {
    %>
        <p class="error"><%= request.getAttribute("error") %></p>
    <%
        } else {
    %>
        <p>Your Current Balance is:</p>
        <div class="balance">
            ₹<%= request.getAttribute("balance") != null ? request.getAttribute("balance") : "N/A" %>
        </div>
    <%
        }
    %>
    <a href="dashboard.jsp">Back to Dashboard</a>
</div>
</body>
</html>
