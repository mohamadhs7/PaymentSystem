<%@ page import="com.example.paymentsystem.valueobjects.CustomerVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.paymentsystem.valueobjects.DepositVO" %>
<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Deposits</title>
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

        .inoneline-cell {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

    </style>
</head>
<body>
<% List<DepositVO> deposits = (List<DepositVO>) request.getAttribute("deposits");
    DecimalFormat decimalFormat = new DecimalFormat("###,###");%>
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
            <h3>Deposits List</h3>
            <hr>
            <!--  Add New Project Button -->
            <a href="/new-deposit"
               class="btn btn-primary btn-sm mb-3">
                New Deposit
            </a>
            <a href="/changeDepositState"
               class="btn btn-primary btn-sm mb-3">
                Change State
            </a>
            <a href="/card-request"
               class="btn btn-primary btn-sm mb-3">
                Card Request
            </a>
            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                <tr>
                    <th rowspan="2">Number</th>
                    <th class="inoneline-cell">Customer Number</th>
                    <th>Balance</th>
                    <th>Card Pan</th>
                    <th>IBAN</th>
                    <th>State</th>
                </tr>
                </thead>
                <tbody>
                <%for (DepositVO deposit : deposits) { %>
                <tr>
                    <td><%=deposit.getNumber()%>
                    </td>
                    <td align="center"><%=deposit.getCustomerNumber()%>
                    </td>
                    <td><%=decimalFormat.format(deposit.getBalance())%>
                    </td>
                    <td><%=deposit.getCardPan()%>
                    </td>
                    <td><%=deposit.getIBAN()%>
                    </td>
                    <td><%=deposit.getStateName()%>
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
