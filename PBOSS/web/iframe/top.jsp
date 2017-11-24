<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@page import="com.sunrise.jop.ui.User"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="/inc/listhead.inc" %>

 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<title>top</title>
<script type="text/javascript" src="<%= contextPath %>/js/base.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/cookies.js"></script>

<link href="<%=contextPath%>/css/top.css" rel="stylesheet" type="text/css" />
<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function doChangecity(){
		var cityid = window.showModalDialog("<%=contextPath%>/cityselect.do",null,"dialogWidth:400px; dialogHeight:170px; status:no; resizable:no;");
		document.getElementById('cityno').value=cityid;
		if(cityid==null){
			return;
		}
		//var ajaxinfo = {
		//	dataType:'text',
		//	success:handleChangecity
		//}
		$('#cityForm').ajaxSubmit();//ajaxinfo
		
		//document.cityForm.submit();
	}
</script>
</head>
<style>
a {
background:url(../images/image_top/top_menu_icon_blank.gif) no-repeat top right;width:82px;height:23px;color:#243458;text-align:center;center;padding-top:5px;text-decoration:none;
font-weight:1000;
}
	</style>
<script>
	var lookpoint;
	function dochangemenubace (obj) {
		if(lookpoint != obj){
			obj.style.backgroundPosition = "top left";
			if (lookpoint != null) {
				lookpoint.style.backgroundPosition = "top right";
			}
		lookpoint = obj;
		}
	}
	var movedfom,moveobject,movedfodiv;
	function ch(m,p){
	movedfom=m;
	moveobject=p;
	movedfodiv=window.setInterval("chforstep(moveobject)",10);
	}
	var menuwidth=800;
	function chforstep (m) {
		if (menuonleft.scrollLeft <= Math.abs(document.all("menuonleft").firstChild.childNodes.length / 2 * 88 - document.all("menuonleft").offsetWidth) ||movedfom<0 ) {
			eval(m).scrollLeft+=movedfom;
			}
	}
	function rch() {
		window.clearInterval(movedfodiv);
	}
</script>
<body  leftmargin="0" topmargin="0" bottommargin="0" onload="resizwindow();">
<form action="<%=contextPath%>/changecity.do" name="cityForm" id="cityForm" method="post">
<input type="hidden" name="cityno" id="cityno"/>
</form>

<div class="bj">

	<div class="top_left"></div>
<div>

<div class="top_right">
<s:if test='%{#session["LOGIN_TYPE"] == "NOTBOSS"}'>
<img src="../images/image_top/city_shift.png" alt="切换地市" width="16" height="16" style="position:relative;top:-6px;cursor:hand;" onclick="doChangecity();" />
</s:if><img src="../images/f2.gif" class="pt" onclick="top.myframe01.rows='66,*,6';top.myframe02.cols='0,*'"><img src="../images/f3.gif" class="pt" onclick="top.myframe01.rows='66,*,6';top.myframe02.cols='180,*'">
<img src="../images/image_top/botton1.gif" width="80" height="31" border="0" usemap="#Map" style="margin-right: 1px"/>
<map name="Map" id="Map">
  <area shape="rect" coords="0,0,80,31" href="<%=contextPath%>/logout.do" onfocus="this.blur()" alt="离开系统" target="_parent"/>
</map>
<div class="top_yonghu">当前用户:<s:property value="#session.USER.oprcode"/></div>
</div>

<div>
<div class="button_if_left" style="margin-top:29px;margin-left:30px;" onmousedown="ch(-15,'menuonleft')" onmouseup="rch()" onmouseout="rch()"><img src="../images/ifleft_t.gif"></div>
<div class="top_guanli" id="menuonleft">
 	<div style="width:1200px;">
	<!-- 
		a href="<%=contextPath %>/base/functionitem_MenuTree.do" target="leftmainFrame" onclick="top.leftFrame.lefttopFrame.menuname.innerHTML='基础管理';dochangemenubace(this);setlocation('待办任务','<%=contextPath%>/communication/advinfo_list.do',top.maintop);" id="index">首页</a>
	 -->
	<s:iterator value="dp.datas">
		<s:if test="funcid == 'RE'">
			<a href="<s:property value='guiobject'/>" target="leftmainFrame" onclick="top.leftFrame.lefttopFrame.menuname.innerHTML='<s:property value="funcname"/>';dochangemenubace(this)"><s:property value="funcname"/></a>
		</s:if>
		<s:else>
			<a href="<%=contextPath%>/base/functionitem_ListFunMenuByParent.do?form.funcid=<s:property value="funcid"/>" target="leftmainFrame" onclick="dochangemenubace(this)"><s:property value="funcname"/></a>
		</s:else>
	</s:iterator>
  </div>
</div>
<div class="button_if_right" style="margin-top:29px;margin-left:15px;" onmousedown="ch(15,'menuonleft')" onmouseup="rch()" onmouseout="rch()"><img src="../images/ifright_t.gif"></div>
</div>

</body>
</html>
<script>
window.onresize = function() {
		resizwindow();
	}	
</script>
