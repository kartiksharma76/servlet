<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>ATM - Deposit</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #43cea2, #185a9d);
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            background: rgba(255, 255, 255, 0.95);
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.2);
            width: 380px;
            text-align: center;
            animation: fadeIn 0.8s ease-in-out;
        }
        h2 {
            color: #2c3e50;
            margin-bottom: 25px;
            font-size: 26px;
        }
        p {
            font-size: 16px;
            margin: 10px 0;
        }
        .error {
            color: #e74c3c;
            font-weight: bold;
        }
        .msg {
            color: #27ae60;
            font-weight: bold;
        }
        input[type="number"] {
            width: 80%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 8px;
            outline: none;
            margin-bottom: 20px;
            transition: border-color 0.3s;
        }
        input[type="number"]:focus {
            border-color: #3498db;
        }
        button {
            background: linear-gradient(90deg, #00c6ff, #0072ff);
            color: white;
            padding: 10px 25px;
            font-size: 16px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            transition: 0.3s;
        }
        button:hover {
            background: linear-gradient(90deg, #0072ff, #00c6ff);
            transform: scale(1.05);
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
            from { opacity: 0; transform: translateY(-10px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>
<div class="container">
    <h2>💰 Deposit Money</h2>
    <% if (request.getAttribute("error") != null) { %>
        <p class="error"><%= request.getAttribute("error") %></p>
    <% } %>
    <% if (request.getAttribute("msg") != null) { %>
        <p class="msg"><%= request.getAttribute("msg") %></p>
    <% } %>

    <form method="post" action="deposit">
        <input type="number" step="0.01" name="amount" placeholder="Enter Amount" required /><br>
        <button type="submit">Deposit</button>
    </form>

    <a href="dashboard.jsp">⬅ Back to Dashboard</a>
</div>
</body>
</html>
