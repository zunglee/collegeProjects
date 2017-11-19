<?php
	require_once( "tbssql_mysqli.php" );
	require_once( "reg_chk.php" );
	require_once( "pass_chk.php" );
	require_once( "event_params.php" );
	require_once( "db_config.php" );
	session_start();
?>
<html>
<body>
	<h1>Quiz Events Framework</h1>
	<form method="post" action="index.php">
	<?php
		if( !isset($_SESSION['team']) ) {
			include( 'login.php' );
		} else {
			echo "<a href=logout.php>Logout</a>";
			include( 'ques.php' );
		}
	?>
	<input type="submit" />
	</form>
</body>
</html>
