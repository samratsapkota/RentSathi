<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Your Profile</h1>
		<h3>Email: ${login }</h3>
		<h3>Password: ${userpw }</h3>

		<div class="services-container">
			<c:forEach items="${bookingdetails }" var="b">
				<div class="box">
					<div class="box-img">
						<!--  -->
						<img src="data:image/jpeg;base64,${b.imgpath}" alt="Image">

					</div>
					<p>${b.created_at }</p>
					<h3>${b.title }</h3>
					<h2>
						${b.price }<span>/per Month</span>
					</h2>
					<p>${b.description }</p>
				</div>
			</c:forEach>


		</div>
	</div>
</body>
</html>