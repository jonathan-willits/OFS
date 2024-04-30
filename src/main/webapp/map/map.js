// Initialize and add the map
let map;
let places_service;
let directions_service;

const OFS = {lat: 37.33385107758178, lng: -121.88189126149555};
const dest_waypoints = [];


async function initMap() {
    // The location of Uluru

    // Request needed libraries.
    //@ts-ignore
    const {Map} = await google.maps.importLibrary("maps");
    const {AdvancedMarkerElement} = await google.maps.importLibrary("marker");
    const {Place} = await google.maps.importLibrary("places");

    // The map, centered at OFS location
    map = new Map(document.getElementById("map"), {
        zoom: 12,
        center: OFS,
        mapId: "DEMO_MAP_ID",
    });

    // The marker, positioned at OFS
    const marker = new AdvancedMarkerElement({
        map: map,
        position: OFS,
        title: "OFS",
    });


    const dests = ["635 Coleman Ave", "1300 W San Carlos St", "1649 Naglee Ave"];
    const markers = [];

    places_service = new google.maps.places.PlacesService(map);
    directions_service = new google.maps.DirectionsService();
    const directions_renderer = new google.maps.DirectionsRenderer();
    directions_renderer.setMap(map);
    for (let i = 0; i < dests.length; i++) {
        const request = {location: OFS, radius: 500, query: dests[i]};
        places_service.textSearch(request, function (results, status) {
            if (status === google.maps.places.PlacesServiceStatus.OK) {
                    dest_waypoints.push({location: results[0].name});
                markers.push(new AdvancedMarkerElement({
                    map: map,
                    position: results[0].geometry.location,
                    title: results[0].name
                }));
            }
            // Check if all destinations have been processed
            if (dest_waypoints.length === dests.length) {
                directions_service.route({
                    origin: OFS,
                    destination: OFS,
                    waypoints: dest_waypoints,
                    optimizeWaypoints: true,
                    travelMode: google.maps.TravelMode.DRIVING,
                }).then((response) => {
                    const rob = new AdvancedMarkerElement({map:map, position: OFS, title:"robot"})
                    directions_renderer.setDirections(response);
                    console.log(response)
                    //move(rob, response.routes[0], 0 ,0);
                });
            }
        });

    }

    // helper function to move robot marker
    function move(yourmarker, yourroute, i, j) {
        while (yourroute.legs.length > i) {
            while(yourroute.legs[i].steps.length > j) {
                yourmarker.location = (yourroute.legs[i].steps[j].start_point);
                window.setTimeout(function () {
                move(yourmarker, yourroute, i, j + 1);
            }, 500);
                move(yourmarker, yourroute, i + 1, 0)
            }
            i++;
        }
    }
}

window.initMap = initMap;