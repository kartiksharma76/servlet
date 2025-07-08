<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>📝 Student Registration</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #eef3f7;
        }
        .container {
            width: 500px;
            margin: 50px auto;
            background-color: white;
            border-radius: 8px;
            padding: 30px;
            box-shadow: 0 8px 18px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #0078d4;
        }
        label {
            font-weight: bold;
            margin-top: 10px;
            display: block;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }
        input[type="submit"] {
            background-color: #0078d4;
            color: white;
            border: none;
            font-weight: bold;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #005ea2;
        }
        .error-message {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Register a New Student</h2>
        <form action="${pageContext.request.contextPath}/RegistrationServlet" method="post">
            <label>Enrollment No:</label>
            <input type="text" name="enrollment" required>

            <label>Name:</label>
            <input type="text" name="name" required>

            <label>Email:</label>
            <input type="email" name="email" required>

            <label>Password:</label>
            <input type="password" name="password" required>

            <label>Branch:</label>
            <input type="text" name="branch" required>

            <label>Year:</label>
            <input type="text" name="year" required>

            <label>Date of Birth:</label>
            <input type="date" name="dob" required>

            <label>Blood Group:</label>
            <input type="text" name="blood_group" required>

            <label>Mobile:</label>
            <input type="tel" name="mobile" required>

            <label>Father's Name:</label>
            <input type="text" name="father_name" required>

            <label>Father's Mobile:</label>
            <input type="tel" name="father_mobile" required>

            <label>Room ID:</label>
            <input type="text" name="room_id" required>

            <input type="submit" value="Register">
        </form>

        <div class="error-message">
            <%= request.getParameter("error") != null ? request.getParameter("error") : "" %>
        </div>
    </div>
</body>
</html>
