<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
<link rel="stylesheet" type="text/css" href="styles/style.css">
</head>
<body>
	<!-- Aggiungi il wrapper per la finestra di login -->
	<div class="modal-overlay">
		<div class="modal-content">
            <button class="close-button" onclick="closeModal()">X</button>
			<!-- Aggiorna il testo del pulsante di chiusura -->
			<h2 class="form-title">Sign in</h2>
			<!-- Aggiorna il testo del titolo -->
			<form method="post" action="login" id="login-form">
				<div class="form-group">
					<label for="email">E-mail:</label> <!-- Aggiorna il testo dell'etichetta -->
					<input type="text" name="email" id="email" placeholder="La tua e-mail" /> <!-- Aggiorna il placeholder -->
				</div>
				<div class="form-group">
					<label for="password">Password:</label> <input type="password"
						name="password" id="password" placeholder="Password" />
				</div>
				<div class="form-group form-button">
					<input type="submit" name="signin" id="signin" value="Accedi" />
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

	<script>
	function closeModal() {
		  var modal = document.getElementById("loginModal");
		  modal.style.display = "none";
		}
	</script>

</body>
</html>
