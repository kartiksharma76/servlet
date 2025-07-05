<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>📝 Student Registration</title>
    <style>
        body {
            font-family: Arial;
            background: #e3f2fd;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #2196f3;
        }
        h2 {
            text-align: center;
            color: #1565c0;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }
        input[type="text"], input[type="email"], input[type="tel"], input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-top: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #1565c0;
            color: white;
            border: none;
            padding: 12px 20px;
            margin-top: 20px;
            cursor: pointer;
            width: 100%;
            border-radius: 5px;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0d47a1;
        }
        .error {
            text-align: center;
            color: red;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<%
    if (session.getAttribute("enrollment") != null) {
        response.sendRedirect("dashboard.jsp");
        return;
    }
%>
    <div class="container">
        <h2>📝 Student Registration</h2>
        <form action="RegistrationServlet" method="post">
            <label>Full Name:</label>
            <input type="text" name="name" required>

            <label>Enrollment No:</label>
            <input type="text" name="enrollment" required>

            <label>Email:</label>
            <input type="email" name="email" required>

            <label>Branch:</label>
            <input type="text" name="branch" required>

            <label>Year:</label>
            <input type="text" name="year" required>

            <label>Date of Birth:</label>
            <input type="date" name="dob" required>

            <label>Blood Group:</label>
            <input type="text" name="blood_group" required>

            <label>Mobile Number:</label>
            <input type="tel" name="mobile" required>

            <label>Father's Name:</label>
            <input type="text" name="father_name" required>

            <label>Father's Mobile:</label>
            <input type="tel" name="father_mobile" required>

            <label>Room ID:</label>
            <input type="text" name="room_id" required>

            <input type="submit" value="Register">
        </form>

        <% String error = request.getParameter("error");
           if (error != null) { %>
            <div class="error"><%= error %></div>
        <% } %>
    </div>
</body>
</html>
