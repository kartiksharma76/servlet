<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>ATM - Withdraw</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .withdraw-container {
            background: rgba(255, 255, 255, 0.95);
            border-radius: 20px;
            padding: 40px 50px;
            box-shadow: 0 8px 25px rgba(0, 0, 0, 0.3);
            text-align: center;
            width: 400px;
            animation: fadeIn 0.8s ease-in-out;
        }
        h2 {
            color: #2c3e50;
            margin-bottom: 20px;
            font-size: 28px;
        }
        .error, .msg {
            font-size: 16px;
            font-weight: bold;
            margin-bottom: 15px;
        }
        .error {
            color: #e74c3c;
        }
        .msg {
            color: #27ae60;
        }
        input[type="number"] {
            width: 85%;
            padding: 10px;
            margin: 10px 0;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 8px;
            outline: none;
            transition: border-color 0.3s;
        }
        input:focus {
            border-color: #5b86e5;
        }
        button {
            background: linear-gradient(90deg, #36d1dc, #5b86e5);
            color: white;
            border: none;
            padding: 10px 25px;
            border-radius: 10px;
            font-size: 16px;
            margin-top: 15px;
            cursor: pointer;
            transition: 0.3s;
        }
        button:hover {
            background: linear-gradient(90deg, #5b86e5, #36d1dc);
            transform: scale(1.05);
        }
        a {
            text-decoration: none;
            color: #2980b9;
            font-weight: 500;
            transition: 0.3s;
        }
        a:hover {
            color: #1f6391;
        }
        .atm-logo {
            font-size: 40px;
            color: #5b86e5;
            margin-bottom: 10px;
        }
        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(-10px); }
            to { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>
<div class="withdraw-container">
    <div class="atm-logo">🏧</div>
    <h2>Withdraw Funds</h2>

    <% if (request.getAttribute("error") != null) { %>
        <p class="error"><%= request.getAttribute("error") %></p>
    <% } %>

    <% if (request.getAttribute("msg") != null) { %>
        <p class="msg"><%= request.getAttribute("msg") %></p>
    <% } %>

    <form method="post" action="withdraw">
        <input type="number" step="0.01" name="amount" placeholder="Enter Amount to Withdraw" required /><br>
        <button type="submit">Withdraw</button>
    </form>

    <p style="margin-top: 20px;">
        <a href="dashboard">← Back to Dashboard</a>
    </p>
</div>
</body>
</html>
