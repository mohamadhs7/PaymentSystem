<%@ page import="com.example.paymentsystem.valueobjects.CustomerVO" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Customers</title>
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
<% List<CustomerVO> customers = (List<CustomerVO>) request.getAttribute("customers"); %>
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
            <h3>Customers List</h3>
            <hr>
            <!--  Add New Project Button -->
            <a href="/new-customer"
               class="btn btn-primary btn-sm mb-3">
                New Customer
            </a>
            <a href="/changeCustomerState"
               class="btn btn-primary btn-sm mb-3">
                Change State
            </a>
            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                <tr>
                    <th>Number</th>
                    <th>Full Name</th>
                    <th>National Code</th>
                    <th>Postal Code</th>
                    <th>Address</th>
                    <th>State</th>
                </tr>
                </thead>
                <tbody>
                <%for (CustomerVO customer : customers) { %>
                <tr>
                    <td><%=customer.getNumber()%>
                    </td>
                    <td><%=customer.getFullName()%>
                    </td>
                    <td><%=customer.getNationalCode()%>
                    </td>
                    <td><%=customer.getPostalCode()%>
                    </td>
                    <td><%=customer.getAddress()%>
                    </td>
                    <td><%=customer.getStateString()%>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

</html>
