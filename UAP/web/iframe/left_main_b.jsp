<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
	String contextPath = request.getContextPath();
	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<link href="<%= contextPath %>/css/<%=currentTheme%>/dtree.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/dtree.js"></script>
<script type="text/javascript" src="../js/cookies.js"></script>
<style type="text/css">
<!--
a:link {
	text-decoration: none;
	color: #000000;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
	color: #00D900;
}
a:active {
	text-decoration: none;
}
body,td,th {
	font-family: 宋体;
	font-size: 12px;
}
-->
</style>
<script type="text/JavaScript">
<!--



function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}
//-->
</script>
</head>

<body leftmargin="0" >
<script language="JavaScript">
NS4 = (document.layers) ? 1 : 0;
IE4 = (document.all) ? 1 : 0;
ver4 = (NS4 || IE4) ? 1 : 0;

if (ver4) {
    with (document) {
        write("<STYLE TYPE='text/css'>");
        if (NS4) {
            write(".parent {position:absolute; visibility:visible}");
            write(".child {position:absolute; visibility:visible}");
            write(".regular {position:absolute; visibility:visible}")
        }
        else {
            write(".child {display:none}")
        }
        write("</STYLE>");
    }
}

function getIndex(el) {
    ind = null;
    for (i=0; i<document.layers.length; i++) {
        whichEl = document.layers[i];
        if (whichEl.id == el) {
            ind = i;
            break;
        }
    }
    return ind;
}

function arrange() {
    nextY = document.layers[firstInd].pageY +document.layers[firstInd].document.height;
    for (i=firstInd+1; i<document.layers.length; i++) {
        whichEl = document.layers[i];
        if (whichEl.visibility != "hide") {
            whichEl.pageY = nextY;
            nextY += whichEl.document.height;
        }
    }
}

function initIt(){
    if (!ver4) return;
    if (NS4) {
        for (i=0; i<document.layers.length; i++) {
            whichEl = document.layers[i];
            if (whichEl.id.indexOf("Child") != -1) whichEl.visibility = "hide";
       }
        arrange();
    }
    else {
        divColl = document.all.tags("DIV");
        for (i=0; i<divColl.length; i++) {
            whichEl = divColl(i);
            if (whichEl.className == "child") whichEl.style.display = "none";
        }
    }
}

function expandIt(el) {
    if (!ver4) return;
    if (IE4) {
        whichEl = eval(el + "Child");
        if (whichEl.style.display == "none") {
            whichEl.style.display = "block";
        }
        else {
            whichEl.style.display = "none";
        }
    }
    else {
        whichEl = eval("document." + el + "Child");
        if (whichEl.visibility == "hide") {
            whichEl.visibility = "show";
        }
        else {
            whichEl.visibility = "hide";
        }
        arrange();
    }
}
onload = initIt;
</script>
	  <div id="KB1Parent" class="dtree">　　
			<a href="../sousuo/xin.jsp" target="maintop" onClick="setlocation('测试用户标号','../sousuo/xin.jsp',top.maintop);" >
			<img src="../images/dtree/base.gif" width="12" height="12" border=0 class="dtree_weizhi" >测试用户标号</a>
	  </div>
      <div id="KB2Parent" class="dtree">　　<a href="../sousuo/xink.jsp" target="maintop" onClick="setlocation('受理修改','../sousuo/xink.jsp',top.maintop);" ><img src="../images/dtree/base.gif" width="12" height="12" border=0 class="dtree_weizhi" >受理修改</a></div>
      <div id="KB3Parent" class="dtree">　　<a href="../sousuo/sousuo_shoulishenghe.jsp" target="maintop" onClick="setlocation('受理审核','../sousuo/sousuo_shoulishenghe.jsp',top.maintop);" ><img src="../images/dtree/base.gif" width="12" height="12" border=0 class="dtree_weizhi" >受理审核</a></div>
      <div id="KB4Parent" class="dtree">　　<a href="#" onclick="expandIt('KB1'); return false" ><img src="../images/dtree/folder.gif" width="12" height="12" border="0" class="dtree_weizhi" id="Image1" /></a><a href="../tan.jsp" target="maintop" onClick="expandIt('KB4'); return false" >权限管理</a></div>
      <div id="KB4Child" class="child">
        <table border="0" cellpadding="0" cellspacing="0" class="dtree_x" >
          <tr>
            <td><a href="#" onclick="expandIt('KB3'); return false" ><img src="../images/dtree/join.gif" width="18" height="18" border="0" /></a><a href="sample.htm" target="_blank" ><img src="../images/dtree/page.gif" width="13" height="10"  border="0" class="dtree_weizhit" /></a></td>
            <td class="dtree_xz"><a href="../stree_two/tan.jsp" target="maintop" onclick="setlocation('权限管理','../sousuo/tan.jsp',top.maintop);">权限管理</a></td>
          </tr>
          <tr>
            <td><a href="sample.htm" target="_blank" ><img src="../images/dtree/join.gif" alt="" width="18" height="18"  border="0" /><img src="../images/dtree/page.gif" width="13" height="10"  border="0" class="dtree_weizhit" /></a></td>
            <td class="dtree_xz"><a  href="#" onclick="setlocation('权限管理','../sousuo/tan.jsp',top.maintop);">权限管理</a></td>
          </tr>
          <tr>
            <td><a href="sample.htm" target="_blank" ><img src="../images/dtree/joinbottom.gif" alt="" width="18" height="18"  border="0" /><img src="../images/dtree/page.gif" width="13" height="10"  border="0" class="dtree_weizhit" /></a></td>
            <td  class="dtree_xz" ><a href="#" onclick="setlocation('权限管理','../sousuo/tan.jsp',top.maintop);">权限管理</a></td>
          </tr>
        </table>
</div>
      <script language="JavaScript">
if (NS4) {
        firstEl = "KB1Parent";
        firstInd = getIndex(firstEl);
        arrange();
}
</script>
<script>
        	top.leftFrame.lefttopFrame.menuname.innerHTML=document.title;
        </script>
</body>
</html>
