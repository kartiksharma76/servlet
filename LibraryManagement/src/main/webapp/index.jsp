<!DOCTYPE html>
<html>
<head>
    <title>Library Management System</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f2f5;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 450px;
            margin: 120px auto;
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 0px 15px rgba(0,0,0,0.2);
            text-align: center;
        }

        h2 {
            color: #333;
            margin-bottom: 30px;
        }

        a.button {
            display: block;
            background: #4CAF50;
            color: white;
            padding: 15px;
            margin: 15px auto;
            text-decoration: none;
            width: 80%;
            border-radius: 10px;
            font-size: 18px;
            transition: 0.3s;
        }

        a.button:hover {
            background: #388E3C;
            transform: scale(1.05);
        }
    </style>
</head>

<body>

<div class="container">
    <h2>📚 Library Management System</h2>

    <a href="add_book.jsp" class="button">➕ Add New Book</a>
    <a href="ViewBooksServlet" class="button">📖 View All Books</a>
</div>

</body>
</html>
