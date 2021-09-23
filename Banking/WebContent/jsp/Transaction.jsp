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
    width: 100px;
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
<title>Transaction</title>

<body>
<form action="bank" method="post">
<input type="hidden" name="link" value="Transaction">
    <div class="navbar">

        <pre> <i class="fas fa-home"></i>     Transaction</pre>
    </div>
    <div class="cust-body">
    <a href="bank?link=withdraw">
        <input type="button" value="WithDraw" class="add"></a>
        <a href="bank?link=deposit">
        <input type="button" value="Deposit" class="add">
        </a>
        </a>
    </div>
</form>
</body>

</html>
