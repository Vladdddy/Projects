function toggleActiveClass(element) {
    element.classList.toggle('active');
}





/* <>Code from another source</> */

window.addEventListener('scroll', function () {
    var ids = ['image1', 'image2', 'estate',
        'digitale', 'contemporaneo', 'biblioteca',
        'ricola', 'educazione', 'image1_mostre',
        'image2_mostre', 'image3_mostre', 'cont1_visita',
        'cont2_visita', 'cont3_visita'];

    function toggleVisibility(elementId) {
        var element = document.getElementById(elementId);
        if (element) {
            var position = element.getBoundingClientRect();
            console.log('Element:', elementId, 'Position:', position);
            if (position.top < window.innerHeight && position.bottom > 0) {
                element.classList.add('show');
                console.log('Element shown:', elementId);
            } else {
                element.classList.remove('show');
                console.log('Element hidden:', elementId);
            }
        } else {
            console.warn('Element not found:', elementId);
        }
    }

    ids.forEach(toggleVisibility);
});
window.dispatchEvent(new Event('scroll'));












const CONFIGURATION = {
    "locations": [
        { "title": "Museo MAGA", "address1": "Via Egidio de Magri", "address2": "1, 21013 Gallarate VA, Italia", "coords": { "lat": 45.65416860199153, "lng": 8.797967864418048 }, "placeId": "ChIJZQuAYOyJhkcRVllvlfIFMWw" }
    ],
    "mapOptions": { "center": { "lat": 38.0, "lng": -100.0 }, "fullscreenControl": true, "mapTypeControl": false, "streetViewControl": false, "zoom": 4, "zoomControl": true, "maxZoom": 17, "mapId": "" },
    "mapsApiKey": "AIzaSyDuQqFgn5mduggHNhjIe83d1JoUrIXJs5o",
    "capabilities": { "input": true, "autocomplete": true, "directions": false, "distanceMatrix": true, "details": false, "actions": false }
};