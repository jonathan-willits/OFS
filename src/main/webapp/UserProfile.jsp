<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Profile</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    /* body {
      font-family: 'Arial', serif;
      margin: 0;
      padding: 0;
      background: linear-gradient(to right, #fcfcfb, #faf9f9);
      color: #333;
    }
    header {
      background: linear-gradient(to right, #228b22, #ffffff);
      color: #ecf0f1;
      padding: 1em;
      text-align: center;
    }
    nav {
      background: linear-gradient(to right, #f6f7f6, #228b22);
      padding: 10px;
      text-align: center;
    }
    nav a {
      color: #ecf0f1;
      text-decoration: none;
      margin: 0 10px;
      font-weight: bold;
      transition: color 0.3s ease-in-out;
    }
    nav a:hover {
      color: #228b22;
    }
    section {
      max-width: 800px;
      margin: 20px auto;
      background: linear-gradient(to right, #228b22, #f8f7f7);
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    }
    img {
      border-radius: 50%;
      max-width: 100%;
      height: auto;
    }
    h2 {
      color: #2c3e50;
    }
    h3 {
      color: #FFD700;
    }
    p {
      color: #555;
    }
    ul {
      list-style-type: none;
      padding: 0;
    }
    li {
      margin-bottom: 8px;
      color: #2c3e50;
    }
    .animate {
      animation: fadeIn 1s ease-in-out;
    }
    @keyframes fadeIn {
      from {
        opacity: 0;
        transform: translateY(-20px);
      }
      to {
        opacity: 1;
        transform: translateY(0);
      }
    } */
  </style>
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
    OFS
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
  <!-- <header>
    <h1 class="display-4">User Profile</h1>
  </header> -->
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
            <a href="">
              <i class="fa fa-user" aria-hidden="true"></i>
              <span>
                Login
              </span>
            </a>
            <a href="">
              <i class="fa fa-shopping-bag" aria-hidden="true"></i>
            </a>
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
  <nav>
  </nav>
  <section id="profile" class="animate">
    <img src="https://via.placeholder.com/150" alt="User Photo" class="rounded-circle">
    <h2 class="text-dark">Jane Doe</h2>
    <p class="text-dark font-italic"> App User</p>
    <p class="text-dark">Member Since: January 2023</p>
    <p class="text-dark">Contact: jane.doe@example.com</p>
  </section>
  <section id="orders" class="animate">
    <h2 class="text-dark">Orders</h2>
    <ul>
      <li>Order #1: Delivered on March 1, 2024</li>
      <li>Order #2: Scheduled for March 5, 2024</li>
    </ul>
  </section>
  <section id="payment" class="animate">
    <h2 class="text-dark">Payment</h2>
    <p class="text-dark">Payment Method: Credit Card</p>
    <p class="text-dark">Card Number: 1234 5678 9012 3456</p>
    <p class="text-dark">Expires: 05/25</p>
  </section>
  <section id="settings" class="animate">
    <h2 class="text-dark">Settings</h2>
    <p class="text-dark">Notification Preferences: <a href="mailto:jane.doe@example.com">Email</a></p>
    <p class="text-dark">Language: English</p>
  </section>
  <section id="contact" class="animate">
    <h2 class="text-dark">Contact</h2>
    <p class="text-dark">Email: jane.doe@example.com</p>
    <p class="text-dark">Phone: +1 (555) 123-4567</p>
    <p class="text-dark">Address: 123 Grocery St, San Jose, CA, 95112</p>
  </section>
</body>
</html>