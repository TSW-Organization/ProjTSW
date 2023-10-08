    function togglePasswordVisibility(inputId) {
        const passwordInput = document.getElementById(inputId);
        const passwordToggle = document.querySelector(`#${inputId} + .password-toggle img`);
        
        if (passwordInput.type === "password") {
            passwordInput.type = "text";
            passwordToggle.src = "images/show.png";
        } else {
            passwordInput.type = "password";
            passwordToggle.src = "images/hide.png";
        }
    }
