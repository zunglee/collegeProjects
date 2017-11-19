<?php 
	
	include "variable.php";
	error_reporting(0);
?>

<html>

    <head>
        <!--Author Divanshu Garg | Shubham Sharma -->
        <title>IT GURU | Effervescence MM12</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
		<script src="js/jquery.js" type="text/javascript"></script>
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

<body>

<div id="wrapper">
	
	<div id="header">
    
    	<div id="site_title"><h1 style="padding-top:13px;font-family:'Frijole' ,'cursive';padding-right:40px;margin-left:5px; margin-right:-5px;">Effervescence</h1><p style="margin-left:100px;">Event Tag Line</p></div>
        
        <div id="fb"><a href="#" ><img src="images/fb.png" height="35px" width="35px" style="border-radius:35px;background-color:rgba(255,255,255,0.8);padding:2px;margin-top:10px;" title="Visit Us at Facebook"/></a></div>
        <div id="menu">
            <ul>
                <li><a href="#" >Home</a></li>
                <li ><a href="question.php">Arena</a></li>
                <li><a href="score.php" >Scores</a></li>
                <li><a href="rules.php" class="current">Rules</a></li>
                <li><a href="contact.php">Contact</a></li>
                <li class="last"><a href="oevent.php">Other Events</a></li>
            </ul>    	
        </div> 
        
    </div> 
    

    <div id="main">
    	<div style="width:960;margin:0px;">
		
            <div style="border-radius:15px;background-color:rgba(255,255,255,0.2);padding:25px;min-height:430px;width:600px;float:left;">
           	  	<div class="post_box">
			  
              		<div class="post_header">
                        <h2>Rules</h2>
                        
                    </div>
					
                   
                    <ul>
						<li>The duration is of 60 mins.</li>
						<li>Each correct answer carries 3 marks.</li>
						<li>Each negative answer deducts 1 mark from your total score.</li>
					</ul>						
                    
					
                    <div class="cleaner"></div>
              	</div>
				
                
            </div>
            
            <div style="border-radius:15px;background-color:rgba(255,255,255,0.2);padding:25px;margin-bottom:30px;width:250px;float:right;">
            	
                <div class="lbe_box" id="lbox">
					<?php
						
						session_start();
						if(isset($_SESSION['user']))
							echo '
								<h2>Welcome</h2>'.
								$_SESSION['user'].
								'<br /><a href="logout.php">Logout</a>';
						else
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
                    <h3>&bull; dsadadsadasdsadas</h3>
                    <p>dsadasdsadasdsadas</p>
                    
                </div>
				
                <div class="lbe_box">
                    <h3>&bull; dsadadsadasdsadas</h3>
                    <p>dsadasdsadasdsadas</p>
                    
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