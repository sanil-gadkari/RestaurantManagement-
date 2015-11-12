<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<form:form action="editFoodItems" >
<body>
<h3>Food List</h3>
<c:if test="${!empty foodlistUpdate}">
    <table class="tg">
    <tr>
        <th align="center">Food ID</th>
        <th align="center">Food Name</th>
        <th align="center">Food Cost</th>
       
        <th align="center""60">Update</th>
    </tr>
    <c:forEach items="${foodlistUpdate}" var="dish">
        <tr>
            <td>${dish.food_id}</td>
            <td>${dish.foodName}</td>
            <td>${dish.cost}</td>
        <!--   <td><a href="<c:url value='/update/${dish.food_id}' />" >Update</a></td> -->
                    <td><a href="<c:url value='update?food_id=${dish.food_id}'/>" >Update</a></td>
        </tr>
    </c:forEach>
    <tr>
      
    </tr>  
    </table>
</c:if>



</form:form>
</body>
</html>