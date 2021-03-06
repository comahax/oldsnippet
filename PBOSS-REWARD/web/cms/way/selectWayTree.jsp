<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>

<%
	String contextPath = request.getContextPath();	
	String basePath = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + contextPath + "/";

	String rootWayId = (String)request.getAttribute("rootWayId");
	String rootName = (String)request.getAttribute("rootName");
	String topChildrenURL = (String)request.getAttribute("topChildrenURL" );
	String queryText =(String)request.getAttribute("queryText" );
	String topAction = (String)request.getAttribute("topAction" );
%>
<html>
<head>
<base target="_self"/>
<META HTTP-EQUIV="Pragma" CONTENT="no-cache"> 
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache"> 
<META HTTP-EQUIV="Expires" CONTENT="0"> 
<title><bean:message bundle="Way" key="selectway"/></title>
<script type="text/javascript" >
	var contextPath = '<%=contextPath%>';
</script>
<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xtree.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xmlextras.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xloadtree.js"></script>

<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/table.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/xtree.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/button.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/dtree.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/css_1/form.css" />
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
<%
	String showOfCitycomStr = (String)request.getParameter("showOfCitycom")==null?"":request.getParameter("showOfCitycom").toString(); ; //显示父渠道
	String showParentStr = (String)request.getParameter("showParent")==null?"":request.getParameter("showParent").toString(); ; //显示父渠道
	String showSiblingStr = (String)request.getParameter("showSibling")==null?"":request.getParameter("showSibling").toString(); ; //显示兄弟渠道(同级渠道)			
	String menuTokenId = (String)request.getParameter("menuTokenId")==null?"":request.getParameter("menuTokenId").toString(); ; 
	String waytype = request.getParameter("waytype")==null?"":request.getParameter("waytype").toString(); 
	String waysubtype = (String)request.getParameter("waysubtype")==null?"":request.getParameter("waysubtype").toString(); 
	String runmode = (String)request.getParameter("runmode")==null?"":request.getParameter("runmode").toString(); 
	String cityid = (String)request.getParameter("cityid")==null?"":request.getParameter("cityid").toString(); 
	showOfCitycomStr = StringUtils.isNotBlank(showOfCitycomStr) ?  showOfCitycomStr : "";
	showParentStr = StringUtils.isNotBlank(showParentStr) ?  showParentStr : "";
	showSiblingStr = StringUtils.isNotBlank(showSiblingStr) ?  showSiblingStr : "";
	menuTokenId = StringUtils.isNotBlank(menuTokenId) ?  menuTokenId : "";
%>
<html:form action="/cms/way.do?CMD=selectwaytree" styleId="formList" method="post" >
<input type="hidden" name="showOfCitycom" value="<%=showOfCitycomStr%>">
<input type="hidden" name="showParent" value="<%=showParentStr%>">
<input type="hidden" name="showSibling" value="<%=showSiblingStr%>">
<input type="hidden" name="menuTokenId" value="<%=menuTokenId%>">
<input type="hidden" name="waytype" value="<%=waytype%>">
<input type="hidden" name="waysubtype" value="<%=waysubtype%>">
<input type="hidden" name="runmode" value="<%=runmode%>">
<input type="hidden" name="cityid" value="<%=cityid%>">

<c:set var="way" scope="request" value="${requestScope['/cms/way/WayForm']}"/>
<div class="table_div">
			<table class="top_table">
				<tr>
					<td>
						<bean:message bundle="Way" key="selectway"/>
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
        	var queryText ="<%=queryText%>";
        	//queryText = encodeURIComponent(queryText);
        	if(queryText!="") 
        		topChildrenURL += "&queryText=" +  queryText;
        	
			<%if(rootWayId!=null && !"非法渠道".equals(rootName) ) { %>	
						
				var tree = new WebFXLoadTree("<%=rootName%>",topChildrenURL ,<%=topAction%>);
			<% }else { %>	
			
				rootName = "非法渠道";		 	
				var tree = new WebFXLoadTree("<%=rootName%>",topChildrenURL );		
			<%} %>
				document.write(tree);
				
				if(queryText!="" && queryText!="null")
					tree.expandAllover();
        </script>
  </div>
 </div>
 


	<div class="table_div">	
			<table class="table_button_list">
					<tr>
						<td>
							<input type="button" name="ch1" value="+" onclick="tree.expandOrCollapse(); " title="点击展开或折叠渠道树">
						</td>
						<td>
							<nobr>&nbsp;&nbsp;显示失效渠道</nobr>
						</td>
						<td>
			                <html:checkbox property="showDisabled" styleClass="null" title="选中可以显示禁用的渠道"/>   
						</td>
						<td  width="100%">
							<html:text property="_sk_wayname" title="请输入渠道名称或编码进行模糊查询！"/>           
							<img style="vertical-align:bottom;" src="<%=contextPath%>/images/b_preview.gif" onclick="query();">	
			                
						    
							<input type="button" style="display: none" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnCancel" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="导出" class="submit" onclick="exportWays();">	
		                           
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
		                           name="btnCancel" onfocus="buttonover(this)" onblur="buttonout(this)"
		                           value="取消" class="submit" onclick="cancel();">	
						</td>
					</tr>
			</table>

	</div>
</html:form>	
</body>
<script  type="text/javascript">
	var inValue = null;
	
	function initParam() {
		var args = window.dialogArguments;		
		if(args==null) return false;
		
		var inputBox = args;		
		inValue = inputBox.value;
	}	
</script>
<script  type="text/javascript">
	initParam();
</script>	
<script  type="text/javascript">	
	var selectwayid = null;
	
	function selectWay(nodeId, nodeName, nodeType) {		
		if(nodeId  == null || nodeId =="null" || nodeId =="") {
		   //alert("错误:丢失wayid");
		   return ;
		} 
		
		var wayIdName = new Array(2);
		wayIdName[0] = nodeId;
		wayIdName[1] = nodeName;
		
		if(nodeType == "Way" ) {
			if(nodeId  == null || nodeId =="null" || nodeId =="") {			  
			   return ;
			} 
			window.returnValue = wayIdName;		
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

<script  type="text/javascript">	
	function query() {
		document.formList.submit();
	}
	
	function exportWays() {
		alert();
	}
</script>
</html>