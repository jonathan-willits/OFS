<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link rel="shortcut icon" href="images/shoppingcart.png" type="image/x-icon">

  <title>
    OFS - Contact Us
  </title>

  <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
</head>

<body>
  <div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <nav class="navbar navbar-expand-lg custom_nav-container ">
        <a class="navbar-brand" href="home.jsp">
          <span>
            OFS
          </span>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class=""></span>
        </button>

        <div class="collapse navbar-collapse innerpage_navbar" id="navbarSupportedContent">
          <ul class="navbar-nav  ">
            <li class="nav-item ">
              <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="shop.jsp">
                Shop
              </a>
            </li>
            <!-- <li class="nav-item">
              <a class="nav-link" href="why.html">
                Why Us
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="testimonial.html">
                Testimonial
              </a>
            </li> -->
            <li class="nav-item active">
              <a class="nav-link" href="contact.html">Contact Us</a>
            </li>
          </ul>
          <div class="user_option">
            <a href="Login.jsp">
              <i class="fa fa-user" aria-hidden="true"></i>
              <span>
                Login/Sign-up
              </span>
            </a>
            <!-- <a href="">
              <i class="fa fa-shopping-bag" aria-hidden="true"></i>
            </a> -->
                      <!-- shopping cart sidebar section  -->
          <nav id="main-nav">
            <a class="cart-button" href="#">
              <span class="bag-count">3</span>
              <span class="bag-icon">Bag</span>
              <span class="bag-label">View Bag</span>
            </a>
          </nav>
          <aside id="sidebar-cart">
            <main>
              <a href="#" class="close-button"><span class="close-icon">X</span></a>
              <h2>Shopping Bag <span class="count">3</span></h2>
              <ul class="products">
                <li class="product">
                  <a href="#" class="product-link">
                    <span class="product-image">
                      <img src="https://via.placeholder.com/75x50/ffffff/cccccc?text=PHOTO" alt="Product Photo">
                    </span>
                    <span class="product-details">
                      <h3>Very Cool Product One</h3>
                      <span class="qty-price">
                        <span class="qty">
                          <button class="minus-button" id="minus-button-1">-</button>
                          <input type="number" id="qty-input-1" class="qty-input" step="1" min="1" max="1000" name="qty-input" value="1" pattern="[0-9]*" title="Quantity" inputmode="numeric">
                          <button class="plus-button" id="plus-button-1">+</button>
                          <input type="hidden" name="item-price" id="item-price-1" value="12.00">
                        </span>
                        <span class="price">$16.00</span>
                      </span>
                    </span>
                  </a>
                  <a href="#remove" class="remove-button"><span class="remove-icon">X</span></a>
                </li>
                <li class="product">
                  <a href="#" class="product-link">
                    <span class="product-image">
                      <img src="https://via.placeholder.com/75x50/ffffff/cccccc?text=PHOTO" alt="Product Photo">
                    </span>
                    <span class="product-details">
                      <h3>Very Cool Product Two with Long Title</h3>
                      <span class="qty-price">
                        <span class="qty">
                          <button class="minus-button" id="minus-button-1">-</button>
                          <input type="number" id="qty-input-2" class="qty-input" step="1" min="1" max="1000" name="qty-input" value="1" pattern="[0-9]*" title="Quantity" inputmode="numeric">
                          <button class="plus-button" id="plus-button-1">+</button>
                          <input type="hidden" name="item-price" id="item-price-2" value="12.00">
                        </span>
                        <span class="price">$28.00</span>
                      </span>
                    </span>
                  </a>
                  <a href="#remove" class="remove-button"><span class="remove-icon">X</span></a>
                </li>
                <li class="product">
                  <a href="#" class="product-link">
                    <span class="product-image">
                      <img src="https://via.placeholder.com/75x50/ffffff/cccccc?text=PHOTO" alt="Product Photo">
                    </span>
                    <span class="product-details">
                      <h3>Very Cool Product Three</h3>
                      <span class="qty-price">
                        <span class="qty">
                          <form action="#" name="qty-form" id="qty-form-1">
                            <button class="minus-button" id="minus-button-1">-</button>
                            <input type="number" id="qty-input-3" class="qty-input" step="1" min="1" max="1000" name="qty-input" value="1" pattern="[0-9]*" title="Quantity" inputmode="numeric">
                            <button class="plus-button" id="plus-button-1">+</button>
                            <input type="hidden" name="item-price" id="item-price-3" value="12.00">
                          </form>
                        </span>
                        <span class="price">$12.00</span>
                      </span>
                    </span>
                  </a>
                  <a href="#remove" class="remove-button"><span class="remove-icon">X</span></a>
                </li>
              </ul>
              <div class="totals">
                <div class="subtotal">
                  <span class="label">Subtotal:</span> <span class="amount">$54.00</span>
                </div>
              </div>
              <div class="action-buttons">
                <a class="view-cart-button" href="#">Cart</a>
                <a class="checkout-button" href="checkout.jsp">Checkout</a>
              </div>
            </main>
          </aside>
          <div id="sidebar-cart-curtain"></div>
          <!-- end shopping cart sidebar section  -->
            <form class="form-inline ">
              <button class="btn nav_search-btn" type="submit">
                <i class="fa fa-search" aria-hidden="true"></i>
              </button>
            </form>
          </div>
        </div>
      </nav>
    </header>
    <!-- end header section -->

  </div>
  <!-- end hero area -->

  <!-- contact section -->

  <section class="contact_section layout_padding">
    <div class="container px-0">
      <div class="heading_container ">
        <h2 class="">
          Contact Us
        </h2>
      </div>
    </div>
    <div class="container container-bg">
      <div class="row">
        <!-- <div class="col-lg-7 col-md-6 px-0">
          <div class="map_container">
            <div class="map-responsive">
              <iframe src="https://www.google.com/maps/embed/v1/place?key=AIzaSyA0s1a7phLN0iaD6-UE7m4qP-z21pH0eSc&q=Eiffel+Tower+Paris+France" width="600" height="300" frameborder="0" style="border:0; width: 100%; height:100%" allowfullscreen></iframe>
            </div>
          </div>
        </div> -->
        <div class="col-md-6 col-lg-5 px-0">
          <form action="#">
            <div>
              <input type="text" placeholder="Name" />
            </div>
            <div>
              <input type="email" placeholder="Email" />
            </div>
            <div>
              <input type="text" placeholder="Phone" />
            </div>
            <div>
              <input type="text" class="message-box" placeholder="Message" />
            </div>
            <div class="d-flex ">
              <button>
                SEND
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </section>

  <!-- end contact section -->

  <!-- info section -->

  <section class="info_section  layout_padding2-top">
    <div class="social_container">
      <div class="social_box">
        <a href="">
          <i class="fa fa-facebook" aria-hidden="true"></i>
        </a>
        <a href="">
          <i class="fa fa-twitter" aria-hidden="true"></i>
        </a>
        <a href="">
          <i class="fa fa-instagram" aria-hidden="true"></i>
        </a>
        <a href="">
          <i class="fa fa-youtube" aria-hidden="true"></i>
        </a>
      </div>
    </div>
    <div class="info_container ">
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-lg-3">
            <h6>
              ABOUT US
            </h6>
            <p>
              Your Neighborhood Organic Market Online
            </p>
          </div>
          <div class="col-md-6 col-lg-3">
            <div class="info_form ">
              <h5>
                Weekly Savings
              </h5>
              <form action="#">
                <input type="email" placeholder="Enter your email">
                <button>
                  Subscribe
                </button>
              </form>
            </div>
          </div>
          <div class="col-md-6 col-lg-3">
            <h6>
              NEED HELP
            </h6>
            <p>
              For inquiry and assistance, please send us a message.
            </p>
          </div>
          <div class="col-md-6 col-lg-3">
            <h6>
              CONTACT US
            </h6>
            <div class="info_link-box">
              <a href="">
                <i class="fa fa-map-marker" aria-hidden="true"></i>
                <span> Two Washington Square, San Jose, CA 95192 </span>
              </a>
              <a href="">
                <i class="fa fa-phone" aria-hidden="true"></i>
                <span> +1 (408) 123-4567 </span>
              </a>
              <a href="">
                <i class="fa fa-envelope" aria-hidden="true"></i>
                <span> OFS@OFS.com </span>
              </a>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- footer section -->
    <footer class=" footer_section">
      <div class="container">
        <p>
          &copy; <span id="displayYear"></span> All Rights Reserved By
          <a href="https://html.design/">OFS</a>
        </p>
      </div>
    </footer>
    <!-- footer section -->

  </section>

  <!-- end info section -->


  <script src="js/jquery-3.4.1.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js">
  </script>
  <script src="js/custom.js"></script>

</body>

</html>