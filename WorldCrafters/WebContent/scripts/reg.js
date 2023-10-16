function closeModal() {
	window.location.href = "/WorldCrafters/home";
}

$(document).ready(function () {
    // Aggiungi un listener per l'evento di cambio nei campi di input
    $('input[data-validation]').on('input', function () {
        var validationType = $(this).data('validation');
        var value = $(this).val().trim();
        var isValid = false;

        // Aggiungi qui le tue regole di validazione per ogni campo
        switch (validationType) {
            case 'firstName':
                isValid = /^[A-Za-z\s]+$/.test(value); // Consente solo lettere e spazi
                break;
            case 'lastName':
                isValid = /^[A-Za-z\s]+$/.test(value); // Consente solo lettere e spazi
                break;
            case 'email':
                isValid = /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value); // Valida l'indirizzo email
                break;
            case 'password':
                // La password deve avere almeno 8 caratteri
                // Deve contenere almeno un numero e almeno un simbolo
                isValid = value.length >= 8 && /[A-Z]/.test(value) && /\d/.test(value) && /[!@#$%^&*]/.test(value);
                break;
            case 'confirmPassword':
                var password = $('#password').val().trim();
                // Confronta la "Conferma Password" con la password
                isValid = value === password;
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