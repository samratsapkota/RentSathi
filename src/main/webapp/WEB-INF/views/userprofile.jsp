<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Profile</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/profilestyle.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body
	style="background-image: url(${pageContext.request.contextPath}/resources/Images/Background1.png)">
	<main>
		<c:forEach items="${registerDetail}" var="rd">
			<section class="profile-container">
				<div class="profile-info">
					<div class="profile-picture-container">
						<img id="profile-picture"
							src="${pageContext.request.contextPath}/resources/Images/Background.png"
							alt="Profile picture"> <label for="profile-upload"
							class="upload-button">Change Profile Picture</label> <input
							type="file" id="profile-upload" accept="image/*"
							style="display: none;">
					</div>
					<p>
						Name:<span id="name">${rd.fullname }</span>
					<p>
					<p>
						Username: <span id="username">${rd.email }</span>
					</p>
					<p>
						Email: <span id="email">${rd.email }</span>
					</p>
					<p>
						Phone: <span id="phone">${rd.mobileno }</span>
					</p>
				</div>
				<div class="profile-info">
					<h3>Other Information</h3>
					<p>
						Occupation: <span id="occupation">${rd.occupation }</span>
					</p>
					<p>
						Gender: <span id="gender">${rd.gender }</span>
					</p>
					<p>
						Address Type: <span id="address-type">${rd.addressType }</span>
					</p>
					<p>
						City: <span id="city">${rd.city }</span>
					</p>
					<p>
						Province: <span id="province">${rd.province }</span>
					</p>
					<p>
						District: <span id="district">${rd.district }</span>
					</p>
				</div>

				<!-- <div class="profile-settings">
					<h3>Account Settings</h3>
					<ul>
						<li><a href="#">Edit Profile</a></li>
						<li><a href="/changepass.html">Change password</a></li>
						<li><a href="#">Delete Account</a></li>
					</ul>
				</div> -->
				<div class="profile-info">
					<a href="${pageContext.request.contextPath}/book/bookingDetails"
						style="text-decoration: none;">
						<button type="button">Your Bookings</button>
					</a>
				</div>
				<div class="container">
					<a href="${pageContext.request.contextPath}/intro"
						style="text-decoration: none; color: inherit;"><button
							style="font-size: 20px; background-color: #ff6600; color: white; border: none; padding: 10px 20px;">Back</button></a>
				</div>

			</section>
		</c:forEach>
	</main>
	<script
		src="${pageContext.request.contextPath}/resources/js/profscript.js"></script>
</body>
</html>
