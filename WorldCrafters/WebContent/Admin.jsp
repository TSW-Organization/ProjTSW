<!DOCTYPE html>
<html lang="it">
<head>
    <%@ include file="templates/head.html" %>
    <link rel="stylesheet" type="text/css" href="styles/admin.css"> <!-- Un foglio di stile separato per l'amministrazione -->
</head>
<body>
    <%@ include file="templates/header.jsp" %>
    <%@ include file="templates/sidebar.jsp" %>
    <%@ include file="templates/userbar.jsp" %>
    
    <div class="admin-content">
        <h1>Area Amministratore</h1>
        
        <!-- Riepilogo degli Ordini Recenti -->
        <div class="admin-section">
            <h2>Riepilogo Ordini Recenti</h2>
            <table>
                <tr>
                    <th>Numero Ordine</th>
                    <th>Data</th>
                    <th>Cliente</th>
                    <th>Importo Totale</th>
                </tr>
                <c:forEach items="${recentOrders}" var="order">
                    <tr>
                        <td>${order.orderNumber}</td>
                        <td>${order.date}</td>
                        <td>${order.customerName}</td>
                        <td>${order.totalAmount}</td>
                    </tr>
                </c:forEach>
            </table>
            <button onclick="location.href='admin?action=viewAllOrders'">Visualizza Tutti gli Ordini</button>
        </div>
        
        <!-- Statistiche di Vendita -->
        <div class="admin-section">
            <h2>Statistiche di Vendita Mensili</h2>
            <canvas id="salesChart" width="400" height="200"></canvas>
        </div>
        <script>
            // Codice JavaScript per generare il grafico delle statistiche di vendita
            // Utilizza una libreria come Chart.js per questo scopo.
        </script>
        
        <!-- Gestione dei Produttori -->
        <div class="admin-section">
            <h2>Gestione Produttori</h2>
            <table>
                <tr>
                    <th>Nome Produttore</th>
                    <th>Origine</th>
                    <th>Azioni</th>
                </tr>
                <c:forEach items="${manufacturers}" var="manufacturer">
                    <tr>
                        <td>${manufacturer.name}</td>
                        <td>${manufacturer.origin}</td>
                        <td>
                            <button onclick="location.href='admin?action=editManufacturer&id=${manufacturer.id}'">Modifica</button>
                            <button onclick="location.href='admin?action=deleteManufacturer&id=${manufacturer.id}'">Elimina</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <button onclick="location.href='admin?action=addManufacturer'">Aggiungi Produttore</button>
        </div>
    </div>
    
    <%@ include file="templates/footer.jsp" %>
</body>
</html>
