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