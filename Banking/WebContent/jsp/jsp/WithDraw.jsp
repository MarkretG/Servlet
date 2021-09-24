<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
    <style type="text/css">
    * {
    margin: 0;
    padding: 0%;
    font-family: Arial, Helvetica, sans-serif;
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

.border-box {
    width: 400px;
    border-style: solid;
    border-color: #89ced5;
    border-width: 5px;
    border-radius: 10px;
    margin-top: 50px;
    margin-left: 50px;
    padding-top: 40px;
    padding-bottom: 40px;
}

.form {
    margin-left: 40px;
}

.form1 {
    margin-left: 40px;
    margin-top: 40px;
    font-size: 18px;
    padding-bottom: 20px;
}

.add {
    background-color: #89ced5;
    color: white;
    width: 100px;
    font-size: 18px;
    padding: 10px;
    border-radius: 10px;
    border-style: none;
    margin-top: 20px;
}

.input {
    width: 300px;
    height: 30px;
}
    </style>
    <script src="https://kit.fontawesome.com/a232a4c6d6.js" crossorigin="anonymous"></script>
</head>
<title>Withdraw </title>

<body>
    <div class="navbar">

        <pre> <i class="fas fa-home"></i>    Withdraw</pre>
    </div>
    <div class="border-box">
        <form action="bank" method="post">
          <input type="hidden" name="link" value="submitWithdraw">
            <label for="fname" class="form1">Customer Id:</label><br><br>
            <input type="text" id="fname" class="form input" name="customerId"><br><br>
            <label for="lname" class="form1">Account Id:</label><br><br>
            <input type="text" id="lname" class="form input" name="accountId"><br><br>
            <label for="lname" class="form1">Withdraw amount:</label><br><br>
            <input type="text" id="lname" class="form input" name="amount"><br><br>
            <input type="submit" class="form add" value="Submit">
        </form>
    </div>
</body>

</html>
