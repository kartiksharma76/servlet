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
            background: linear-gradient(to right, #fffde7, #e3f2fd);
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
            color: #f57f17;
            font-size: 24px;
            margin-bottom: 25px;
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
            padding: 10px;
            margin-top: 8px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
        }

        textarea {
            resize: vertical;
            min-height: 100px;
        }

        select {
            background-color: #f9f9f9;
        }

        input[type="submit"] {
            background-color: #f57f17;
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
            background-color: #e65100;
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
        <h2>📣 Lodge a Complaint</h2>
        <form action="ComplainServlet" method="post">
            <label for="enrollment">Enrollment No:</label>
            <input type="text" name="enrollment" id="enrollment" value="<%= enrollment %>" readonly>

            <label for="category">Category:</label>
            <select name="category" id="category" required>
                <option value="">-- Select Issue Type --</option>
                <option value="Room">🛏️ Room</option>
                <option value="Water">🚰 Water</option>
                <option value="Food">🍽️ Food</option>
                <option value="Electricity">💡 Electricity</option>
                <option value="Others">📦 Others</option>
            </select>

            <label for="description">Complaint Description:</label>
            <textarea name="description" id="description" placeholder="Describe the issue in detail..." required></textarea>

            <input type="submit" value="Submit Complaint">
        </form>

        <% String message = (String) request.getAttribute("message");
           if (message != null) { %>
            <div class="message">✅ <%= message %></div>
        <% } %>
    </div>
</body>
</html>
