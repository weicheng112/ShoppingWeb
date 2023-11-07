<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Sparkle pin shopping website－Modify Information (Account )</title>
  <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.0/css/bootstrap.min.css'><link rel="stylesheet" href="/static/css/user_modified.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="navbar navbar-light bg-light navbar-expand-lg">
  <div class="container-fluid"><a class="navbar-brand">Sparkle pin</a>
    <div class="nav-item">Modify Information</div>
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
<section id="reg">
  <div class="container">
    <form class="row">
      <div class="col-12">
        <h4>Modify information</h4>
      </div>
      <div class="col-md-6" id="username">
        <div class="title">Username</div>
        <input name="username" value="data loading...." required="required" disabled="disabled"/>
        <button id="edit" type="button">Edit </button>
      </div>
      <div class="col-md-6" id="gender">
        <div class="title">Gender </div>
        <input class="form-check-input" type="radio" name="gender" value="1"/>
        <label class="form-check-label" for="flexRadioDefault1">male</label>
        <input class="form-check-input" type="radio" name="gender" value="0"/>
        <label class="form-check-label" for="flexRadioDefault1">female</label>
      </div>
      <div class="col-md-6" id="phone">
        <div class="title">phone</div>
        <input name="phone" value="data loading...." required="required" disabled="disabled"/>
        <button id="edit" type="button">Edit </button>
      </div>
      <div class="col-md-6" id="email">
        <div class="title">email</div>
        <input name="email" value="data loading...." required="required" disabled="disabled"/>
        <button id="edit" type="button">Edit </button>
      </div>
      <div class="col-12">
        <button class="btn" id="save" type="button">Save</button>
      </div>
    </form>
  </div>
</section>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.0/js/bootstrap.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script><script  src="/static/js/user_modified.js"></script>

</body>
</html>