
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link href="mystyle.css" rel="stylesheet">
</head>
<body>

	<h1>JBM Book Store</h1>
	<br />
	<h2>Search book</h2>
	<form action="searchBook.do" method="post">
		<div class="mb-3">
			<select class="form-select" aria-label="Default select example"
				name="category">
				<option selected>Select Your Book</option>
				<option value="Java">Java</option>
				<option value="Jdbc">Jdbc</option>
				<option value="Servlet">Servlet</option>
				<option value="Mysql">Mysql</option>
				<option value="SpringFramework">SpringFramework</option>
			</select>
		</div>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
