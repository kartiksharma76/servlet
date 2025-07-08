<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("enrollment") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    String enrollment = (String) session.getAttribute("enrollment");
%>
<html>
<head>
    <title>📣 Lodge a Complaint</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: radial-gradient(circle at top left, #fff8e1, #e3f2fd);
            padding: 30px;
            margin: 0;
        }

        .container {
            max-width: 700px;
            margin: auto;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 14px;
            box-shadow: 0 4px 25px rgba(0, 0, 0, 0.08);
        }

        h2 {
            text-align: center;
            color: #f57f17;
            font-size: 26px;
            margin-bottom: 30px;
        }

        label {
            font-weight: 600;
            display: block;
            margin-top: 20px;
            color: #333;
        }

        input[type="text"],
        select,
        textarea {
            width: 100%;
            padding: 12px;
            margin-top: 8px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
        }

        textarea {
            resize: vertical;
            min-height: 110px;
        }

        select {
            background-color: #f9f9f9;
        }

        input[type="submit"] {
            background-color: #f57f17;
            color: white;
            padding: 14px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 30px;
            width: 100%;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #e65100;
        }

        .message {
            text-align: center;
            color: green;
            font-weight: bold;
            margin-top: 20px;
            padding: 10px;
            border-radius: 6px;
            background-color: #f1f8e9;
            box-shadow: 0 0 8px rgba(76, 175, 80, 0.2);
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>📣 Lodge a Complaint</h2>
        <form action="ComplainServlet" method="post">
            <label for="enrollment">Enrollment No:</label>
            <input type="text" name="enrollment" id="enrollment" value="<%= enrollment %>" readonly>

            <label for="category">Complaint Category:</label>
            <select name="category" id="category" required>
                <option value="">-- Select an Issue --</option>
                <option value="Room">🛏️ Room</option>
                <option value="Water">🚰 Water</option>
                <option value="Food">🍽️ Food</option>
                <option value="Electricity">💡 Electricity</option>
                <option value="Others">📦 Others</option>
            </select>

            <label for="description">Issue Description:</label>
            <textarea name="description" id="description" placeholder="Please describe the problem in detail..." required></textarea>

            <input type="submit" value="Submit Complaint">
        </form>

        <% String message = (String) request.getAttribute("message");
           if (message != null) { %>
            <div class="message">✅ <%= message %></div>
        <% } %>
    </div>
</body>
</html>
