<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
   <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>



<body>
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

<form:form action="addToCart">

<h3>Food List</h3>

    <table class="tg">
    <tr>
        <th align="center">Food ID</th>
        <th align="center">Food Name</th>
        <th align="center">Food Cost</th>
        <th align="center">Quantity</th>
       
        
    </tr>
  
        <tr>

            <td>${foodItem.food_id}</td>
            <td>${foodItem.foodName}</td>
            <td>${foodItem.cost}</td>
            <td><input type="number" name="quantity" min = "1" required="required" ></td>
            <td><input type="hidden" name="food_id" value="${foodItem.food_id}"></td>
        </tr>
  
       <tr>
             <td><input type = "submit" name="submit" value="Add To Cart"/></td>
         </tr>
          
     
    
    </table>




</form:form>


</body>
</html>