function categoryClick(category) {
	
    var url = 'products?category=' + encodeURIComponent(category) + '&page=1';

    window.location.href = url;
}

