<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous"/>
<link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
<style>
.banner-background{
clip-path: polygon(50% 0%, 99% 0, 100% 0%, 100% 91%, 68% 100%, 32% 93%, 0 100%, 0% 43%, 0 0);
}
</style>
<title>Register_Page</title>
</head>
<body>

<!-- navbar -->
<%@include file="navbar.jsp" %>

<main class="secondary-background banner-background " style="padding-bottom: 70px;" >
<div class="container">
<div class="col-md-6 offset-md-4">
<div class="card">
<div class="card-header text-center bg-info text-white">
<span class="fa-3x fa fa-user-circle"></span>
<br>
<h1>REGISTER</h1>
</div>
<div class="card-body">

<form id="reg-form" action="RegisterServlet">

 <div class="form-group">
    <label for="user_name">User Name</label>
    <input type="text" name="name" class="form-control" id="user_name" aria-describedby="emailHelp" placeholder="Enter Name">
  </div>

  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>

  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
  </div>
  
   <div class="form-group">
    <label for="gender">Gender : </label>
    <input type="radio"  id="gender" name="gender" value="Male">Male
    <input type="radio"  id="gender" name="gender" value="Female">Female
  </div>

<div clasas="form-group">
<textarea  name ="about" class="form-control" rows="4" cols="62" placeholder="Enter something about yourself"></textarea> 
</div>
<br>
  <div class="form-check">
    <input name="check" type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">Agree terms and conditions!</label>
  </div>
<br>
<span class="fa fa-refresh fa-spin fa-2x"></span>
  <input type="submit" class="btn btn-info" value="Sign Up"></input>
</form>
</div>
</div>
</div>
</div></main>

<!-- Script -->

<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="js/myjs.js" type="text/javascript"></script>
<script>

$(document).ready(function(){
	console.log("loaded....");
	
	$('#reg-form').on('submit',function(event){
	event.priventDefault();
	
	let form=new FormData(this);
	
	//send register servlet
	
	$.ajax({
		url: "RegisterServlet",
		type: 'POST',
		data: form,
		success: function(data , textStatus , jqXHR){
		console.log(data)	
		},
		error: function(jqXHR , textStatus , errorThrow){
			console.log(jqXHR)
		},
		processData: false,
	     contentType: false
		
	});
	
	});
	
});



</script>




</body>
</html>