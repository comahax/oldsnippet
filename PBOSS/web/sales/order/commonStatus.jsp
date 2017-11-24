<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@page
	import="com.gmcc.pboss.common.batch.processfile.BaseBatchTaskBean"%>
<%@page import="java.util.HashMap"%>
<%@ include file="/inc/head.inc"%>
<%
	String beanname = request.getParameter("beanname");
	HashMap beanMap = (HashMap) session.getAttribute("beanMap");
	BaseBatchTaskBean task = null;
	if (beanMap != null && beanname != null) {
		task = (BaseBatchTaskBean) beanMap.get(beanname);
	}
	String show = (String) request.getParameter("show");
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
		<TITLE>进度条</TITLE>
		<style type="text/css">
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
  
.table_div {
	width:100%;
	text-align:center;
	border:#000000 dashed 0px;
}

.table_normal {
	width:100%;
	font-size:12px;
	color: #2F3732;;
	border:#CDCDCD solid 1px;
	border-collapse:collapse;
	margin-top:10px;
	margin-bottom:4px;
}

.table_normal td {
	font-size: 12px;
	font-weight: normal;
	color: #2F3732;
	height: 22px;
	border:#000 solid 0px;
	
	border-right:#CDCDCD inset 1px;
	border-bottom:#CDCDCD solid 1px;
	padding:0px 2px 0px 2px;
	background:#F8F8F8;
	vertical-align:middle;
}
  </style>
	</HEAD>
	<BODY onload="loadforiframe()">
		<div class="table_div">
				<%
				if (task != null || "true".equals(show)) {
				%>
				<div class="table_div">
					<TABLE ALIGN="CENTER" BORDER=1 CELLPADDING=0 CELLSPACING=1
						class="table_normal" width="100%">
						<tr>
							<td width="12%" align="right">
								进度条:
							</td>
							<td id="status"></td>
							<td id="percent" width="10%"></td>
						</TR>
					</TABLE>
				</div>
				<div class="table_div">
					<table border="0" class="table_normal" width="100%">
						<tr>
							<td align="center" colspan="2">
								<font color=blue>批量导入报告</font>
							</td>
						</tr>
						<tr>
							<td width="12%">
								<div align="right">
									导入总记录数:
								</div>
							</td>
							<td width="88%">
								<div align="left" id="countRecord">
									0
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="right">
									成功数:
								</div>
							</td>
							<td>
								<div align="left" id="okRecord">
									0
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="right">
									失败数:
								</div>
							</td>
							<td>
								<div align="left" id="failRecord">
									0
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div align="right">
									处理结果记录:
								</div>
							</td>
							<td>
								<div align="left" id="resultFile">
									&nbsp;
								</div>
							</td>
						</tr>
					</table>
				</div>
				<script language="JavaScript" type="text/javascript">
	parent.document.getElementById("btnUpload").disabled = true;
    parent.document.getElementById("btnDeal").disabled = true;
    
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
  var url = "<%=contextPath%>/common/response.jsp?beanname="+beanname;
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
  var hrefResultFile="<a id='downloadFile' href='<%=contextPath%>/common/download.jsp?filename="+array[4]+
	"'><font color=blue>result.txt(下载) </font> </a>";
  document.getElementById("status").innerHTML = progressBar;
  document.getElementById("percent").innerHTML = percent+"%";
  document.getElementById("countRecord").innerHTML = array[1];
  document.getElementById("okRecord").innerHTML =  array[2];
  document.getElementById("failRecord").innerHTML =  array[3];
  
    //隐藏中间数据
  var step = parent.document.getElementById("step").value;
  if(step != '2')
  {
  	    document.getElementById("countRecord").style.display = 'none';
    	document.getElementById("okRecord").style.display = 'none';
    	document.getElementById("failRecord").style.display = 'none';
  }
  
  if( Number(percent)>=0 && Number(percent)<100){
    timeid=setTimeout("sendit();",1000);
  }else{
    clearTimeout(timeid);
    document.getElementById("resultFile").innerHTML = hrefResultFile;
    
    //根据步骤标识，执行boss入账
    var step = parent.document.getElementById("step").value;
    if(step != '2')
    {
    	var delaySeconds = parent.document.getElementById("delaySeconds").value;
    	var delayMilliseconds = delaySeconds * 1000;
    	document.getElementById("downloadFile").style.display = 'none';
    	parent.document.getElementById("msg").innerHTML = '系统入账完成，正在调用BOSS入账接口，请稍候……';
    	document.getElementById("downloadFile").style.display = 'none';
    	setTimeout(function(){checkProcessByBoss(array[4])},delayMilliseconds);
    }
  }
}

function checkProcessByBoss(filepath)
{
	
	var filename = filepath;
	if(filename != null || filename != ""){
		parent.formItem.btnDeal.disabled=true;
		var wayid = parent.document.getElementById("wayid").value;
		parent.document.getElementById("tt").href="<%=contextPath%>/sales/importrecordedByBoss.do?filename="+filename+"&beanname=com.gmcc.pboss.web.sales.order.RecordedTaskBean&step=2&wayid="+wayid;
   		parent.document.getElementById("tt").click();
	}
}
</script>
				<%
				}
				%>
				</div>
	</BODY>
</HTML>
