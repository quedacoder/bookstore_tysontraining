<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<div id="link">
			<h1 class="header"><a href="list">Book Store</a></h1>
    		<h2 class="header"><a href="new">Add New Book</a></h2>
		</div>
		<form class="formBorder" name="book_form" action="insert" method="post">
			<caption><h2>New Book Form</h2></caption>
			<p>
				<label>Title:</label>
				<input type="text" name="booktitle" />
			</p>
			<p>
				<label>Author:</label>
				<input type="text" name="bookauthor" />
			</p>
			<p>
				<label>Price:</label>
				<input type="text" name="bookprice" />
			</p>
			<p><input class="btn btn-light" type="submit" value="Submit" /></p>
		</form>
	</div>
</body>
</html>