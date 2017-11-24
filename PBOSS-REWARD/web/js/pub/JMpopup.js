/*   JMpopup 1.0
 *   提供基于popup的各种功能； 
 */
function messagePopup (x,y,width,height,title,str) {  //popup对象。
this.x = x; 
this.y = y;
this.width = width;
this.height = height;

var oPopup = window.createPopup();
this.str = oPopup.document.body;

this.toshow = function () {
this.str.style.backgroundColor = "transparent";
this.str.style.border = "#A5ACB5 solid 1px";
this.str.innerHTML = "<div style='font-size:12px; width:"+this.width+"; height:"+this.height+";'><div style='width:"+this.width+"; height:24; padding:5px; border-bottom:#A5ACB5 solid 1px; filter:progid:DXImageTransform.Microsoft.Gradient(enabled=true,startColorStr=#ffE4EBF3,endColorStr=#ffffffff,GradientType=1)'><span style='width:"+(this.width-40)+"; font-weight:900; color:#000;'>"+title+"</span><span style='cursor:hand;' onclick='parent.newin.toclose();'>关闭</span></div><div style='padding:10px;'>"+str+"</div></div>";
oPopup.show(this.x,this.y,this.width,this.height);
}

this.toclose = function () {
if (oPopup.isOpen) {oPopup.hide();}
}
}
//------------------------------------------------------------------------------------------
//通过利用messagePopup对象，信息提示功能。
var y_message = window.screen.availHeight;
var x_message = window.screen.availWidth;
var w_message = 200;
var h_message = 0; 
var step_message = 90;
var obj_message;
var newin;

function openclew (title,str,surl) {
if (newin == null) {
	newin = new messagePopup(x_message,y_message,w_message,h_message,title,str,surl);
	obj_message = setInterval (messageChange,10);
	}else {
	h_message = 0;
	obj_message = setInterval (messageChange,10);
	}
}
function messageChange (){
if (h_message<=step_message) {
newin.y = y_message - h_message;
newin.height = h_message;
newin.toshow();
h_message += 2;

}else{
clearInterval(obj_message);
}
}

//------------------------------------------------------------------------------------------
//通过利用messagePopup对象，词汇表功能。
var w_word = 450;
var h_word = 350; 

function openword (title,str) {
newin = new messagePopup(event.screenX-450,event.screenY+10,w_word,h_word,title,str);
newin.toshow();
}

//------------------------------------------------------------------------------------------
//通过利用popup对象，右键菜单功能。
var oPopup = window.createPopup()
document.oncontextmenu = function () {
goContext("88")
return false;
}
function goContext(oHeight)
{
var oPopupBody = oPopup.document.body;
var lefter = event.offsetY+10;
var topper = event.offsetX+10;
oPopupBody.innerHTML = creatmenu();
oPopupBody.style.background = "#D4D0C8"
oPopup.show(topper, lefter, 90, oHeight, document.body);
document.body.onmouseup = closePopup;
}
function closePopup()
{
oPopup.hide();
}
function creatmenu () {
var menustr;
menustr = document.getElementById("rcm").innerHTML;
return menustr;
}


