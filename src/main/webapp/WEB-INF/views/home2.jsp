<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	 
	<style type="text/css">
	html,body {
margin: 0;
padding: 0;
background-color: green;
background-image: url("/OnlineRestaurent/src/main/webapp/WEB-INF/views/bckgrnd.jpg")
}

.wrapper1{
margin-left:auto;
margin-right:auto;
width:60%;
background-color: gray;
margin-top: 10px;
border:4px solid white;
}
	ul.header1
 {


color:white;
font-size:12px;
font-family:arial;
padding:5px;
display: inline;


}

li.k
{
float:left;
padding:5px 20px;
display:inline-block;
margin-left: 10px;
}
	
.menu{
height: 20px;
width:100%
}
	
	
	</style>
</head>
<body>

<h1>
	Welcome to Chelsea Restaurant!!  
</h1>

<div class = "wrapper1">
		<div class = "menu">
		<ul class="header1">
	<li class="k" ><a href = "custLogin">Customer Login</a></li>
	<li class="k" style="border-left:1px solid gray" >
	<a href = "customerSignUp1">Sign Up New Customers</a></li>
	<li class="k" ><a href = "adminLogin">Admin Login</a></li>
	
	</ul>
	
</div>
</div>

</body>
</html>
