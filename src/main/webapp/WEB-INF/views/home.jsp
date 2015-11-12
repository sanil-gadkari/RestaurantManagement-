<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">> <html>
 <head>
  <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <title>Nav Bar</title>
   <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
   <style>
body {
   border: 1px solid black;
    background:url(images/cheesecakefgf.jpg);
    background-repeat: no-repeat;
    /*padding:15px;*/
    background-size: cover;
    
    
    
}
</style> 
 </head>
 <body>
         
         <nav class="navbar navbar-default">
   <div class="container-fluid">
     <!-- Brand and toggle get grouped for better mobile display -->
     <div class="navbar-header">
       <button type="button" class="navbar-toggle collapsed" color="black" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
         <span class="sr-only">Toggle navigation</span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
         <span class="icon-bar"></span>
       </button>
       
       <a class="navbar-brand">Sanils Dinning and Bar</a>
     </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
     <div class="collapse navbar-collapse" color="black" id="bs-example-navbar-collapse-1">
       <ul class="nav navbar-nav">
         <li class="active"><a href="custLogin">Customer Login<span class="sr-only">(current)</span></a></li>
         <li><a href="customerSignUp1">Customer Sign Up</a></li>
         <li><a href="adminLogin">Admin Sign In</a></li>
       </ul>
  
     </div><!-- /.navbar-collapse -->
   </div><!-- /.container-fluid -->
 </nav>
         
 </body>
 </html>