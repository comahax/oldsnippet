<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3C" />
</jsp:include>
<%
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

<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/table.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/xtree.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/button.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/dtree.css" />

</head>
<body>	
<s:form action="/cms/way_tree.do" key="formList" cssStyle="formList" theme="simple" method="post">
	
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
</s:form>

 <script  type="text/javascript">	
	var selectwayid = null;
	
	function showOpertor(nodeId, nodeName, nodeType) {		
		var openURL = "<%=contextPath%>/base/operator_list.do?param._se_orgid=" + nodeId;						
		window.parent.mainFrame.location.href=openURL;
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