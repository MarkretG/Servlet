<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

.Wrapper {
    width: 100%;
    background-color: rgb(128, 128, 248);
}

.container {
    width: 75%;
    margin: auto;
    text-align: left;
    padding-top: 100px;
    color: white;
}

.Banner {
    width: 100%;
    background-image: url('/Banking/WebContent/jsp/image/bank.jpg');
    background-repeat: no-repeat;
    background-size: 100%;
    padding-bottom: 600px;
}

.Banner i {
    color: white;
    float: left;
    font-size: 50px;
    margin-left: 40px;
    margin-top: 50px;
}

h1 {
    font-size: 76px;
}

h3 {
    font-size: 30px;
}

.list {
    width: 200px;
    background-color: transparent;
    padding-top: 100px;
    display: none;
}

ul li {
    list-style: none;
    display: block;
    margin-top: 30px;
}

ul li a {
    text-decoration: none;
    color: white;
    font-size: 30px;
    margin-left: 40px;
}
    </style>
    <script src="https://kit.fontawesome.com/a232a4c6d6.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<title>
    Main page
</title>

<body>
    <!--Navbar section-->

    <div class="Banner">
        <div id="bars"><i class="fas fa-bars"></i>
        </div>
        <div class="list">
            <ul>
                <li><a href="#">Customer</a></li>
                <li><a href="#">Account</a></li>
                <li><a href="#">Transaction</a></li>
            </ul>
        </div>
        <div class="container">
            <h1>WELCOME</h1>
            <h3>KASMIV Bank welcomes you!!!</h3>
        </div>

    </div>
    <script>
        $("document").ready(function() {
            $('#bars').on('click', function() {
                $('.list').toggle();
            });
        });
    </script>
</body>
</html>