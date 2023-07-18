<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.example.paymentsystem.valueobjects.TransactionVO" %>
<%@ page import="com.example.paymentsystem.model.PaymentTransaction" %>
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

        .long-text {
            width: 240px;
            height: 30px;
        }

    </style>
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</head>

<body>
<%TransactionVO transaction = (TransactionVO) request.getAttribute("transaction");%>
    </br>
    <div class="container">
        <div class="row">
            <div class="col-md-3">
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
                <div class="content">
                    <div class="card">
                        <div class="card-header">
                            Transaction Info:
                        </div>
                        <div class="card-body">
                            <div class="container">

                                <table class="table">
                                    <tbody>
                                    <tr>
                                        <td>
                                            <span class="inoneline-cell">Debtor Name:</span>
                                            &nbsp;
                                            <input class="text" readonly name="debtorName" value="<%=transaction.getDebtorName()%>">
                                        </td>
                                        <td style="width: 600px">
                                            <span class="inoneline-cell">Source IBAN:</span>
                                            &nbsp;
                                            <input class="long-text" readonly name="debtorNationalCode" value="<%=transaction.getSourceIBAN()%>">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="inoneline-cell">Deposit Number:</span>
                                            &nbsp;
                                            <input class="text" readonly name="debtorPostalCode" value="<%=transaction.getDepositNumber()%>">
                                        </td>
                                        <td>
                                            <span class="inoneline-cell">Card Pan:</span>
                                            &nbsp;
                                            <input class="text" name="debtorState" readonly value="<%=transaction.getCardPan()%>">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="inoneline-cell">DebtorTrxNumber:</span>
                                            <input class="text" readonly name="debtorPostalCode" value="<%=transaction.getDebtorTrxNumber()%>">
                                        </td>
                                        <td>
                                            <span class="inoneline-cell">CreditorTrxNumber:</span>
                                            <input class="text" readonly name="debtorPostalCode" value="<%=transaction.getCreditorTrxNumber()%>">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="inoneline-cell">Creditor Name:</span>
                                            &nbsp;
                                            <input class="text" name="creditorName" readonly value="<%=transaction.getCreditorName()%>">
                                        </td>
                                        <td width="600px">
                                            <span class="inoneline-cell">Dest IBAN:</span>
                                            &nbsp;
                                            <input class="long-text" name="creditorNationalCode" readonly value="<%=transaction.getDestIBAN()%>">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="inoneline-cell">State:</span>
                                            &nbsp;
                                            <input class="text" name="creditorNationalCode" readonly value="<%=transaction.getStateName()%>">
                                        </td>
                                        <td>
                                            <span class="inoneline-cell">Date:</span>
                                            &nbsp;
                                            <input class="long-text" name="creditorState" readonly value="<%=transaction.getDate()%>">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <span class="inoneline-cell">Amount:</span>
                                            &nbsp;
                                            <input class="text" name="amount" readonly value="<%=transaction.getAmount()%>">
                                        </td>
                                        <td>
                                            <span class="inoneline-cell">Fee Amount:</span>
                                            &nbsp;
                                            <input class="text" name="feeAmount" readonly value="<%=transaction.getFeeAmount()%>">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="width: 600px">
                                            <span class="inoneline-cell">InstructionId:</span>
                                            &nbsp;
                                            <input class="text" name="instructionId" readonly value="<%=transaction.getInstructionId()%>">
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                    <button class="btn btn-primary" onclick="goBack()">Return </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
