<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    </style>
</head>

<body>
<%TransactionVO transactionVO = (TransactionVO) request.getAttribute("transaction");%>

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
                        Transaction Inquire Info
                    </div>
                    <div class="card-body">
                        <div class="container">

                            <table class="table">
                                <tbody>
                                <tr>
                                    <td colspan="2">
                                        <h5>Source Info :</h5>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="inoneline-cell">Name:</span>
                                        &nbsp;
                                        <input class="text" readonly name="debtorName" value="<%=transactionVO.getDebtorName()%>">
                                    </td>
                                    <td style="width: 600px">
                                        <span class="inoneline-cell">National Code:</span>
                                        &nbsp;
                                        <input class="text" readonly name="debtorNationalCode" value="<%=transactionVO.getDebtorNationalCode()%>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="inoneline-cell">Postal Code:</span>
                                        &nbsp;
                                        <input class="text" readonly name="debtorPostalCode" value="<%=transactionVO.getDebtorPostalCode()%>">
                                    </td>
                                    <td>
                                        <span class="inoneline-cell">State:</span>
                                        &nbsp;
                                        <input class="text" name="debtorState" readonly value="<%=transactionVO.getDebtorState()%>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br>
                                        <h5>Destination Info :</h5>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="inoneline-cell">Name:</span>
                                        &nbsp;
                                        <input class="text" name="creditorName" readonly value="<%=transactionVO.getCreditorName()%>">
                                    </td>
                                    <td width="600px">
                                        <span class="inoneline-cell">National Code:</span>
                                        &nbsp;
                                        <input class="text" name="creditorNationalCode" readonly value="<%=transactionVO.getCreditorNationalCode()%>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="inoneline-cell">Postal Code:</span>
                                        &nbsp;
                                        <input class="text" name="creditorNationalCode" readonly value="<%=transactionVO.getCreditorPostalCode()%>">
                                    </td>
                                    <td>
                                        <span class="inoneline-cell">State:</span>
                                        &nbsp;
                                        <input class="text" name="creditorState" readonly value="<%=transactionVO.getCreditorState()%>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <br>
                                        <h5>Transaction Info :</h5>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <span class="inoneline-cell">Amount:</span>
                                        &nbsp;
                                        <input class="text" name="amount" readonly value="<%=transactionVO.getAmount()%>">
                                    </td>
                                    <td>
                                        <span class="inoneline-cell">Fee Amount:</span>
                                        &nbsp;
                                        <input class="text" name="feeAmount" readonly value="<%=transactionVO.getFeeAmount()%>">
                                    </td>
                                </tr>
                                <tr>
                                    <td style="width: 600px">
                                        <span class="inoneline-cell">InstructionId:</span>
                                        &nbsp;
                                        <input class="text" name="instructionId" readonly value="<%=transactionVO.getInstructionId()%>">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <a href="/payTransaction"
                                           class="btn btn-primary btn-sm mb-3">
                                            Pay
                                        </a>
                                        <input type="hidden" name="customerNumber" value="<%=transactionVO.getCustomerNumber()%>">
                                        <input type="hidden" name="identifier" value="<%=transactionVO.getIdentifier()%>">
                                        <input type="hidden" name="destIBAN" value="<%=transactionVO.getDestIBAN()%>">
                                        <input type="hidden" name="debitType" value="<%=transactionVO.getDebitType()%>">
                                    </td>
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
