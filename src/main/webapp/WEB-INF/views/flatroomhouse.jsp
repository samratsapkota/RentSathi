<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%
String login = (String) session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rent</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/intro.css">
<link rel="stylesheet"
	href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>
<body>
	<section>
		<jsp:include page="header.jsp" />
	</section>
	<section class="services" id="service">
		<div class="services-container">
			<c:forEach items="${rentDetails }" var="rentDetail">
				<div class="box">
					<div class="box-img">
						<!--  -->
						<img src="data:image/jpeg;base64,${rentDetail.imgpath}"
							alt="Image">

					</div>
					<p>${rentDetail.created_at }</p>
					<c:if test="${rentDetail.status	 == 'available' }">
						<div style="color: green;">● ${rentDetail.status }</div>
					</c:if>
					<c:if test="${rentDetail.status	 == 'pending' }">
						<div style="color: yellow;">● ${rentDetail.status }</div>
					</c:if>
					<h3>${rentDetail.title }</h3>
					<h2>
						${rentDetail.price }<span>/per Month</span>
					</h2>
					<p>Location: ${rentDetail.location }</p>
					<a
						href="${pageContext.request.contextPath}/book/rentNow/${rentDetail.rent_id}"
						class="btn">Rent Now</a>
				</div>
			</c:forEach>
		</div>
	</section>
	<section>
		<div class="container">
			<a href="${pageContext.request.contextPath}/intro"
				style="text-decoration: none; color: inherit;"><button
					style="font-size: 20px; background-color: #ff6600; color: white; border: none; padding: 10px 20px;">Back</button></a>
		</div>
	</section>


</body>
</html>