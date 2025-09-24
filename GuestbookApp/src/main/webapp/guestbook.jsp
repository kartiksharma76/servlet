<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.User" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Advanced Guestbook - All Entries</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2>📋 All Guestbook Entries</h2>
        <a href="${pageContext.request.contextPath}/" class="btn btn-primary">➕ Add New Entry</a>
    </div>

    <%
        List<User> users = (List<User>) request.getAttribute("users");
        if (users == null || users.isEmpty()) {
    %>
        <div class="alert alert-info">
            No entries found. <a href="${pageContext.request.contextPath}/">Add your information</a>.
        </div>
    <%
        } else {
    %>
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover">
                <thead class="table-dark">
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <th>Gender</th>
                        <th>DOB</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 1;
                        for (User user : users) {
                    %>
                    <tr>
                        <td><%= count++ %></td>
                        <td><%= user.getName() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getPhone() %></td>
                        <td><%= user.getAddress() != null ? user.getAddress() : "-" %></td>
                        <td><%= user.getGender() != null ? user.getGender() : "-" %></td>
                        <td><%= user.getDobFormatted() %></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    <%
        }
    %>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>