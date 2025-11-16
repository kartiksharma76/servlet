<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
if(session.getAttribute("userId") == null){
    response.sendRedirect("login.jsp");
    return;
}
%>
<html>
<head>
    <title>Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #667eea, #764ba2);
            display: flex;
            justify-content: center;
            align-items: flex-start;
            padding-top: 50px;
        }
        .container {
            background: white;
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
            width: 450px;
        }
        h2 {
            text-align: center;
            color: #333;
        }
        p.balance {
            font-size: 18px;
            font-weight: bold;
            color: #667eea;
        }
        form {
            margin-top: 20px;
        }
        input[type=number] {
            width: 80%;
            padding: 10px;
            margin: 8px 0;
            border-radius: 8px;
            border: 1px solid #ccc;
        }
        input[type=submit] {
            padding: 10px 20px;
            background: #667eea;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            margin-left: 10px;
        }
        input[type=submit]:hover {
            background: #764ba2;
        }
        a.logout {
            display: block;
            text-align: center;
            margin-top: 25px;
            color: #667eea;
            text-decoration: none;
            font-weight: bold;
        }
        a.logout:hover {
            color: #764ba2;
        }
        .msg {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Welcome, ${sessionScope.name}</h2>
    <p class="balance">Balance: ₹${sessionScope.balance}</p>

    <c:if test="${not empty msg}">
        <p class="msg">${msg}</p>
    </c:if>

    <form action="DepositServlet" method="post">
        Deposit Amount: <input type="number" name="amount" min="1" required/>
        <input type="submit" value="Deposit"/>
    </form>

    <form action="WithdrawServlet" method="post">
        Withdraw Amount: <input type="number" name="amount" min="1" required/>
        <input type="submit" value="Withdraw"/>
    </form>

    <a href="LogoutServlet" class="logout">Logout</a>
</div>
</body>
</html>
