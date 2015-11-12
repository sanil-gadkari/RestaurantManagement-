<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<div class="container">
        <h1>Please add a new dish details</h1>
        <form method="POST" action="addNewProduct" name="addfood" id="addfood" >
            
             <table class="table table-bordered">
              
              <tr>
              <td>${enter}</td>
              </tr>
              
                 <tr>
                     <td> Food Name: </td>
                     <td> <input type="text"  name="foodname" id='foodname' required="required"></td>
                 </tr>
                 <tr>
            <td>Food Description: </td>
            <td> <TEXTAREA name="description" id="description"COLS=60 ROWS=8 required="required"></TEXTAREA></td>
                 </tr>
               <tr>
            <td> Cost: </td>
            <td> <input type="number" min = "1" step="0.01" name="cost" id="cost" required="required"></td>
                 </tr>
                
           
                 <tr>
                  <td> Food Category: </td>
                 <td>
                 <select name="category" id="category">
          			<c:forEach items="${catList}" var="fcat1"> 
          			<option value="${fcat1.category_id}">${fcat1.category_name}</option>
          		    
          			</c:forEach>
          		</select>
          		</td>
                 </tr>
                 
                  <tr>
                   <td> Food Type: </td>
                  <td>
                 <select name="type" id="type">
          			<c:forEach items="${foodList}" var="fType1"> 
          			<option value="${fType1.ftype_id}">${fType1.ftype_name}</option>
          	
          			</c:forEach>
          		</select>
          		</td>
                 </tr>
                 <tr>
                 <c:forEach items="${foodList}" var="fType1"> 
          			
          			<td>${fType1.ftype_id}</td>
          			</c:forEach>
                 
                 </tr>
				
            </table>
            <input type="submit" value="submit">
        </form>
        </div>
    </body>
    </html>