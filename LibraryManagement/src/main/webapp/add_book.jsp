<!DOCTYPE html>
<html>
<head>
    <title>Add Book</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f3ff;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 400px;
            margin: 50px auto;
            background: white;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #4a4aff;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 15px;
            border: 1px solid #aaa;
            border-radius: 5px;
        }

        button {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            background: #4a4aff;
            color: white;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background: #0000cc;
        }

        .back {
            display: block;
            text-align: center;
            margin-top: 15px;
        }

        .back a {
            text-decoration: none;
            color: #333;
        }
    </style>

</head>

<body>

<div class="container">
    <h2>Add New Book</h2>

    <form action="AddBookServlet" method="post">
        Title:
        <input type="text" name="title" required>

        Author:
        <input type="text" name="author" required>

        Color:
        <select name="color">
            <option>Red</option>
            <option>Green</option>
            <option>Blue</option>
            <option>Yellow</option>
            <option>Black</option>
        </select>

        Category:
        <input type="text" name="category" required>

        Cost:
        <input type="number" step="0.1" name="cost" required>

        <button type="submit">Add Book</button>
    </form>

    <div class="back">
        <a href="index.jsp">⬅ Back to Home</a>
    </div>

</div>

</body>
</html>
