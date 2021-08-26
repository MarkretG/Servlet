<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<style>
		body{
			margin: 0;
			padding: 0;
			font-family: Arial;

		}
		
		.sidebar {
  			position: fixed;
  			float: left;
  			width: 22%;
  			height: 100%;
  			box-shadow: 1px 2px 8px grey; 
  		}
  		.sidebar span{
  			font-size: 20px;

  		}
  		.sidebar a{
  			text-decoration: none;
  			color: black;
  			display: block;
  			padding-left:15%;
  			padding: 5%;
  			font-size: 17px;

  		}
		.sidebar a:hover{
			background:#0c9f0c ;
			color: white;
		}
		.sidebar  .active{
			background: #0c9f0c;
			color: white;
			box-shadow: 3px 3px 8px #f0ebeb; 
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
  padding: 12px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
  width: 100%;
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
		
		
		.main{
			float: right;
			width: 78%;
			height: 100%;
			position: relative;
			display: inline-block;
			background: #e4e5e5;
		}

		
	</style>
</head>
<body>
<div class="sidebar">
	<div class="dropdown">
    <button class="dropbtn" width=100%>Dropdown 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">Link 1</a>
      <a href="#">Link 2</a>
      <a href="#">Link 3</a>
    </div>
	</div>
	</div>
<div class="main">
	
</div>
</body>
</html>