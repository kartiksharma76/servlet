<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JBM Book store</h1>
<br/>
<h2>Search book</h2>
<font color="pink" size="10">${added}</font>
<br/>
<%Object obj=request.getAttribute("message");
if(obj!=null){%>
<br/>
<font color="blue" size="10"><%=obj %></font>
<br/>
<a href="index.jsp">Go to search page</a>
<% }
else{
	obj=session.getAttribute("books");
	ArrayList<String>booklist=(ArrayList<String>)obj;
	for(String book:booklist){
%>
<form action="addToCart.do"method="post">
<%=book%>  <input type="hidden" name="bookName" value="<%=book%>"/>
<input type="submit" value="addToCart"/>
<br/>
</form>
<%} %>
<br/>
<form action="showCart.do"method="post">
<input type="submit" value="showCart"/>
</form>
<%} %>
</body>
</html>