<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Customer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <h1>Register Customer</h1>
    <form>
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" id="firstName" placeholder="Enter first name">
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" class="form-control" id="lastName" placeholder="Enter last name">
        </div>
        <div class="form-group">
            <label for="nationalCode">National Code:</label>
            <input type="text" class="form-control" id="nationalCode" placeholder="Enter national code">
        </div>
        <div class="form-group">
            <label for="customerNumber">Customer Number:</label>
            <input type="text" class="form-control" id="customerNumber" placeholder="Enter customer number">
        </div>
        <div class="form-group">
            <label for="openAmount">Open Amount:</label>
            <input type="number" class="form-control" id="openAmount" placeholder="Enter open amount">
        </div>
        <div class="form-group">
            <label for="balance">Balance:</label>
            <input type="number" class="form-control" id="balance" placeholder="Enter balance">
        </div>
        <button type="submit" class="btn btn-primary">Register</button>
    </form>
</div>
</body>

</html>
