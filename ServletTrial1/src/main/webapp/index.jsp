<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Create New Account</h2>
<form action="Trial1" method="post">

<label>Account Holder Name </label><br>
<input type="text" name="name" required><br><br>

<label>Account Number</label><br>
<input type="number" name="ACnumber" required><br><br>

<label>Address of AC Holder</label><br>
<input type="text" name="Address" required><br><br>

<label>Type of Account</label><br>
<input type="text" name="type"><br><br>

<label>Balance</label><br>
<input type="number" name="balance"><br><br>

<input type="submit" value="Create Account">

</form>
</body>
</html>