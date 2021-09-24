<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
     <meta charset="ISO-8859-1">
     <style type="text/css">
     * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, Helvetica, sans-serif;
}
#table1{
margin-left: auto;
  margin-right: auto;
   border-collapse: collapse;
}
th, td {
                width:150px;
                text-align:center;
                border:1px solid black;
                padding:5px
              
            }
.navbar {
    width: 100%;
    background-color: #89ced5;
    padding: 20px;
    text-align: left;
}

.navbar i {
    font-size: 50px;
    color: white;
}

pre {
    color: white;
    font-size: 40px;
    font-weight: 600;
}

.add {
    background-color: #89ced5;
    color: white;
    width: 150px;
    font-size: 18px;
    margin-top: 50px;
    margin-left: 50px;
    padding: 10px;
    border-radius: 10px;
    border-style: none;
}
     </style>
    <script src="https://kit.fontawesome.com/a232a4c6d6.js" crossorigin="anonymous"></script>
</head>
<title>Welcome kasmiv bank</title>

<body>
<form action="bank" method="post">
<input type="hidden" name="link" value="DeleteCustomers">
    <div class="navbar">

        <pre> <i class="fas fa-home"></i>     Welcome kasmiv bank</pre>
    </div>
    <div class="cust-body">
    <a href="bank?link=Customer">
        <input type="button" value="Customer" class="add"></a>
      <a href="bank?link=Account">
        <input type="button" value="Account" class="add"></a>
         <a href="bank?link=Transaction">
         <input type="button" value="Transaction" class="add">
        </a>
    </div>
   
    
    
</form>
</body>

</html>



<!--   
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #333;
}

.navbar a {
  float: left;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;  
  border: none;
  outline: none;
  color: black;
  padding: 14px 16px;
  background-color: blue;
  font-family: red;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>
</head>
<body>
<form action="/bank" method="post">
<div class="navbar">
  <div class="dropdown">
    <button class="dropbtn">Home
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="bank?link=Customer">Customer</a>
      <a href="bank?link=Account">Account</a>
      <a href="bank?link=Transaction">Transaction</a>
    </div>
  </div> 
</div>
<div class="header" color:"blue">
<h3><center>Welcome to banking management</center></h3>
</div>
</form>
</body>
</html>
-->