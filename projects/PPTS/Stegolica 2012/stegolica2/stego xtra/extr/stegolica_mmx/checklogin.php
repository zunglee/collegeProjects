<?php
	session_start();

	include ("db_connect.php");

	// getting the username and password
	
	$username = trim(htmlspecialchars(strip_tags($_POST['username'])));
	$password = htmlspecialchars(strip_tags($_POST['password']));
	
	// retrieving data from table user_profile of database stockhunt
	
	if (ereg("^[A-Za-z0-9_.@!$]+$", $username) == false){
		$_SESSION['mcode'] = "01";
		$_SESSION['message'] = "Please enter valid email id";
		header("Location:index_login.php");
		exit;
	}
	
	if (ereg("^[A-Za-z0-9_.@!$%&]+$", $password) == false){
		$_SESSION['mcode'] = "01";
		$_SESSION['message'] = "Password enter is not valid. Password cannot contain spaces or speacial characters";
		header("Location:index_login.php");
		exit;
	}
	
	$query = "select * from user_profile where email='$username'";
	$result = mysql_query($query);
	
	$num = mysql_num_rows($result);
	$record = mysql_fetch_array($result);
	
	$_SESSION['mcode'] = "11";
	
		
	if ($num >= 1 && $password == $record['password']){
	
		$_SESSION['login'] = "YES";
		$_SESSION['loginid'] = $username;
		$_SESSION['password'] = $password;
		$_SESSION['message'] = "Login Successfull";
		header("Location:arena.php");
		
	} else if ($num >= 1 && $password != $record['password']){
		$_SESSION['login'] = "NO";
		$_SESSION['message'] = "Wrong Password";
		header("Location:index_login.php");
		exit;
	} else {
	     mysql_connect("effervescence.iiita.ac.in", "b2k7", "b@kw@sh");
		mysql_select_db("effervescence");
		
		$query = "select * from user_info where email='$username'";
		$result = mysql_query($query) or die("Not able to retrieve data");
		
		$record = mysql_fetch_array($result);		
		$num = mysql_num_rows($result);
		
		if ($num < 1){
			$_SESSION['message'] = "You are not a registered user";
			$_SESSION['login'] = "NO";
			header("Location:login.php");
		} else {
			if ($password != $record['password']){
			
				$_SESSION['message'] = "Wrong Password";
				
			} else {
			
				$qry = "select * from stegolica where email = '$username'";
				$res = mysql_query($qry);
				
				$num = mysql_num_rows($res);
				
				if ($num < 1){
					$_SESSION['message'] = "You are not registered for stegolica";
				} else {
					$rec = mysql_fetch_array($res);
					
					mysql_close();
					
					
					
					$l_qry = "select * from user_profile where email = '$username'";
					$l_res = mysql_query($l_qry);
					
					$l_num = mysql_num_rows($l_res);
					
					if ($l_num < 1){
						$i_qry = "insert into user_profile values ('$username', '$password')";
						$i_res = mysql_query($i_qry);
						
						mysql_query("insert into users (email) values ('$username')");
						
						
						$_SESSION['login'] = "YES";
						$_SESSION['loginid'] = $username;
						$_SESSION['password'] = $password;
						$_SESSION['loginname'] = $record['name'];
						$_SESSION['message'] = "Login Successful";
					}
						header("Location:index.php");
													
					
				}
			}
		}
		
		
		header("Location:index.php");
		
	}
	
	
?>