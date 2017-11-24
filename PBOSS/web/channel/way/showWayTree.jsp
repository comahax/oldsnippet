<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ include file="/inc/listhead.inc" %>
<%
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
<title>选择渠道</title>
<script type="text/javascript" >
	var contextPath = '<%=contextPath%>';
</script>
<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xtree.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xmlextras.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xloadtree.js"></script>
<script type="text/javascript" src="<%=contextPath%>/js/xloadtree/xloadtree.extend.js"></script>

<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/table.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/xtree.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/button.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/dtree.css" />
<link type="text/css" rel="stylesheet" href="<%=contextPath%>/css/form.css" />
</head>

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
<input type="hidden" name="showOfCitycom" value="<%=showOfCitycomStr%>">
<input type="hidden" name="showParent" value="<%=showParentStr%>">
<input type="hidden" name="showSibling" value="<%=showSiblingStr%>">
<input type="hidden" name="menuTokenId" value="<%=menuTokenId%>">
<input type="hidden" name="waytype" value="<%=waytype%>">
<input type="hidden" name="waysubtype" value="<%=waysubtype%>">
<input type="hidden" name="runmode" value="<%=runmode%>">
<input type="hidden" name="cityid" value="<%=cityid%>">

<div class="table_div">
			<table class="top_table">
				<tr>
					<td>
						<bean:message bundle="Way" key="selectway"/>
					</td>
				</tr>
			</table>
		</div>
	
<div class="error_text" >
	<table class="error_text">
		<s:actionerror /><s:actionmessage/>
	</table>
</div>
			
<div class="waytree_div">
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
			var cityid;
			if(window.parent.mainFrame.document.all('param._se_cityid') != null) {
				cityid = window.parent.mainFrame.document.all('param._se_cityid').value;
			}
			var mainFramUrl = "<%=contextPath%>/channel/saleway_list.do?param._se_upperwayid=" + nodeId;
			if(cityid != null) {
				mainFramUrl = mainFramUrl + "&param._se_cityid="+cityid;
			}
			window.parent.mainFrame.location.href=mainFramUrl;
			/*if(window.parent.mainFrame.document.all('param._se_upperwayid') != null) {

				window.parent.mainFrame.document.all('param._se_upperwayid').value = nodeId;
			}*/
			//window.returnValue = wayIdName;		
			//window.close();			
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