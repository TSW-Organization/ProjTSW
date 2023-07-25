// CART
function goBack() {
    var previousPage = document.referrer;
    window.location.href = previousPage; // Imposta l'URL della pagina precedente come destinazione
}




function addToCart() {
    
    var urlParams = new URLSearchParams(window.location.search);
	var productId = urlParams.get('id');
    
    $.ajax({
        type: "POST",
        url: "add-to-cart",
        data: { productId: productId },
        success: function(response) {
            updateCart();
        },
        error: function(xhr, status, error) {
            console.log("Errore durante l'aggiunta al carrello: " + error);
        }
    });
}

function updateCart() {
    $.ajax({
        type: "GET",
        url: "cart",
        dataType: "json",
        success: function(response) {
            
            var cartItems = JSON.parse(response);

            // Ora puoi utilizzare cartItems per aggiornare il contenuto del carrello nel DOM
            var cartList = $("#cartList");
            cartList.empty();
            if (cartItems.length > 0) {
                $.each(cartItems, function(index, item) {
                    // Utilizza solo il campo "name" del prodotto
                    cartList.append("<li>" + item.name + "</li>");
                    cartList.append("<li>" + item.price + "</li>");
                });
            } else {
                cartList.append("<li>Il carrello è vuoto</li>");
            }
        },
        error: function(xhr, status, error) {
            console.log("Errore durante il recupero dei prodotti dal carrello: " + error);
        }
    });
}