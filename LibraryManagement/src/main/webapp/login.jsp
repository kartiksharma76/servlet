<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #eef2ff;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 380px;
            margin: 100px auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0px 0px 20px rgba(0,0,0,0.2);
            text-align: center;
        }

        h2 {
            margin-bottom: 25px;
            color: #4a4aff;
        }

        input {
            width: 100%;
            padding: 12px;
            margin-bottom: 18px;
            border: 1px solid #aaa;
            border-radius: 6px;
            font-size: 15px;
        }

        button {
            width: 100%;
            padding: 12px;
            background: #4a4aff;
            border: none;
            color: white;
            font-size: 17px;
            cursor: pointer;
            border-radius: 6px;
            transition: 0.3s;
        }

        button:hover {
            background: #0000cc;
        }

        .footer {
            margin-top: 15px;
        }

        .footer a {
            text-decoration: none;
            color: #333;
        }
    </style>
</head>

<body>

    <div class="container">
        <h2>Admin Login</h2>

        <form action="LoginServlet" method="post">
            <input type="text" name="username" placeholder="Username" required>
            
            <input type="password" name="password" placeholder="Password" required>

            <button type="submit">Login</button>
        </form>

        <div class="footer">
            <a href="index.jsp">⬅ Back to Home</a>
        </div>
    </div>

</body>
</html>
