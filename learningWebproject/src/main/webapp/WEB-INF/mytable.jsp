<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="mystyle.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<table class="table table-dark table-striped">
  <thead>
  <tr>
    <th scope="col">#</th>
    <th scope="col">Username</th>
    <th scope="col">Phone</th>
    <th scope="col">Course</th>
    <th scope="col">Email</th>
    <th scope="col">Gender</th>
    <th scope="col">Timing</th>
  </tr>
</thead>
<tbody>
  <c:forEach var="student" items="${requestScope.stu}" varStatus="status">
    <tr>
      <th scope="row">${status.index + 1}</th>
      <td>${student.username}</td>
      <td>${student.phone}</td>
      <td>${student.course}</td>
      <td>${student.email}</td>
      <td>${student.gender}</td>
      <td>${student.timing}</td>
        <td>
        <a href="UpdateServlet?username=${student.username}
    &phone=${student.phone}
    &course=${student.course}
    &email=${student.email}
    &gender=${student.gender}
    &timing=${student.timing}"
   class="btn btn-sm btn-warning">Update</a>

        <a href="DeleteServlet?phone=${student.phone}" class="btn btn-sm btn-danger"
           onclick="return confirm('Are you sure you want to delete this record?');">Delete</a>
           
      </td>
    </tr>
  </c:forEach>
</tbody>

</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>