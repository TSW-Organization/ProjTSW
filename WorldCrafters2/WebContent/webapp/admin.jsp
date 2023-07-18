<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>WorldCrafters</title>
    <link rel="icon" type="image/x-icon" href="imgs/favicon.ico">
    <link rel="stylesheet" type="text/css" href="styles/userbar.css">
    <link rel="stylesheet" type="text/css" href="vendor/flickity.min.css">
    <link rel="stylesheet" type="text/css" href="vendor/font-awesome/css/all.css">
    <link rel="stylesheet" type="text/css" href="styles/style.css">
    <link rel="stylesheet" type="text/css" href="styles/home.css">
    <script src="vendor/jquery.min.js"></script>
    <script src="vendor/flickity.pkgd.min.js"></script>
    <script src="scripts/script.js"></script>
    <style>
        /* Stili per i bottoni delle funzioni simulate */
        .function-button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 10px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        .function-button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp"%>
    <%@ include file="sidebar.jsp"%>
    <div id="userbar">
        <ul>
            <li>
                <button onclick="redirectToHome()">Exit</button>
            </li>
        </ul>
    </div>
    <div id="presentationContainer">
        <p>Fatti ispirare dalle tradizioni<br>artigianali di tutto<br>il mondo</p>
    </div>
    <main onclick="closeAll()">
        <div id="showcaseContainer">
            <h1>Admin Page</h1><br>
            <p>Benvenuto nella pagina di amministrazione. Di seguito alcune funzioni simulate:</p>
            <div>
                <button class="function-button" onclick="addNewProduct()">Aggiungi Nuovo Prodotto</button>
                <button class="function-button" onclick="manageUsers()">Gestisci Utenti</button>
                <button class="function-button" onclick="viewOrders()">Visualizza Ordini</button>
                <!-- Altre funzioni di amministrazione simulate -->
            </div>
        </div>
    </main>
    <%@ include file="footer.jsp" %>

    <!-- JavaScript per il reindirizzamento alla home.jsp -->
    <script>
        function redirectToHome() {
            window.location.href = "home";
        }

        // Funzioni di amministrazione simulate (nessuna azione reale)
        function addNewProduct() {
            alert("Aggiungi un nuovo prodotto: Funzione simulata!");
        }

        function manageUsers() {
            alert("Gestisci utenti: Funzione simulata!");
        }

        function viewOrders() {
            alert("Visualizza ordini: Funzione simulata!");
        }
    </script>
</body>
</html>
