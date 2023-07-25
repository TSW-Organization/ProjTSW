<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	boolean showFooter = false;
	showFooter = (Boolean) request.getAttribute("showFooter"); 
%>

<% if (showFooter==true) { %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Footer</title>
<link rel="stylesheet" type="text/css" href="../styles/footer.css">
</head>
<body>
	<footer onclick="closeAll()">
        <div class="carousel" data-flickity='{ "wrapAround": true }'>
            <div class="carousel-cell cell-1">
                <h1>Chi siamo</h1>
                <p>
                    WorldCrafters è un sito dedicato a promuovere e valorizzare l'artigianato proveniente da tutto il mondo.
                    La nostra missione è quella di connettere gli artigiani talentuosi con gli amanti dell'artigianato, offrendo una piattaforma globale per esporre e acquistare i loro prodotti unici.
                </p>
            </div>
            <div class="carousel-cell cell-2">
                <h1>Vasta selezione di prodotti</h1>
                <p>
                    WorldCrafters offre una vasta gamma di prodotti provenienti da tutto il mondo, tra cui gioielli, abbigliamento, accessori per la casa, oggetti d'arte e molto altro.
                    Ogni prodotto presente sul nostro sito è realizzato a mano da artigiani talentuosi e riflette l'autenticità delle loro culture e tradizioni.
                </p>
            </div>
            <div class="carousel-cell cell-3">
                <h1>Opportunità di vendita</h1>
                <p>
                    Se siete voi stessi artigiani o avete prodotti artigianali unici da vendere, WorldCrafters vi offre la possibilità di 
                    aprire un negozio sul nostro sito e raggiungere una vasta base di clienti interessati.
                </p>
            </div>
        </div>
        
        <div id="info">
            <h1>Social</h1>
            <p>
                (inserire i link ai profili social di WorldCrafters)<br><br>
            </p> 
        </div>
    
        <div id="signature">
            <p>@2023 WorldCrafters</p>
        </div>
    </footer>
</body>
</html>
<% } %>