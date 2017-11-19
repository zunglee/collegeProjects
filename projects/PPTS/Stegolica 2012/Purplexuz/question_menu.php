<?php
	session_start();
	//$_SESSION['index']=$_REQUEST['var'];
	$k=$_REQUEST['var'];

	
	
		$temp="question.php?var=".$k;
		header("Location:".$temp);
		exit;
	
?>
