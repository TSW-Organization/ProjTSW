<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
   	request.setAttribute("showHeader", true);
	request.setAttribute("showFooter", true);
	request.setAttribute("showSidebar", true);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorldCrafters</title>
    <link rel="icon" type="image/x-icon" href="imgs/favicon.ico">
    <link rel="stylesheet" type="text/css" href="styles/contact.css">
    <link rel="stylesheet" type="text/css" href="styles/userbar.css">
    <link rel="stylesheet" type="text/css" href="vendor/flickity.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/font-awesome/css/all.css">
    <script src="vendor/jquery.min.js"></script>
    <script src="vendor/flickity.pkgd.min.js"></script>
</head>
<body>
	
	<%@ include file="header.jsp" %>
    
    <%@ include file="sidebar.jsp" %>
    
    <div id="userbar">
        <ul>
            <li><a href="#">Accedi<br></a></li>
            <li><a href="#">Registrati<br></a></li>
            <li><a href="contact.jsp">Assistenza<br></a></li>
        </ul>
    </div>
    

    <main onclick="closeAll()">
        <div id="background"></div>
        
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
    
	        <form id="contact-form" name="contact-form" method="POST" action="CheckContactForm" novalidate>
	            <div class="form-item">
	                <label for="name">Nome: *</label>
	                <input type="text" name="name" value="<%=name %>" required>
	            </div>
	            <div class="form-item">
	                <label for="surname">Cognome: *</label>
	                <input type="text" name="surname" value="<%=surname %>" required>
	            </div>
	            <div class="form-item">
	                <label for="email">Email: *</label>
	                <input type="email" name="email" value="<%=email %>" required>
	            </div>
	            <div class="form-item">
	                <label for="subject">Oggetto: *</label>
	                <select name="subject" required>
				        <option value="">Seleziona un motivo:</option>
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
	                <textarea name="message" required><%=message %></textarea>
	            </div>
	            <div class="form-item">
	                <input id="submit" type="submit" value="Invia">
	            </div>
	        </form> 
	        
	        <%
	        String error = (String)request.getAttribute("error");
			if(error != null) {
			%>
			<div class="error"><%=error %></div>
			<%
			}
			%>
			
    	</div>
    </main>

	<%@ include file="footer.jsp" %>


    <script src="scripts/script.js"></script>
    <script src="scripts/contact.js"></script>
    
</body>
</html>