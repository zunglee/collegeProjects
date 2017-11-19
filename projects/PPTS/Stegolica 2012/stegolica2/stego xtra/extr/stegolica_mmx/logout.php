<?php
	session_start();
	
	$_SESSION['login'] = "NO";
	$_SESSION['loginid'] = "";
	
	header("Location:index.html");

?>