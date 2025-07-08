<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("enrollment") == null) {
        response.sendRedirect("index.jsp?error=Please login first");
        return;
    }
%>
<html>
<head><title>Room Allocation</title><style>/* styles omitted */</style></head>
<body>
    <div class="container">
        <h2>🏠 Room Allocation Request</h2>
        <form action="${pageContext.request.contextPath}/RoomAllocationServlet" method="post">
            <input type="text" name="enrollment" value="<%= session.getAttribute("enrollment") %>" readonly>
            <input type="text" name="preferred_room" placeholder="Room ID" required>
            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
