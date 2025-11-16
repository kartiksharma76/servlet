<!DOCTYPE html>
<html>
<head>
    <title>Your Orders - Food Delivery</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f8f9fa;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }

        .orders-table {
            width: 90%;
            margin: 0 auto;
            border-collapse: collapse;
            background: #fff;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 6px 15px rgba(0,0,0,0.1);
        }

        .orders-table th, .orders-table td {
            padding: 12px 15px;
            text-align: center;
        }

        .orders-table th {
            background-color: #007BFF;
            color: #fff;
        }

        .orders-table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .orders-table tr:hover {
            background-color: #e0f0ff;
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 30px;
            text-decoration: none;
            color: #28a745;
            font-weight: bold;
            transition: 0.3s;
        }

        .back-link:hover {
            color: #1e7e34;
        }
    </style>
</head>
<body>

<h2>Your Orders</h2>

<table class="orders-table">
<tr>
    <th>Food</th>
    <th>Quantity</th>
    <th>Total</th>
    <th>Date</th>
</tr>
<c:forEach var="o" items="${orders}">
<tr>
    <td>${o.name}</td>
    <td>${o.quantity}</td>
    <td>₹${o.total}</td>
    <td>${o.order_date}</td>
</tr>
</c:forEach>
</table>

<a class="back-link" href="FoodServlet">Back to Menu</a>

</body>
</html>
