<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Smart Hostel Dashboard</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #d0f0c0, #f1f1f1);
            margin: 0;
            padding: 0;
        }
        .container {
            padding: 60px;
            text-align: center;
        }
        h2 {
            color: #004d40;
            margin-bottom: 40px;
            font-size: 32px;
        }
        ul {
            list-style: none;
            padding: 0;
            margin: 0 auto;
            display: inline-block;
        }
        li {
            margin: 20px 0;
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
        <h2>🏨 Welcome to <span style="color:#00695c;">Smart Hostel System</span></h2>
        <ul>
            <li><a href="hostel.jsp">🛏️ Room Allocation & 🍽️ Food Feedback</a></li>
            <li><a href="water_monitor.jsp">🚰 Water Supply Monitoring</a></li>
        </ul>
    </div>
</body>
</html>
