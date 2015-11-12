<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.o/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

   <meta name="viewport" content="width=device-width, initial-scale=1">
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

<form action="summaryOrder" method="POST" role="form">

<h3>Food List</h3>
<c:if test="${!empty sessionScope.newList}">
    <table class="tg">
    <tr>
        <th align="center">Food ID</th>
        <th align="center">Food Name</th>
        <th align="center">Food Cost</th>
       
        
    </tr>
    <c:forEach items="${sessionScope.newList}" var="dish">
        <tr>
            <td>${dish.food.foodName}</td>
            <td>${dish.quantity}</td>
            <td>${dish.total}</td>
      
         <c:set var="total" value="${dish.total}" />          
        </tr>
    </c:forEach>
       <tr><td><b>Total=</b><fmt:formatNumber value="${total+0}" type="currency"/> </td></tr>
  
  
    </table>
</c:if>


<div class="container">
    <div class="row">
        <div class="col-xs-12 col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Payment Details
                    </h3>
                 
                </div>
                <div class="panel-body">
                   
                    <div class="form-group">
                        <label for="cardNumber">
                            CARD NUMBER</label>
                        <div class="input-group">
                            <input type="text" class="form-control" id="cardNumber" placeholder="Valid Card Number"
                                required autofocus />
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-7 col-md-7">
                            <div class="form-group">
                                <label for="expityMonth">
                                    EXPIRY DATE</label>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityMonth" placeholder="MM" required />
                                </div>
                                <div class="col-xs-6 col-lg-6 pl-ziro">
                                    <input type="text" class="form-control" id="expityYear" placeholder="YY" required /></div>
                            </div>
                        </div>
                        <div class="col-xs-5 col-md-5 pull-right">
                            <div class="form-group">
                                <label for="cvCode">
                                    CV CODE</label>
                                <input type="password" class="form-control" id="cvvCode" placeholder="CVV" required />
                            </div>
                        </div>
                    </div>
          
                </div>
            </div>
        
        </div>
    </div>
</div>







<table>

   <tr>
             <td><input type = "submit" name="submit" value="CheckOut"/></td>
         </tr>
</table>
</form>









</body>
</html>