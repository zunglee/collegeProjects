<table border="0" cellspacing="0" cellpadding="2">
	<tr>
		<td>Username : </td>
		<td><input name="userid" type="text" value="Username" id="userid"/></td>
	</tr><tr><td></td></tr>
	<tr>
		<td>Password &nbsp;: </td>
		<td><input name="pass" type="password" value="password" id="pass"/></td>
	</tr>
	<tr>
		<td></td>
	</tr>
<?php
	if( isset( $_POST['userid'] ) ) {
		$lg = false;
		$userid = $_POST['userid'];
		$pass = $_POST['pass'];
		if( !strlen( $userid ) == 0 && !strlen( $pass ) == 0 ) {
			if( chk_pass( $userid, $pass ) == 1 && chk_reg( $userid, $EVENT_NAME ) == 1 ) {
				$lg = true;
			}
		}
		if( $lg == true ) {
			$_SESSION['team'] = "test";
			header("Location:ques.php") ;
		}
	}
	if( isset($lg) ) {
		if( $lg == false ) {
			echo "Login Unsuccessful";
		}
	}
?>
