<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc" %>
<%String s;
s=request.getParameter("KIND");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>渠道</title>
<a id="workLink" href="#" target="mainContent" style="display: none">org</a>	
<script  type="text/javascript">	
function selectWay(nodeId, nodeName,nodetype) {	
var openURL;
<%if(s.equals("G")){%>
	 openURL= "<%=contextPath%>" + "/cms/employee.do?CMD=SOCIETYSHOW&KIND=G";
	<%}else{%>
	  openURL= "<%=contextPath%>" + "/cms/employee.do?CMD=SOCIETYSHOW";
<%}%>
	openURL = openURL + "&_sk_wayid=" + nodeId ;
		
	var workLink = document.getElementById("workLink");
	if( openURL!=null) {
		workLink.href = openURL;
		workLink.click();
	}
} 
</script>

</head>
<jsp:include page="/cms/way/selectWayTreePage.jsp"><jsp:param name="waytype" value="AG"/></jsp:include>

<noframes><body>
 frame is not supoorted by you browser.
</body></noframes>
</html>

