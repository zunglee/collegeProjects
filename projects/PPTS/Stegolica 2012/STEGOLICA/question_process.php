<?php
	session_start();
	include "dbconnect.php";
	include "variable.php";
	if(($show_ans<0)){
		header("location:"."ans.php");
		exit();
	}
	
	if (isset($_SESSION['user']) && isset($_SESSION['score'])){
		//header("Location: index.php");
	}
	
	$qid=$_SESSION['score']+1;
	$query = "SELECT ans FROM question_info where qid='{$qid}'";
	$result=mysql_query($query)  or die("Query failed:1 ".mysql_error());
	$row = mysql_fetch_array($result);
	$ans= $row['ans'];
	
	$pro_ans=$_POST['pro_ans'];
	$pro_ans=strip_tags($pro_ans);
	$pro_ans=htmlentities($pro_ans,ENT_QUOTES);
	$pro_ans=addslashes($pro_ans);
	$pro_ans=md5($pro_ans);
	
	$ans=htmlentities(stripslashes($ans), ENT_QUOTES);
	
	//Security////
	
	if ($pro_ans==$ans){
		//updating the time of submission
		//$mani = date('H:i:s',time() + (4 * 60));
		$mani = date('Y-m-d H:i:s',time());
		$query = "UPDATE user_info SET  score=score+1, time = '$mani' WHERE user_id ='{$_SESSION['user']}'"; 
		$result=mysql_query($query)  or die("Query failed2: ".mysql_error());
		$_SESSION['score']=$_SESSION['score']+1;
		$_SESSION['message']="";
		
		if ($_SESSION['score']==$total_question)
			header("Location: winner.php");
	}
	else{
		$_SESSION['message']="Try Again";
	}
	
	header('Location: question.php');
	exit;		
?>