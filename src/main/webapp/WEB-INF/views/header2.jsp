<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- This below will show the flats or houses and when the person tries to click on the items they want they need to log in or signup to look into that product in more detailed way -->
	<!-- <div class="form-container"> -->
	<header>
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
	</header>
	<!-- </div> -->

</body>
</html>