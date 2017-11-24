<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s"%>
<%@ page import="com.sunrise.boss.ui.cms.way.*" %>
<%
	WayAction action=new WayAction();
	action.doOrgTreePage(request);
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ contextPath + "/";

	String rootAdaId = (String) request.getAttribute("rootAdaId");
	String rootName = (String) request.getAttribute("rootName");
	String topChildrenURL = (String) request
			.getAttribute("topChildrenURL");
	String topAction = (String) request.getAttribute("topAction");
	String text=(String) request.getAttribute("text");
%>
<html>
	<head>
		<base target="_self" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
		<META HTTP-EQUIV="Expires" CONTENT="0">
		<title>选择组织结构</title>
		<script type="text/javascript">
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
		<html:form action="/cms/way.do?CMD=Selectorgtree" styleId="formList"
			method="post">
			<div class="waytree_div" align="left">
			<script type="text/javascript">       			
        	var topChildrenURL = "<%=topChildrenURL%>";     	
        	<%if(rootAdaId!=null) { %>	
				var tree = new WebFXLoadTree("<%=rootName%>",topChildrenURL ,<%=topAction%>);
			<% }else { %>	
				rootName = "<%=text%>";		 	
				var tree = new WebFXLoadTree("<%=text%>","example.jsp","javascript:void(0)");		
			<%} %>
				document.write(tree);
        </script>
		</div>
		<a id="wayLink" href="#" target="mainContent" style="display: none">way</a>
		</html:form>
	</body>
	<script type="text/javascript">
	var inValue = null;
	
	function initParam() {
		var args = window.dialogArguments;	
		if(args==null) return false;
		
		var inputBox = args;		
		inValue = inputBox.value;
	}	
</script>
	<script type="text/javascript">
	initParam();
</script>
	<script type="text/javascript">	
	var selectwayid = null;

	function cancel() {
		window.returnValue = null;		
		window.close();
	}
</script>

</html>
