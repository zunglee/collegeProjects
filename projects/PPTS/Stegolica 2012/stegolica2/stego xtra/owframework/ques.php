<?php
	if( isset($_SESSION['team']) ) {
		$ST_TIME = $ST_TIME - 5 * 60 * 60 - 30 * 60;
		$ET_TIME = $ET_TIME - 5 * 60 * 60 - 30 * 60;
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
				$Db = new clsTbsSQL();
				$Db->Connect( $DBHost, $DBUser, $DBPass, $DBName );
				$result = $Db->GetRows( "select ans from " . $EVENT_NAME . "_questions where ans = @2@ and no = (select no from " . $EVENT_NAME . "_progress where team = @1@)", $team, $_POST['ans'] );
				if( $result ) {
					$Db->Execute( "update " . $EVENT_NAME . "_progress  set no = no + 1 where team = @1@", $team );
					$Db->Execute( "update " . $EVENT_NAME . "_progress  set uptime = now() where team = @1@", $team );
				} else {
					echo "Incorrect";
				}
				$Db->Close();
			}
			$Db = new clsTbsSQL();
			$Db->Connect( $DBHost, $DBUser, $DBPass, $DBName );
			$result = $Db->GetRow("select no, ques from " . $EVENT_NAME . "_questions where no = (select no from " . $EVENT_NAME . "_progress where team = @1@)", $team );
			if( $result ) {
				echo $result['no'] . "<br />";
				echo $result['ques'] . "<br />";
				echo "<input type=\"text\" name=\"ans\" id=\"ans\" />";
			} else {
				echo "You have completed all questions. Please wait while the results are being composed.";
			}
			$Db->Close();
		}
		
	}
?>