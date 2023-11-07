<!DOCTYPE html>
<html>
<head>

</head>
<body>
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
</html>