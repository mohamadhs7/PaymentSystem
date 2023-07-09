<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Dashboard</title>
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
</br>
<div class="container">
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
            <!-- Main content area -->
            <div class="content">
                <h2>Welcome to the Dashboard</h2>
                <p>This is a sample dashboard page.</p>
                <div class="card">
                    <div class="card-header">
                        Recent Activity
                    </div>
                    <div class="card-body">
                        <ul>
                            <li>User A logged in</li>
                            <li>New order received</li>
                            <li>Product X out of stock</li>
                        </ul>
                    </div>
                </div>
            </br>
                <div class="card">
                    <div class="card-header">
                        Statistics
                    </div>
                    <div class="card-body">
                        <p>Total Users: 100</p>
                        <p>Total Orders: 50</p>
                        <p>Revenue: $5000</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
