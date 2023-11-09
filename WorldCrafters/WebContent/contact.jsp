<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="it">
<head>
   	<title>WorldCrafters</title>
    <%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/contact.css">
    <script src="scripts/contact.js"></script>
</head>
<body>
	
	<%@ include file="templates/header.jsp" %>
    <%@ include file="templates/sidebar.jsp" %>
    <%@ include file="templates/userbar.jsp" %>
	<%@ include file="templates/presentationBg.jsp" %>
    
    
    <main onclick="closeAll()">
        
        <div id="contactContainer">
	        <h1>Contattaci</h1>
	          
	        <%
			String name = (String)request.getAttribute("name");
			if(name == null) name = "";
			
			String surname = (String)request.getAttribute("surname");
			if(surname == null) surname = "";
			
			String email = (String)request.getAttribute("email");
			if(email == null) email = "";
			
			String subject = (String)request.getAttribute("subject");
			if(subject == null) subject = "";
			
			String message = (String)request.getAttribute("message");
			if(message == null) message = "";
			%>
    
	        <form id="contact-form" name="contact-form" method="POST" action="CheckContactForm">
	            <div class="form-item">
	                <label for="name">Nome: *</label>
	                <input type="text" name="name" value="<%=name %>" required data-validation="name">
	            </div>
	            <div class="form-item">
	                <label for="surname">Cognome: *</label>
	                <input type="text" name="surname" value="<%=surname %>" required data-validation="surname">
	            </div>
	            <div class="form-item">
	                <label for="email">Email: *</label>
	                <input type="email" name="email" value="<%=email %>" required data-validation="email">
	            </div>
	            <div class="form-item">
	                <label for="subject">Oggetto: *</label>
	                <select name="subject" required>
				        <option value="" disabled selected>Seleziona un motivo:</option>
				        <option value="general" <%= subject.equals("general") ? "selected" : "" %>>Domanda generale</option>
				        <option value="product" <%= subject.equals("product") ? "selected" : "" %>>Informazioni sul prodotto</option>
				        <option value="billing" <%= subject.equals("billing") ? "selected" : "" %>>Questioni di fatturazione</option>
				        <option value="technical" <%= subject.equals("technical") ? "selected" : "" %>>Assistenza tecnica</option>
				        <option value="partnership" <%= subject.equals("partnership") ? "selected" : "" %>>Opportunità di partnership</option>
				        <option value="feedback" <%= subject.equals("feedback") ? "selected" : "" %>>Feedback e suggerimenti</option>
				        <option value="other" <%= subject.equals("other") ? "selected" : "" %>>Altro</option>
				    </select>
	            </div>
	            <div class="form-item">
	                <label for="message">Messaggio: *</label>
	                <textarea name="message" required data-validation="message"><%=message %></textarea>
	            </div>
	            <div class="form-item">
	                <input id="submit" type="submit" value="Invia">
	            </div>
	        </form> 
	        
	        <%
	        String error = (String)request.getAttribute("error");
			if(error != null) {
			%>
			<div class="error-message"><%=error %></div>
			<%
			}
			%>
			
    	</div>
    </main>

	<%@ include file="templates/footer.jsp" %>
	

</body>
</html>