<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Log In form</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/stylelogin.css"/>">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
</head>
<body>
	<div>
		<h3 style="color: red;">${error}</h3>
	</div>
	<div class="login">
		<form action="${pageContext.request.contextPath}/registration/loginPost" method=post>
			<div class="title">Log In</div>
			<div class="inputbox">
				<input type="text" name="email" placeholder="Enter your email"
					required>
				<div class="underline"></div>
			</div>
			<div class="inputbox">
				<input type="password" name="password"
					placeholder="Enter your password" required>
				<div class="underline"></div>
			</div>
			<div class="inputbox button">
				<input type="submit" value="Continue">
			</div>
		</form>
		<div class="option">Or Connect With Social Media</div>
		<div class="twitter">
			<a href="#"><li class="l fab fa-twitter"></li>Login with Twitter</a>
		</div>
		<div class="facebook">
			<a href="#"><li class="l fab fa-facebook-f"></li>Login with
				Facebook</a>
		</div>
		<div>
			<a href="<c:url value="/registration/register"/>">Create your
				account</a>

		</div>
	</div>
</body>
</html>