<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles/guestUserbar.css">
    <script src="scripts/sidebar-userbar.js"></script>
    <script src="scripts/log-reg.js"></script>
</head>
<body>
	<div id="userbar">
        <ul>
            <li>
                <button onclick="openModal('loginModal', 'log.jsp')">login</button>
                <!-- Finestra modale di login -->
                <div id="loginModal" class="modal"></div>
            </li>
            <li>
                <button onclick="openModal('registerModal', 'register.jsp')">register</button>
                <!-- Finestra modale di registrazione -->
                <div id="registerModal" class="modal"></div>
            </li>
            <li><a href="contact.jsp">Assistenza<br></a></li>
        </ul>
    </div>
</body>
</html>