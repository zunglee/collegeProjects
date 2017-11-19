<?php
 //do not use  $temp['index']
			 include "dbconnect.php";
			 include "variable.php";
			 $total_user=0;
			 $query = "SELECT user_key  FROM user_info ";
			 $result=mysql_query($query)  or die("Query failed:1 ".mysql_error());
			 while ($row = mysql_fetch_array($result))
			 {
				$total_user++;
				$temp[]=0;
			 }
			 $index=0;
			 $query = "SELECT * FROM user_info";//change this
			 $result=mysql_query($query)  or die("Query failed:2 ".mysql_error());
			 $j=1;
			 while ($row = mysql_fetch_array($result))
			 {
				$temp=0;
				for($i=0;$i<$total_question;$i++)
					$temp+=$row[$arr[$i]];
			
				$query = "UPDATE user_info SET score = {$temp} WHERE user_key = {$j} ";
				//echo $j." ".$temp."\n";
				$res1=mysql_query($query)  or die("Query failed:3 ".mysql_error());
				$j++;
			 }
			 
			mysql_close($connection);
?>
