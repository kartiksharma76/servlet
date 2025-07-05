<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>🏨 Hostel Services</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to bottom right, #e3f2fd, #fce4ec);
            margin: 0;
            padding: 30px;
        }

        .container {
            max-width: 800px;
            margin: auto;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 0 25px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #1976d2;
            margin-bottom: 30px;
            font-size: 24px;
        }

        label {
            display: block;
            margin-top: 20px;
            font-weight: 600;
            color: #333;
        }

        input[type="text"],
        input[type="date"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
        }

        textarea {
            resize: vertical;
            min-height: 80px;
        }

        input[type="submit"] {
            background-color: #1976d2;
            color: white;
            padding: 12px;
            margin-top: 25px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #0d47a1;
        }

        .divider {
            height: 2px;
            background-color: #eeeeee;
            margin: 50px 0 30px;
        }

        .message {
            text-align: center;
            color: green;
            font-weight: bold;
            margin-bottom: 20px;
        }

    </style>
</head>
<body>
<%
    if (session.getAttribute("enrollment") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
    <div class="container">
        <% String roomMsg = (String) request.getAttribute("roomMessage");
           if (roomMsg != null) { %>
            <div class="message"><%= roomMsg %></div>
        <% } %>

        <% String fbMsg = (String) request.getAttribute("feedbackMessage");
           if (fbMsg != null) { %>
            <div class="message"><%= fbMsg %></div>
        <% } %>

        <h2>🛏️ Room Allocation</h2>
        <form action="hostel.do" method="post">
            <input type="hidden" name="action" value="allocate">

            <label for="studentId">Student ID:</label>
            <input type="text" name="studentId" id="studentId" value="<%= session.getAttribute("enrollment") %>" readonly>

            <label for="roomNumber">Room No:</label>
            <input type="text" name="roomNumber" id="roomNumber" placeholder="Ex: R-102" required>

            <label for="allocationDate">Allocation Date:</label>
            <input type="date" name="allocationDate" id="allocationDate" required>

            <input type="submit" value="Allocate Room">
        </form>

        <div class="divider"></div>

        <h2>🍽️ Food Feedback</h2>
        <form action="hostel.do" method="post">
            <input type="hidden" name="action" value="feedback">

            <label for="studentIdFb">Student ID:</label>
            <input type="text" name="studentId" id="studentIdFb" value="<%= session.getAttribute("enrollment") %>" readonly>

            <label for="menuDate">Date:</label>
            <input type="date" name="menuDate" id="menuDate" required>

            <label for="menuItems">Menu Items:</label>
            <textarea name="menuItems" id="menuItems" placeholder="E.g., Rice, Dal..." required></textarea>

            <label for="feedback">Your Feedback:</label>
            <textarea name="feedback" id="feedback" placeholder="Write your thoughts here..." required></textarea>

            <input type="submit" value="Submit Feedback">
        </form>
    </div>
</body>
</html>
