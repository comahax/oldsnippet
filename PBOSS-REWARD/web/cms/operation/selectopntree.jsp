<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s"%>

<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ contextPath + "/";

	String rootAdaId = (String) request.getAttribute("rootAdaId");
	String rootName = (String) request.getAttribute("rootName");
	String topChildrenURL = (String) request
			.getAttribute("topChildrenURL");
	String topAction = (String) request.getAttribute("topAction");
	String text = (String) request.getAttribute("text");
%>
<html>
	<head>
		<base target="_self" />
		<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
		<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
		<META HTTP-EQUIV="Expires" CONTENT="0">
		<title>选择业务类型</title>
		<script type="text/javascript">
	var contextPath = '<%=contextPath%>';
</script>
		<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/xloadtree/xtree.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/xloadtree/xmlextras.js"></script>
		<script type="text/javascript"
			src="<%=contextPath%>/js/xloadtree/xloadtree.js"></script>

		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/css_1/table.css" />
		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/css_1/xtree.css" />
		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/css_1/button.css" />
		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/css_1/dtree.css" />
		<link type="text/css" rel="stylesheet"
			href="<%=contextPath%>/css/css_1/form.css" />
	</head>
	<style>
	.waytree_div { 
		width:323px;
		height: 300px;
		overflow: auto;
		padding-left: 20px
	}
</style>
	<body>
		<html:form action="/cms/way.do?CMD=Selectorgtree" styleId="formList"
			method="post">
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							选择业务类型
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<table width="100%" class="error_text">
					<s:Msg />
				</table>
			</div>

			<div class="table_div">
				<div class="tree_style">
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
			</div>
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
	
	function selectOpn(nodeId, nodeName, nodeType) {		
		if(nodeId  == null || nodeId =="null" || nodeId =="") {
		   return ;
		} 
		if(nodeType == "opn" || nodeType=="opn5") {
			if(nodeId  == null || nodeId =="null" || nodeId =="") {			  
			   return ;
			} 
			window.returnValue = nodeId;		
			window.close();			
		}else {
			//donothting;
		}
	}
	
	function cancel() {
		window.returnValue = null;		
		window.close();
	}
</script>

</html>
