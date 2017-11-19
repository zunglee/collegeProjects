<?php
	session_start();
	
	if ($_SESSION['login'] == "YES"){
		header("Location:arena.php");
	}
	
	
?>

<html>
	<title>
		Stegolica
	</title>
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

</html>