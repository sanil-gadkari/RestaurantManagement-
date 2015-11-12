<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<style>
body {
   border: 1px solid black;
    background:url(images/cocktails.jpg);
    background-repeat: no-repeat;
    /*padding:15px;*/
    background-size: cover;
    
    
    
}
</style> 
</head>
<body>

<form:form method = "POST" commandName="customer">
     <table>
         <tr>
              <td>User Name:</td>
              <td><form:input path="username"/></td>
              <td><form:errors path="username" cssStyle="color:#ff0000"></form:errors>
         </tr>
         <tr>
             <td>Password:</td>
             <td><form:input type="password" path="password"/></td>
             <td><form:errors path="password" cssStyle="color:#ff0000"/></td>
         </tr>
         
         <tr/><tr/>
         
         <tr/><tr/><tr/><tr/>
         <tr>
             <td><input type = "submit" name="submit" value="Member Login"/></td>
         </tr>
          
         
         
         
     </table>
</form:form>


</body>
</html>
