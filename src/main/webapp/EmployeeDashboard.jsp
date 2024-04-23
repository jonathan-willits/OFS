<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Grocery Store Dashboard</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    /* Your custom styles here */
  </style>
</head>
<body>
  <!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Grocery Store Dashboard</a>
  </nav>

  <!-- Employee Section -->
  <section id="employees" class="container mt-4">
    <h2 class="text-dark">Employees</h2>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Employee Name</th>
          <th scope="col">Inventory Items Fulfilled</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>John Doe</td>
          <td>Apples, Oranges, Bananas</td>
        </tr>
        <tr>
          <td>Jane Smith</td>
          <td>Milk, Eggs, Bread</td>
        </tr>
        <!-- Add more rows for other employees -->
      </tbody>
    </table>
  </section>

  <!-- Inventory Section -->
  <section id="inventory" class="container mt-4">
    <h2 class="text-dark">Inventory</h2>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Item Name</th>
          <th scope="col">Quantity Left</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>Apples</td>
          <td>50</td>
        </tr>
        <tr>
          <td>Oranges</td>
          <td>30</td>
        </tr>
        <!-- Add more rows for other items -->
      </tbody>
    </table>
  </section>

  <!-- Orders Section -->
  <section id="orders" class="container mt-4">
    <h2 class="text-dark">Orders</h2>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Order Number</th>
          <th scope="col">Status</th>
          <th scope="col">User Name</th>
          <th scope="col">User Address</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>001</td>
          <td>Processing</td>
          <td>UserRandom23</td>
          <td>123 Main St, Anytown, USA</td>
        </tr>
        <tr>
          <td>002</td>
          <td>Delivered</td>
          <td>RandomUser34</td>
          <td>456 Elm St, Othertown, USA</td>
        </tr>
        <!-- Add more rows for other orders -->
      </tbody>
    </table>
  </section>

</body>
</html>
