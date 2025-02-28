<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listings</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body
	style="background-image: url('<c:url value="/resources/Images/Background1.png"/>')">

	<div class="container mt-5">
		<h2>Booking Details</h2>
		<p>Here's a list of bookings with their User's Id</p>
		<table class="table-bordered">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Booking ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Mobile Number</th>
					<th>Comment</th>
					<th>Created At</th>

					<th>Rent ID</th>
					<th>Rent Type</th>
					<th>Title</th>
					<th>Location</th>
					<th>Price</th>
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
						<td>${l.bookingId }</td>
						<td>${l.name }</td>
						<td>${l.email }</td>
						<td>${l.mobileno }</td>
						<td>${l.comment }</td>
						<td>${l.createdAt }</td>
						<td>${l.rentId }</td>
						<td>${l.rentType }</td>
						<td>${l.title }</td>
						<td>${l.location }</td>
						<td>${l.price }</td>
						<td>${l.status }</td>
						<td>
							<div>
								<%-- <input type="hidden" class="rent-id" value="${l.rentId}"> --%>
								<form action="${pageContext.request.contextPath }/admin/bookinglistings/${l.rentId }/approved" method="post"><button
										class="pull-right btn btn-primary plan-action"
										data-value="approved">Approve</button></form>
								<form action="${pageContext.request.contextPath }/admin/bookinglistings/${l.rentId }/rejected" method="post"><button
										class="pull-right btn btn-danger plan-action"
										data-value="rejected" style="margin-right: 10px;">Reject</button></form>

							</div>
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

	<script type="text/javascript">
		$(function() {
			$(document)
					.on(
							'click',
							'.plan-action',
							function() {
								var Status = $(this).data('value');
								var rentId = $(this).closest('td').find(
										'.rent-id').val();
								console.log(Status);

								var form = $('<form method="POST">'
										+ '<input type="text" name="status" value="' + Status + '" />'
										+ '<input type="hidden" name="rentId" value="' + rentId + '" />'
										+ '</form>');
								form.appendTo('body').submit();
								form.remove();
							});
		});
	</script>
</body>
</html>