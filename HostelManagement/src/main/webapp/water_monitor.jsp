<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>🚰 Water Supply Monitoring</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #e0f7fa, #ffffff);
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 480px;
            margin: 80px auto;
            background-color: #ffffff;
            padding: 35px 40px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.08);
        }
        h2 {
            text-align: center;
            color: #00796b;
            margin-bottom: 25px;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #004d40;
        }
        input[type="text"], input[type="time"], select {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            box-sizing: border-box;
            transition: border-color 0.3s ease, box-shadow 0.3s ease;
        }
        input[type="text"]:focus, input[type="time"]:focus, select:focus {
            border-color: #00796b;
            outline: none;
            box-shadow: 0 0 5px rgba(0,121,107,0.3);
        }
        input[type="submit"] {
            background-color: #00796b;
            color: #fff;
            padding: 12px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            margin-top: 25px;
            width: 100%;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #004d40;
        }
        .note {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
            color: #888;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>🚰 Water Supply Monitoring</h2>
        <form action="monitorWater.do" method="post">
            <label for="source">Source:</label>
            <input type="text" name="source" id="source" required placeholder="e.g. Borewell, Tank A">

            <label for="supplyTime">Supply Time:</label>
            <input type="time" name="supplyTime" id="supplyTime" required>

            <label for="status">Status:</label>
            <select name="status" id="status" required>
                <option value="" disabled selected>Select status</option>
                <option value="Normal">Normal</option>
                <option value="Low">Low</option>
                <option value="Overflow">Overflow</option>
            </select>

            <input type="submit" value="Log Water Supply">
        </form>
        <div class="note">Keep the system hydrated and clean ✨</div>
    </div>
</body>
</html>
