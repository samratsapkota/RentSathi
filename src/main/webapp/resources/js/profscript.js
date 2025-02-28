document.addEventListener("DOMContentLoaded", function() {
    // Get user data from localStorage (with error handling)
    const userData = JSON.parse(localStorage.getItem('userData'));
    if (!userData) {
      console.error("User data not found in localStorage");
      return; // Exit if no data found
    }
  
  // Populate profile fields with user data
  document.getElementById("name").textContent = userData.name;
  document.getElementById("username").textContent = userData.username;
  document.getElementById("email").textContent = userData.email;
  document.getElementById("phone").textContent = userData.phone;
  document.getElementById("occupation").textContent = userData.occupation;
  document.getElementById("gender").textContent = userData.gender;
  document.getElementById("address-type").textContent = userData.addressType;
  document.getElementById("nationality").textContent = userData.nationality;
  document.getElementById("province").textContent = userData.province;
  document.getElementById("district").textContent = userData.district;

    const profileUpload = document.getElementById('profile-upload');
    const profilePicture = document.getElementById('profile-picture');
  
    profileUpload.addEventListener('change', function() {
      const file = this.files[0];
      if (file) {
        if (!file.type.match('image/.*')) {
          alert("Only image files are allowed!");
          return;
        }
        if (file.size)
          alert("Image size cannot exceed 1MB!");
          return;
        }
  
        const reader = new FileReader();
        reader.onload = function() {
          profilePicture.src = this.result;
        };
        reader.readAsDataURL(file);
      });  
    // Get the elements
    var accountChangePasswordLink = document.querySelector('[href="#account-change-password"]');
    var accountChangePasswordTab = document.querySelector('#account-change-password');
  
    // Hide the change password tab initially
    accountChangePasswordTab.classList.add('d-none');
  
    // Add click event listener to the change password link
    accountChangePasswordLink.addEventListener('click', function(event) {
      event.preventDefault();
      accountChangePasswordTab.classList.toggle('d-none');
    });
    const bookingData = [
        { id: 1, service: "Flat Booking", date: "2024-03-18", time: "10:00 AM", status: "Confirmed" },
        { id: 2, service: "Room Booking", date: "2024-03-25", time: "02:00 PM", status: "Pending" },
      ];
  });
  