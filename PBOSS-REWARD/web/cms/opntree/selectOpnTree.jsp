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
	String topChildrenURL = (String) request.getAttribute("topChildrenURL");
	String topAction = (String) request.getAttribute("topAction");
	
	String skname=(String)session.getAttribute("_sk_name");
	String neopnid=(String)session.getAttribute("_ne_opnid");
	String isLeaf=request.getParameter("isLeaf")==null?"":request.getParameter("isLeaf");
	String treeType=request.getParameter("treeType");
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
		<html:form action="/cms/opntree.do?CMD=TREE" styleId="formList"
			method="post">
			<input type="hidden" name="style" value="<%=isLeaf%>">
			<html:hidden property="rootid"/>
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
        	var nodeid;
        	var skname="<%=skname%>";
        	var neopnid="<%=neopnid%>";
        	var treeType="";
			<%if(rootAdaId!=null) { %>	
				var tree = new WebFXLoadTree("<%=rootName%>",topChildrenURL ,<%=topAction%>);
			<% } %>
				document.write(tree);
        </script>
				</div>
			</div>
			<div class="table_div">	
			<table class="table_button_list">
					<tr>
						<td>
							<nobr>&nbsp;&nbsp;显示失效业务</nobr>
						</td>
						<td>
							<html:checkbox property="showdisabled" styleClass="null" title="选中可以显示失效的业务" onclick="query();"/> 
						</td>
						<td  width="100%">
							业务名称:<html:text property="_sk_name" title="请输入业务名称进行模糊查询！"/>           
							<img style="vertical-align:bottom;" src="<%=contextPath%>/images/b_preview.gif" onclick="query();">	
			                
						    业务编码:<html:text property="_se_opnid" title="请输入业务编码进行查询！"/>           
							<img style="vertical-align:bottom;" src="<%=contextPath%>/images/b_preview.gif" onclick="query();">	
							
							<input type="button" style="display: none" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnCancel" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="导出" class="submit" onclick="exportWays();">	
		                           
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnCancel" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="关闭" class="submit" onclick="cancel();">	
						</td>
					</tr>
			</table>

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
	//tree.WebFXTree.getFirst().tree.WebFXTree.expand();
	
	
</script>
	<script type="text/javascript">	
	var selectwayid = null;
	
	function selectOpn(nodeId, nodeName, nodeType) {	
		var opnIdName = new Array(2);
		if(nodeId  == null || nodeId =="null" || nodeId =="") {
		   return ;
		} 
		opnIdName[0]=nodeId;
		opnIdName[1]=nodeName;
		window.returnValue = opnIdName;		
		window.close();			
	}
	
	function cancel() {
		window.returnValue = null;		
		window.close();
	}
	
	function query() {
		var rootid = formList.rootid.value;	
		document.formList.action="<%=contextPath%>/cms/opntree.do?CMD=TREE&treeType=<%=treeType%>&isLeaf=<%=isLeaf%>&rootId="+rootid;
		document.formList.submit();
	}
</script>

</html>
