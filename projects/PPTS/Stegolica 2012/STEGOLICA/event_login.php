<?php

	include "dbconnect.php";
	include "variable.php";
	
	$event_name='STEGOLICA';
	$user_name=trim($_POST['user']);
	$password=trim($_POST['pass']);
	
	$user_name=strip_tags($user_name);
	$password=strip_tags($password);
	$email=$user_name;
	//echo $password;
	
	
	$query="SELECT * from auth_user where email='$user_name'";
	$result=mysql_query($query) or die ("Couldn't retrieve Database....");
	$chk_user=mysql_fetch_array($result);
	$check=0;
	
	//$pass=explode("$",$chk_user["password"]);
	$pass=explode("$","sha1$992c3$750f2d53114b2860889573d409b03a23323de96b");
	$passAct = sha1($pass[1].$password);
	
	//echo $password."<br />".$passAct."<br />".$pass[1]."<br />". $pass[2]."<br />";
	
	if($user_name==$chk_user["email"] && $passAct==$pass[2]){
		$check=1;
	}
	
	
	if($check==1){
		//Correct User	
		//echo $user_name;
		$query="SELECT * from user_info where user_id='$user_name'";
		
		$result=mysql_query($query) or die("Could not retrieve database");
		
		if (mysql_num_rows($result)==0)
			$user_insert=mysql_query("INSERT user_info (user_id) VALUES ('$user_name') ") or die("Some Problem occured. Please login again.");
		
		$result=mysql_query("SELECT * FROM user_info WHERE user_id='$user_name'");
		$row=mysql_fetch_array($result);
		session_start();
		$_SESSION['user']=$user_name;
		$_SESSION['score']=$row['score'];
		header("Location: question.php");
	}
	else
	{
		header("Location:"."loginfailed.php");
	}
	
	
	//user:gagangupt16@gmail.com
	//password:aass
?>