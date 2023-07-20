<%@ page import="com.example.paymentsystem.valueobjects.TransactionVO" %>
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

        .inoneline-cell {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .container {
            width: 100%;
            padding-right: 5px;
            padding-left: 5px;
            margin-right: auto;
            margin-left: auto
        }

        .card-body {
            width: 90%;
            height: 10%;
            padding-right: 5px;
            padding-left: 5px;
            margin-right: auto;
            margin-left: auto
        }

    </style>
</head>

<body>
<%TransactionVO transactionVO = (TransactionVO) request.getAttribute("transaction");%>
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
                <div class="card">
                    <div class="card-header">
                        Recent Activity
                    </div>
                    <div class="card-body">
                        <div class="container">
                            <table class="table">
                                <tbody>
                                <tr>
                                    <td>
                                        <h3 class="inoneline-cell"><%=transactionVO.getDescription()%></h3>
                                    </td>
                                    <td>
                                        <input type="hidden">
                                    </td>
                                </tr>
                                <tr class="inoneline-cell">
                                    <td>
                                        <span class="inoneline-cell">DebtorTransactionTRX:</span>
                                        &nbsp;
                                        <input class="text inoneline-cell" disabled value="<%=transactionVO.getDebtorTrxNumber()%>">
                                    </td>
                                    <td>
                                        <span>CreditorTransactionTRX:</span>
                                        &nbsp;
                                        <input class="text" disabled value="<%=transactionVO.getCreditorTrxNumber()%>">
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <a href="/"
                               class="btn btn-primary btn-sm mb-3">
                                Home
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>
