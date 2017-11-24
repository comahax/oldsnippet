<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc" %>
<%@ page import= "java.util.List" %>
<%@ page import= "com.sunrise.boss.ui.commons.combineinput.CombineinputConstant" %>

<%
String definition = (String) request.getAttribute(CombineinputConstant.DEFINITION);
String title = (String) request.getAttribute(CombineinputConstant.TITLE);
String type1 = (String) request.getAttribute(CombineinputConstant.TYPENAME1);
String type2 = (String) request.getAttribute(CombineinputConstant.TYPENAME2);
String description = (String) request.getAttribute(CombineinputConstant.DESCRIPTION);
String relateflag = (String) request.getAttribute(CombineinputConstant.RELATEFLAG);
String symbol_mid = (String) request.getAttribute(CombineinputConstant.SYMBOL_MID);
String symbol_tail = (String) request.getAttribute(CombineinputConstant.SYMBOL_TAIL);

String[] original = (String[]) request.getAttribute(CombineinputConstant.ORIGINAL_ARRAY);
request.setAttribute("ORIGINAL_ARRAY", original);
List list_type1 = (List) request.getAttribute(CombineinputConstant.COLLECTION_TYPE1_OUT);
request.setAttribute("LIST_TYPE1", list_type1);
List list_type2 = (List) request.getAttribute(CombineinputConstant.COLLECTION_TYPE2_OUT);
request.setAttribute("LIST_TYPE2", list_type2);
%>

<html>
	<head>
		<title>PBOSS</title>
		<meta name="author" content="www.sunrise.com" />
		<meta name="robots" content="none" />
		<link href="<%=contextPath%>/css/css_1/interfacebase.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/navigate.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/common.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/form.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/button.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/table.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/menu.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/xmlhttp.css" rel="stylesheet" type="text/css" media="all" />
		<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/xmlhttp.js"></script>
	</head>
	
	<body>
	<form name= "form1">
	<div class="table_container">			
		<div class="table_div">
			<table width="95%" border="0" cellspacing="0" cellpadding="0" ID="Table2">
                <tr> 
                    <td width="10" height="30" align="right"><img src="<%=contextPath%>/images/Ico_CircleBlue2.gif" width="20" height="20">&nbsp;</td>
                    <td class="AreaName"><%= title %></td>
                    <td width="140"><table width="100%" border="0" cellspacing="0" cellpadding="0" ID="Table3">
                        <tr>
                        <td valign=bottom>
                        <!--此处可以放按钮，不需要则去除-->
							
                        <!--此处可以放按钮，不需要则去除-->
                        </td>
                        </tr>
                    </table></td>
                </tr>
            </table>
		</div>
	
		<div class="table_div">
			<table class="table_style">
					<tr class="table_style_content">
						<td align=left><%= type1 %></td>
						<td align=left><%= type2 %></td>
						<td align=left></td>
						<td align=left><%= type1 %> + <%= type2 %></td>
					</tr>
					<tr class="table_style_content">
						<td align=left>
							<input type=text name="prefix_type1" value="" onkeyup="waitforchange('/commons/combineinput.do?CMD=change', 's1')">
						</td>
						<td align=left>
							<input type=text name="prefix_type2" value="" onkeyup="waitforchange('/commons/combineinput.do?CMD=change', 's2')">
						</td>
						<td align=left></td>
						<td align=left></td>
					</tr>
					<tr class="table_style_content">
						<td align=left>
								<select size=10 id=s1 name=s1 class="multi" onclick="docilckchange('/commons/combineinput.do?CMD=change', 's2')" >
									<option value=""></option>
									<c:forEach var="item" items="${LIST_TYPE1}" varStatus="id">
								      	<option value=<c:out value="${item.id}"/>><c:out value="${item.id}"/> <c:out value="${item.name}"/></option>
								    </c:forEach>
								</select>
						</td>
						<td align=left>
								<select size=10 id=s2 name=s2 class="multi" onclick="ff()" >
									<option value=""></option>
									<c:forEach var="item" items="${LIST_TYPE2}" varStatus="id">
								      	<option value=<c:out value="${item.id}"/>><c:out value="${item.id}"/> <c:out value="${item.name}"/></option>
								    </c:forEach>
								</select> 
						</td>
						<td align=left>
								<input  type=button  value=">>"  onclick="onsl()"><br /><br />
								<input  type=button  value="<<"  onclick="outsl()"><br /><br />
						</td>
						<td align=left>
								<select size=10 id=s3 name=s3 class="multi">
									<c:forEach var="item" items="${ORIGINAL_ARRAY}" varStatus="id">
										<option value=<c:out value="${item}"/>>
										<c:out value="${item}"/>
										</option>
									</c:forEach>
								</select>
						</td>				
					</tr>
					<tr class="table_style_content">
						<td colspan="4" align="center">
								<input  type=button  value="确定" onclick="doConfirm()" class="comfir">
								<input  type=button  value="关闭"  onclick="window.close()" class="comfir">
						</td>
					</tr>
					<tr class="table_style_content">
						<td colspan="4" align="center"><%= description %></td>
					</tr>
					
			</table>
		</div>
	</div>
	</form>
	</body>
</html>

<HTML>
<HEAD>
<SCRIPT  LANGUAGE="JavaScript">
//加入选项
function onsl() {
	elm1=document.all("s1");  
	elm2=document.all("s2");  
	elm3=document.all("s3");
	
	var MMjiu1 = false;
	for (var i=elm1.length-1;i>-1;i--) {
		op = elm1.options[i];
		if  (op.selected && i > 0)  {
			MMjiu1 = true;
			break;
		}
	}
	
	var MMjiu2 = false;
	for (var i=elm2.length-1;i>-1;i--) {
		opt = elm2.options[i];  
		if  (opt.selected && i > 0)  {
			MMjiu2 = true;
			break;
		}
	}
	
	var add = "";
	if (MMjiu1 && MMjiu2) {
		add = op.value + '<%=symbol_mid%>' + opt.value;
	} else if (MMjiu1 || MMjiu2) {
		add = MMjiu1? op.value:"";
		add += MMjiu2? opt.value:"";
	}
	
	var repeat = false;
	for (var i = 0; i < elm3.length; i++) {
		if(elm3.options[i].value == add) {
			repeat = true;
			break;
		}
	}
	
	if (!repeat && add != '') {
		elm3.options[elm3.length] = new Option(add, add);
	}
}

//移除选项
function outsl () {
	elm3=document.all("s3");
	for  (var  i=elm3.length-1;i>-1;i--) {  
	opo=elm3.options[i];  
	if  (opo.selected)  {
		elm3.options[i]=null; 
	}
	}
}

//点击动作
var cilck_timer;
function docilckchange (url, obj) {
	var all_s1 = document.all("s1");
	if (all_s1.options[0].selected) {
		return;
	}
	
	ff();
	
	if ('<%=relateflag%>' != 'true') {
		return;
	}
	
	if (cilck_timer) {
		window.clearTimeout(cilck_timer);
	}
	cilck_timer = window.setTimeout("dochangebox('"+url+"', '"+obj+"')", 1000);
}

//延时提交
var keyup_timer;
function waitforchange(url, obj) {
	if(event.keyCode == 16 || event.keyCode == 17 || event.keyCode == 18 ||
	 	event.keyCode == 37 || event.keyCode == 38 || event.keyCode == 39 || 
	 	event.keyCode == 40) {
		return;
	}
	
	if (keyup_timer) {
		window.clearTimeout(keyup_timer);
	}
	keyup_timer = window.setTimeout("dochangebox('"+url+"', '"+obj+"')", 1500);
}

var target_type1 = '<%= CombineinputConstant.TARGET_TYPE1 %>';
var target_type2 = '<%= CombineinputConstant.TARGET_TYPE2 %>';

//提交Ajax动作
function dochangebox (url, obj) {
	var upid = "";
	if ('<%=relateflag%>' == 'true') {
		var select1 = document.all("s1");
		for (var i=0; i < select1.length; i++) {
			var opo = select1.options[i];
			if  (opo.selected)  {
				upid = select1.options[i].value;
				break;
			}
		}
	}
	
	var target = target_type1;
	if (obj == 's2') {
		target = target_type2;
	}
	
	url = contextPath + url + "&definition=" + '<%= definition %>' + 
		"&PREFIX_TYPE1=" + form1.prefix_type1.value +
		"&PREFIX_TYPE2=" + form1.prefix_type2.value +
		"&UPID=" + upid +
		"&TARGET=" + target;
	startAjax(url, "elm1chxml('"+obj+"')", 'XML', 'post');
}

//解析xml并数据页面
function elm1chxml (obj) {
	var elm1 = document.getElementById(obj);
	var length = elm1.length;
	for (i=0; i < length; i++) {
		elm1.options[0].removeNode(true);
	}
	
	var blank = document.createElement("<option value=''></option>");
	elm1.appendChild(blank);
	
	var p = mypoint.getElementsByTagName("select");
	for (i=0; i < p.length; i++) {
		mvalue=p[i].childNodes[0].childNodes[0].nodeValue;
		mtext=p[i].childNodes[1].childNodes[0].nodeValue;
		addl = document.createElement("<option value='"+mvalue+"'></option>");
		addl.innerHTML = mtext;
		elm1.appendChild(addl);
	}
}

var selectoptionin=null;
function quit (obj) {
	if (selectoptionin!=null){
		if (selectoptionin==obj.selectedIndex){
		obj.value="";
		selectoptionin=null;
		}else{
		selectoptionin=obj.selectedIndex;
		}
	}else{
		selectoptionin=obj.selectedIndex;
	}
}

//return values
window.returnValue = "";
function doConfirm() {
	var str = "";
	elm3 = document.all("s3");
	for (var i=0; i<elm3.length; i++) {
		str = str + elm3.options[i].value + '<%=symbol_tail%>';
	}
	
	var len = str.length;
	if (len == 0) {
		str = 'NULL';
	}
	
	window.returnValue = str;
	window.close();
}

//字符串浮动效果
function ff() {
	obj = event.srcElement;
	var selectStr = obj.options[obj.selectedIndex].text;
	if (selectStr.length < 16) {
		return;
	}
	openword('ceshi', selectStr, '#');
}
//------------------------------------------------------------------------------------------
//通过利用messagePopup对象，词汇表功能。
var w_word = 160;
var h_word = 22; 

function openword (title,str,surl) {
newin = new messagePopup(event.screenX+10,event.screenY+10,w_word,h_word,title,str,surl);
newin.toshow();
}
function messagePopup (x,y,width,height,title,str,surl) {  //popup对象。
this.x = x; 
this.y = y;
this.width = str.length*13;
this.height = height;
this.surl = surl;

var oPopup = window.createPopup();
this.str = oPopup.document.body;

this.toshow = function () {
this.str.style.backgroundColor = "transparent";
this.str.style.border = "#000 solid 0px";
this.str.innerHTML = "<div style='width:100%;height:100%;background:#FFFFE1;border:#000 solid 1px;font-size:12px;padding:3px;'>"+str+"</div>";
oPopup.show(this.x,this.y,this.width,this.height);
}

this.toclose = function () {
if (oPopup.isOpen) {oPopup.hide();}
}
}

</SCRIPT>
</HEAD>
</HTML>