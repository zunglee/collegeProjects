<?php
	session_start();
	include "dbconnect.php";
	include "variable.php";
	if(($show_ans<0)){
		header("location:"."ans.php");
		exit();
	}
	
	if (isset($_SESSION['user']) && isset($_SESSION['score'])){
		header("Location: index.php");
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
			
?>


<?php 
	
	include "variable.php";
	include "dbconnect.php";
	session_start();
	error_reporting(0);
	
	if (isset($_SESSION['user'])){
		$qid=$_SESSION['score'];
		//echo $qid;
		$query = "SELECT * FROM question_info where qid='{$qid}'";
		$result=mysql_query($query)  or die("Query failed:2 ".mysql_error());
		while($row = mysql_fetch_array($result)){
			$question= $row['question'];
		}
	
		mysql_close($connection);	
	}
	
?>


<html>

    <head>
        <!--Author Divanshu Garg | Shubham Sharma -->
        <title>IT GURU | Effervescence MM12</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
		<script src="js/jquery.js" type="text/javascript"></script>
		<script src="js/ajax.js" type="text/javascript"></script>
        <link href='http://fonts.googleapis.com/css?family=Frijole' rel='stylesheet' type='text/css' />

        <style>
            input:not([type=submit]) {
                border: 2px solid white; 
                border-radius:15px;
                padding: 2px;
                background: rgba(255,255,255,0.5);
                margin: 0 0 10px 0;
            }
            input[type=submit]{
                position:absolute;
                width:100px;
                height:30px;
                border:none;
                border-radius:15px;
                padding:6px 25px;
                background-color:#19ABFA;

                margin-left:150px;
                color:white;
                font-weight:bold;
                cursor:pointer;
            }
            input[type=submit]:hover{
                background-color: #118BF8;
            }
        </style>

    </head>
<?php
echo "<body onLoad='ServerTimer(".$show_ans.")'>";
?>

<div id="wrapper">
	
	<div id="header">
    
    	<div id="site_title"><h1 style="padding-top:13px;font-family:'Frijole' ,'cursive';padding-right:40px;margin-left:5px; margin-right:-5px;">Effervescence</h1><p style="margin-left:100px;">Event Tag Line</p></div>
        
        <div id="fb"><a href="#" ><img src="images/fb.png" height="35px" width="35px" style="border-radius:35px;background-color:rgba(255,255,255,0.8);padding:2px;margin-top:10px;" title="Visit Us at Facebook"/></a></div>
        <div id="menu">
            <ul>
                <li><a href="index.php" >Home</a></li>
                <li ><a href="#" class="current">Arena</a></li>
                <li><a href="score.php" >Scores</a></li>
                <li><a href="rules.php">Rules</a></li>
                <li><a href="contact.php">Contact</a></li>
                <li class="last"><a href="oevent.php">Other Events</a></li>
            </ul>    	
        </div> 
        
    </div> 
    

    <div id="main">
    	<div style="width:960;margin:0px;">
			
            <div style="border-radius:15px;background-color:rgba(255,255,255,0.2);padding:25px;min-height:430px;width:600px;float:left;">
           	  	<div class="post_box">
			  
              		
                    <?php
						
						echo '<div class="post_header"><h2>Arena</h2></div>';
						if (!isset($_SESSION['user'])){ //Not logged in
							
							echo "You must be logged in to view the arena";
						}
						else if ($show_ans<0){
							header("Location: ans.php");
						}
						else if ($ready>0){ //Not ready
							echo "The event will begin at ".$event.". See the <a href='rules.php' >rules</a>";
						}
						else if ($ready<0){
							
							if ($pro_ans==$ans){
							
								//echo $_SESSION['message']."<br />";
								//$qid=$_SESSION['score']+1;
								echo 'Q'.($qid).": ".$question;
								echo 'Explaination: '.$row['explain'];
								echo '<a href="question.php">Next</a>';
								//echo 
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
		header('Location: question.php');
	}
						}
						
					?>
					
                    <div class="cleaner"></div>
              	</div>
				
                
            </div>
            <!--Changes-->
			<div style="border-radius:15px;background-color:rgba(255,255,255,0.2);padding:25px;margin-bottom:30px;width:250px;float:right;">
				
				<div id="serverday"><p style="color:#f9b507;font-weight:bold;">Time Remaining:</p></div><span id="servertime" style="color:#f9b507"></span>
			</div>
			<!-- -->
            <div style="border-radius:15px;background-color:rgba(255,255,255,0.2);padding:25px;margin-bottom:30px;width:250px;float:right;">
            	
                <div class="lbe_box" id="lbox">
					<?php
						
						session_start();
						if(isset($_SESSION['user'])){
							echo '
								<h2>Welcome</h2>'.
								$_SESSION['user'].
								'<br /><a href="logout.php">Logout</a><br />';
						}else
							echo '
								<h2>Login</h2>
								<form action="event_login.php" method="post">
									<label>
										Username :
									<input  type="text" id="user" name="user"/>
									</label>

									<label>
										Password : 
									<input type="password" id="pass" name="pass" style="margin-left:2px;"/>
									</label>
									<br/>
									<input type="submit" value ="Login" />
								</form>';
					?>
					
                </div>

            </div>
            <br/><br/><br/>
            <div  style="border-radius:15px;background-color:rgba(255,255,255,0.2);padding:25px;width:250px;float:right;">
                
                <h2>Latest Updates</h2>
                <div class="lbe_box">
                    <h3>&bull; Event Date : 1st Oct,2012</h3>
                    <p></p>
                    
                </div>
				
                <div class="lbe_box">
                    <h3>&bull; Event Time : 12:00 PM - 5:00PM</h3>
                    <p></p>
                    
                    <div class="cleaner"></div>
                </div>
                <div class="cleaner " style="height:30px;"></div>
            </div>	
        </div>
		
    	<div class="cleaner"></div> 
    </div> 
</div>

<div id="footer_wrapper">
    <div id="footer">
        Owned By <a href="#">GeekHaven</a> | Designed by Divanshu Garg | Shubham Sharma    
    </div>
</div>

</body>
<!--Author Divanshu Garg | Shubham Sharma -->
</html>