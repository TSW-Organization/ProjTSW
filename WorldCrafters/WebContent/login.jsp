<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="it">
<head>
	<title>WorldCrafters</title>
	<%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/log-reg.css">
    <script src="scripts/log.js"></script>
    <script src="scripts/script.js"></script>
    
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
                    <div class="password-container">
                        <input type="password" name="password" id="password" placeholder="Password" required />
                        <button class="password-toggle" type="button" onclick="togglePasswordVisibility('password')">
                            <img src="images/hide.png" alt="Show Password" class="show-password" />
                        </button>
                    </div>
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
			</div>
		</div>
	
	</div>
		
</body>
</html>
