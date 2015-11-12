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
<script type="text/javascript">
$(document).ready(function() {
	$('#password').keyup(function() {
	$('#result').html(checkStrength($('#password').val()))
	})
	function checkStrength(password) {
	var strength = 0
	if (password.length < 6) {
	$('#result').removeClass()
	$('#result').addClass('short')
	return 'Too short'
	}
	if (password.length > 7) strength += 1
	// If password contains both lower and uppercase characters, increase strength value.
	if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) strength += 1
	// If it has numbers and characters, increase strength value.
	if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/)) strength += 1
	// If it has one special character, increase strength value.
	if (password.match(/([!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1
	// If it has two special characters, increase strength value.
	if (password.match(/(.*[!,%,&,@,#,$,^,*,?,_,~].*[!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1
	// Calculated strength value, we can return messages
	// If value is less than 2
	if (strength < 2) {
	$('#result').removeClass()
	$('#result').addClass('weak')
	return 'Weak'
	} else if (strength == 2) {
	$('#result').removeClass()
	$('#result').addClass('good')
	return 'Good'
	} else {
	$('#result').removeClass()
	$('#result').addClass('strong')
	return 'Strong'
	}
	}
	$('#state').bind('keyup blur', function() {
	    $(this).val($(this).val().replace(/[^A-Za-z]/g, ''))
	});
	});

$(document).ready(function() {
    $('#submit').click(function(event){
    
        data = $('#password').val();
        var len = data.length;
        
        if(len < 1) {
            alert("Password cannot be blank");
            // Prevent form submission
            event.preventDefault();
        }
         
        if($('#password').val() != $('#confirmPassword').val()) {
            alert("Password and Confirm Password don't match");
            // Prevent form submission
            event.preventDefault();
        }
         
    });
});




</script>

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
<form action="customerSign" method="POST" id="user"
class="form-horizontal" role="form">
<div class="container">
<div id="loginbox" style="margin-top: 50px;"
class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
<div class="panel panel-info">
<div class="panel-heading">
<div class="panel-title">Sign Up</div>

</div>

<div style="padding-top: 30px" class="panel-body">

<div style="display: none" id="login-alert"
class="alert alert-danger col-sm-12"></div>

<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-user"></i></span>
<input type="text" class="form-control" id="firstname" name="firstname" placeholder="First Name" required="required" >
<br>

</div>

<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-user"></i></span>
<input type="text" class="form-control" id="lastName" name="lastname" placeholder="Last Name" required="required" >
<br>
</div>
 <div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-user"></i></span>
<input type="email" class="form-control" id="email" name="email" placeholder="Email" required="required" >
<br>

</div>

<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-user"></i></span>
<input type="text" class="form-control" id="username" name="username" placeholder="Username" required="required" >
<br>

</div>






<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-lock"></i></span>
<input type="password" name="password" id="password"
class="form-control" placeholder="Password" required="required" />
<br>
</div>

<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-lock"></i></span>
<input type="password" name="confirmPassword" id="password"
class="form-control" placeholder="Password" required="required" />
<br>

</div>

<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-user"></i></span>
<input type="number" class="form-control" id="MobileNumber" name="number" placeholder="Mobile Number" required="required"  min = "1" >
<br>

</div>



<div>Gender</div>

<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="radio"></i></span>
 <label><input type="radio" value="Male" name="option">Male</label>	
      <label><input type="radio" name="option" value="Female">Female</label>
<br>

</div>

<div>Shipping Address</div>

<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-user"></i></span>
<input type="text" class="form-control" id="street" name="street" placeholder="Street" required="required" >
<br>

</div>

<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-user"></i></span>
<input type="text" class="form-control" id="apt_no" name="apt_no" placeholder="Apartment Name" required="required" >
<br>

</div>



<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-user"></i></span>
<input type="number" class="form-control" id="zipcode" name="zipcode" placeholder="Zipcode" required="required" >
<br>

</div>

<div style="margin-bottom: 25px" class="input-group">
<span class="input-group-addon"><i
class="glyphicon glyphicon-user"></i></span>
<input type="text" class="form-control" id="state" name="state" placeholder="State Name" required="required" >
<br>

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

</form>
</body>
</html>