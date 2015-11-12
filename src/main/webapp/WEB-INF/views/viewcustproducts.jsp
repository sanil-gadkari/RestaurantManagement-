<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
 <nav class="navbar navbar-default">
   <div class="container-fluid">
     <!-- Brand and toggle get grouped for better mobile display -->
     <div class="navbar-header">
       <button type="button" class="navbar-toggle collapsed" color="blue" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
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
        
        
         <li><a href="viewcustproducts">View Products</a></li>
         <li><a href="logoutcust">Customer logout</a></li>
       </ul>
  
     </div><!-- /.navbar-collapse -->
   </div><!-- /.container-fluid -->
 </nav>
<h3>Food List</h3>
<c:if test="${!empty foods}">

    <table class="tg">
    <tr>
        <th align="center">Food ID</th>
        <th align="center">Food Name</th>
        <th align="center">Food Cost</th>
       
        
    </tr>
    <c:forEach items="${foods}" var="dish">
        <tr>
            <td>${dish.food_id}</td>
          <%--   <td> <a href="foodcart?food_id=${dish.food_id}">${dish.foodName}</td> --%> 
             <td><a href="<c:url value='foodcart?food_id=${dish.food_id}'/>" >${dish.foodName}</a></td>
           
            
            <td>${dish.cost}</td>
             </c:forEach>
             </table>
             </c:if>

</body>
</html>