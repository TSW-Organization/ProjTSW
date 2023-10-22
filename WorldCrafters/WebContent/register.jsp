<!DOCTYPE html>
<html>
<head>
    <%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/log-reg.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="scripts/script.js"></script>
    
</head>
<body>
    <div class="modal-overlay">
        <div class="modal-content">
            <button class="close-button" onclick="closeOverlay('register-overlay')">X</button>
            <h2 class="form-title">Sign up</h2>
            <form method="post" action="registration" id="signup-form" onsubmit="return validateForm()">
                <div class="form-group">
                    <label for="firstName">First name:</label> 
                    <input type="text" name="firstName" id="firstName" placeholder="First name" required />
                </div>
                <div class="form-group">
                    <label for="lastName">Last name:</label> 
                    <input type="text" name="lastName" id="lastName" placeholder="Last name" required />
                </div>

                <div class="form-group">
                    <label for="email">Email:</label> 
                    <input type="email" name="email" id="email" placeholder="Your Email" required />
                    <div id="email-error" style="color: red;"><%= (request.getAttribute("emailError") != null) ? request.getAttribute("emailError") : "" %></div>
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <div class="password-container">
                        <input type="password" name="password" id="password" placeholder="Password" required />
                        <button class="password-toggle" type="button" onclick="togglePasswordVisibility('password')">
                            <img src="images/hide.png" alt="Show Password" class="show-password" />
                        </button>
                    </div>
                </div>

                <div class="form-group">
                    <label for="confirm-password">Confirm Password:</label>
                    <div class="password-container">
                        <input type="password" name="confirm-password" id="confirm-password" placeholder="Confirm Password" required />
                        <button class="password-toggle" type="button" onclick="togglePasswordVisibility('confirm-password')">
                            <img src="images/hide.png" alt="Hide Password" class="hide-password" />
                        </button>
                    </div>
                </div>

                <!-- Aggiungi un messaggio di errore per la validazione della password -->
                <div id="password-error" style="color: red;"></div>

                <input type="hidden" id="redirectCode" name="redirectCode" value="<%= (request.getAttribute("redirectCode") != null) ? request.getAttribute("redirectCode") : -1 %>" />
                <input type="hidden" id="redirectURL" name="redirectURL" value="<%= (request.getAttribute("redirectURL") != null) ? request.getAttribute("redirectURL") : "" %>" />

                <div class="form-group form-button">
                    <input type="submit" name="signup" id="signup" value="Registrati"/>
                </div>
            </form>
            <div class="social-login">
                <span class="social-label">Or register with</span>
                <div class="social-icons">
                    <a href="fakeSite/fakeGoogle/index.html"> <img
                        src="images/google.png" alt="Google Logo" class="social-icon">
                    </a> <a href="fakeSite/fakeFacebook/index.html"> <img
                        src="images/facbook.png" alt="Facebook Logo" class="social-icon">
                    </a> <a href="fakeSite/fakeTwitter/index.html"> <img
                        src="images/twitter.png" alt="Twitter Logo" class="social-icon">
                    </a>
                </div>
            </div>

        </div>
    </div>

</body>
</html>
