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
<title>Accounts</title>

<body>
   <form action="bank" method="post">
   <input type="hidden" name="link" value="DeleteAccounts">
    <div class="navbar">

        <pre> <i class="fas fa-home"></i>     Accounts</pre>
    </div>
    <div class="cust-body">
        <a href="bank?link=AddAccounts">
        <input type="button" value="Add" class="add"></a>
      
        <input type="submit" value="Delete" class="add">
        
    </div>
    <table  id="table1" BORDER=2 CELLPADDING=20 CELLSPACING=20>
    <thead>
    <tr>
        <th>check</th>
        <th>CustomerId</th>
        <th>AccountId</th>
        <th>Balance</th>
    </tr>
    
    </thead>
    <c:forEach items="${accountList}" var="account">
        <tr>
            <td><input type="checkbox" name="selectedAccounts" value="${account.customer_id},${account.account_id}"></td>
            <td><c:out value="${account.customer_id}" /></td>
            <td><c:out value="${account.account_id}" /></td>
            <td><c:out value="${account.balance}" /></td>
           
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>
