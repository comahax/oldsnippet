<%@page contentType="text/html;charset=gbk"%>
<%@ include file="/inc/listhead.inc" %>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style>
* {font-size:12px;}
.menu_d {
	padding-top: 6px;
	padding-left: 5px;
	text-decoration:none;
	height:21px;
	margin-right:0px;
	text-align:center;
	cursor:hand;
	float:left;
	width:92px;
	text-overflow:ellipsis;
	white-space:nowrap;
	overflow:hidden;
	background-color: #FFFFFF;
	background-image: url(../images/image_peijian/bq_bjb.gif);
	background-repeat: no-repeat;
	background-position: left bottom;
	border-top-width: 0px;
	border-right-width: 0px;
	border-bottom-width: 0px;
	border-left-width: 5px;
	font-family: "宋体";
	font-size: 12px;
	font-weight: normal;
	color: #000000;
	padding-right: 6px;margin-right:2px;
}
.menu_f {
	padding-top: 6px;
	padding-left: 5px;
	text-decoration:none;
	height:21px;
	width:92px;
	margin-right:0px;
	text-align:center;
	cursor:hand;
	float:left;
	text-overflow:ellipsis;
	white-space:nowrap;
	overflow:hidden;
	background-color: #FFFFFF;
	background-image: url(../images/image_peijian/bq_likai.gif);
	background-repeat: no-repeat;
	background-position: left bottom;
	border-top-width: 0px;
	border-right-width: 0px;
	border-bottom-width: 0px;
	border-left-width: 5px;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style:  none;
	font-family: "宋体";
	font-weight: bold;
	color: #FF8040;
	padding-right: 6px;margin-right:2px;
}
.menu_a {
	border-bottom-width: 1px;
	border-bottom-style: solid;
	border-bottom-color: #D1D1D1;
	height: 28px;
	padding:5px 5px 0px 5px;
}
.closeall {
	position:absolute;right:10px;top:5px;width:16px;
	border:#000 solid 0px;background:url(../images/closeall.gif) no-repeat;
}
</style>
<script>
var menuNum=10,nowmenuNum=1,defaultUrl="<%=contextPath%>/iframe/content.jsp";
function b (id,mystr,myvalue) {
	if (nowmenuNum == 1) {
			rame.innerHTML = "";
		}
	if (nowmenuNum<=menuNum) {
		var addl = document.createElement("<div onclick=\"openurl('"+myvalue+"',this)\" ondblclick=\"closeurl(this)\" class='menu_f'></div>");
		menu.appendChild(addl);
		addl.innerHTML=mystr+"<span style='display:none'>"+id+"</span>";
		var addf = document.createElement("<iframe id='f"+addl.uniqueID+"' style='width:100%;height:100%;overflow:auto;display:block;' src='"+ myvalue +"'></iframe>");
		rame.appendChild(addf);
		setnp (addl);
		nowmenuNum++;
		}else{
		closeurl(menu.lastChild);
		b(id,mystr,myvalue);
		}
	}
function openurl(url,obj) {
	//top.maintop.location.href=url;
	obj.className="menu_f";
	document.getElementById("f" + obj.uniqueID).style.display = "block";
	setnp (obj);
	}
function closeurl (obj) {
	var topNode = obj.parentNode;
	document.getElementById("f" + obj.uniqueID).removeNode(true);
	obj.removeNode(true);
	nowmenuNum--;
	if(topNode.children[topNode.children.length-1] != null) {
		topNode.children[topNode.children.length-1].onclick();
	}else{
		rame.innerHTML = "<iframe id='findex' style='width:100%;height:100%;overflow:auto;display:block;' src='"+ defaultUrl +"'></iframe>"
		//top.maintop.location.href=defaultUrl;
	}
	}
function setnp (obj) {
	for (i=0;i<obj.parentNode.children.length;i++) {
		if(obj != obj.parentNode.children[i]) {
			
			obj.parentNode.children[i].className="menu_d";
			//alert(document.all("f" + obj.parentNode.children[i].uniqueID).outerHTML)
			document.getElementById("f" + obj.parentNode.children[i].uniqueID).style.display = "none";
			}
		}
	}
function closeall () {
	if (window.confirm("是否关闭所有标签？")) {
	if (nowmenuNum >= 1) {
		menu.innerHTML = "";
		rame.innerHTML = "";
		nowmenuNum = 1;
		rame.innerHTML = "<iframe id='findex' style='width:100%;height:100%;overflow:auto;display:block;' src='"+ defaultUrl +"'></iframe>"
		
		}
	}
}
function documentload () {
	
iframeheight=document.getElementsByTagName("body")[0].offsetHeight;
document.getElementById("rame").style.posHeight = iframeheight - document.getElementById("menu").offsetHeight;
}
</script>
</head>
<body style="margin:0px;padding:0px;" onload="documentload()" onresize="documentload()">
	<div class="menu_a" id="menu" ></div>
	<span style="display: none"> </span>
	<input type="hidden" value="11,222,33,444,">
	<input type="button" class="closeall" onclick="closeall()" title="关闭所有标签">
	<div style="width:100%;overflow:hidden;" id="rame">
		<iframe id='findex' style='width:100%;height:100%;overflow:auto;display:block;' src='<%=contextPath%>/iframe/content.jsp'></iframe>
	</div>
	
</body>
</html>
