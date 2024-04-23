<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href=css/style.css>//productView
<script type="js/script.js"></script>
</head>
<body>
<img src=images/empimage.jpg>
<form action="productView" method="post" id="product" name="productView" onsubmit="return validateForm()">
<label for="id">Enter id</label><br> 
<input type="number" id="id" name="id"><br>
<label for="name">Enter name</label><br> 
<input type="text" id="name" name="name"><br> 
<label for="price">Enter Price</label><br> 
<input type="number" id="price" name="price"><br> 
<input type="submit" value="submit"> 
</form>
</body>
</html>