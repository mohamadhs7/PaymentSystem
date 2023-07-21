<%@ page import="com.example.paymentsystem.valueobjects.UpdateCustomerVO" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Change Volume Limitation</title>
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

        .inoneline-cell {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
     <script>
         function formatNumber(value) {
             // Remove any existing commas from the input value
             var cleanedValue = value.replace(/,/g, '');

             // Format the value with commas
             var formattedValue = Number(cleanedValue).toLocaleString();

             // Set the formatted value in the input box
             document.getElementById('newVolumeString').value = formattedValue;

             // Use the cleaned value (without commas) for further processing or sending to the system
             sendToSystem(cleanedValue)
         }

         function sendToSystem(value) {
             var amount = document.getElementById("newVolume");
             amount.value = value;
         }
     </script>
</head>
<body>
<% String currentVolume = request.getAttribute("volumeLimitation").toString();
    DecimalFormat dc = new DecimalFormat("###,###");%>
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
            <h1>Change Volume Limitation</h1>
            <hr>
            <h3 class="inoneline-cell"> Current Volume: <%=dc.format(Double.parseDouble(currentVolume)) %></h3>
            <br>
            <form:form action="doChangeVolumeLimitation" modelAttribute="updateVolume">

                <div class="form-group">
                    <label for="newVolume">Volume:</label>
                    <input type="text" class="form-control" name="newVolumeString" id="newVolumeString" placeholder="Enter Volume"
                           oninput="formatNumber(this.value)" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <input type="hidden" id="newVolume" name="newVolume">
            </form:form>
        </div>
    </div>
</div>
</body>

</html>
