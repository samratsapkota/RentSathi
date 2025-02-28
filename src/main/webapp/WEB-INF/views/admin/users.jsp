<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="background-image: url('<c:url value="/resources/Images/Background1.png"/>')">

	<div class="container mt-5">
		<h2>User Records</h2>
		${message }
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Id</th>
					<th>Email</th>
					<th>Password</th>
					<th>Action</th>
				</tr>
			</thead>
			<%
			int i = 0;
			%>
			<c:forEach items="${users }" var="u">
				<tbody>
					<tr>

						<td><%=i++%></td>
						<td>${u.id }</td>
						<td>${u.email }</td>
						<td>${u.password}</td>
						<td>
							<form
								action="${pageContext.request.contextPath}/admin/deleteUser/${u.id}"
								method="GET">
								<button class="pull-right btn btn-danger plan-action" type="submit">Delete user</button>
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