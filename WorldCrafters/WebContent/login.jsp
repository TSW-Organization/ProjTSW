<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/log-reg.css">
    <script src="scripts/log.js"></script>
</head>
<body>
	
	<%
		String email = (String)request.getAttribute("email");
		if(email == null) email = "";
	%>
	
	
	<!-- Aggiungi il wrapper per la finestra di login -->
	<div class="modal-overlay">
		<div class="modal-content">
			<button class="close-button" onclick="closeModal()">X</button>
			<!-- Aggiorna il testo del pulsante di chiusura -->
			<h2 class="form-title">Sign in</h2>
			<!-- Aggiorna il testo del titolo -->
			<form method="post" action="login" id="login-form">
				<div class="form-group">
					<label for="email">Email:</label> 
					<input type="text" name="email" id="email" required value="<%=email %>" data-validation="email" placeholder="La tua email" />
					<div id="errorMessageEmail"></div>
				</div>
				<div class="form-group">
					<label for="password">Password:</label> 
					<input type="password" name="password" required id="password" data-validation="password" placeholder="Password" />
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
					<input type="submit" name="signin" id="signin" value="Accedi" disabled/>
					<!-- Aggiorna il testo del pulsante di accesso -->
				</div>
			</form>
			<div class="social-login">
				<span class="social-label">Oppure accedi con:</span>
				<!-- Aggiorna il testo dell'etichetta dei social login -->
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
