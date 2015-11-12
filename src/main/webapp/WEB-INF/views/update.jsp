<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
</head>
 
<form action="updatePrice" name="myForm">
     <table>
     <br>
     <br>
         <tr><th colspan="2" align="left">Edit the Food Item</th></tr>
         <tr><th colspan="2" align="left">"${error}"</th></tr>
         <tr>
         	<td> Edit Name </td>
         	<td>"${foodUpdate.foodName}"</td>
         </tr> 
        
         <tr>
         	<td> Edit Name </td>
         	<td><input type="text" name="editedName"></td>
         </tr> 
         <tr>
         	<td>Edit  Price </td>
         	<td><input type="number" name="cost"></td>
         </tr>     
         
         <tr><td colspan="2" align="center"><input type = "submit" name="submit" value="Change Details"/></td></tr>
     </table>
     
    
     
</form>
</body>
</html>