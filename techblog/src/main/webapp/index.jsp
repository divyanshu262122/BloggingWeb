<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link href="css/mystyle.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href="img/bloggers.jpg">
<style>
.banner-background{
clip-path: polygon(50% 0%, 99% 0, 100% 0%, 100% 91%, 68% 100%, 32% 93%, 0 100%, 0% 43%, 0 0);
}
</style>
<title>Bloggers</title>
</head>
<body>

<!-- navbar -->
<%@include file="navbar.jsp" %>


<!-- banner -->
<div class="container-fluid p-0 m-0 secondary-back">
<div class="jumbotron  secondary-background banner-background">
<div class="container">
<div class="row mb-4">
<div class="col mb-6">
<h3 class="display-2 "><strong>Welcome to Tech-Blog</strong></h3>
<br>
<h4>Keep working harder to get success in life.</h4>
<p>"A programming language is a system of notation for writing computer programs. Most programming languages are text-based formal languages, but they may also be graphical. They are a kind of computer language."</p>
<br>
<button class="btn btn-outline-light bg-info btn-lg"> <span class="fa fa-user-plus"></span> Start! it's Free</button>
<a href="login.jsp"class="btn btn-outline-light bg-info btn-lg"> <span class="fa fa-user-circle fa-spin"></span> Login</a>
</div>
<div class="col mb-6">
<img class="banner_img" alt="laptop" src="images/gra.png">
</div>
</div>
</div>
</div>

<!--  Cards -->
<div class="container">
<div class="row mb-4">
<div class="col-md-4">
<div class="card" ">
  <div class="card-body">
    <h5 class="card-title">Java Programming</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn bg-info text-white">Read More</a>
  </div>
</div>
</div>
<div class="col-md-4">
<div class="card" >
  <div class="card-body">
    <h5 class="card-title">Java Programming</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn bg-info text-white">Read More</a>
  </div>
</div></div>
<div class="col-md-4">
<div class="card" ">
  <div class="card-body">
    <h5 class="card-title">Java Programming</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn bg-info text-white">Read More</a>
  </div>
</div>
</div>

</div>


</div>

<div class="container">
<div class="row">
<div class="col-md-4">
<div class="card" ">
  <div class="card-body">
    <h5 class="card-title">Java Programming</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn bg-info text-white">Read More</a>
  </div>
</div>
</div>
<div class="col-md-4">
<div class="card" ">
  <div class="card-body">
    <h5 class="card-title">Java Programming</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn bg-info text-white">Read More</a>
  </div>
</div></div>
<div class="col-md-4">
<div class="card" ">
  <div class="card-body">
    <h5 class="card-title">Java Programming</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn bg-info text-white">Read More</a>
  </div>
</div>
</div>

</div>
</div>
</div>
<br>
<hr>
<footer>


</footer>
<!-- Script -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="js/myjs.js" type="text/javascript"></script>
</body>
</html>