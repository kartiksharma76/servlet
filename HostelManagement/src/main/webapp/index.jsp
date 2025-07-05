<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>🏨 Smart Hostel Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #f0f8ff, #d9f5f2);
            margin: 0; padding: 0;
        }
        .container {
            padding: 60px;
            text-align: center;
        }
        h2 {
            color: #00695c;
            font-size: 30px;
            margin-bottom: 40px;
        }
        ul {
            list-style: none;
            padding: 0;
            margin: 0 auto;
            display: inline-block;
        }
        li {
            margin: 15px 0;
        }
        a {
            display: inline-block;
            width: 300px;
            padding: 15px 20px;
            background: #00796b;
            color: white;
            text-decoration: none;
            border-radius: 10px;
            font-size: 18px;
            transition: background 0.3s ease;
        }
        a:hover {
            background: #004d40;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>🏨 Welcome to Smart Hostel Management</h2>
        <ul>
            <li><a href="registration.jsp">📝 Student Registration</a></li>
            <li><a href="setPassword.jsp">🔐 Set Password</a></li>
            <li><a href="login.jsp">👤 Login</a></li>
            <li><a href="hostel.jsp">🛏️ Room Allocation & 🍽️ Food Feedback</a></li>
            <li><a href="water_monitor.jsp">🚰 Water Supply Monitoring</a></li>
            <li><a href="LogoutServlet">🚪 Logout</a></li>
        </ul>
    </div>
</body>
</html>
