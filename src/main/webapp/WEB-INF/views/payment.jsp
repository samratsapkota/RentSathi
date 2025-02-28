<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>payment</title>
</head>
<body>
	<div style="text-align: center;">
	<h2>Payment Options</h2>
	<h3>Choose your preference</h3>
    <%-- <img align="center" src="<c:url value="/resources/Images/QR_fonepay.jpg"/>"/> --%>
    <img style="width:30%" src="<c:url value="/resources/Images/esewa.jfif"/>"/>
    <h3>Esewa</h3>
    <img style="width:30%" src="<c:url value="/resources/Images/bank.jpg"/>"/>
    <h3>Bank</h3>
</div>
<div class="container">
					<a href="${pageContext.request.contextPath}/intro"
						style="text-decoration: none; color: inherit;"><button
							style="font-size: 20px; background-color: #ff6600; color: white; border: none; padding: 10px 20px; ">Home</button></a>
				</div>
</body>
</html>