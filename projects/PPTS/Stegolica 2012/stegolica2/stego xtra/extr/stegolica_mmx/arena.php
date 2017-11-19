<?php

	session_start();

	if ($_SESSION['login'] == "YES"){
		$username = $_SESSION['loginid'];
	} else {
		$username = "";
		$_SESSION['login'] = "NO";
		header("Location:login.php");
	}

	$noq = 3;
	
	include("db_connect.php"); 
	
?>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>ARENA-STEGOLICA effMM09</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<style type="text/css">
<!--
.style1 {font-size: 18px}
-->
</style>
</head>
<body>
<div id="wrapper">
<div align="right">
  <!-- end #header -->
  <a href="logout.php" class="style1">Logout</a><br />
  <br />
</div>
<div id="logo">
		<h1><a href="#">Stegolica </a></h1>
		
</div>
	
	<hr />
	<!-- end #logo -->
<!-- end #header-wrapper -->
<center>
<div id="page">
	<div id="content">
		
						
			<div class="entry">
					
<?php

	$sql_1 = "select * from users where email = '$username'";
	$res_1 = mysql_query($sql_1);
	$rec_1 = mysql_fetch_array($res_1);
	
	$sql_2 = "select * from answers";
	$res_2 = mysql_query($sql_2);
	
	echo "<center><div id = \"data\">";
	
	echo "<table border = 0 cellpadding = 6 width = \"100%\">";
	
	echo "<tr><td><h1>$username</h1></td><br /><br />";
	echo "<td>Solved";
	echo "<table border = 1><tr>";
		
	for ($i = 1; $i <= $noq; $i++){
		$field = "q" . $i;
		if ($rec_1[$field] == 1){
				echo "<td>$i</td>";
		}		
	}
	
	echo "</tr></table></td></tr>";

	$sql_r = "select * from users order by points desc, time asc";
	$res_r = mysql_query($sql_r) or die("could not retrieve data");

	$i = 0;
	$ran = $i;

	while ($rec_r = mysql_fetch_array($res_r)){
$i++;
	if ($username == $rec_r['email']){
		$ran = $i;
	}

	

	}

	echo "<tr><td>Your Rank :- $ran out of $i<br><br></td>";




	echo "<td>Points <table border = 1><tr>";
	echo "<td>" . $rec_1['points'] . "</td>";		
	echo "</tr></table></td></tr>";

		
	if ($_SESSION['mcode'] == "21"){
		$_SESSION['mcode'] = "20";
		echo $_SESSION['message'] . "<br /><br />";
	}
	
	echo "</table>";
	
	echo "<br /><br />";
		
	while ($rec_2 = mysql_fetch_array($res_2)){
		$qno = "q" . $rec_2['qno'];
		
		if ($rec_1[$qno] == 1) continue;	
		echo "<table border = 1 cellpadding = 10>";
		echo "<tr><td rowspan = 2>". $rec_2['qno'] . "</td><td>Question</td><td>" . $rec_2['question'] . "</td></tr>";
		echo "<tr valign = top><td>Answer</td><td valign = bottom><form name = form1 method = get action = \"checkans.php\"><input type=hidden name=qno value=".$rec_2['qno']."><input type = text name = value>&nbsp;&nbsp;<input type = submit value=\"submit\"></form></td></tr>";
		echo "</table>";
	}		
	
	echo "</div></center>";

?>
		
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

</center>
</body>
</html>
