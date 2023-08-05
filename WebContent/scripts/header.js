// Dati di esempio, puoi sostituirli con i tuoi dati o caricarli da un'API
const dati = [
  'Apple',
  'Banana',
  'Cherry',
  'Date',
  'Grape',
  'Lemon',
  'Mango',
  'Orange',
  'Pineapple',
  'Strawberry',
  'Appli',
  'Applo',
  'Applu'
];


window.addEventListener("DOMContentLoaded", function() {
    const searchInput = document.getElementById('searchInput');
    searchInput.addEventListener('input', updateSearchResults);
    searchInput.addEventListener('blur', clearSearchResults);
});

window.addEventListener("DOMContentLoaded", function() {
    const searchButton = document.getElementById('searchButton');
    searchButton.addEventListener('click', performSearch);
});


function performSearch() {
  const searchText = searchInput.value.toLowerCase();
  const filteredResults = dati.filter(item => item.toLowerCase().includes(searchText));
  displayResults(filteredResults);
}


function updateSearchResults() {
    const searchResults = document.getElementById('searchResults');
    searchResults.innerHTML = '';
    
    const searchInput = document.getElementById('searchInput');
    const searchText = searchInput.value.toLowerCase();
    const filteredResults = dati.filter(item => item.toLowerCase().includes(searchText));
    displayResults(filteredResults);
}


function displayResults(results) {
	const searchResults = document.getElementById('searchResults');
	
	searchResults.innerHTML = '';
	results.forEach(result => {
		const li = document.createElement('li');
		li.textContent = result;
		searchResults.appendChild(li);
	});
}

function clearSearchResults() {
    const searchResults = document.getElementById('searchResults');
    searchResults.innerHTML = '';
}