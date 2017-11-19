function ServerTimer(mytime)
{
	
if(mytime<=0)
{
	alert("Time's Up");
	window.location="ans.php";
}

seconds=mytime%60;
minutes=parseInt(mytime/60)%60;
hours=parseInt(mytime/3600)%24;



seconds=(seconds<10)?"0"+seconds:seconds;
minutes=(minutes<10)?"0"+minutes:minutes;
hours=(hours<10)?"0"+hours:hours;


			
document.getElementById("servertime").innerHTML=hours+" : "+minutes+" : "+seconds;
setTimeout("ServerTimer("+(mytime-1)+")", 1000);
}


function padlength(what){
var output=(what.toString().length==1)? "0"+what : what
return output
}

function displaytime(){
serverdate.setSeconds(serverdate.getSeconds()+1)
var datestring=montharray[serverdate.getMonth()]+" "+padlength(serverdate.getDate())+", "+serverdate.getFullYear()
var timestring=padlength(serverdate.getHours())+":"+padlength(serverdate.getMinutes())+":"+padlength(serverdate.getSeconds())
document.getElementById("servertimenow").innerHTML=datestring+" "+timestring
}

window.onload=function(){
	setInterval("displaytime()", 1000)
}