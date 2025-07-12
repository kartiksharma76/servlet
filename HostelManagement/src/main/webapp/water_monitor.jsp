
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("enrollment") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>🚰 Water Supply Monitoring</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #e1f5fe, #fce4ec);
            padding: 30px;
            margin: 0;
        }

        .container {
            max-width: 650px;
            margin: auto;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 14px;
            box-shadow: 0 0 25px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #0288d1;
            font-size: 24px;
            margin-bottom: 30px;
        }

        label {
            font-weight: 600;
            display: block;
            margin-top: 20px;
            color: #333;
        }

        input[type="text"],
        input[type="time"],
        select {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
        }

        select {
            background-color: #f9f9f9;
        }

        input[type="submit"] {
            background-color: #0288d1;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 30px;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #01579b;
        }

        .message {
            text-align: center;
            color: green;
            font-weight: bold;
            margin-top: 20px;
        }

    </style>
</head>
<body>
    <div class="container">
        <h2>🚰 Water Supply Monitoring</h2>
        <form action="monitorWater.do" method="post">
            <label for="source">Water Source:</label>
            <input type="text" name="source" id="source" placeholder="Tank 1, Borewell..." required>

            <label for="supplyTime">Supply Time:</label>
            <input type="time" name="supplyTime" id="supplyTime" required>

            <label for="status">Status:</label>
            <select name="status" id="status" required>
                <option value="">-- Select Status --</option>
                <option value="Available">✅ Available</option>
                <option value="Not Available">❌ Not Available</option>
            </select>

            <input type="submit" value="Log Supply">
        </form>

        <% String message = (String) request.getAttribute("message");
           if (message != null) { %>
            <div class="message"><%= message %></div>
        <% } %>
    </div>
</body>
</html>
