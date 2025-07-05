<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>📝 Student Registration</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #f9fbe7, #e0f7fa);
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 650px;
            margin: 60px auto;
            background-color: #ffffff;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.08);
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
        input[type="text"], input[type="email"], input[type="date"], input[type="tel"] {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
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
            margin-top: 30px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #004d40;
        }
        .note {
            text-align: center;
            margin-top: 20px;
            color: #888;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>📝 Student Registration</h2>
        <form action="RegistrationServlet" method="post">
            <label for="name">Full Name:</label>
            <input type="text" name="name" id="name" required>

            <label for="enrollment">Enrollment No:</label>
            <input type="text" name="enrollment" id="enrollment" required>

            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required>

            <label for="branch">Branch:</label>
            <input type="text" name="branch" id="branch" required placeholder="Enter your branch (e.g. CSE)">

            <label for="year">Year:</label>
            <input type="text" name="year" id="year" required placeholder="Enter your year (e.g. 1st, 2nd)">

            <label for="dob">Date of Birth:</label>
            <input type="date" name="dob" id="dob" required>

            <label for="blood_group">Blood Group:</label>
            <input type="text" name="blood_group" id="blood_group" required placeholder="E.g. B+, O-">

            <label for="mobile">Mobile Number:</label>
            <input type="tel" name="mobile" id="mobile" required>

            <label for="father_name">Father's Name:</label>
            <input type="text" name="father_name" id="father_name" required>

            <label for="father_mobile">Father's Mobile:</label>
            <input type="tel" name="father_mobile" id="father_mobile" required>

            <label for="room_id">Room ID:</label>
            <input type="text" name="room_id" id="room_id" required>

            <input type="submit" value="Register">
        </form>
        <div class="note">Already registered? <a href="login.jsp">Login here</a></div>
    </div>
</body>
</html>
