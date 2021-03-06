<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true"%>

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
<title>Self Service Portal</title>
</head>
<body>
<%-- <h6 style="color: #ff0000">${error}</h6> --%>
<c:if test="${error.length()>0}">
<div id="index-alert" class="alert alert-danger alert-dismissable">
<button type="button" class="close" data-dismiss="alert"
aria-hidden="true">&times;</button>
<strong>Oh snap!</strong> ${error}<br> ${error0}<br>
${error1}
</div>
<%-- div class="alert alert-dismissible alert-danger">
<button type="button" class="close" data-dismiss="alert">×</button>
<strong>Oh snap!</strong> ${error}
</div> --%>
</c:if>
<form:form method="POST" commandName="admin" id="user"
class="form-horizontal" role="form">
<div class="container">
<div id="loginbox" style="margin-top: 50px;"
class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
<div class="panel panel-info">
<div class="panel-heading">
<div class="panel-title">Admin Sign In</div>
<div
style="float: right; font-size: 80%; position: relative; top: -10px">

</div>
</div>

<div style="padding-top: 30px" class="panel-body">

<div style="display: none" id="login-alert"
class="alert alert-danger col-sm-12"></div>

<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-user"></i></span>
<form:input path="username" class="form-control" id="userName"
placeholder="username" required="required" />
<br>
<form:errors path="username" cssStyle="color:#ff0000" required="required"></form:errors>
</div>

<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-lock"></i></span>
<form:password path="password" id="userPassword"
class="form-control" placeholder="password" required="required" />
<br>
<form:errors path="password" cssStyle="color:#ff0000"></form:errors>
</div>






<div style="margin-top: 10px" class="form-group">
<!-- Button -->

<div class="col-sm-12 controls">
<input type="submit" class="btn btn-primary" name="submit"
value="Submit" />
</div>
</div>
</div>
</div>
</div>
</div>
</form:form>
</body>
</html>