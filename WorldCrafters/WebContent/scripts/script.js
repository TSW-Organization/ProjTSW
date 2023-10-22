//script per validazione password
function validateForm() {
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirm-password').value;

            if (password !== confirmPassword) {
                document.getElementById('password-error').innerText = 'Le password non corrispondono.';
                return false;
            } else {
                document.getElementById('password-error').innerText = '';
            }

            if (!validatePassword(password)) {
                document.getElementById('password-error').innerText = 'La password non rispetta i criteri di complessità.';
                return false;
            } else {
                document.getElementById('password-error').innerText = '';
            }

            return true;
        }

//script per visibilità
    function togglePasswordVisibility(inputId) {
        const passwordInput = document.getElementById(inputId);
        const passwordToggle = document.querySelector(`#${inputId} + .password-toggle img`);
        
        if (passwordInput.type === "password") {
            passwordInput.type = "text";
            passwordToggle.src = "images/show.png";
        } else {
            passwordInput.type = "password";
            passwordToggle.src = "images/hide.png";
        }
    }

//script per limitare le password
function validatePassword(password) {
    // La password deve avere almeno 8 caratteri
    if (password.length < 8) {
        return false;
    }

    // La password deve contenere almeno una lettera maiuscola
    if (!/[A-Z]/.test(password)) {
        return false;
    }

    // La password deve contenere almeno un numero
    if (!/\d/.test(password)) {
        return false;
    }

    // Altrimenti, la password è valida
    return true;
}

// Controlla se ci sono attributi di reindirizzamento e gestisci il reindirizzamento
function handleRedirect() {
   const redirectCode = parseInt(document.getElementById('redirectCode').value);
    const redirectURL = document.getElementById('redirectURL').value;
    if (redirectCode === 0) {
        alert("Errore: " + document.getElementById('email-error').textContent);
    } else if (redirectCode === 1) {
        window.location.href = redirectURL;
    }
}

// Chiamata alla funzione quando la pagina si carica
window.onload = function() {
    handleRedirect();
};
