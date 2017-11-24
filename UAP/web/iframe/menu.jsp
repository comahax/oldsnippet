<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%String contextPath = request.getContextPath();%>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
	background-position: bottom;
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
	border-top-width: 0px;
	border-right-width: 0px;
	border-bottom-width: 0px;
	border-left-width: 5px;
	border-top-style: none;
	border-right-style: none;
	border-bottom-style: none;
	border-left-style:  none;
	background-position: bottom;
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
</style>
<script>
var menuNum=10,nowmenuNum=1,defaultUrl="<%=contextPath%>/iframe/navmap.jsp";

function b (mystr,myvalue) {
	
	if (nowmenuNum<=menuNum) {
		
		var tabname = mystr.length > 7 ? mystr.substring(0,7):mystr;		
		if(!tabDuplicateCheck(tabname)) return ;
		var addl = document.createElement("<div title='"+mystr+"' onclick=\"openurl('"+myvalue+"',this)\" ondblclick=\"closeurl(this)\" class='menu_f'></div>");
		menu.appendChild(addl);
		addl.innerHTML=tabname;
		setnp (addl);
		nowmenuNum++;
		}
	}
	// 检查是否存在相同TAB项
	function tabDuplicateCheck(tabname){
		var tabs = document.getElementById('menu').childNodes;
		if(tabs && tabs.length > 0){
			 for(var i in tabs){
					var tab = tabs[i].innerHTML;			
					if(tab == tabname){
					    tabs[i].className="menu_f";
						setnp (tabs[i]);
						return false;			
					}
			  }			  
		}
		return true;
	}

function openurl(url,obj) {		
	top.mainFrame.location.href=url;	
	obj.className="menu_f";
	setnp (obj);
	
  }
	
function closeurl (obj) {	
	var topNode = obj.parentNode;	
	// 设置最后tab 项不能关闭	
	if(topNode.children.length == 1){
	    topNode.children[0].innerText = '首页';
		top.mainFrame.location.href = defaultUrl;
		return ;
	}
	obj.removeNode(true);
	nowmenuNum--;
	if(topNode.children[topNode.children.length-1] != null) {		
		topNode.children[topNode.children.length-1].onclick();		
		// top.mainFrame.location.href.load();
	}else{		
		top.mainFrame.location.href=defaultUrl;		
	}
	
	}
	
function setnp (obj) {
	for (i=0;i<obj.parentNode.children.length;i++) {
		if(obj != obj.parentNode.children[i]) {
			obj.parentNode.children(i).className="menu_d";
			}
		}
	}


</script>
</head>
<body style="margin:0px;padding:0px;">
	<div class="menu_a" id="menu" >
           <div title ="首页" onclick="openurl('../iframe/navmap.jsp',this)" ondblclick="" class='menu_f'>首页</div>     
	</div>
	
</body>
</html>
