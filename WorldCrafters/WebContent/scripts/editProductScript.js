// Contenuto di editProductScript.js
function updateProduct(productId) {
    // Recupera i valori dai campi del modulo di modifica
    var name = document.getElementById("productName").value;
    var price = document.getElementById("productPrice").value;
    var seller = document.getElementById("productSeller").value;
    var category = document.getElementById("productCategory").value;
    var quantity = document.getElementById("productQuantity").value;
    var description = document.getElementById("productDescription").value;

    // Effettua una richiesta asincrona al server utilizzando Ajax
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "EditProductServlet", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    // Callback da eseguire quando la richiesta è completata
    xhr.onload = function () {
        if (xhr.status === 200) {
            // Gestisci la risposta del server
            var response = JSON.parse(xhr.responseText);
            if (response.success) {
                // Operazione di modifica completata con successo
                alert("Prodotto modificato con successo!");
                // Puoi reindirizzare l'utente a una pagina di conferma o visualizzazione dettagli
                window.location.href = 'product-details.jsp?productId=' + productId;
            } else {
                // Operazione di modifica fallita
                alert("Errore durante la modifica del prodotto.");
            }
        }
    };

    // Invia la richiesta al server con i dati del prodotto da modificare
    xhr.send("productId=" + productId +
             "&name=" + encodeURIComponent(name) +
             "&price=" + price +
             "&seller=" + encodeURIComponent(seller) +
             "&category=" + category +
             "&quantity=" + quantity +
             "&description=" + encodeURIComponent(description));
}
