<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OFS - Register</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: "poppins", sans-serif;
            background-color: #f8f9fa;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
            margin: 0;
        }

        .container {
            margin-top: 100px;
        }

        .card {
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .card-header {
            background-color: #8fbc8f;
            color: #ffffff;
            text-align: center;
            border-bottom: none;
            border-radius: 10px 10px 0 0;
        }

        .card-body {
            padding: 30px;
        }

        .card-footer{
          background-color: #8fbc8f;
          text-align: center;
          border: none;
          height: 60px;
      }

        .btn-success {
            background-color: #28a745;
            border: none;

        }

        .btn-success:hover {
            border-radius: 1px;
            background-color: transparent;
            border: 1px solid #228b22;
            color: #228b22;
        }

        main {
            flex: 1;
        }

        footer {
            background-color: #343a40;
            color: #ffffff;
            text-align: center;
            padding: 10px;
        }

         /* Style all input fields */
        input {
        width: 100%;
        padding: 12px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
        margin-top: 6px;
        margin-bottom: 16px;
        }

        /* Style the submit button */
        input[type=submit] {
        background-color: #04AA6D;
        color: white;
        }

        /* Style the container for inputs */
        /* .container {
        background-color: #f1f1f1;
        padding: 20px;
        } */

        /* The message box is shown when the user clicks on the password field */
        #message {
        display:none;
        background: #f1f1f1;
        color: #000;
        position: relative;
        padding: 20px;
        margin-top: 10px;
        }

        #message p {
        padding: 10px 35px;
        font-size: 16px;
        }

        /* Add a green text color and a checkmark when the requirements are right */
        .valid {
        color: green;
        }

        .valid:before {
        position: relative;
        left: -35px;
        /* content: "&#10004;"; */
        content: "✔";

        }

        /* Add a red text color and an "x" icon when the requirements are wrong */
        .invalid {
        color: red;
        }

        .invalid:before {
        position: relative;
        left: -35px;
        /* content: "&#10006;"; */
        content: "✖";
        } 
    </style>
    <!-- Custom styles for this template -->
    <!-- <link href="css/style.css" rel="stylesheet" /> -->
</head>

<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="#">OFS</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="home.jsp">Home</a>
                    </li>
                    <!-- <li class="nav-item">
                        <a class="nav-link" href="Login.jsp">Profile</a>
                    </li> -->
                </ul>
            </div>
        </nav>
    </header>
    <!-- <header class="header_section">
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
              </a> -->
              <!-- <a href="">
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
      </header> -->

    <main>
        <div class="container">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-header">
                        <h2>OFS - Register</h2>
                    </div>
                    <div class="card-body">
                        <!-- <form method="post" onsubmit="return showSuccessMessage()"> -->
                          <form name="RegisterServlet" method="POST" action="registerServlet">
                            <div class="form-group">
                                <label for="email">Email Address:</label>
                                <input type="email" class="form-control" name="email" id="email" required>
                            </div>
                            <div class="form-group">
                                <label for="username">Username:</label>
                                <input type="text" class="form-control" name="username" id="username" required>
                            </div>
                            <div class="form-groupo">
                                <label for="password">Password:</label>
                                <!-- <input type="password" class="form-control" name="password" id="password" required> -->
                                <input type="password" class="form-control" id="psw" name="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
                            </div>
                            <div class="form-group">
                                <label for="confirmPassword">Confirm Password:</label>
                                <input type="password" class="form-control" name="confirmPassword" id="confirmPassword"
                                    required>
                            </div>
                            <button type="submit" class="btn btn-success btn-block">Register</button>
                        </form>
                        <div id="success-message" class="alert alert-success d-none" role="alert">
                            Congrats, your account has been made!
                            <a href="question.jsp" title="Go to question page">Go to question page</a>
                        </div>
                        <div id="message">
                            <p>Password must contain the following:</p>
                            <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
                            <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
                            <p id="number" class="invalid">A <b>number</b></p>
                            <p id="length" class="invalid">Minimum <b>8 characters</b></p>
                          </div>
                        <div class="mt-3">
                            <p class="text-center">Already have an account?<a href="Login.jsp">Login</a></p>
                        </div>
                    </div>
                    <div class="card-footer"></div>
                </div>
            </div>
        </div>
    </main>

    <footer class="bg-dark text-white text-center py-3">
        <p>&copy; 2024 OFS. All rights reserved.</p>
    </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        function showSuccessMessage() {
            // Display the success message
            var successMessage = document.getElementById('success-message');
            successMessage.classList.remove('d-none');

            // Prevent the form from submitting
            return false;
        }
    </script>
    <script>
        var myInput = document.getElementById("psw");
        var letter = document.getElementById("letter");
        var capital = document.getElementById("capital");
        var number = document.getElementById("number");
        var length = document.getElementById("length");
        
        // When the user clicks on the password field, show the message box
        myInput.onfocus = function() {
          document.getElementById("message").style.display = "block";
        }
        
        // When the user clicks outside of the password field, hide the message box
        myInput.onblur = function() {
          document.getElementById("message").style.display = "none";
        }
        
        // When the user starts to type something inside the password field
        myInput.onkeyup = function() {
          // Validate lowercase letters
          var lowerCaseLetters = /[a-z]/g;
          if(myInput.value.match(lowerCaseLetters)) {
            letter.classList.remove("invalid");
            letter.classList.add("valid");
          } else {
            letter.classList.remove("valid");
            letter.classList.add("invalid");
        }
        
          // Validate capital letters
          var upperCaseLetters = /[A-Z]/g;
          if(myInput.value.match(upperCaseLetters)) {
            capital.classList.remove("invalid");
            capital.classList.add("valid");
          } else {
            capital.classList.remove("valid");
            capital.classList.add("invalid");
          }
        
          // Validate numbers
          var numbers = /[0-9]/g;
          if(myInput.value.match(numbers)) {
            number.classList.remove("invalid");
            number.classList.add("valid");
          } else {
            number.classList.remove("valid");
            number.classList.add("invalid");
          }
        
          // Validate length
          if(myInput.value.length >= 8) {
            length.classList.remove("invalid");
            length.classList.add("valid");
          } else {
            length.classList.remove("valid");
            length.classList.add("invalid");
          }
        }
        </script>
</body>
</html>