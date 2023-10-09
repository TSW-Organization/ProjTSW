<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/log-reg.css">
    <script src="scripts/reg.js"></script>
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
				</div>
				<div class="form-group">
					<label for="lastName">Last name:</label> 
					<input type="text" name="lastName" id="lastName" value="<%= lastName %>" data-validation="lastName" placeholder="Last name" required />
				</div>
				<div class="form-group">
					<label for="email">Email:</label> 
					<input type="email" name="email" id="email" value="<%= email %>" data-validation="email" placeholder="Your Email" required />
				</div>
				<div class="form-group">
					<label for="password">Password:</label> 
					<input type="password"name="password" id="password" placeholder="Password" required />
				</div>
				<div class="form-group">
					<label for="confirmPassword">Confirm Password:</label> 
					<input type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirm Password" required />
				</div>
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
