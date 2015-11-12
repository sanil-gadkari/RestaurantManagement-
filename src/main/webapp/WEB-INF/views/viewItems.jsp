<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.o/DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>
<form:form>

<h3>Food List</h3>
<c:if test="${!empty viewFoods}">
    <table class="tg" width="700">
    <tr>
        <th align="center">Food ID</th>
        <th align="center">Food Name</th>
        <th align="center">Food Cost</th>
       
        
    </tr>
    <c:forEach items="${viewFoods}" var="food">
        <tr>
            <td>${food.food_id}</td>
            <td>${food.foodName}</td>
            <td>${food.cost}</td>
      
           
        </tr>
    </c:forEach>
    
    </table>
</c:if>



</form:form>









</body>
</html>