<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OFS - Bananas, 3lb</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/style.css">
    <style>
        body { font-family: Arial, sans-serif; margin: 0; padding: 0; }
        /* .hero_area { background-color: #f2f2f2; } */
        .header_section .navbar { padding-top: 15px; padding-bottom: 15px; margin-bottom: 0; }
        .slider_section { text-align: center; padding: 20px 0; margin-top: 0; }
        .container { display: flex; max-width: 1200px; margin: auto; padding: 20px; align-items: flex-start; }
        .product-image { flex: 1; text-align: center; }
        .product-details { flex: 2; padding-left: 20px; }
        .product-title { font-size: 24px; margin-bottom: 10px; }
        .product-price { font-weight: bold; color: #C00; margin-bottom: 20px; }
        img { max-width: 100%; height: auto; }
        .add-to-cart { background-color: #228b22; color: white; padding: 10px 20px; border: none; cursor: pointer; font-size: 18px; margin-top: 20px; }
        .product-description { margin-top: 20px; }
    </style>
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" />
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
            <li class="nav-item active">
              <a class="nav-link" href="shop.jsp">
                Shop
              </a>
            </li>
            <!-- <li class="nav-item">
              <a class="nav-link" href="why.html">
                Why Us
              </a>
            </li> -->
            <!-- <li class="nav-item">
              <a class="nav-link" href="testimonial.html">
                Testimonial
              </a>
            </li> -->
            <li class="nav-item">
              <a class="nav-link" href="contact.jsp">Contact Us</a>
            </li>
          </ul>
          <div class="user_option">
            <a href="login.jsp">
              <i class="fa fa-user" aria-hidden="true"></i>
              <span>
                Login/Signup
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

    <section class="slider_section">
    <div class="slider_container">
        <div class="container-fluid">
            <div class="row">
                <div class="col"></div>
                    <div class="detail-box">
                        <h1>
                            <a href="fruits.html" class="slider-button small-button">Fruits</a>
                            <a href="vegetables.html" class="slider-button small-button">Vegetables</a>
                            <a href="meat.html" class="slider-button small-button">Meat</a>
                            <a href="beverages.html" class="slider-button small-button">Beverages</a>
                        </h1>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>



</div>

<div class="container">
    <div class="product-image">
        <img src="images/banana.png" alt="Bananas, 3lb">
    </div>
    <div class="product-details">
        <div class="product-title">Bananas, 3lb</div>
        <div class="product-price">$2.29</div>
        <div class="product-description">
            <p>Organic bananas for anyone to enjoy. Perfect for a healthy breakfast.</p>
        </div>
        <button class="add-to-cart">Add to Cart</button>
    </div>
</div>

<script src="js/jquery-3.4.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/custom.js"></script>

</body>
</html>
