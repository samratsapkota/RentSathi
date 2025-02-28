<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

h2 {
	text-align: center;
	color: #333;
}

form {
	max-width: 400px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

label {
	display: block;
	margin-bottom: 5px;
	color: #333;
}

input[type="text"], input[type="email"], input[type="tel"], input[type="number"],
	textarea {
	width: calc(100% - 20px);
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 16px;
}

input[type="submit"] {
	width: 100%;
	background-color: #007bff;
	color: #fff;
	border: none;
	padding: 10px;
	border-radius: 5px;
	cursor: pointer;
	font-size: 18px;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<h2>Booking Information</h2>
	<form action="${pageContext.request.contextPath}/book/bookAdd"
		method="post">
		<label for="name">Name:</label><br> <input type="text" id="name"
			name="name" required><br> <label for="email">Email:</label><br>
		<input type="email" id="email" name="email" required><br>
		<label for="mobileno">Mobile Number:</label><br> <input
			type="tel" id="mobileno" name="mobileno" required><br> <label
			for="comment">Comment:</label><br>
		<textarea id="comment" name="comment" rows="4" cols="50"></textarea>
		<br> <input type="hidden" name="rent_id" value="${rent_id}">
		<input type="submit" value="Submit">
	</form>
</body>
</html>
