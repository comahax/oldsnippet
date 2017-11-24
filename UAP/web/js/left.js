/*=====================================================*/
/*                   left.js矫正部分                   */
/*                 left相关页面中调用到                */
/*=====================================================*/
function quitmouseover (ev) {
	ev.src="images/images_1/quit_on.gif";
}
function quitmouseout (ev) {
	ev.src="images/images_1/quit_off.gif";
}
function Jmmtime(){
jiumei_today = new Date(); document.write (""+jiumei_today.getYear ()+"年" + (jiumei_today.getMonth () + 1)+"月"+ jiumei_today.getDate ()+"日"+" "); 
//document.write(jiumei_today.getHours ()+":"+jiumei_today.getMinutes());
}
var iframeheight;  //窗口高度
function leftmenuload () {
iframeheight=top.document.all("FRAME_LEFT").offsetHeight;
document.all("left_menu").style.posHeight=iframeheight-document.all("user").offsetHeight;
document.all("menu_content"+nowobj).style.posHeight=iframeheight-document.all("user").offsetHeight-150;
}
var nowobj='1';
function clickmenu (aobj) {
if (document.all("menu_title"+aobj).className == "menu_title_on"){
	document.all("menu_title"+aobj).className="menu_title_off";
	document.all("menu_content"+aobj).className="menu_content_off";
	}else{
	document.all("menu_title"+aobj).className="menu_title_on";
	document.all("menu_content"+aobj).className="menu_content_on";
	}
}
var nowObj = null;
document.onmousemove() = function() {
	var obj  = event.srcElement;
	if (obj.className == "menu_content_chird_off") {
		obj.className = "menu_content_chird_over";
		}
	
	}
document.onmouseout() = function() {
	var obj = event.srcElement;
	if (obj.className == "menu_content_chird_over" && obj != nowObj) {
	obj.className = "menu_content_chird_off";
		}
		}
	
document.onmousedown() = function() {
	var obj = event.srcElement;
	if (obj.className == "menu_content_chird_off" || obj.className == "menu_content_chird_on" || obj.className == "menu_content_chird_over") {
	if (obj != nowObj) {
		obj.className = "menu_content_chird_on"	;
		if (nowObj != null){
			nowObj.className = "menu_content_chird_off";
			if (nowObj.childNodes[1] != undefined && nowObj.childNodes[1].style.display == "block") {
				nowObj.childNodes[1].style.display="none";
				open=true;
				}
			}
		nowObj = obj;
		}
		}
	}

var   open=true;
function leftTopToOpen (obj,str) {
	if (obj.childNodes[1] != undefined) {
		tobj = obj.childNodes[1];
		if (event.offsetY<20 && event.srcElement == obj) {//必须在obj所在目标内并且必须距离顶部20px; 
		if (open) {
			tobj.style.display="block";
			open=false;
			}else{
			tobj.style.display="none";
			open=true;
			}  
			}
		}else{
		top.FRAME_MAIN.location.href = str;
		}
	}

