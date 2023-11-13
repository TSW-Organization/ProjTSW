// Contenuto di editorScript.js
var currentPage = 1;
var totalPages = 1;

function loadEditorProducts(page) {
    // Effettua una richiesta asincrona al server utilizzando Ajax
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "EditorServlet?page=" + page, true);

    // Callback da eseguire quando la richiesta è completata
    xhr.onload = function () {
        if (xhr.status === 200) {
            var jsonResponse = JSON.parse(xhr.responseText);
            displayEditorProducts(jsonResponse);
            updateEditorPaginationControls(page);
        }
    };

    // Invia la richiesta al server
    xhr.send();
}

function displayEditorProducts(products) {
    var tableBody = document.getElementById("editorProductTableBody");
    tableBody.innerHTML = ""; // Pulisce la tabella prima di aggiungere nuovi dati

    for (var i = 0; i < products.length; i++) {
        var product = products[i];
        var row = tableBody.insertRow(i);

        // Aggiungi qui le celle della tabella con le informazioni del prodotto
        var cellId = row.insertCell(0);
        cellId.innerHTML = product.id;

        var cellName = row.insertCell(1);
        cellName.innerHTML = product.name;

        var cellPrice = row.insertCell(2);
        cellPrice.innerHTML = product.price;

        var cellSeller = row.insertCell(3);
        cellSeller.innerHTML = product.seller;

        // Aggiungi la cella per il pulsante di modifica
        var cellEdit = row.insertCell(4);
        cellEdit.innerHTML = '<button onclick="editProduct(' + product.id + ')">Modifica</button>';
        // Aggiungi altre colonne secondo necessità
    }
}

function updateEditorPaginationControls(page) {
    currentPage = page;
    // Aggiorna il numero della pagina corrente nella pagina
    document.getElementById("editorCurrentPage").innerHTML = page;
    // Aggiungi altre logiche per gestire la visualizzazione delle frecce/disabilitazione
}

// Carica i prodotti per l'editor per la prima volta all'avvio della pagina
loadEditorProducts(currentPage);

function editProduct(productId) {
    // Reindirizza l'utente alla pagina di modifica con l'ID del prodotto
    window.location.href = 'editProduct.jsp?id=' + productId;
}
