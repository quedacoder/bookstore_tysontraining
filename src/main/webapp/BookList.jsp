<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
    	<div class="link">
    		<h1 class="header"><a href="list">Book Store</a></h1>
    		<h2 class="header"><a href="new">Add New Book</a></h2>
    	</div>
    	<table class="table table-bordered">
    		<caption class="captionHeader" >List of Books</caption>
    		<tr>
    			<th>Title</th>
    			<th>Author</th>
    			<th>Price</th>
    		</tr>
    		<c:forEach items="${book_list}" var="item">
				<tr>
					<td>${item.getTitle()}</td>
					<td>${item.getAuthor()}</td>
					<td>&#36;${item.getPrice()}</td>
				</tr>
			</c:forEach>
    	</table>
    </div>
	
</body>
</html>