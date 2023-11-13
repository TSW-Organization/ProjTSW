<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="it">
<head>
	<title>WorldCrafters</title>
	<%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/log-reg.css">
    <script src="scripts/reg.js"></script>
    <script src="scripts/script.js"></script>
    
</head>
<body>
	
	<%
		String firstName = (String)request.getAttribute("firstName");
		if(firstName == null) firstName = "";
		
		String lastName = (String)request.getAttribute("lastName");
		if(lastName == null) lastName = "";
		
		String email = (String)request.getAttribute("email");
		if(email == null) email = "";
		
	%>
	
	
	<div class="modal-overlay">
		<div class="modal-content">
			<button class="close-button" onclick="closeModal()">X</button>
			<h2 class="form-title">Sign up</h2>
			<form method="post" action="registration" id="signup-form">
				<div class="form-group">
					<label for="firstName">First name:</label> 
					<input type="text" name="firstName" id="firstName" value="<%= firstName %>" data-validation="firstName" placeholder="First name" required />
					<div id="errorMessageFirstName"></div>
				</div>
				<div class="form-group">
					<label for="lastName">Last name:</label> 
					<input type="text" name="lastName" id="lastName" value="<%= lastName %>" data-validation="lastName" placeholder="Last name" required />
					<div id="errorMessageLastName"></div>
				</div>
				<div class="form-group">
					<label for="email">Email:</label> 
					<input type="email" name="email" id="email" value="<%= email %>" data-validation="email" placeholder="Your Email" required />
					<div id="errorMessageEmail"></div>
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

				<%
		        String error = (String)request.getAttribute("error");
				if(error != null) {
				%>
					<div class="error-message"><%=error %></div>
					<br/>
				<%
				}
				%>
				<div class="form-group form-button">
					<input type="submit" name="signup" id="signup" value="Registrati"/>
				</div>
			</form>
		</div>
	</div>

	
</body>
</html>
