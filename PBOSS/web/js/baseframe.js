//-------------------------------------------------------------
//                 baseframe.js��������
//           ���ص���,ʹϵͳ��������Ҫ����
//                      ҳ����ع���
//-------------------------------------------------------------

var frameAllWidth,frameAllHeight,browseTitleHeight,frameLeftWidth,frameLeftHeight,frameLeftContentWidth;
var line,frameLeftTopHeight,frameRightHeight,frameRightTopHeight;
var frameBottomStyle,userHeight;
//-------------------------------------------------------------
//�˵��ƶ�����
//-------------------------------------------------------------
var movedfodiv,movedfom,moveobject
//-------------------------------------------------------------
//��ǰĿ¼
//-------------------------------------------------------------
var nowlocation=null;
//-------------------------------------------------------------
//Ĭ�ϵĵ�ǰ����ҵ������
//-------------------------------------------------------------
var iframeNowMenu = "IFRM_MAIN1";
function baseframe () {
	newWindowResize();
	//-------------------------------------------------------------
	//�������߶��趨
    //-------------------------------------------------------------
	browseTitleHeight=24;
	//-------------------------------------------------------------
	//��ܿ�,��ȡֵ,ʹ������ȫ��Ч��
    //-------------------------------------------------------------
	frameAllWidth=window.screen.availWidth;
	frameAllHeight=window.screen.availHeight-browseTitleHeight;
	//-------------------------------------------------------------
	//��ܿ�,�߽���
    //-------------------------------------------------------------
	document.all("top").style.posWidth=frameAllWidth;
	document.all("topdown").style.posWidth=frameAllWidth;
	document.all("top").style.posHeight=58;
	document.all("topdown").style.posHeight=frameAllHeight-58;
	//-------------------------------------------------------------
	//���ҿ�ܿ��ƽ��,�߶�100%
    //-------------------------------------------------------------
	frameLeftWidth=136;
	document.all("left").style.posWidth=frameLeftWidth;
	document.all("right").style.posWidth=frameAllWidth-frameLeftWidth;
	//-------------------------------------------------------------
	//������Ĭ�Ͽ�ȣ�IFRM_LEFT_TOPĬ�ϸ߶�
    //-------------------------------------------------------------
	line=8;
	frameLeftTopHeight=500;

	frameLeftContentWidth=frameLeftWidth-line;
	document.all("left_content").style.posWidth=frameLeftContentWidth;
	document.all("left_line").style.posWidth=line;
	frameLeftHeight=document.all("left").offsetHeight;
	//-------------------------------------------------------------
	//280��Դ�����ڵ�line;
    //-------------------------------------------------------------
	frameLeftTopBottom = frameLeftHeight - frameLeftTopHeight - line;
	document.all("left_content_top").style.posHeight=frameLeftTopHeight;
	document.all("IFRM_LEFT_TOP").style.posHeight=frameLeftTopHeight;
	document.all("left_content_line").style.posHeight=line;
	document.all("left_content_bottom").style.posHeight=frameLeftHeight-frameLeftTopHeight-line;
	document.all("IFRM_LEFT_BOTTOM").style.posHeight = frameLeftHeight-frameLeftTopHeight-line;
	//-------------------------------------------------------------
	//frameRightTopHeight���ݴ���Ĭ�ϸ߶ȣ����������Ƿ��
    //-------------------------------------------------------------
	frameRightTopHeight=590;
	frameBottomStyle=false;
	frameRightHeight=frameLeftHeight;
	framebottomdisplay(frameBottomStyle);

	frameContentBottomFettle = false;
	frameContentBottomDisplay (frameContentBottomFettle);

	document.all("IFRM_TOP").focus();
}
function framebottomdisplay(objstyle) {
	//-------------------------------------------------------------
	//�Ҳര����ʾ
    //-------------------------------------------------------------
	if (objstyle){
		document.all("right_top").style.posHeight=frameRightTopHeight;
		document.all("right_line").style.display="";
		document.all("right_line").style.posHeight=line;
		document.all("right_bottom").style.display="";
		document.all("right_bottom").style.posHeight=frameRightHeight-line-frameRightTopHeight;
		}else {
			document.all("right_top").style.posHeight=frameRightHeight;
			document.all("right_line").style.display="none";
			document.all("right_bottom").style.display="none";
			}
}
function frameContentBottomDisplay(objstyle) {
	//-------------------------------------------------------------
    //��ര����ʾ
    //-------------------------------------------------------------
	if (objstyle){
		document.all("left_content_top").style.posHeight=frameLeftTopHeight;
		document.all("IFRM_LEFT_TOP").style.posHeight=frameLeftTopHeight;
		document.all("left_content_line").style.display="";
		document.all("left_content_line").style.posHeight=line;
		document.all("left_content_bottom").style.display="";
		document.all("left_content_bottom").style.posHeight=frameLeftHeight-line-frameLeftTopHeight;
		}else {
			document.all("left_content_top").style.posHeight=frameLeftHeight;
			document.all("IFRM_LEFT_TOP").style.posHeight=frameLeftHeight;
			document.all("left_content_line").style.display="none";
			document.all("left_content_bottom").style.display="none";
			}
}
//-------------------------------------------------------------
//��ťЧ��
//-------------------------------------------------------------
function buttonover (thobj) {
	//thobj.style.color="#ffffff"
}
function buttonout (thobj) {
	//thobj.style.color="#ffffff"
}
function buttonoverpage (thobj) {
	//thobj.style.color="#ffffff"
}
function buttonoutpage (thobj) {
	//thobj.style.color="#ffffff"
}
function buttonoverselect (thobj) {
	//thobj.style.backgroundImage="url(../../images/btnUnify/button_B_2.gif)";
	//thobj.style.color="#ffffff"
}
function buttonoutselect (thobj) {
	//thobj.style.backgroundImage="url(../../images/btnUnify/button_B_2.gif)";
	//thobj.style.color="#ffffff"
}

function leftcloseORopen () {
	//-------------------------------------------------------------
	//left display;
	if (document.all("left").style.posWidth==frameLeftWidth) {
		document.all("left_content").style.display="none";
		document.all("left").style.posWidth=line;
		document.all("right").style.posWidth=frameAllWidth-line;
		}else{
		document.all("left_content").style.display="";
		document.all("left").style.posWidth=line+frameLeftContentWidth;
		document.all("right").style.posWidth=frameAllWidth-line-frameLeftContentWidth;
		}
}
var thiskey=null;
function leftcontentcloseORopen(objkey) {//left_bottom display
	if (thiskey==null||thiskey==objkey) {
	if (document.all("left_content_top").style.posHeight==frameLeftTopHeight) {
		document.all("left_content_bottom").style.display="none";
		document.all("left_content_top").style.posHeight=frameLeftHeight-line;
		document.all("IFRM_LEFT_TOP").style.posHeight=frameLeftHeight-line;
		thiskey=objkey;
		}else{
		document.all("left_content_bottom").style.display="";
		document.all("left_content_top").style.posHeight=frameLeftTopHeight;
		document.all("IFRM_LEFT_TOP").style.posHeight=frameLeftTopHeight;
		thiskey=null;
		}
	//-------------------------------------------------------------
	//IFRM_LEFT_TOP.leftmenuload(),������չ��ʾ�˵�ʱ���õ�����ͬ��
    //-------------------------------------------------------------
	}
}
function lefttopcloseORopen(objkey) {//left_top display
	if (thiskey==null){
	userHeight=IFRM_LEFT_TOP.user.offsetHeight;
	}
	if (thiskey==null||thiskey==objkey) {
	if (document.all("left_content_bottom").style.posHeight==(frameLeftHeight-frameLeftTopHeight-line)) {
		document.all("left_content_top").style.posHeight=userHeight;
		document.all("IFRM_LEFT_TOP").style.posHeight=userHeight;
		document.all("left_content_bottom").style.posHeight=frameLeftHeight-line-userHeight;
		document.all("IFRM_LEFT_BOTTOM").style.posHeight=frameLeftHeight-line-userHeight;
		thiskey=objkey;
		}else{
		document.all("left_content_top").style.posHeight=frameLeftTopHeight;
		document.all("IFRM_LEFT_TOP").style.posHeight=frameLeftTopHeight;
		document.all("left_content_bottom").style.posHeight=frameLeftHeight-frameLeftTopHeight-line;
		document.all("IFRM_LEFT_BOTTOM").style.posHeight=frameLeftHeight-frameLeftTopHeight-line;
		thiskey=null;
		}

	//IFRM_LEFT_BOTTOM.leftmenuload();
	}
}
function rightcloseORopen() {//right display;
	if (document.all("right_top").style.posHeight==frameRightTopHeight) {
		document.all("right_bottom").style.display="none";
		document.all("right_top").style.posHeight=frameRightHeight-line;
		document.all(iframeNowMenu).style.posHeight=frameRightHeight-line;
		}else{
		document.all("right_bottom").style.display="";
		document.all("right_top").style.posHeight=frameRightTopHeight;
		document.all(iframeNowMenu).style.posHeight=frameRightTopHeight;
		}
}
function openmainframe() {
	window.open("index.html","_blank","toolbar=no,location=no,resizable=1,width=1024,height=740,status=yes,scrollbars=no");
}
function newWindowResize() {
	//-------------------------------------------------------------
	//����
    //-------------------------------------------------------------

	h=window.screen.availHeight+8;
	w=window.screen.availWidth+8;
	resizeTo(w,h);
	moveTo(-4,-4);
	//-------------------------------------------------------------
	//Ŀǰ��system�¸ô���ʧЧ
    //-------------------------------------------------------------
	if (window.opener != null) {
		window.opener.opener=null;
		window.opener.close();
		}
	}
function ifrmMainAutoHeight () {
	//-------------------------------------------------------------
	//iframe��ǩ����Ӧ
	//alert(iframeNowMenu);
	//-------------------------------------------------------------
	document.all("IFRM_MAIN").offsetHeight = document.all("right_top").style.posHeight;
	//alert(document.all("right_top").style.posHeight);
	/*
	if (IFRM_MAIN.document.body.scrollHeight<=document.all("right_top").style.posHeight){
		}else{
	*/
	//document.all("IFRM_MAIN").style.posHeight=IFRM_MAIN.document.body.scrollHeight;
	//document.all("IFRM_MAIN").style.posHeight-=20;
	//}
}
//-------------------------------------------------------------
function goInfo (obj,str) {
	if (parent.iframeNowMenu == "IFRM_MAIN1" || parent.iframeNowMenu == "IFRM_MAIN2") {
		if (parent.IFRM_TOP.iframeMenuNum > 3) {
			parent.IFRM_TOP.iframeMenuUpFloor(parent.IFRM_TOP.eval("d3"));
			parent.IFRM_TOP.iframeMenuMain("IFRM_MAIN3");
			}else{
			parent.IFRM_TOP.addIframeMenuDb (parent.IFRM_TOP.message)
			}
		}
	parent.document.all(parent.iframeNowMenu).src = str
	parent.menucloseall();
	}
//-------------------------------------------------------------
var menunum = 1,m = null,movedfodiv,menuwidth = 0,movedfom;
var nowlocation=null;
var visit=null;
var mothercontent = "";
var menuarray = new Array;
var menuZJJ = new Array;
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
var PowerUrl = "";
var PowerKey = "";
function addmenu (addurl,addname,imageurl) {
	var docname = "<div id='mymenu"+menunum+"' class='menu_off' onclick='topmenuclick(\""+addurl+"\",this)'>"+ addname+"</div>";
	document.write("<div id='mymenu"+menunum+"' class='" + ((menunum == 1)?"menu_on":"menu_off") + "' onclick='topmenuclick(\""+addurl+"\",this)'>"+addname+"</div>");
	menuarray[menunum-1] = docname;
	menuZJJ[menunum-1] = menunum;
	mothercontent += "<div class=\"childstyle\" onmouseOver=\"this.style.backgroundColor=\'#E9F5F9\'\" onmouseOut=\"this.style.backgroundColor=\'#F7FCFD\'\" onclick=\"parent.gotomylocation(\'mymenu" + menunum + "\'," + menunum + ")\">"+addname+"</div>"
	nowlocation = document.all("mymenu1");
	menuwidth = menuwidth + 15*addname.length+18;
	if (menunum == 1) {
		m = new Object;
		PowerUrl = addurl;
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
	document.write("<div class=\"button_if_left\" onmousedown=\"ch(-15,'menuonleft')\" onmouseup=\"rch()\" onmouseout=\"rch()\"><img src=\""+contextPath +"/images/ifright.gif\"></div>");
	document.write("<div class=\"button_if_right\" onmousedown=\"ch(15,'menuonleft')\" onmouseup=\"rch()\" onmouseout=\"rch()\"><img src=\""+contextPath +"/images/ifleft.gif\"></div>");
	document.write("<div class=\"button_if_right\" onclick=\"selectmenu(this)\"><img src=\""+contextPath +"/images/ifmenu.gif\"></div>");
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
function closemotherdoor () {
	if (document.all("menumother") != null){
		if(document.all("menumother").style.display == "block"){
				document.all("menumother").style.display = "none";
			}
		}
	}
function reloadmother (num) {
	if (num >20) {
		document.getElementById("menumother").style.posHeight = 20*20+3;
		}else{
		document.getElementById("menumother").style.posHeight = (num)*20+3;
		}
	}
function printinmother () {
	addmen ="<link href=\"" + contextPath + "/css/iframemenu.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />";
	window.frames["menumother"].document.write(addmen + "<body class=\"Menumotherscroll\" style=\"background:#F7FCFD; margin:0px; padding:0px;\" oncopy=\"return false;\" oncut=\"return false;\" onselectstart=\"return false;\"  oncontextmenu=\"return false;\"><div class=\"childstyleclose\" onclick=\"parent.closemother()\">��</div>"+mothercontent+"</body>");
	}
function brinmenumother () {
	if (document.all("menumother") == null){
		var addl;
		addl = document.createElement("<iframe id=\"menumother\" class=\"menumother\" onmouseout=\"closemotherdoor()\" style=\"display:block;\" frameborder=\"0\" scrolling=\"yes\"></iframe>");
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
	document.getElementById("menuonleft").scrollLeft = 0;
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
		if (IFRM_MAIN.jumpstr != null) {
			IFRM_MAIN.jumpstr = true;
			}
		if (!postURL(thUrl, 	"IFRM_MAIN")) {
			return;
			}
		if(nowlocation!=null){nowlocation.className="menu_off";}
		thobj.className="menu_on";
		nowlocation=thobj;	
		}	
}
function ifrmMainAutoHeight () {

}

function postURL( url, target ) {
		var strUrl = url != null ? url : "";
		var addf;
		
		var urlArray = strUrl.split("?");
		var urlBase = urlArray[0];
		var strEnding = urlArray.length > 1 ? urlArray[1] : "";
		
		var urlForm = document.createElement("form");	
		urlForm.name = "urlForm";	
		urlForm.action = urlBase;
		urlForm.target = target;
		urlForm.method = "POST";
		var urlDiv = document.createElement("div");	
		urlDiv.id = "urlDiv";
		urlDiv.name = urlDiv.id;
		urlDiv.innerText = "";		
		
		document.body.appendChild(urlDiv);
		var itemArray = strEnding.split("&");		
		for(i=0;i<itemArray.length;i++){
			
			var paramArray = itemArray[i].split("=");
						
			var paramName = paramArray[0];
			var paramValue = paramArray.length > 1 ? paramArray[1] : null;
			var inputEle = document.createElement("input");
			inputEle.name = paramName;
			inputEle.value = paramValue;
			if(paramName!=null && paramName!="" && paramValue!=null) 
				urlForm.appendChild(inputEle);			
		}
		
		
		if(itemArray.length > 0) {
			urlDiv.appendChild(urlForm);
			try {
				urlForm.submit();
				document.body.removeChild(urlDiv);
				return true;
				}
			catch (exception) {
				document.body.removeChild(urlDiv); 
				return false;
			}
		}		
		
}

