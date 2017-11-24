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
	String skname=(String)session.getAttribute("_sk_name");
	String neopnid=(String)session.getAttribute("_ne_opnid");
	
	String style=request.getParameter("style")==null?"":request.getParameter("style");
	String city=request.getParameter("city")==null?"":request.getParameter("city");
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
		<html:form action="/cms/operation.do?CMD=Selectopntree2" styleId="formList"
			method="post">
			<input type="hidden" name="style" value="<%=style%>">
			<input type="hidden" name="city" value="<%=city%>">
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
        	var expandIntervalHandler2,expandIntervalHandler3,expandIntervalHandler4;
        	var nodes=[];
        	var nodeid;
        	var skname="<%=skname%>";
        	var neopnid="<%=neopnid%>";
        	var MAX_TIMES = 7;
			var times = 0;
			<%if(rootAdaId!=null) { %>	
				var tree = new WebFXLoadTree("<%=rootName%>",topChildrenURL ,<%=topAction%>);
			<% }else { %>	
				rootName = "<%=text%>";		 	
				var tree = new WebFXLoadTree("<%=text%>","example.jsp","javascript:void(0)");		
			<%} %>
				document.write(tree);
				function tests(){
				if (tree.loaded) {
				window.clearInterval(expandIntervalHandler2);
				for(var i=0 ; i<tree.childNodes.length; i++) {
				nodes[i]=tree.childNodes[i];
				}
				nodeid=nodes.length-1;
				doloads();
				}
				}
				
				function doloads(){
				if(nodeid>-1 && nodes[nodeid].text.indexOf('---')<0 && skname.length==0 && neopnid.length==0){
				if(expandIntervalHandler3==null){
				expandIntervalHandler3=window.setInterval("doloads();",100);
				}
				if(nodes[nodeid].childNodes.length>0){
				if(!nodes[nodeid].loaded && !nodes[nodeid].loading){
				 nodes[nodeid].expand();
				}
				if(nodes[nodeid].loaded){
				nodes[nodeid].deSelect();
				nodeid=nodeid-1;
				}
				}else{
				nodeid=nodeid-1;
				}
				if(nodeid==-1){
				window.clearInterval(expandIntervalHandler3);
				tree.select();
				}
				}
				}
				expandIntervalHandler2=window.setInterval("tests();",2000);
				if(skname.length>0 || neopnid.length>0){
				expandIntervalHandler4=window.setInterval("begins();",1000);
				}
				
				function begins(){
				if (tree.loaded) {
				doexpandChildren(tree);
				}
				if(times >= MAX_TIMES && expandIntervalHandler4){
				window.clearInterval(expandIntervalHandler4);
				}
				times++;
				}
				function doexpandChildren(trees){
					for (var i = 0; i < trees.childNodes.length; i++) {
					doexpandAll(trees.childNodes[i]);
					}
				}
				
				function doexpandAll(trees){
					if ((trees.folder) && (!trees.open)) { trees.expand(); }
					if(trees.loaded){trees.deSelect();}
					if(trees.text.indexOf(skname)>=0 ){
						trees.deSelect();
					}else{
						trees.select();
					}
					doexpandChildren(trees);
				}
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
							<html:checkbox property="showendopn" styleClass="null" title="选中可以显示失效的业务" onclick="query();"/> 
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
		if(nodeType == "operation") {
			if(nodeId  == null || nodeId =="null" || nodeId =="") {			  
			   return ;
			}
			opnIdName[0]=nodeId;
			opnIdName[1]=nodeName;
			window.returnValue = opnIdName;		
			window.close();			
		}else {
			//donothting;
		}
	}
	
	function cancel() {
		window.returnValue = null;		
		window.close();
	}
	
	function query() {	
		document.formList.submit();
	}
</script>

</html>
