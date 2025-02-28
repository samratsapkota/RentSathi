<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rent Listings</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body
	style="background-image: url('<c:url value="/resources/Images/Background1.png"/>')">
	<div class="container mt-5">
		<h2>Rent Details</h2>
		<p>Here's a list of all Rents available</p>
		<table class="table-bordered">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Rent Id</th>
					<th>Title</th>
					<th>location</th>
					<th>Price</th>
					<th>Rent Type</th>
					<th>Property specifition</th>
					<th>Created At</th>
					<th>Created By</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<%
			int i = 1;
			%>
			<c:forEach items="${listings }" var="l">
				<tbody>
					<tr>
						<td><%=i++%></td>
						<td>${l.rent_id }</td>
						<td>${l.title }</td>
						<td>${l.location }</td>
						<td>${l.price }</td>
						<td>${l.rentType }</td>
						<td>${l.propertySpecification }</td>
						<td>${l.created_at }</td>
						<td>${l.createdBy }</td>
						<td>${l.status }</td>
						<td>
							<form
								action="${pageContext.request.contextPath}/admin/deleterent/${l.rent_id}"
								method="GET">
								<button class="pull-right btn btn-danger plan-action" type="submit">Delete rent</button>
							</form>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
	<div class="container">
		<a href="${pageContext.request.contextPath}/admin/index"
			style="text-decoration: none; color: inherit;"><button
				style="font-size: 20px; background-color: #ff6600; color: white; border: none; padding: 10px 20px;">Back</button></a>
	</div>
</body>
</html>