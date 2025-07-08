<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session.getAttribute("enrollment") == null) {
        response.sendRedirect("index.jsp?error=Please login first");
        return;
    }
%>
<html>
<head><title>Feedback</title><style>/* styles omitted */</style></head>
<body>
    <div class="container">
        <h2>🗣️ Submit Feedback</h2>
        <form action="${pageContext.request.contextPath}/FeedbackServlet" method="post">
            <textarea name="message" rows="5" style="width:100%;" placeholder="Your comments..." required></textarea>
            <input type="submit" value="Send Feedback">
        </form>
    </div>
</body>
</html>
