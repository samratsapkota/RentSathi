<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<title>Registration Form</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/registerstyle.css"/> " />
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<title>Regisration Form</title>
</head>
<body>
	<div class="container">
		<header>Registration</header>
		<div>
			<h3 style="color: red;">${error}</h3>
		</div>
		<div class="alert alert-danger" role="alert">
			<form:errors path="registerTable.*" />
		</div>
		<form
			action="${pageContext.request.contextPath}/registration/registerPost"
			modelAttribute="registerTable" method=post>
			<div class="form first">
				<div class="details personal">
					<span class="title">Personal Details</span>
					<div class="fields">
						<div class="input-field">
							<label>Full Name</label> <input type="text" name="fullname"
								id="fullname" placeholder="Enter your name" required>
						</div>
						<div class="input-field">
							<label>Date of Birth</label> <input type="date" name="dob"
								id="dob" placeholder="Enter birth date" required>
						</div>
						<div class="input-field">
							<label>Email</label> <input type="text" name="email" id="email"
								placeholder="Enter your email" required>
						</div>
						<div class="input-field">
							<label>Mobile Number</label> <input type="number" name="mobileno" id="phonenum"
								placeholder="Enter mobile number" required>
						</div>
						<div class="input-field">
							<label>Gender</label> <select name="gender" required>
								<option disabled selected>Select gender</option>
								<option>Male</option>
								<option>Female</option>
								<option>Others</option>
							</select>
						</div>
						<div class="input-field">
							<label>Occupation</label> <input type="text" name="occupation"
								placeholder="Enter your ccupation">
						</div>
					</div>
				</div>

				<div class="details ID">
					<span class="title">Identity Details</span>
					<div class="fields">
						<div class="input-field">
							<label>ID Type</label> <select name="idType" required>
								<option disabled selected>Select ID type</option>
								<option>Citizenship</option>
								<option>Passport</option>
								<option>Driving License</option>
							</select>
						</div>
						<div class="input-field">
							<label>ID Number</label> <input type="text" name="idNo"
								placeholder="Enter ID number" required>
						</div>
						<div class="input-field">
							<label>Issued Authority</label> <input type="text"
								name="IssuedAuthority" placeholder="Enter issued authority"
								required>
						</div>
					</div>
					<button class="nextBtn">
						<span class="btnText">Next</span> <i class="uil uil-navigator"></i>
					</button>
				</div>
			</div>
			<div class="form second">
				<div class="details address">
					<span class="title">Address Details</span>
					<div class="fields">
						<div class="input-field">
							<label>Address Type</label> <select name="addressType" required>
								<option disabled selected>Select address type</option>
								<option>Temporary</option>
								<option>Permanent</option>
							</select>
						</div>
						<div class="input-field">
							<label>City</label> <input type="text" name="city"
								placeholder="Enter your city" required>
						</div>
						<div class="input-field">
							<label>Province</label> <select id="province" class="select2"
								name="province" required>
								<option disabled selected>Select your province</option>
								<option value="Province 1">Province 1</option>
								<option value="Province 2">Province 2</option>
								<option value="Bagmati Province">Bagmati Province</option>
								<option value="Gandaki Province">Gandaki Province</option>
								<option value="Lumbini Province">Lumbini Province</option>
								<option value="Karnali Province">Karnali Province</option>
								<option value="Sudurpashchim Province">Sudurpashchim
									Province</option>
							</select>
						</div>
						<div class="input-field">
							<label>District</label><select id="district" name="district"
								required>
								<option disabled selected>Select your district</option>
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
					</div>
				</div>
				<span class="title">Create a new password</span>
				<div class="fields">
					<div class="input-field">
						<input type="password" name="password"
							placeholder="Enter your password" id="pd1" required> <input
							type="password" name="confirmpassword"
							placeholder="Enter your password again" id="pd2" required>
					</div>
				</div>
				<div class="buttons">
					<div class="backBtn">
						<i class="uil uil-navigator"></i> <span class="btnText">Back</span>
					</div>

					<button class="submit" id="submit">
						<span class="btnText">Submit</span> <i class="uil uil-navigator"></i>
					</button>
				</div>
			</div>
		</form>
	</div>
	<script src="${pageContext.request.contextPath }/resources/js/script.js"></script>
</body>
</html>

