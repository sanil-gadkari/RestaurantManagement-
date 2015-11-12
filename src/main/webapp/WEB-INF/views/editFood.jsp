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
<form:form action="deleteFoodItems" >
<body>
<h3>Food List</h3>
<c:if test="${!empty foods}">
    <table class="tg">
    <tr>
        <th align="center">Food ID</th>
        <th align="center">Food Name</th>
        <th align="center">Food Cost</th>
       
        <th align="center""60">Delete</th>
    </tr>
    <c:forEach items="${foods}" var="dish">
        <tr>
            <td>${dish.food_id}</td>
            <td>${dish.foodName}</td>
            <td>${dish.cost}</td>
            <td><input type="checkbox" name="deleteSelectedFood" value="${dish.food_id}">Delete</td>
            
        </tr>
    </c:forEach>
    <tr>
      <td colspan = "5" align="center"><input type = "submit" name="submit" value="Delete Selected Food Items"/></td>
    </tr>  
    </table>
</c:if>



</form:form>
</body>
</html>