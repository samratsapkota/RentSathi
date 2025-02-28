<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Introduction page</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/intro.css">
<%-- <link rel="stylesheet" href="<c:url value="/resources/css/intro.css"/>"> --%>
<link rel="stylesheet"
	href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
</head>
<body
	style="background-image: url('<c:url value="/resources/Images/Background4.png"/>')">
	<jsp:include page="header.jsp" />

	<!-- Home  -->
	<section class="home" id="home">
	<div class="slideshow">
                <img class="slide" src="<c:url value="/resources/Images/Background4.png"/>" alt="image 1">
                <img class="slide" src="<c:url value="/resources/Images/apartment.jpg"/>" alt="image 2">
                <img class="slide" src="<c:url value="/resources/Images/Background1.png"/>" alt="image 3">
                <img class="slide" src="<c:url value="/resources/Images/Background4.png"/>" alt="image 4">
              </div>
		<div class="text">
			<h1>
				<span>Discover Comfort,</span><br>Rent with Ease.
			</h1>
			<p>Seamless Rentals, Tailored for You. Find your perfect space
				hassle-free. Secure, convenient, and personalized living solutions
				at your fingertips.</p>
		</div>
		<!-- This below will show the flats or houses and when the person tries to click on the items they want they need to log in or signup to look into that product in more detailed way -->
		<div class="form-container">
			<form action="${pageContext.request.contextPath}/model/search"
				method=get>
				<div class="input-box">
					<span>Location:</span> <select id="dropdown" name="district">
						<option value="">Any</option>
						<option value="Achham">Achham</option>
						<option value="Arghakhanchi">Arghakhanchi</option>
						<option value="Baglung">Baglung</option>
						<option value="Baitadi">Baitadi</option>
						<option value="Bajhang">Bajhang</option>
						<option value="Bajura">Bajura</option>
						<option value="Banke">Banke</option>
						<option value="Bara">Bara</option>
						<option value="Bardiya">Bardiya</option>
						<option value="Bhaktapur">Bhaktapur</option>
						<option value="Bhojpur">Bhojpur</option>
						<option value="Chitwan">Chitwan</option>
						<option value="Dadeldhura">Dadeldhura</option>
						<option value="Dailekh">Dailekh</option>
						<option value="Dang">Dang</option>
						<option value="Darchula">Darchula</option>
						<option value="Dhading">Dhading</option>
						<option value="Dhankuta">Dhankuta</option>
						<option value="Dhanusa">Dhanusa</option>
						<option value="Dholkha">Dholkha</option>
						<option value="Dolpa">Dolpa</option>
						<option value="Doti">Doti</option>
						<option value="Gorkha">Gorkha</option>
						<option value="Gulmi">Gulmi</option>
						<option value="Humla">Humla</option>
						<option value="Illam">Illam</option>
						<option value="Jajarkot">Jajarkot</option>
						<option value="Jhapa">Jhapa</option>
						<option value="Jumla">Jumla</option>
						<option value="Kailali">Kailali</option>
						<option value="Kalikot">Kalikot</option>
						<option value="Kanchanpur">Kanchanpur</option>
						<option value="Kapilvastu">Kapilvastu</option>
						<option value="Kaski">Kaski</option>
						<option value="Kathmandu">Kathmandu</option>
						<option value="Kavrepalanchok">Kavrepalanchok</option>
						<option value="Khotang">Khotang</option>
						<option value="Lalitpur">Lalitpur</option>
						<option value="Lamjung">Lamjung</option>
						<option value="Mahottari">Mahottari</option>
						<option value="Makwanpur">Makwanpur</option>
						<option value="Manang">Manang</option>
						<option value="Morang">Morang</option>
						<option value="Mugu">Mugu</option>
						<option value="Mustang">Mustang</option>
						<option value="Myagdi">Myagdi</option>
						<option value="Nawalparasi">Nawalparasi</option>
						<option value="Nuwakot">Nuwakot</option>
						<option value="Okhaldhunga">Okhaldhunga</option>
						<option value="Palpa">Palpa</option>
						<option value="Panchthar">Panchthar</option>
						<option value="Parbat">Parbat</option>
						<option value="Parsa">Parsa</option>
						<option value="Pyuthan">Pyuthan</option>
						<option value="Ramechhap">Ramechhap</option>
						<option value="Rasuwa">Rasuwa</option>
						<option value="Rautahat">Rautahat</option>
						<option value="Rolpa">Rolpa</option>
						<option value="Rukum">Rukum</option>
						<option value="Rupandehi">Rupandehi</option>
						<option value="Salyan">Salyan</option>
						<option value="Sankhuwasabha">Sankhuwasabha</option>
						<option value="Saptari">Saptari</option>
						<option value="Sarlahi">Sarlahi</option>
						<option value="Sindhuli">Sindhuli</option>
						<option value="Sindhupalchok">Sindhupalchok</option>
						<option value="Siraha">Siraha</option>
						<option value="Solukhumbu">Solukhumbu</option>
						<option value="Sunsari">Sunsari</option>
						<option value="Surkhet">Surkhet</option>
						<option value="Syangja">Syangja</option>
						<option value="Tanahu">Tanahu</option>
						<option value="Taplejung">Taplejung</option>
						<option value="Terhathum">Terhathum</option>
						<option value="Udayapur">Udayapur</option>
					</select>
				</div>
				<div class="input-box">
					<span>Type of Space:</span> <select id="dropdown" name="rentType">
						<option value="">Any</option>
						<option value="house">House</option>
						<option value="room">Rooms</option>
						<option value="flat">Flats</option>
					</select>
				</div>
				<div class="input-box">
					<span>Search:</span> <input type="text" name="description" />
				</div>
				<!-- <div class="input-box">
					<span>No of peoples: </span> <input type="number" id="quantity"
						name="quantity" min="1" max="">
				</div> -->
				<input type="submit" name="" id="" class="btn">
			</form>
		</div>
	</section>
	<section class="rent" id="rent">
		<div class="heading">
			<span> How Its Done</span>
			<h1>Rent With 4 Easy Steps</h1>
		</div>
		<div class="rent-container">
			<div class="box">
				<i class='bx bx-log-in'></i>
				<h2>Log In or Register your Account</h2>
				<p>The first step is to create your account. Please fill up all
					the required fields nicely</p>
			</div>
			<div class="box">
				<i class='bx bx-map'></i>
				<h2>Choose a Location</h2>
				<p>The next step is to choose the location that you want to stay
					or prefer.</p>
			</div>
			<div class="box">
				<i class='bx bxs-home-heart'></i>
				<h2>Choose your preferred space</h2>
				<p>Then choose your choice of space, like do you want to rent a
					Apartment, house, flat or rooms.</p>
			</div>
			<div class="box">
				<i class='bx bxs-contact'></i>
				<h2>Contact with the Owner</h2>
				<p>Lastly, you can contact with the owner and the you can
					prepare for visit to your new home.</p>
			</div>
		</div>
	</section>
	<section class="services" id="service">
		<div class="heading">
			<h1>
				<br> <span> Our Top Picks </span><br>Explore Our Top Deals
				<br> <span> From Top Rated Dealers</span>
			</h1>
		</div>
		<div class="services-container">
			<c:forEach items="${rentDetails }" var="rentDetail">
				<c:if
					test="${rentDetail.status == 'available' || rentDetail.status == 'pending' }">
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
						${rentDetail.description }
						<p>Location: ${rentDetail.location }</p>
						<c:if test="${rentDetail.status	 == 'available' }">
							<a
								href="${pageContext.request.contextPath}/book/rentNow/${rentDetail.rent_id}"
								class="btn">Rent Now</a>
						</c:if>
					</div>
				</c:if>
			</c:forEach>
			<h2>${error }</h2>


		</div>
		<ul class="pagination">
              <li class="active"><a href="#">1</a></li>
              <li><a href="#">2</a></li>
              <li><a href="#">3</a></li>
          </ul> 
	</section>
	<footer>
		<p>&copy; RentSathi 2024. All rights reserved.</p>
	</footer>
	<script src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</html>