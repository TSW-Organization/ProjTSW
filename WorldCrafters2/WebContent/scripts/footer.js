// FOOTER
// Creazione carousel
document.addEventListener("DOMContentLoaded", function() {
    var elem = document.querySelector('.main-carousel');
	var flkty = new Flickity( elem, {
		// options
		cellAlign: 'center',
		contain: true,
		wrapAround: true
	});
});