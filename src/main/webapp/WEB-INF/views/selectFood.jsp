<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
body {
   border: 1px solid black;
    background:url(images/ChineseVegNoodles.jpg);
    background-repeat: no-repeat;
    /*padding:15px;*/
    background-size: cover;
    
    
    
}
</style> 
</head>
<body>
<h1>Welcome,Registered successfully</h1>



<h1>${sessionScope.registeredCustomer.username}</h1>
<h2>You can now login with your credentials</h2>

</body>
</html>