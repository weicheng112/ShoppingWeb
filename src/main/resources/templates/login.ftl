<!DOCTYPE html>
<html lang="zh-tw" >
<head>
  <meta charset="UTF-8">
  <title>Sparkle pin shopping website</title>
  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css'>
    <link rel="stylesheet" href="/static/css/login.css">

</head>
<body>
<!-- partial:index.partial.html -->
<div class="container-fluid"><a class="navbar-brand" href="/">Sparkle pin</a>
<main class="form-signin">
    <h1 class="mb-3">Sparkle pin user login</h1>
    <h1 class="h4 mb-3 fw-normal">Login Page</h1>
    <!--form class="form-signin" method="post" action="/security/login"-->
        <div class="form-floating">
          <input class="form-control" id="username" name="username"/>
          <label for="username">username</label>
        </div>
        <div class="form-floating">
          <input class="form-control" id="password" name="password"type="password"/>
          <label for="password">password</label>
        </div>
        <div class="checkbox mb-3">
          <label>
            <input type="checkbox" value="remember-me"/>
            Stay logged in
          </label>
        </div>
        <button class="w-100 btn btn-lg btn-primary" id="enter">login</button>
    <!--/form-->

</main>
<!-- partial -->
  <script src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.0/js/bootstrap.min.js'></script>
  <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js'></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.6.11/vue.min.js"></script>
  <script  src="/static/js/login.js"></script>
</body>
</html>