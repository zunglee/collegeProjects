<?php

	include("db_connect.php");
	
	$sql_1 = "select * from users order by points desc";
	$res_1 = mysql_query($sql_1);
	
	echo "<a href = \"arena.php\">Back</a>";
	
	echo "<center><table border = 1 cellpadding = 7>";
	echo "<tr><th>Rank</th><th>Username</th><th>Points</th></tr>";
	
	$i = 1;
	
	while ($rec_1 = mysql_fetch_array($res_1)){
	
		$user = $rec_1['email'];
		$point = $rec_1['points'];
		echo "<tr><td>$i</td><td>$user</td><td>$point</td></tr>";	
		$i++;
	}
	
	echo "</table></center>";
?>