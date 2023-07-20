<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Card Request</title>
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

        <!-- Main Content -->
        <div class="col-md-9">
            <h1>New Card Request</h1>
            <hr>
            <form:form action="addCardPan" modelAttribute="updateDepositVO">
                <div class="form-group">
                    <label for="customerNumber">Customer Number:</label>
                    <input type="text" class="form-control" name="customerNumber" id="customerNumber" placeholder="Enter customer number">
                </div>
                <div class="form-group">
                    <label for="depositNumber">Deposit Number:</label>
                    <input type="text" class="form-control" name="depositNumber" id="depositNumber" placeholder="Enter deposit number">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </div>
</div>
</body>

</html>
