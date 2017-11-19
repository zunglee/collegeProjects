<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Stegolica</title>
		<link rel="shortcut icon" type="image/x-icon" href="images/icon.ico"/>
		<link rel="stylesheet" type="text/css" href="style.css"/>
	</head>
	<body>
		<div id="container">				
			<center><br/><br/>
				<div width="300px" style="color:#ffffff; font-size:15px;">
					<form action="ques.php" method="post">
<?php
	require_once( "tbssql_mysqli.php" );
	require_once( "reg_chk.php" );
	require_once( "pass_chk.php" );
	require_once( "event_params.php" );
	require_once( "db_config.php" );
	session_start();
	if( isset($_SESSION['team']) ) {
		$ST_TIME = $ST_TIME;
		$ET_TIME = $ET_TIME;
		$team = $_SESSION['team'];
		if( $ST_TIME - time() > 0 ) {
			echo "The event has not started yet.";
		} else if( time() - $ET_TIME > 0 ) {
			echo "The event has ended. Please wait while the results are being composed.";
		} else {
			$Db = new clsTbsSQL();
			$Db->Connect( $DBHost, $DBUser, $DBPass, $DBName );
			$result = $Db->GetRows( "select * from " . $EVENT_NAME . "_progress where team = @1@", $team );
			if( !$result ) {
				$Db->Execute( "insert into " . $EVENT_NAME . "_progress values ( @1@, 1, now() )", $team );
			}
			$Db->Close();
			if( isset( $_POST['ans'] ) ) {
				if (!is_numeric($_POST['ans']))
					$_POST['ans'] = strtolower($_POST['ans']);
				$Db = new clsTbsSQL();
				$Db->Connect( $DBHost, $DBUser, $DBPass, $DBName );
				$result = $Db->GetRows( "select ans from " . $EVENT_NAME . "_questions where ans = @2@ and no = (select no from " . $EVENT_NAME . "_progress where team = @1@)", $team, $_POST['ans'] );
				if( $result ) {
					$Db->Execute( "update " . $EVENT_NAME . "_progress  set no = no + 1 where team = @1@", $team );
					$Db->Execute( "update " . $EVENT_NAME . "_progress  set uptime = now() where team = @1@", $team );
				} else {
					echo "Incorrect<br/>";
				}
				$Db->Close();
			}
			$Db = new clsTbsSQL();
			$Db->Connect( $DBHost, $DBUser, $DBPass, $DBName );
			$result = $Db->GetRow("select no, ques from " . $EVENT_NAME . "_questions where no = (select no from " . $EVENT_NAME . "_progress where team = @1@)", $team );
			if( $result ) {
				echo "<br/><div id=\"ques_text\">Question : " . $result['no'] . "</div><br />";
				echo "<div id=\"ques\"><img src=\"".$result['ques'] . "\"></div><br />";
				echo "<input type=\"text\" name=\"ans\" id=\"ans\" />";
				echo "<input id=\"button\" name=\"login\" type=\"submit\"/>";
			} else {
				echo "You have completed all questions. Please wait while the results are being composed.";
			}
			$Db->Close();
		}
		
	}
?>
					</form>
					<div id="button"><a href="logout.php">Logout</a></div>
				</div><br/>
			</center>					
		</div>
		<div id="footer">
		</div>
	</body>
</html>
