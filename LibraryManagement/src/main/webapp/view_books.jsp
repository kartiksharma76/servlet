<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>
<head>
    <title>All Books</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background: #eef2ff;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #4a4aff;
            margin-bottom: 25px;
        }

        table {
            width: 90%;
            margin: auto;
            border-collapse: collapse;
            background: white;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
        }

        th {
            background: #4a4aff;
            color: white;
            padding: 12px;
            font-size: 16px;
        }

        td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background: #f2f2ff;
        }

        a {
            text-decoration: none;
            padding: 6px 12px;
            border-radius: 5px;
            color: white;
            font-size: 14px;
        }

        .edit-btn {
            background: #007bff;
        }

        .edit-btn:hover {
            background: #0056b3;
        }

        .delete-btn {
            background: #d32f2f;
        }

        .delete-btn:hover {
            background: #9a0007;
        }

        .home-link {
            text-align: center;
            margin-top: 20px;
        }

        .home-link a {
            color: #4a4aff;
        }
    </style>
</head>

<body>

<h2>All Books</h2>

<table>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Color</th>
        <th>Category</th>
        <th>Cost</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

<%
    ResultSet rs = (ResultSet) request.getAttribute("bookList");
    while(rs.next()) {
%>

<tr>
    <td><%= rs.getString("title") %></td>
    <td><%= rs.getString("author") %></td>
    <td><%= rs.getString("color") %></td>
    <td><%= rs.getString("category") %></td>
    <td><%= rs.getDouble("cost") %></td>

    <td>
        <a class="edit-btn" href="GetBookServlet?id=<%= rs.getInt("id") %>">Edit</a>
    </td>

    <td>
        <a class="delete-btn" href="DeleteBookServlet?id=<%= rs.getInt("id") %>">Delete</a>
    </td>
</tr>

<%
    }
%>
</table>

<div class="home-link">
    <br>
    <a href="index.jsp">⬅ Back to Home</a>
</div>

</body>
</html>
