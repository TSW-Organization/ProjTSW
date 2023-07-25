// CONTACT
window.onload = function() {
    var form = document.getElementById("contact-form");
    var isFormSubmitted = false;

    form.addEventListener("submit", function() {
        isFormSubmitted = true;
    });

    window.addEventListener("beforeunload", function(event) {
        if (!isFormSubmitted) {
            event.preventDefault();
            event.returnValue = "Sei sicuro di voler lasciare questa pagina? Le modifiche non salvate andranno perse.";
        }
    });

    window.addEventListener("popstate", function(event) {
        if (!isFormSubmitted) {
            event.preventDefault();
            var confirmLeave = confirm("Sei sicuro di voler lasciare questa pagina? Le modifiche non salvate andranno perse.");
            if (confirmLeave) {
                history.back();
            }
        }
    });

    history.pushState(null, null, location.href);
    window.onpopstate = function() {
        history.pushState(null, null, location.href);
    };
};

///////////////////////////////////////////

$(document).ready(function () {
    // Aggiungi un listener per l'evento di cambio nei campi di input
    $('input[data-validation], textarea[data-validation]').on('input', function () {
        var validationType = $(this).data('validation');
        var value = $(this).val().trim();
        var isValid = false;

        // Aggiungi qui le tue regole di validazione per ogni campo
        switch (validationType) {
            case 'name':
                isValid = /^[A-Za-z\s]+$/.test(value); // Consente solo lettere e spazi
                break;
            case 'surname':
                isValid = /^[A-Za-z\s]+$/.test(value); // Consente solo lettere e spazi
                break;
            case 'email':
                isValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value); // Valida l'indirizzo email
                break;
            case 'message':
                isValid = value.length > 0; // Assicura che il messaggio non sia vuoto
                break;
            default:
                isValid = true; // Se non è specificato alcun tipo di validazione, è valido
        }

        // Aggiungi o rimuovi la classe 'error' in base alla validità
        if (isValid) {
            $(this).removeClass('error');
        } else {
            $(this).addClass('error');
        }
    });
});