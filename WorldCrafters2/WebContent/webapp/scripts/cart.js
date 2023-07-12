document.addEventListener('DOMContentLoaded', function() {
	var goBackLink = document.getElementById('goBack');
    
    goBackLink.addEventListener('click', function(event) {
    	//event.preventDefault(); // Evita il comportamento predefinito del link
    	goBack(); // Chiama la funzione per tornare indietro
  	});
});

function goBack() {
    var previousPage = document.referrer;
    window.location.href = previousPage; // Imposta l'URL della pagina precedente come destinazione
}