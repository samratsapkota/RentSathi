document.addEventListener("DOMContentLoaded", function() {
  const form = document.querySelector("form"),
      nextBtn = form.querySelector(".nextBtn"),
      backBtn = form.querySelector(".backBtn"),
      allInput = form.querySelectorAll(".first input");

  nextBtn.addEventListener("click", (e) => {
      e.preventDefault(); // Prevent the default form submission behavior

      let isValid = true; // Flag to track overall validation status

      // Loop through all inputs and check if they are empty
      allInput.forEach(input => {
          if (input.value.trim() === "") { // Check if input is empty after trimming whitespace
              isValid = false;
          }
      });

      if (isValid) {
          form.classList.add('secActive'); // Proceed to the next step if all inputs are filled
      } else {
          form.classList.remove('secActive'); // Remove the 'secActive' class if any input is empty
      }
  });

  backBtn.addEventListener("click", () => form.classList.remove('secActive'));

  // Function to validate email
  function validateEmail(email) {
      const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      return emailRegex.test(email);
  }

  // Function to validate phone number 
  function validatePhoneNumber(phonenum) {
      const phoneRegex = /^98[0-9]{8}$/; // 
      return phoneRegex.test(phonenum);
  }

  // Function to validate full name (allow spaces)
  function validateName(fullname) {
      const nameRegex = /^[a-zA-Z\s]+$/; // Allow spaces
      return nameRegex.test(fullname);
  }
  // Function to validate passwords 
  function validatePasswords() {
    const password1 = document.getElementById('pd1').value;
    const password2 = document.getElementById('pd2').value;

    // Validate password format (minimum 8 characters, mix of uppercase, lowercase, numbers, and symbols)
    const passwordRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^\w\s]).{8,}$/;
    if (!passwordRegex.test(password1)) {
        return false; // Invalid password format
    }

    // Check if passwords match
    return password1 === password2;
}

  // Function to show custom alert
  function showAlert(message) {
      const alertBox = document.getElementById('custom-alert');
      const alertMessage = document.getElementById('alert-message');
      alertMessage.textContent = message;
      alertBox.style.display = 'block';

      // Hide the alert after 3 seconds
      setTimeout(function() {
          alertBox.style.display = 'none';
      }, 3000);
  }

  // Event listener for form submission
  
  $(function() {
	  
	  $('.submit').click(function() {
		  const fullname = document.getElementById('fullname').value;
    if (!validateName(fullname)) {
        showAlert('Please enter a valid name (letters and spaces only).');
        document.getElementById('fullname').focus();
        return false; 
    }
    // Validate email
    const email = document.getElementById('email').value;
    if (!validateEmail(email)) {
        showAlert('Please enter a valid email address.');
        document.getElementById('email').focus();
        return false; 
    }
    // Validate phone number
    const phonenum = document.getElementById('phonenum').value;
    if (!validatePhoneNumber(phonenum)) {
        showAlert('Please enter a valid phone number (e.g. 9812345678).');
        document.getElementById('phonenum').focus();
        return false; 
    }
    // Validate passwords before submission
    if (!validatePasswords()) {
          showAlert('Passwords do not match or invalid format. Minimum 8 characters with mix of uppercase, lowercase, numbers, and symbols.');
          document.getElementById('pd1').focus(); // Focus on first password field
          return false; 
    }

      // Successful validation
      showAlert("Registered Successfully! Click OK to continue");
		var form = $('<form method="POST">'
		+'</form>'
		);
		form.appendTo('body').submit();
		form.remove();
      
  
	  })
  });
  
  //form.addEventListener("submit", function(event) {
      //event.preventDefault(); // Prevent default form submission
    // Validate full name
    
});
