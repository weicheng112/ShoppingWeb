<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Sparkle pin shopping website</title>
  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css'><link rel="stylesheet" href="/static/css/style.css">

</head>
<body>
    <h1>Checkout</h1>

    <!-- Display cart items and total amount -->
    <table>
        <thead>
            <tr>
                <th>Product</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>



    <!-- Shipping information form -->
    <h1>Shipping Information</h1>


    <form action="/checkout/process" method="post">
    <div class="form-group">
        <label for="name">Full Name</label>
        <input type="text" id="name" name="name" class="form-control" required>
    </div>
    <div class="form-group">
        <label for="address">Shipping Address</label>
        <textarea id="address" name="address" class="form-control" rows="4" required></textarea>
    </div>

    <button type="submit">Proceed to Checkout</button>
    </form>
</body>

<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script><script  src="/static/js/script.js"></script>
</html>