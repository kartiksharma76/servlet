<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>🏨 Hostel Services</title>
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
            margin-bottom: 25px;
        }
        form {
            margin-bottom: 40px;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #004d40;
        }
        input[type="text"], input[type="date"], textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            box-sizing: border-box;
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
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #004d40;
        }
        .divider {
            height: 1px;
            background-color: #ddd;
            margin: 40px 0;
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

            <input type="submit" value="Allocate Room">
        </form>

        <div class="divider"></div>

        <h2>🍽️ Food Feedback</h2>
        <form action="hostel.do" method="post">
            <input type="hidden" name="action" value="feedback">

            <label for="studentIdFb">Student ID:</label>
            <input type="text" name="studentId" id="studentIdFb" required>

            <label for="menuDate">Date:</label>
            <input type="date" name="menuDate" id="menuDate" required>

            <label for="menuItems">Menu Items:</label>
            <textarea name="menuItems" id="menuItems" placeholder="E.g., Rice, Dal, Sabzi..." required></textarea>

            <label for="feedback">Your Feedback:</label>
            <textarea name="feedback" id="feedback" placeholder="Write your thoughts here..."></textarea>

            <input type="submit" value="Submit Feedback">
        </form>
    </div>
</body>
</html>
