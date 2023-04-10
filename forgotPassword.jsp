<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <title>Forgot Password</title>
  <style>
     .main
	 {
	    margin-top:50px;
	    padding-top:50px;
	    text-align:center;
	    box-shadow:2px 2px 4px;
		border-radius:4px;
		height : 500px;
		width : 500px;
		background : white;
	 }
  </style>
 </head>
 <body>
 <input type = "hidden" id = "status" value = "<%= request.getAttribute("status")%>" >
 <input type = "hidden" id = "password" value = "<%= request.getAttribute("password")%>" >
   <form action = "forgot" method = "POST">
	  <center>
		   <div class = "main">
				 <h3>Enter Email Address : </h3>
				 <input type = "email" size = "30px" name = "email" required><br><br>
				 <h3>Enter Old Password</h3>
				 <input type = "password" size = "20px" name = "password"  minlength = "8"  maxlength = "16" required><br><br>
				 <h3>Enter New Password</h3>
				 <input type = "password" size = "20px" name = "newpassword"  minlength = "8"  maxlength = "16" required><br><br>
				 <h3>Confirm Password</h3>
				 <input type = "password" size = "20px" name = "conpassword"  minlength = "8"  maxlength = "16" required><br><br>
				 <input type = "submit" value = "Submit">
		   </div>
	 </center>
   </form>
   <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script type = "text/javascript">   
	   var status = document.getElementById("status").value;
	   if(status == "success"){
			 swal("Congratulations","Password chamnged SuccessFully", "success");
		 }
	   else if(status == "failure"){
		   swal("Sorry","Wrong Credentials","error");
	   }
	 </script>
	 <script type = "text/javascript">
	   var password = document.getElementById("password").value;
		if(password == "failure"){
			swal("Sorry","Password Mismatch","error");
		}
	</script>
</body>
</html>	

