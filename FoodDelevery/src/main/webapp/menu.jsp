<!DOCTYPE html>
<html>
<head>
    <title>Food Menu - Food Delivery</title>
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

        .menu-container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: 20px;
            max-width: 1200px;
            margin: 0 auto;
        }

        .food-card {
            background: #fff;
            border-radius: 15px;
            padding: 20px;
            box-shadow: 0 6px 15px rgba(0,0,0,0.1);
            transition: transform 0.3s, box-shadow 0.3s;
        }

        .food-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        }

        .food-card b {
            font-size: 18px;
            color: #007BFF;
        }

        .food-card p {
            color: #555;
            margin: 10px 0;
        }

        .food-card input[type="number"] {
            width: 60px;
            padding: 5px;
            margin-right: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .food-card input[type="submit"] {
            padding: 6px 15px;
            background: #28a745;
            color: #fff;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            transition: 0.3s;
        }

        .food-card input[type="submit"]:hover {
            background: #218838;
        }

        .pagination {
            text-align: center;
            margin-top: 30px;
        }

        .pagination a {
            margin: 0 10px;
            text-decoration: none;
            color: #007BFF;
            font-weight: bold;
            transition: 0.3s;
        }

        .pagination a:hover {
            color: #0056b3;
        }

        .orders-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            font-size: 16px;
            text-decoration: none;
            color: #17a2b8;
        }

        .orders-link:hover {
            color: #117a8b;
        }
    </style>
</head>
<body>

<h2>Food Menu</h2>

<div class="menu-container">
<c:forEach var="food" items="${foodList}">
    <div class="food-card">
        <b>${food.name}</b> - ₹${food.price} 
        <p>${food.description}</p>
        <form action="OrderServlet" method="post">
            <input type="hidden" name="foodId" value="${food.id}" />
            Quantity: <input type="number" name="quantity" value="1" min="1"/>
            <input type="submit" value="Order"/>
        </form>
    </div>
</c:forEach>
</div>

<div class="pagination">
    <a href="FoodServlet?page=${currentPage-1}">Prev</a>
    <a href="FoodServlet?page=${currentPage+1}">Next</a>
</div>

<a class="orders-link" href="OrderHistoryServlet">View Orders</a>

</body>
</html>
