//-------------------------------------------------------------
var menunum = 1,m = null,movedfodiv,menuwidth = 0,movedfom;
var nowlocation=null;
var visit=null;
var mothercontent = "";
var menuarray = new Array;
var menuZJJ = new Array;contextPath="";
function setm (myname,obj) {
	eval("parent.m." + myname + " = obj.value");
	}
function getm (myname) {
	var rebox = eval("parent.m." + myname)
	if (rebox == null){
		rebox ="";
		}
	return rebox;
	}
function returnm(myobj,myname) {
	if (document.all(myobj) != null) {
		document.all(myobj).value = getm(myname);
		}
	}
function addmenu (addurl,addname,imageurl) {
	var docname = "<div id='mymenu"+menunum+"' class='menu_off' onclick='topmenuclick(\""+addurl+"\",this)'>"+addname+"</div>";
	document.write("<div id='mymenu"+menunum+"' class='" + ((menunum == 1)?"menu_on":"menu_off") + "' onclick='topmenuclick(\""+addurl+"\",this)'>"+addname+"</div>");
	menuarray[menunum-1] = docname;
	menuZJJ[menunum-1] = menunum;
	mothercontent += "<div class=\"childstyle\" onmouseOver=\"this.style.backgroundColor=\'#E9F5F9\'\" onmouseOut=\"this.style.backgroundColor=\'#F7FCFD\'\" onclick=\"parent.gotomylocation(\'mymenu" + menunum + "\'," + menunum + ")\">"+addname+"</div>"
	nowlocation = document.all("mymenu1");
	menuwidth = menuwidth + 15*addname.length+16
	if (menunum == 1) {
		m = new Object;
		}
	menunum ++;
}
function addmenuleft () {
	document.write("<div class=\"left_iframemenu\" id=\"menuonleft\"><div class=\"left_iframemenu_auto\" id=\"menuonleft_box\">");
	}
function addmenuright () {
	document.write("</div></div>");
	}
function addmenumore () {
	document.write("<div class=\"right_iframemenu\">");
	document.write("<div class=\"button_if_left\" onmousedown=\"ch(-15,'menuonleft')\" onmouseup=\"rch()\"><img src=\""+contextPath +"/images/ifright.gif\"></div>");
	document.write("<div class=\"button_if_right\" onmousedown=\"ch(15,'menuonleft')\" onmouseup=\"rch()\"><img src=\""+contextPath +"/images/ifleft.gif\"></div>");
	document.write("<div class=\"button_if_right\" onclick=\"selectmenu(this)\">¡ý</div>");
	document.write("</div>");
	}
function selectmenu (obj) {
	if (document.all("menumother") == null){
			brinmenumother ();
			motherlocation (obj);
			printinmother ();
			reloadmother(menunum);
		}else {
			closemother ();
		}
	}
function closemother () {
	if (document.all("menumother") != null){
		if(document.all("menumother").style.display == "block"){
				document.all("menumother").style.display = "none";
			}else{
				document.all("menumother").style.display = "block";
			}
		}
	}
function reloadmother (num) {
	document.getElementById("menumother").style.posHeight = (num)*20+2;
	}
function printinmother () {
	addmen ="<link href=\"" + contextPath + "/css/css_1/iframemenu.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />";
	window.frames["menumother"].document.write(addmen + "<body style=\"background:#F7FCFD; margin:0px; padding:0px;\" oncopy=\"return false;\" oncut=\"return false;\" onselectstart=\"return false;\"  oncontextmenu=\"return false;\"><div class=\"childstyleclose\" onclick=\"parent.closemother()\">¡Á</div>"+mothercontent+"</body>");
	}
function brinmenumother () {
	if (document.all("menumother") == null){
		var addl;
		addl = document.createElement("<iframe id=\"menumother\" class=\"menumother\" style=\"display:block;\" frameborder=\"0\" scrolling=\"no\"></iframe>");
		document.body.appendChild(addl);
		}
	}
function gotomylocation (obj,num) {
	if (nowlocation != null) {
		nowlocation.className="menu_off";
		}
	var addl="",mp = "";
	for (var p=0; p<menuZJJ.length; p++) {
		if (menuZJJ[p] == num) {
			menuZJJ.splice(p,1);
			menuZJJ.unshift(num);
			}
		}	
	document.getElementById("menuonleft_box").removeNode(true);
	addl = document.createElement("<div class=\"left_iframemenu_auto\" id=\"menuonleft_box\"></div>");
	document.getElementById("menuonleft").appendChild(addl);
	for (var i=0;i<menuZJJ.length;i++) {
		if (menuZJJ[i] != null) {
			mp += menuarray[menuZJJ[i]-1];
			}
		}
	document.getElementById("menuonleft_box").innerHTML = mp;
	document.getElementById(obj).click();
	closemother();
	}
function sumalldiv(num) {
	var allboxwidth = 0;
	for (var i=1;i<num;i++) {
		allboxwidth += parent.document.getElementById("mymenu" + i).offsetWidth + 1;
		}
	return allboxwidth;
	}
function motherlocation (obj) {
	vSrc = obj;
	if (document.all("menumother") != null){
		h = vSrc.offsetHeight;
		w = vSrc.offsetWidth;
		l = vSrc.offsetLeft;
		t = vSrc.offsetTop + h + 5;
		vParent = vSrc.offsetParent;
		while (vParent.tagName.toUpperCase() != "BODY")
			{
				l += vParent.offsetLeft;
				t += vParent.offsetTop;
				vParent = vParent.offsetParent;
			}
		}
	 document.getElementById("menumother").style.posLeft = l - 170;
	 document.getElementById("menumother").style.posTop = t;
	}
function ch(m,p){
	movedfom=m;
	moveobject=p;
	movedfodiv=window.setInterval("chforstep(moveobject)",10);
}
function chforstep (m) {
	if (menuonleft.scrollLeft<=menuwidth-document.all("menuonleft").offsetWidth||movedfom<0)
	eval(m).scrollLeft+=movedfom
}
function rch() {
	window.clearInterval(movedfodiv);
}
function reloadvisit (obj,addurl,addname) {
	if (parent.document.all(obj) != null) {
		if (parent.document.all(obj) != parent.nowlocation) {
				parent.document.all(obj).outerHTML = "<div id='"+obj.toString()+"' class='menu_off' onclick='topmenuclick(\""+addurl+"\",this)'>"+addname+"</div>"
			}else{
				parent.document.all(obj).outerHTML = "<div id='"+obj.toString()+"' class='menu_on' onclick='topmenuclick(\""+addurl+"\",this)'>"+addname+"</div>"
			}
		}
		menunum ++;
	}
function topmenuclick (thUrl,thobj) {
	if (nowlocation!=thobj) {
		if(nowlocation!=null){nowlocation.className="menu_off";}
		thobj.className="menu_on";
		nowlocation=thobj;
		if (document.all("mywin") != null) {
				mywin.location.href=thUrl;		
			}
		if (document.all("mywinin") != null) {
				mywinin.location.href=thUrl;		
			}
		}	
}
