$(document).ready(function () {
    // Aggiungi un listener per l'evento di cambio nei campi di input
    $('input[data-validation], textarea[data-validation]').on('input', function () {
        let validationType = $(this).data('validation');
        let value = $(this).val().trim();
        let isValid = false;

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
        if (isValid || value=='') {
            $(this).removeClass('error');
        } else {
            $(this).addClass('error');
        }
    });
});