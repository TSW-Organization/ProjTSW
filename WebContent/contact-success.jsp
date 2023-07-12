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
    <link rel="stylesheet" type="text/css" href="styles/contact-success.css">
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
        
        <div id="messageContainer">
        	<h1>Messaggio inviato con successo. Ti risponderemo al più presto</h1>
        	<br><br>
        	<a href="home">Torna alla home</a>
        </div>
    </main>

	<%@ include file="footer.jsp" %>


    <script src="scripts/script.js"></script>

</body>
</html>