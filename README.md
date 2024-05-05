# OFS - a grocery delivery service
Authors: Osayame Erinmwingbovo, Annie Luu, Charlie Nguyen, Jonathan Willits
## About

This project is a grocery delivery service website for a San Jose-based grocery store chain. The site serves as a way 
for grocery store customers to purchase organic food online (e.g. fruits, vegetables, and other grocery items) into a 
virtual shopping cart, pay for it online and have it delivered to their home. The site stores inventory, transaction, 
customer data in MySQL, and includes an employee/admin dashboard view to update/query the inventory and transaction 
database.

## Features include

```
1. Login and Registration, including input validation.
2. Search and browse items.
3. Add to cart.
4. Manage shopping cart.
5. Checkout.
6. View orders history of customers.
7. Update customer/product information.
```

## WIP

1. Mapping service: completed but currently not updating in frontend; 
    Code can be found in map.jsp, map.js
2. Credit card validation, registration validation, and login: completed but not fully integrated into the website.
    Code can be found on the main branch in the same directory as this README.md under files named:

   ```CreditCardValidator```, ```RegistrationValidation```, ```Validation```

## Prerequisites

What things you need to install

```
You need Docker and git installed on your local machine.
If you don't have Docker installed, you can download it from https://www.docker.com/products/docker-desktop
If you don't have git installed, you can download it from https://git-scm.com/downloads
```

## How to run the project

1. Open a terminal and navigate to the directory where you want to clone the project
2. Git clone the project to your local machine

    ```git clone https://github.com/anniebluu/CS160_Project.git```

2. Navigate to the project directory

   ```cd CS160_Project```

3. Open Docker Desktop and make sure it is running
4. If you have MySQL running on your local machine, stop it
   1. By running this commmand for MacOS/Linux
      ```sudo service mysql stop```
   2. By running this command for Windows
      ```net stop mysql```
   This is to prevent any conflicts with the MySQL container that will be running in Docker.
5. Run the following command to start the project
   ```docker-compose up --build```
6. Open a browser and navigate to http://localhost:8080/ to view the website

## how-to video for install/configure/customization/usage ##
Video link:
https://drive.google.com/file/d/1_XwcDng6KE1AfHpxDi58AjypiV3BESJu/view?usp=drive_link

## OFS Users
Admin: ```admin```, password: ```password```

Customer: ```customer```, password: ```password```

## Built With

* [Java](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html) - Oracle Java 16 JDK
* [MySQL](https://www.mysql.com/) - MySQL Database
* [Connector/J](https://dev.mysql.com/downloads/connector/j/) - Connecting to MySQL Database Server
* [Maven](https://maven.apache.org/) - Dependency Management
* [Shoppers - Free Bootstrap 4 HTML5 ecommerece website template](https://themewagon.com/themes/free-bootstrap-4-html5-ecommerece-website-template-shoppers/) - Website Front-end

## License

This project is licensed under the MIT License - see
the [LICENSE.md](https://github.com/truonghoangthuan/jsp-servlet-ecommerce-website/blob/master/LICENSE) for details.
