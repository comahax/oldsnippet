function setc(str,value){
var Then = new Date() 
Then.setTime(Then.getTime() + 60*1000*60*24*10 ) //60√Î
document.cookie = str +"="+value+";expires="+ Then.toGMTString();
}

function getc(str){ 
var cookieString = new String(document.cookie);
var cookieHeader = str + "="
var beginPosition = cookieString.indexOf(cookieHeader);
var mycookieString;
if (beginPosition != -1){

mycookieString = cookieString.substring(beginPosition + cookieHeader.length);
return mycookieString.substring(0,mycookieString.indexOf(";")==-1?mycookieString.length:mycookieString.indexOf(";"));
}else{
	return -1;
	}
}

mycook = new Array (10);

function getcookie () {
	for (i=0;i<mycook.length;i++) {
		if (getc("mystr"+i)!=-1){
			mycook[i] = getc ("mystr"+i);
		}else{
			mycook[i] = "";
			}
		}
	}
function setcookie () {
	for (i=0;i<mycook.length;i++) {
		if (mycook[i]!=null){
			setc("mystr"+i,mycook[i]);
		}else{
			setc("mystr"+i,"");
			}
		}
	}
function setar (str) {
	mycook.shift();
	mycook.push(str);
	}
function getar() {
	
	}
function setlocation (myname,mylocation,mytarget) {
	addmylimenu(myname,mylocation);
	if (mytarget!=null) {
		mytarget.location.href=mylocation;
		}
	mystr = myname + "|" + mylocation;
	getcookie();
	getar();
	setar (mystr);
	setcookie();
	}
function getlocation () {
	getcookie();
	getar();
	var mystr,myvalue,ttlost="";
	for (i=mycook.length-1;i>=0;i--) {
		if(mycook[i]!=""){
			mystr=mycook[i].substring(0,mycook[i].indexOf("|"));
			myvalue=mycook[i].substring(mycook[i].indexOf("|")+1);
			ttlost+="<div class='u'><a href='"+myvalue+"' class='menu_c' target='maintop'>"+mystr+"</a></div>";
			}
		}
	pushmenu(ttlost);
	}
function pushmenu(ttlost) {
	document.all("use").innerHTML=ttlost;
	}


function addmylimenu (mystr,myvalue) {
	//var stL="<a href='"+myvalue+"' class='menu_d' target='maintop'>"+mystr+"</a>";
	//var addl = document.createElement(stL);
	//top.mainmenu.body.menu.appendChild(addl);
	top.tabFrame.b(mystr,myvalue);
	}
function closemiddlewin() {
	top.middlewin.rows="22,*,0"
	}
function openmiddlewin() {
	top.middlewin.rows="22,*,210"
	}