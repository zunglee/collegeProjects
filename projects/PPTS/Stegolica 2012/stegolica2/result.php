<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Stegolica</title>
		<link rel="shortcut icon" type="image/x-icon" href="images/icon.ico"/>
		<link rel="stylesheet" type="text/css" href="style.css"/>
	</head>
	<body>
		<div id="container">				
			<center><br/><br/>
			<div id="ques_text">Results</div>
<?php
	require_once( "tbssql_mysqli.php" );
	require_once( "reg_chk.php" );
	require_once( "pass_chk.php" );
	require_once( "event_params.php" );
	require_once( "db_config.php" );
	$Db = new clsTbsSQL();
	$Db->Connect( $DBHost, $DBUser, $DBPass, $DBName );
	$result = $Db->GetRows( "SELECT * FROM " . $EVENT_NAME . "_progress order by no desc, uptime" );
	echo "<table>";
	$i = 1;
	foreach( $result as $index ) {
		echo "<tr><td><div style=\"color:#f9f9f9;\">" . $i . " : </div></td>";
		echo "<td><div style=\"color:#f9f9f9;\">" . $index['team'] . "</div></td></tr>";
	}
	echo "</table>";
	$Db->Close();
?>
			</div><br/>
			</center>					
		</div>
		<div id="footer">
		</div>
	</body>
</html>
