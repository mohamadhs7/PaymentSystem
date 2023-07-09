<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Customer</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .sidebar {
            background-color: #f2f2f2;
            padding: 10px;
        }

        .sidebar ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        .sidebar li {
            margin-bottom: 5px;
        }

        .sidebar li a {
            display: block;
            padding: 8px 16px;
            text-decoration: none;
            color: #333;
        }

        .sidebar li a:hover {
            background-color: #ddd;
        }
    </style>
</head>

<body>
<div class="container">
    </br>
    <div class="row">
        <div class="col-md-3">
            <!-- Sidebar -->
            <div class="sidebar">
                <h2>Menu</h2>
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/customers">Customers</a></li>
                    <li><a href="/deposits">Deposits</a></li>
                    <li><a href="/transactions">Transactions</a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-9">
            <h1>Register Customer</h1>
        <form:form action="addCustomer" modelAttribute="customer">
                <div class="form-group">
                    <label for="firstName">First Name:</label>
                    <input type="text" class="form-control" name="firstName" id="firstName" placeholder="Enter first name">
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name:</label>
                    <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Enter last name">
                </div>
                <div class="form-group">
                    <label for="nationalCode">National Code:</label>
                    <input type="text" class="form-control" name="nationalCode" id="nationalCode" placeholder="Enter national code">
                </div>
                <div class="form-group">
                    <label for="postalCode">Postal Code:</label>
                    <input type="text" class="form-control" name="postalCode" id="postalCode" placeholder="Enter postal code">
                </div>
                <div class="form-group">
                    <label for="address">Address:</label>
                    <input type="text" class="form-control"  name="address" id="address" placeholder="Enter address">
                </div>
                <button type="submit" class="btn btn-primary">Register</button>
        </form:form>
        </div>
    </div>
</div>
</body>

</html>
