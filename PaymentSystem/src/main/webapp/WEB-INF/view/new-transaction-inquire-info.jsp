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
                    <li><a href="/card-request">Card Request</a></li>
                    <li><a href="/transactions">Transactions</a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-9">
            <!-- Main content area -->
            <div class="content">
                </br>
                <div class="card">
                    <div class="card-header">
                        Recent Activity
                    </div>
                    <div class="card-body">
                        <div class="container">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Column 1</th>
                                    <th>Column 2</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>Data 1</td>
                                    <td>Data 2</td>
                                </tr>
                                <tr>
                                    <td>Data 3</td>
                                    <td>Data 4</td>
                                </tr>
                                <tr>
                                    <td>Data 5</td>
                                    <td>Data 6</td>
                                </tr>
                                <tr>
                                    <td>Data 7</td>
                                    <td>Data 8</td>
                                </tr>
                                <tr>
                                    <td>Data 9</td>
                                    <td>Data 10</td>
                                </tr>
                                <tr>
                                    <td>Data 11</td>
                                    <td>Data 12</td>
                                </tr>
                                <tr>
                                    <td>Data 13</td>
                                    <td>Data 14</td>
                                </tr>
                                <tr>
                                    <td>Data 15</td>
                                    <td>Data 16</td>
                                </tr>
                                <tr>
                                    <td>Data 17</td>
                                    <td>Data 18</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
