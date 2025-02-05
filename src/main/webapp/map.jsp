<html lang="en">
<head>
    <title>Map</title>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>

    <link rel="stylesheet" type="text/css" href="./css/style.css"/>
    <script type="module" src="/map.js"></script>
</head>

<body>
<%--    <div id="msg"> Your order is en route to </div>--%>
    <strong class="text-black">Your order is en route to:</strong>
<%--    <div id="address">678 Elm St</div>--%>

    <!--The div element for the map -->
    <div id="map" style = "height: 800px; width: 1110px;"></div>

    <!-- prettier-ignore -->
    <script>(g => {
        var h, a, k, p = "The Google Maps JavaScript API", c = "google", l = "importLibrary", q = "__ib__",
            m = document, b = window;
        b = b[c] || (b[c] = {});
        var d = b.maps || (b.maps = {}), r = new Set, e = new URLSearchParams,
            u = () => h || (h = new Promise(async (f, n) => {
                await (a = m.createElement("script"));
                e.set("libraries", [...r] + "");
                for (k in g) e.set(k.replace(/[A-Z]/g, t => "_" + t[0].toLowerCase()), g[k]);
                e.set("callback", c + ".maps." + q);
                a.src = `https://maps.${c}apis.com/maps/api/js?` + e;
                d[q] = f;
                a.onerror = () => h = n(Error(p + " could not load."));
                a.nonce = m.querySelector("script[nonce]")?.nonce || "";
                m.head.append(a)
            }));
        d[l] ? console.warn(p + " only loads once. Ignoring:", g) : d[l] = (f, ...n) => r.add(f) && u().then(() => d[l](f, ...n))
    })
    ({key: "AIzaSyAouqA0zIg_JawP291Qd3GVWfc8Jkde7CA", v: "weekly"});</script>

    <script async
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAouqA0zIg_JawP291Qd3GVWfc8Jkde7CA&loading=async&libraries=places&callback=initMap">
    </script>
</body>
</html>