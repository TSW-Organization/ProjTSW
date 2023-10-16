//FUNZIONE PER FINESTRA DI LOGIN
  // Funzione per aprire la finestra modale e caricare la login.jsp
/*
function openModal(modalId, pageUrl) {
    var modal = document.getElementById(modalId);
    modal.style.display = "block";
  
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            modal.innerHTML = xhr.responseText;
        }
    };
    xhr.open("GET", pageUrl, true);
    xhr.send();
}
*/
// Funzione per chiudere la finestra modale
function closeModal() {
	window.location.href = "/WorldCrafters/home";
}

//Invalidare la sessione lato client
function invalidateSession() {
	window.sessionStorage.clear();
}


//Controlli del form di login
$(document).ready(function () {
    // Aggiungi un listener per l'evento di cambio nei campi di input
    $('input[data-validation]').on('input', function () {
        var validationType = $(this).data('validation');
        var value = $(this).val().trim();
        var isValid = false;

        // Aggiungi qui le tue regole di validazione per ogni campo
        switch (validationType) {
            case 'email':
                isValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value); // Valida l'indirizzo email
                break;
            case 'password':
				isValid = value!=='';
				break;
            default:
                isValid = true; // Se non è specificato alcun tipo di validazione, è valido
        }

        // Aggiungi o rimuovi la classe 'error' in base alla validità
        if (isValid || $(this)=='') {
            $(this).removeClass('error');
        } else {
            $(this).addClass('error');
        }
            
    });
});