<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Water Monitoring</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #e0f7fa, #ffffff);
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 500px;
            margin: 80px auto;
            background-color: #ffffff;
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #00796b;
            margin-bottom: 30px;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #004d40;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #00796b;
            color: #fff;
            padding: 12px;
            border: none;
            border-radius: 8px;
            width: 100%;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #004d40;
        }
        .message {
            text-align: center;
            color: green;
            margin-top: 20px;
            font-weight: bold;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 30px;
            font-size: 16px;
            text-decoration: none;
            color: #00796b;
        }
        .back-link:hover {
            text-decoration: underline;
            color: #004d40;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>🚰 Water Monitoring</h2>
        <form action="monitorWater.do" method="post">
            <label for="source">Source:</label>
            <input type="text" name="source" id="source" required>

            <label for="supplyTime">Time:</label>
            <input type="text" name="supplyTime" id="supplyTime" required>

            <label for="status">Status:</label>
            <input type="text" name="status" id="status" required>

            <input type="submit" value="Log Water Supply">
        </form>

        <% String wm = (String) request.getAttribute("waterMessage");
           if (wm != null) { %>
            <div class="message"><%= wm %></div>
        <% } %>

        <a class="back-link" href="index.jsp">🏠 Back to Dashboard</a>
    </div>
</body>
</html>
