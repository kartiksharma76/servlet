<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hostel Services</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #e0f7fa, #ffffff);
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 60px auto;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.1);
        }
        h2 {
            color: #00796b;
            text-align: center;
            margin-bottom: 30px;
        }
        form {
            margin-bottom: 40px;
        }
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
            color: #004d40;
        }
        input[type="text"], input[type="date"], textarea {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            font-size: 14px;
        }
        textarea {
            resize: vertical;
            min-height: 80px;
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
            color: green;
            font-weight: bold;
            text-align: center;
            margin-top: 10px;
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
        <h2>🛏️ Room Allocation</h2>
        <form action="hostel.do" method="post">
            <input type="hidden" name="action" value="allocate">
            <label for="studentId">Student ID:</label>
            <input type="text" name="studentId" id="studentId" required>

            <label for="roomNumber">Room No:</label>
            <input type="text" name="roomNumber" id="roomNumber" required>

            <label for="allocationDate">Allocation Date:</label>
            <input type="date" name="allocationDate" id="allocationDate" required>

            <input type="submit" value="Allocate">
        </form>
        <% String rm = (String) request.getAttribute("roomMessage");
           if (rm != null) { %>
            <div class="message"><%= rm %></div>
        <% } %>

        <h2>🍽️ Food Feedback</h2>
        <form action="hostel.do" method="post">
            <input type="hidden" name="action" value="feedback">
            <label for="studentIdFb">Student ID:</label>
            <input type="text" name="studentId" id="studentIdFb" required>

            <label for="menuDate">Date:</label>
            <input type="date" name="menuDate" id="menuDate" required>

            <label for="menuItems">Menu Items:</label>
            <textarea name="menuItems" id="menuItems" required></textarea>

            <label for="feedback">Feedback:</label>
            <textarea name="feedback" id="feedback"></textarea>

            <input type="submit" value="Submit Feedback">
        </form>
        <% String fb = (String) request.getAttribute("feedbackMessage");
           if (fb != null) { %>
            <div class="message"><%= fb %></div>
        <% } %>

        <a class="back-link" href="index.jsp">🏠 Back to Dashboard</a>
    </div>
</body>
</html>
