// Initialize and add the map
let map;
let places_service;

const OFS = { lat:37.33385107758178, lng:-121.88189126149555 };
async function initMap() {
  // The location of Uluru

  // Request needed libraries.
  //@ts-ignore
  const { Map } = await google.maps.importLibrary("maps");
  const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");
  const {Place} = await google.maps.importLibrary("places");

  // The map, centered at OFS location
  map = new Map(document.getElementById("map"), {
    zoom: 12,
    center: OFS,
    mapId: "DEMO_MAP_ID",
  });

  // The marker, positioned at Uluru
  const marker = new AdvancedMarkerElement({
    map: map,
    position: OFS,
    title: "OFS",
  });

  const dest = document.getElementById("address").innerText
  const request = {
    location: OFS,
    radius: 500,
    query: dest,
  };

  const place_service = new google.maps.places.PlacesService(map);
  const directions_service = new google.maps.DirectionsService();
  const directions_renderer = new google.maps.DirectionsRenderer();
  directions_renderer.setMap(map);
  place_service.textSearch(request, function(results, status) { //look up place of address string
    if (status === google.maps.places.PlacesServiceStatus.OK) {
      // add destination marker
      const m1 = new AdvancedMarkerElement({
        map: map,
        position: results[0].geometry.location,
        title: results[0].name
      });
      directions_service  // get directions
          .route({origin: OFS, destination: results[0].geometry.location, travelMode: 'WALKING'})
          .then(response => {
            directions_renderer.setDirections(response) // add directions to map
          });
      map.setCenter(results[0].geometry.location);

    }
  });
}
initMap();