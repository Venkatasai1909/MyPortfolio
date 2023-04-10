<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign In Form </title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
	
<link rel = "stylesheet" href = "alert/dist/sweetalert.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<input type = "hidden" id = "status" value ="<%= request.getAttribute("status")%>">
	
	<div class="main">

		<!-- Sing in  Form -->
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-image">
						<figure>
							<img src="images/signin-image.jpg" alt="sing up image">
						</figure>
						<a href="registration.jsp" class="signup-image-link">Create an
							account</a>
					</div>

					<div class="signin-form">
						<h2 class="form-title">Sign in</h2>
						<form method="POST" action="login" class="register-form"
							id="login-form">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="username" id="username"
									placeholder="Your Name" required/>
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password" required/>
							</div>
							<div class = "form-group">
							 	<a href = "forgotPassword.jsp">Forgot Password</a>
							</div>
							<div class="form-group">
								<input type="checkbox" name="remember-me" id="remember-me"
									class="agree-term" /> <label for="remember-me"
									class="label-agree-term"><span><span></span></span>Remember
									me</label>
							</div>
							<div class="form-group form-button">
								<input type="submit" name="signin" id="signin"
									class="form-submit" value="Log in" />
							</div>
						</form>
						<div class="social-login">
							<span class="social-label">Or login with</span>
							<ul class="socials">
								<li><a href="https://www.facebook.com/"><i
										class="display-flex-center zmdi zmdi-facebook"></i></a></li>
								<li><a href="https://twitter.com/i/flow/login?
								input_flow_data=%7B%22requested_variant%22%3A%22eyJsYW5nIjoiZW4ifQ%3D%3D%22%7D">
								<i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
								<li><a href="https://accounts.google.com/"><i
										class="display-flex-center zmdi zmdi-google"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	
	<script type = "text/javascript">
		 var status = document.getElementById("status").value;
		 if(status == "failed"){
			 swal("Sorry","Wrong Credientials", "error");
		 }     
		 else if(status == "invalidName"){
			 swal("Sorry","Please Enter Name","error");
     	}
		else if(status == "invalidPass"){
			swal("Sorry","Please Enter Password","error");
		}
	</script>	
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>