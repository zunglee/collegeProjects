<?php
session_start();
	
	if ($_SESSION['login'] == "YES"){
		header("Location:arena.php");
	}
	
	


?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name       : Reckoning
Description: A two-column, fixed-width design for 1024x768 screen resolutions.
Version    : 1.0
Released   : 20090629

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Stegolica-Effervescence mm9</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">

	
		
		
	</div>
	<!-- end #header -->
	
	<div id="logo">
		<h1><a href="#">Stegolica </a></h1>
		
	</div>
	
	<hr />
	<!-- end #logo -->
<!-- end #header-wrapper -->

<div id="page">
	<div id="content">
		<div class="post">
			
			
			<div class="entry">
				

<html>
	
	<body>
	<?php
	if ($_SESSION['mcode'] == "01"){
	 $_SESSION['mcode'] = "00";
	echo $_SESSION['message'];
	}
	?>
		<h2 class="title">Enter your username and password </h2>	
		<center>
			<form name = form1 method = post action = "checklogin.php">
				<table cellpadding = 10>
					<tr>
						<td>
							Username
						</td>
						<td>
							<input type = text name = username>
						</td>					
					</tr>		
					<tr>
						<td>
							Password
						</td>
						<td>
							<input type = password name = password>
						</td>
					</tr>
					<tr align = center>
						<td colspan = 2>
							<input type = submit name = submit value = "submit">
						</td>
					</tr>		
				</table>
			</form>		
		</center>

	</body>

</html>.<br />
				</p>
		  </div>
		</div>
	  <div class="post">
		  <h2 class="title">
		    <!-- end #content -->
	</h2>
	  </div>
  </div>
	
	<!-- end #sidebar -->
	
<!-- end #page -->
</div>


</body>
</html>
