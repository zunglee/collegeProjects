<?php
	ob_start();
	require_once( "tbssql_mysqli.php" );
	require_once( "reg_chk.php" );
	require_once( "pass_chk.php" );
	require_once( "db_config.php" );
	session_start();
?>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Stegolica</title>
		<link rel="shortcut icon" type="image/x-icon" href="images/icon.ico"/>
		<link rel="stylesheet" type="text/css" href="style.css"/>
	</head>
	<body>
		<div id="container">
			<div id="holder">
				<div id="wrapper">
				<a href="#home"><img src="images/icon2.jpg" id="icon" title="Home"/></a>
					<div id="content_wrapper">
						<div class="content">
							<div class="content_area" id="home"><p>So, how do you hide information you don't want others to see? Cryptography, encryption ?<br/>Back in 440 BC Histiaeus, shaved the head of his most trusted slave and tattooed a message on it, instigating a revolt against the Persians. After his hair had grown the message was hidden. These days, slightly more advanced techniques are used, ranging from invisible ink and microdots to spread spectrum radio communication, Covert channels, Null ciphers and what not. This is Steganography, the science of hiding information.<br/>If cryptography was obscuring the meaning of message then steganography alludes the very existence of it.Behind the veil of obvious messages lies the information that can shatter nations and build a new world order.So probe into the cavern of stegolica and beat the challenge by climbing the acme of dextrality.</p></div>
							<div class="content_area" id="rules">
							<ul>
								<br/>
								<li>-> This is not a team event. Only individual participation is allowed.</li><br/>
								<li>-> Event will be of 6 hours duration.</li><br/>
								<li>-> There will be total of around 10-15 questions.</li><br/>
								<li>-> In case of any dispute decision of the organizers will be binding.</li><br/>
								<li>NOTE : Any rule can be added/changed/removed without prior information </li>
							</ul>
							</div>
							<div class="content_area" id="arena">
								<br/>
								<br/>
								<br/>
								<center>
								<form action="index.php" method="post">
									<?php
										if( !isset($_SESSION['team']) ) {
											include('login.php');
										} else {
											header('Location:ques.php');
										}
									?>
								<tr>
									<td></td>
									<td align="center" valign="middle"><input id="button" name="login" type="submit"/></td>
								</tr>
								</table>
								</form>
								</center>
							</div>
							<div class="content_area" id="contact">
								<ul>
									<br/>
									<li><b>Nishant Garg</b></li>
									<li>Ph no.: +91-9559226534</li>
									<li>E-mail: niks1490@gmail.com </li><br/>
									<li><b>Manish Untwal</b></li>
									<li>Ph no.: +91-9198876172</li>
									<li>E-mail: manishuntwal6@gmail.com</li><br/>
									<li><b>Suyash Katiyar</b></li>
									<li>Ph no.: +91-9792028257</li>
									<li>E-mail: suyash.godfather@gmail.com</li><br/>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div id="sidebar">
				<ul id="menu">
					<li><a href="#rules">Rules</a></li>
					<li><a href="#arena">Enter Arena</a></li>
					<li><a href="http://effervescence.iiita.ac.in/web.index.html">Register</a></li>
					<li><a href="#contact">Contact Us</a></li>
					<li><a href="logout.php">Logout</a></li>
				</ul>
				</div>
				<a href="http://www.facebook.com/pages/Stegolica/105665746201716"><img src="images/facebook1.png" id="icon_2"/></a>
				<a href="http://www.twitter.com/Stegolica"><img src="images/twitter.png" id="icon_3"/></a>
			</div>
		</div>
		<div id="footer">
		</div>
	</body>
</html>
<?php
	ob_end_flush();
?>
