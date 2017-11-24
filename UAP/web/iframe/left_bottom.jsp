<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
	String contextPath = request.getContextPath();
	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<html>
<head>

<link href="<%= contextPath %>/css/<%=currentTheme%>/left.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"><style type="text/css">
<!--
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
}
a:active {
	text-decoration: none;
}
-->
</style></head>

<body leftmargin="0"  topmargin="0"  bottommargin="0"  >
<div ><a href="left_main.jsp" class="4" target="leftmainFrame" onfocus="this.blur()">营业管理子系统</a></div>
<div><a href="left_main_b.jsp" class="2" target="leftmainFrame" onfocus="this.blur()">营收管理子系统</a></div>
<div><a href="left_main_b.jsp" class="1" target="leftmainFrame" onfocus="this.blur()">资源管理子系统</a></div>
<div><a href="left_main_b.jsp" class="5" target="leftmainFrame" onfocus="this.blur()">渠道管理子系统</a></div>
<div><a href="left_main_b.jsp" class="3" target="leftmainFrame" onfocus="this.blur()">生产管理子系统</a></div>
<div class="left_bottom_bj"  ><div class="left_top_bottom" onClick="top.leftFrame.leftmainFrame.location.href='left_main_use.jsp'"></div>
</div>
</body>
</html>
