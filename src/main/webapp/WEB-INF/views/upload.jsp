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
<title>upload</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/upload.css">
</head>
<body
	style="background-image: url(${pageContext.request.contextPath}/resources/Images/Background1.png);">
	<div align="center" class="container">
		<h3>Image Upload</h3>
		<form action="${pageContext.request.contextPath}/upload/add"
			enctype="multipart/form-data" method=post>
			<label for="Image" class="section">Image: </label> <input type="file"
				name="img" class="form-control" /> <label for="rentType"
				class="section">Rent Type:</label> <select class="rentType"
				id="rentType" name="rentType" onchange="changeRentType()">
				<option value="house">house</option>
				<option value="flat">flat</option>
				<option value="room">room</option>
			</select>
			<!-- <option value="Room with Kitchen">Room with Kitche</option>
          <option value="1BHK">1BHK</option>
          <option value="2BHK">2BHK</option> -->
			<label for="Location" class="section">Location:</label><br/> <select class="rentType"
				id="location" name="location" required>
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
			<div id="bhkField">
				<!-- BHK field will be added dynamically here based on selection -->
			</div>


			<label for="title" class="section">Title:</label> <input type="text"
				id="title" name="title"> <label for="price" class="section">Price:
			</label> <input type="number" id="price" name="price"> <label
				for="description" class="section">Description: </label>
			<textarea id="description" name="description" rows="4" cols="50"></textarea>

			<input type="submit" class="uploadbox" value="Upload" />
		</form>
	</div>


	<script>
		function changeRentType() {
			var rentType = document.getElementById("rentType").value;
			var bhkField = document.getElementById("bhkField");

			// Clear previous options
			bhkField.innerHTML = "";

			if (rentType === "flat") {
				// If flat is chosen, add BHK options
				var bhkLabel = document.createElement("label");
				bhkLabel.setAttribute("for", "bhk");
				bhkLabel.textContent = "BHK:";
				bhkField.appendChild(bhkLabel);

				bhkField.appendChild(document.createElement("br"));

				var bhkInput = document.createElement("input");
				bhkInput.setAttribute("id", "bhk");
				bhkInput.setAttribute("name", "PropertySpecification");
				bhkInput.setAttribute("type", "text");
				bhkField.appendChild(bhkInput);
			} else if (rentType === "house") {
				// If house is chosen, add storey label
				var storeyLabel = document.createElement("label");
				storeyLabel.setAttribute("for", "storey");
				storeyLabel.textContent = "Storey:";
				bhkField.appendChild(storeyLabel);

				var storeyInput = document.createElement("input");
				storeyInput.setAttribute("type", "text");
				storeyInput.setAttribute("id", "storey");
				storeyInput.setAttribute("name", "PropertySpecification");
				bhkField.appendChild(storeyInput);
			} else if (rentType === "room") {
				// If room is chosen, add options for number of rooms
				var roomLabel = document.createElement("label");
				roomLabel.setAttribute("for", "numberOfRooms");
				roomLabel.textContent = "Number of Rooms:";
				bhkField.appendChild(roomLabel);

				var roomInput = document.createElement("input");
				roomInput.setAttribute("type", "text");
				roomInput.setAttribute("id", "numberOfRooms");
				roomInput.setAttribute("name", "PropertySpecification");
				bhkField.appendChild(roomInput);
			}
		}
	</script>

</body>
</html>