<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<%=request.getAttribute("username")%>
	</h1>
	<br>
	<h2><c:out value="${username}"></c:out> </h2>
	<c:forEach var="x" items="${requestScope.AL }">
		<p>${x}</p>
	</c:forEach>

	<c:forEach var="entry" items="${requestScope.map }">
	<p>${entry.key}: ${entry.value}</p>
	</c:forEach>
</body>
</html>