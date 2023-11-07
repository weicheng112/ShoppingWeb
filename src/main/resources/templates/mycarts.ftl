<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Sparkle pin－MY CART</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.0/css/bootstrap.min.css'><link rel="stylesheet" href="/static/css/mycarts.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="navbar navbar-light bg-light navbar-expand-lg">
  <div class="container-fluid"><a class="navbar-brand" href="/">Sparkle pin </a>
    <div class="nav-item">MY CART</div>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarText">
      <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" active="active" aria-current="page" href="/mycarts">Cart</a></li>
        <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false" href="#">Member</a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li>
              <button class="dropdown-item" id="modified">modify data</button>
            </li>
            <li>
              <button class="dropdown-item" href="#">order</button>
            </li>
            <li>
              <button class="dropdown-item" id="check"><a href="/register">register</a>
              <button class="dropdown-item" id="check"><a href="/login">login</a></button>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</div>
<section id="mycarts">
  <div class="container" id="info">
    <div class="row">
      <div class="col-3">
        <div class="title">Product Name</div>
        <div class="img">image</div>
      </div>
      <div class="col-2">Price
        <div class="price">$100</div>
      </div>
      <div class="col-3">Num
        <div class="num" id="num">1</div>
      </div>
      <div class="col-2">Total
        <div class="totalprice">1000</div>
      </div>
      <div class="col-2">
        <button class="btn btn-danger">Delete</button>
      </div>
    </div>
  </div>
</section>

<a href="/checkout">Checkout</a>
<!-- partial -->
  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script><script  src="/static/js/mycarts.js"></script>

</body>
</html>