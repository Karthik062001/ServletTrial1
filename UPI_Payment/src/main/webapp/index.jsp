<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple UPI Payment</title>
</head>
<body>

 <h2>Make Payment</h2>
    <form action="ServletCon" method="post">
        <h3>Select Application</h3>
        <select name="app">
            <option value="GooglePay">GooglePay</option>
            <option value="PhonePay">PhonePay</option>
            <option value="Paytm">Paytm</option>
        </select><br><br>

        Receiver Name: <input type="text" name="name"><br><br>

        Amount: <input type="number" name="amount"><br><br>

        <input type="submit" value="Pay Now">
        
        <a href="history">View Transaction History</a>
    </form>
</body>
</html>