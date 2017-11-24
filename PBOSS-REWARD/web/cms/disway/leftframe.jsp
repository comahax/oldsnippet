<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc" %>
<script type="text/javascript" language="javascript">
function selectWay(nodeId, nodeName, nodeType) {		
		if(nodeId  == null || nodeId =="null" || nodeId =="") {			  
			   return ;
		} 
		
		var wayLink = document.getElementById("wayLink");
		var openURL = null;
		var url = "/cms/disway.do?CMD=AGLIST&WAYSUBTYPE=DIS";
		openURL = "<%=contextPath%>" + url + "&_se_upperwayid=" + nodeId ; 
		if( openURL!=null) {
			wayLink.href = openURL;
			wayLink.click();
		}
	}
</script>
<jsp:include page="/cms/way/selectWayTreePage.jsp" flush="true">
<jsp:param name="waytype" value="ET"/>
</jsp:include>

