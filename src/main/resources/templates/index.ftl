<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Sparkle pin shopping website</title>
  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css'><link rel="stylesheet" href="/static/css/style.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="navbar navbar-light bg-light navbar-expand-lg">
  <div class="container-fluid"><a class="navbar-brand" href="/">Sparkle pin</a>
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
<ul class="nav nav-pills">
  <li class="nav-item"><a class="nav-link" aria-current="page" href="#">Active</a></li>
  <li class="nav-item dropdown"><a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Dropdown</a>
    <ul class="dropdown-menu">
      <li><a class="dropdown-item" href="#">Action</a></li>
      <li><a class="dropdown-item" href="#">Another action</a></li>
      <li><a class="dropdown-item" href="#">Something else here</a></li>
      <li>
        <hr class="dropdown-divider"/>
      </li>
      <li><a class="dropdown-item" href="#">Separated link</a></li>
    </ul>
  </li>
  <li class="nav-item"><a class="nav-link" href="#">Link</a></li>
  <li class="nav-item"><a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a></li>
</ul>
<section id="hot_product">
  <div class="container">
    <div class="header">Popular Product!</div>
    <div class="d-flex row" id="hot-list">
      <div class="content col-md-2">
        <div class="title">#title </div>
        <div class="price">#price</div><a class="d-flex justify-content-end" href="">Explore Product</a>
      </div>
    </div>
  </div>
</section>
<!-- partial -->
  <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script  src="/static/js/script.js"></script>

</body>
</html>