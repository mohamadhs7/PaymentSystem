<%@ page import="com.example.paymentsystem.model.enums.DebitTypeEnum" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Transaction</title>
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

    <script>
        function formatNumber(value) {
            // Remove any existing commas from the input value
            var cleanedValue = value.replace(/,/g, '');

            // Format the value with commas
            var formattedValue = Number(cleanedValue).toLocaleString();

            // Set the formatted value in the input box
            document.getElementById('amountString').value = formattedValue;

            // Use the cleaned value (without commas) for further processing or sending to the system
            sendToSystem(cleanedValue)
        }

        function sendToSystem(value) {
            var amount = document.getElementById("amount");
            amount.value = value;
        }
    </script>
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
                    <li><a href="/card-request">Card Request</a></li>
                    <li><a href="/transactions">Transactions</a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-9">
            <h1>New Transaction</h1>
            <hr>
            <form:form action="addTransaction" modelAttribute="transaction">
                <div class="form-group">
                    <label for="debitType">Debit Type:</label>
                    <select class="form-control" name="debitType" id="debitType" required>
                        <option value="<%=DebitTypeEnum.IBAN.type%>">IBAN</option>
                        <option value="<%=DebitTypeEnum.DepositNumber.type%>">Deposit Number</option>
                        <option value="<%=DebitTypeEnum.CardPan.type%>">Card PAN</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="customerNumber">Customer Number:</label>
                    <input type="number" class="form-control" name="customerNumber" id="customerNumber" placeholder="Enter customer number" required>
                </div>
                <div class="form-group">
                    <label for="identifier">Source Identifier:</label>
                    <input type="text" class="form-control" name="identifier" id="identifier" placeholder="Enter Source Identifier" required>
                </div>
                <div class="form-group">
                    <label for="destIBAN">Destination IBAN:</label>
                    <input type="text" class="form-control" name="destIBAN" id="destIBAN" placeholder="Enter destination IBAN" required>
                </div>
                <div class="form-group">
                    <label for="instructionId">Instruction Identification:</label>
                    <input type="number" class="form-control" name="instructionId" id="instructionId" placeholder="Enter instruction identification" required>
                </div>
                <div class="form-group">
                    <label for="amountString">Amount:</label>
                    <input type="text" class="form-control" name="amountString" id="amountString" placeholder="Enter Amount" oninput="formatNumber(this.value)" required>
                </div>
                <input type="hidden" id="amount" name="amount">
                <button type="submit" class="btn btn-primary">Inquire</button>
            </form:form>
        </div>
    </div>
</div>
</body>

</html>
