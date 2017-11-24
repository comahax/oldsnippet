<%@ page language="java" contentType="text/html;charset=GBK"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3C" />
</jsp:include>
<%
	String contextPath = request.getContextPath();	
	String basePath = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + contextPath + "/";

	String rootWayId = (String)request.getAttribute("rootWayId");
	String rootName = (String)request.getAttribute("rootName");
	String topChildrenURL = (String)request.getAttribute("topChildrenURL" );
	String queryText =(String)request.getAttribute("queryText" ); //此处不使用
	String topAction = (String)request.getAttribute("topAction" );
%>
<html>
<head>
<title>Way</title>
<BASE href="<%=basePath%>" target="_self"/>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0"> 
<script type="text/javascript" >
	var contextPath = '<%=contextPath%>';
</script>
<script type="text/javascript" src="<%= contextPath %>/js/dtree.js"></script>

<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xtree.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xmlextras.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xloadtree.js"></script>

<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/table.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/xtree.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/button.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/dtree.css" />

</head>
<body>	
<html:form action="/cms/way.do?CMD=TREE" styleId="formList" method="post" >
	<div class="table_div">
				<table class="table_button_list">
					<tr>
                        <td>
							<nobr>&nbsp;&nbsp;显示失效渠道</nobr>
						</td>
						<td>
			                <html:checkbox property="showDisabled" styleClass="null" title="选中可以显示禁用的渠道"/>   
						</td>  
						<td> 
							<img style="vertical-align:bottom;" src="<%=contextPath%>/images/b_preview.gif" onclick="query();">	
						</td>
				</tr>
			</table>
	</div>
	
	
		 <div class="waytree_div" >
	        <script type="text/javascript">        			
				<%if(rootWayId!=null && !"非法渠道".equals(rootName)) { %>
					var tree = new WebFXLoadTree("<%=rootName%>","<%=topChildrenURL%>",<%=topAction%>);
				<% }else { %>							
					var tree = new WebFXLoadTree("<%=rootName%>","<%=topChildrenURL%>");
				<%}%>	
				
				document.write(tree);
	        </script>
	  	</div>
 	
  <a id="wayLink" href="#" target="mainContent" style="display: none">way</a>
</html:form>  

 <script  type="text/javascript">	
	var selectwayid = null;
	
	function selectWay(nodeId, nodeName, nodeType) {		
		if(nodeId  == null || nodeId =="null" || nodeId =="") {			  
			   return ;
		} 
		
		var wayLink = document.getElementById("wayLink");
		var openURL = null;
		if(nodeType == "Way" ) {
			openURL = "<%=contextPath%>/cms/way.do?CMD=LIST&_se_upperwayid=" + nodeId ;						
								
		}else if(nodeType == "Areacenter" ) {
			openURL = "<%=contextPath%>/cms/way.do?CMD=LIST&_se_centerid=" + nodeId ;	
		}else if(nodeType == "Citycom" ) {
		
			openURL = "<%=contextPath%>/cms/way.do?CMD=LIST&_se_cityid=" + nodeId ;	
			
		}else if(nodeType == "Countycom" ) {
			openURL = "<%=contextPath%>/cms/way.do?CMD=LIST&_se_countyid=" + nodeId ;	
		}else {
			alert("非法的节点类型:" + nodeType);
		}
				
		if( openURL!=null) {
			wayLink.href = openURL;
			wayLink.click();
		}
	}	
</script>
 
<script  type="text/javascript">	
	function query() {	
		document.formList.submit();
	}
	
	function exportWays() {
		alert();
	}
</script>
</body>
</html>