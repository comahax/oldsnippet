<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@page import="com.sunrise.boss.ui.commons.batch.processfile.BaseBatchTaskBean"%>
<%@page import="java.util.HashMap"%>
<%@ include file="/inc/head.inc" %>
<%
String beanname=request.getParameter("beanname");
HashMap beanMap=(HashMap)session.getAttribute("beanMap");
BaseBatchTaskBean task=null;
if(beanMap!=null && beanname!=null){
	task=(BaseBatchTaskBean)beanMap.get(beanname);
}
String show=request.getParameter("show");
%>
<HTML>
<HEAD>
<script language="JavaScript" type="text/javascript">
   //上传后防止页面的表单数据修改
   var filename = parent.formItem.filename.value;
   var allElements=parent.formItem.elements;
   if(filename!=null && filename!=""){
	   for (var i=0; i<allElements.length; i++) {
	     if(allElements[i].type=='button' || allElements[i].type=='submit' || allElements[i].type=='file'){
	       continue;
	     }
	    allElements[i].disabled=true;
	  }
  }
</script>
<TITLE><bean:message bundle="upload" key="progressBar"/></TITLE>
  <style>
  .prog-border {
	  height: 15px;
	  background: #fff;
	  border: 1px solid #000;
	  margin: 0;
	  padding: 0;
  }
  .prog-bar {
	  height: 11px;
	  margin: 2px;
	  padding: 0px;
	  background: #000080;
	  font-size: 10pt;
  }
  body {
  	background:#ffffff;
  }
  </style>
</HEAD>
 <BODY onload="loadforiframe()">
 <div class="table_div">
<%if (task!=null || "true".equals(show)) {%>
 <TABLE ALIGN="CENTER" BORDER=0 CELLPADDING=0 CELLSPACING=1 class="form_table">
  <tr>
    <td width="12%" align="right"><bean:message bundle="upload" key="progressBar"/>:</td>
    <td id="status"></td>
    <td id="percent" width="10%"></td>
  </TR>
 </TABLE>
 <table border="0" class="form_table">
  <tr>
    <td align="center" colspan="2">
      <font color=blue size=+1><bean:message bundle="upload" key="report"/></font>
    </td>
  </tr>
  <tr>
    <td width="12%">
      <div align="right"><bean:message bundle="upload" key="countRecord"/>:</div>
    </td>
    <td width="88%">
      <div align="left" id="countRecord">0</div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="right"><bean:message bundle="upload" key="okRecord"/>:</div>
    </td>
    <td>
      <div align="left" id="okRecord">0</div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="right"><bean:message bundle="upload" key="failRecord"/>:</div>
    </td>
    <td>
      <div align="left"  id="failRecord">0</div>
    </td>
  </tr>
  <tr>
    <td>
      <div align="right"><bean:message bundle="upload" key="resultFile"/>:</div>
    </td>
	<td>
		<div align="left" id="resultFile">
		   &nbsp;
		</div>
	</td>
  </tr>
</table>
<script language="JavaScript" type="text/javascript">
var beanname='<%=beanname%>';
var xmlhttp;
var timeid;

doStart();
function createXMLHttpRequest(){
  xmlhttp = null;
  if(window.ActiveXObject){
    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
  }else{
    xmlhttp = new XMLHttpRequest();
  }
}

function doStart(){
  createXMLHttpRequest();
  sendit();
}

function sendit(){
  var url = "<%=contextPath%>/commons/batch/response.jsp?beanname="+beanname;
  xmlhttp.open("post",url,true);
  xmlhttp.onreadystatechange = startCallback;
  xmlhttp.send(null);
}

function startCallback(){
  if(xmlhttp.readyState == 4){
    if(xmlhttp.status == 200){
      showProgress();
    }
  }
}

function showProgress(){
  temp = xmlhttp.responseText; 
  var array=temp.split("|");
  var percent=array[0];
  if(percent==null || percent==-1 || (array.length!=5)){
    return;
  }
  var progressBar="<div class='prog-border'><div class='prog-bar' style='width:"+
				percent + "%'></div></div>";
  var hrefResultFile="<a href='<%=contextPath%>/commons/batch/download.jsp?filename="+array[4]+
	"'><font color=blue>result.txt(<bean:message bundle="upload" key="downLoad"/>) </font> </a>";				
  document.getElementById("status").innerHTML = progressBar;
  document.getElementById("percent").innerHTML = percent+"%";
  document.getElementById("countRecord").innerHTML = array[1];
  document.getElementById("okRecord").innerHTML =  array[2];
  document.getElementById("failRecord").innerHTML =  array[3];
  if( percent>=0 && percent<100){
    timeid=setTimeout("sendit();",1000);
  }else{
    clearTimeout(timeid);
    document.getElementById("resultFile").innerHTML = hrefResultFile;
  }
}
</script>
<%}%>
</div>
</BODY>
</HTML>