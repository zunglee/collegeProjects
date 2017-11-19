<?php

	session_start();
		
	if ($_SESSION['login'] == "YES"){
		$username = $_SESSION['loginid'];
	} else {
		$_SESSION['login'] = "NO";
		header("Location:login.php");
		exit;
	}

	$qno = $_GET['qno'];
	$value = $_GET['value'];
	
	if ($qno == "" || $value == ""){
		header("Location:arena.php");
	}
	
	include("db_connect.php");
	
	$query = "select * from answers where qno = $qno";
	$result = mysql_query($query);
	$record = mysql_fetch_array($result);
	
	if ($value == $record['answer']){
		$qname = "q" . $qno;
		
		$sql_1 = "select * from users where email = '$username'";
		$res_1 = mysql_query($sql_1) or die("could not retrieve data");
		$rec_1 = mysql_fetch_array($res_1);
		
		$point = $rec_1['points'] + $record['points'];
		$cur_time = time();
			
		$sql_2 = "update users set $qname = 1,points = $point, time=$cur_time where email = '$username'";
		$res_2 = mysql_query($sql_2) or die("could not update data");
		
		$_SESSION['mcode'] = "21";
		$_SESSION['message'] = "Correct Answer";
		header("Location:arena.php"); 	
	
	} else {
		$_SESSION['mcode'] = "21";
		$_SESSION['message'] = "Wrong Answer";
		header("Location:arena.php");	
	}	
?>
