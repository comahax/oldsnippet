<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
%>
<%@include file="/cms/way/selectWayTreePage.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title></title>
    <script  type="text/javascript">
		function selectWay(nodeId, nodeName, nodeType) {		
			if(nodeId  == null || nodeId =="null" || nodeId =="") {			  
				   return ;
			} 
			var wayLink = document.getElementById("workLink");
			var openURL = null;
			openURL = "<%=contextPath%>/cms/saleway/saleway.do?CMD=LIST&_se_upperwayid=" + nodeId ;
			if( openURL!=null) {
				wayLink.href = openURL;
				wayLink.click();
			}
		}
	</script>
  </head>
  <body>
  	<a id="workLink" href="#" target="mainContent" style="display: none">org</a>   
  </body>
</html>
