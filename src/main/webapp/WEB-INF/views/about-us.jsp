<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/aboutus.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
</head>
<body
	style="background-image: url('<c:url value="/resources/Images/Background1.png"/>')">
	<jsp:include page="header.jsp" />
	<main>
		<section class="about-us">
			<h2>About Rentsathi</h2>
			<p>Rentsathi is a revolutionary online platform designed to
				simplify and secure the room, house, flat, and apartment rental
				process in Nepal. We empower both renters and landlords with
				user-friendly tools to find their perfect match, streamlining the
				experience and fostering trust.</p>

			<div class="key-features">
				<h3>Key Features</h3>
				<ul>
					<li><i class="fas fa-search"></i> Extensive Search Filters:
						Find your ideal rental with ease using our advanced search
						filters, tailored to your specific needs and preferences.</li>
					<li><i class="fas fa-map-marker-alt"></i> Location-Based
						Listings: Explore rentals conveniently located in your desired
						areas, saving you time and effort.</li>
					<li><i class="fas fa-shield-alt"></i> Secure Communication
						Platform: Communicate directly with landlords and renters through
						our secure platform, ensuring safe and transparent interactions.</li>
					<li><i class="fas fa-file-alt"></i> Simplified Lease
						Management: Manage lease agreements electronically, streamlining
						the process and keeping everything organized.</li>
					<li><i class="fas fa-user-shield"></i> Verified Listings &
						User Profiles: Enjoy peace of mind with our verification measures
						for both listings and user profiles, minimizing the risk of fraud.</li>
				</ul>
			</div>

			<div class="team">
				<h3>Our Team</h3>
				<p>Rentsathi is driven by a passionate team of individuals
					dedicated to revolutionizing the rental landscape in Nepal. We are
					committed to fostering a user-centric approach, prioritizing your
					needs and creating a seamless experience.</p>
				<ul>
					<li><img src="<c:url value="/resources/Images/aaru.jpg"/>"
						alt="Team Member 1">
						<h4>Bandana Limbu</h4>
						<p>QA/Front-end/</p>
						<p>Project manager</p>
						<p>Roll no: BIT 05/076</p>
						<p>Patan Multiple Campus</p>
						</li>
					<li><img src="<c:url value="/resources/Images/rishesh.jpg"/>"
						alt="Team Member 2">
						<h4>Rishesh Shakya</h4>
						<p>Back-end Developer</p>
						<p>Roll no: BIT 26/076</p>
						<p>Patan Multiple Campus</p>
						</li>
					<li><img src="<c:url value="/resources/Images/sanjiv.jpg"/>"
						alt="Team Member 3">
						<h4>Sanjiv Dainwal</h4>
						<p>Front-end Developer</p>
						<p>Roll no: BIT 30/076</p>
						<p>Patan Multiple Campus</p>
						</li>
				</ul>
			</div>
		</section>
	</main>

	<footer>
		<p>&copy; RentSathi 2024. All rights reserved.</p>
	</footer>
</body>
</html>