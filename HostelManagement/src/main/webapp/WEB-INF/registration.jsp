<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>📝 Registration</title>
    <style>
        body { font-family: Arial; background: #eef2f7; text-align: center; padding-top: 50px; }
        .form-container { background: white; padding: 30px; border-radius: 10px; display: inline-block; max-width: 500px; }
        input, select { margin: 8px 0; padding: 10px; width: 100%; box-sizing: border-box; }
        input[type="submit"] { background: #28a745; color: white; border: none; cursor: pointer; }
        .error { color: red; }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Register New Student</h2>
        <form action="${pageContext.request.contextPath}/portal/registration" method="post">
            <input type="text" name="enrollment" placeholder="Enrollment No" required>
            <input type="text" name="name" placeholder="Full Name" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="text" name="branch" placeholder="Branch (e.g., CSE)" required>
            <input type="text" name="year" placeholder="Year (e.g., 2nd)" required>
            <input type="date" name="dob" required>
            <input type="text" name="blood_group" placeholder="Blood Group" required>
            <input type="tel" name="mobile" placeholder="Mobile" required>
            <input type="text" name="father_name" placeholder="Father's Name" required>
            <input type="tel" name="father_mobile" placeholder="Father's Mobile" required>
            <input type="text" name="room_id" placeholder="Room ID (e.g., R101)" required>
            <input type="submit" value="Register">
        </form>

        <% String error = (String) request.getAttribute("error");
           if (error != null) { %>
            <p class="error"><%= error %></p>
        <% } %>

        <br>
        <a href="${pageContext.request.contextPath}/login.jsp">← Back to Login</a>
    </div>
</body>
</html>