<%@page import="java.sql.ResultSet"%>
<%
   ResultSet rs = (ResultSet) request.getAttribute("rs");
   rs.next();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #eef2ff;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 420px;
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
            border: 1px solid #999;
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
            margin-top: 10px;
            text-align: center;
        }

        .back a {
            text-decoration: none;
            color: #333;
        }
    </style>

</head>

<body>

<div class="container">

    <h2>Edit Book</h2>

    <form action="UpdateBookServlet" method="post">

        <input type="hidden" name="id" value="<%= rs.getInt("id") %>">

        Title:
        <input type="text" name="title" value="<%= rs.getString("title") %>" required>

        Author:
        <input type="text" name="author" value="<%= rs.getString("author") %>" required>

        Color:
        <select name="color">
            <option <%= rs.getString("color").equals("Red")?"selected":"" %>>Red</option>
            <option <%= rs.getString("color").equals("Green")?"selected":"" %>>Green</option>
            <option <%= rs.getString("color").equals("Blue")?"selected":"" %>>Blue</option>
            <option <%= rs.getString("color").equals("Yellow")?"selected":"" %>>Yellow</option>
            <option <%= rs.getString("color").equals("Black")?"selected":"" %>>Black</option>
        </select>

        Category:
        <input type="text" name="category" value="<%= rs.getString("category") %>" required>

        Cost:
        <input type="number" step="0.1" name="cost" value="<%= rs.getDouble("cost") %>" required>

        <button type="submit">Update</button>
    </form>

    <div class="back">
        <a href="ViewBooksServlet">⬅ Back to Books</a>
    </div>

</div>

</body>
</html>
