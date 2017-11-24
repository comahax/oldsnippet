<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<%
Object obj = request.getSession().getAttribute("PACKINFO");
 %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
    <title>My JSP 'packstate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	

 	 
  </head>
  
  <body>

<%
if(obj != null){

 %>
<script type="text/javascript">
		function ev_check() {
	 		 return true;
	 	 }

</script>

	<div class="error_text" >
		<table class="error_text">
			<s:actionerror /><s:actionmessage/>
		</table>
	</div>

<s:form action="compack_getPackInfo.do" key="formList" cssStyle="formList" theme="simple" onsubmit="return ev_check();">

 <table class="table_style">
<tr class="table_style_content" align="center">
<td>开始时间</td><td>完成时间</td><td>总包数</td><td>完成数</td><td>进度</td><td>文件下载</td>
</tr>
<tr class="table_style_content" align="center">
<td id="startTime"></td>
<td id="endTime"></td>
<td id="totalPack"></td>
<td id="processPack"></td>
<td id="percent"></td>
<td id="file"></td>
</tr>	
</table>
</s:form>

<script language="JavaScript" type="text/javascript">
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
  var url = "<%=contextPath%>/resource/compack/compack_getPackInfo.do";
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
  var temp = xmlhttp.responseText;
  //返回格式:   开始时间|结束时间|总包数|完成包数|进度(百分比)|是否完成|文件名称 
  var array=temp.split("|");
  var startTime = array[0];
  var endTime = array[1];
  var totalPack = array[2];
  var processPack = array[3];
  var percent = array[4];
  var isFinish = array[5];
  var file = array[6];
  var errMsg = array[7];
  var hrefResultFile="<a href='<%=contextPath%>/common/download.jsp?filename="+file+"'><font color=blue>result.txt(下载) </font> </a>";
	
  document.getElementById('startTime').innerHTML = startTime;
  document.getElementById('endTime').innerHTML = endTime;
  document.getElementById('totalPack').innerHTML = totalPack;
  document.getElementById('processPack').innerHTML = processPack;	
  document.getElementById('percent').innerHTML = percent;	 

  if(isFinish == 'true'){
  	document.getElementById('file').innerHTML = hrefResultFile;
  	if('' != errMsg ){
  		var msg = '<span class=\'errorkey\' style=\'font-size:12px;\'><span style=\'color:#F00; font-size:12px;\'>[' + errMsg + ']</span></span>';
  		errorMessageShow(msg);
  	}
  	clearTimeout(timeid);
  	
  	parent.document.getElementById('btnBack').disabled='';
  }else{ 
  	parent.document.getElementById('btnSave').disabled=true; 
  	parent.document.getElementById('btnQuery').disabled=true; 	
 	 timeid=setTimeout("sendit();",1000); 
  }
  
     
}
</script>

<%} %>
  </body>
</html>
