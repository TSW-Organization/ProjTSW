<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <title>WorldCrafters</title>
    <%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/contact-success.css">
</head>
<body>
	
	<%@ include file="templates/header.jsp" %>
    <%@ include file="templates/sidebar.jsp" %>
    <%@ include file="templates/userbar.jsp" %>
	<%@ include file="templates/presentationBg.jsp" %>
    

    <main onclick="closeAll()">
        <div id="background"></div>
        
        <div id="messageContainer">
        	<h1>Messaggio inviato con successo. Ti risponderemo al più presto</h1>
        	<br><br>
        	<a href="home">Torna alla home</a>
        </div>
    </main>

	<%@ include file="templates/footer.jsp" %>

</body>
</html>