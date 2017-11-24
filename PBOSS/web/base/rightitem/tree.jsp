<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib prefix="j" uri="/jop-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String rootId = (String)request.getAttribute("rootId");
	String rootName = (String)request.getAttribute("rootName");
	String topChildrenURL = (String)request.getAttribute("topChildrenURL" );
%>
<html>
<head>
<title>令牌树</title>
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
<s:form action="/base/rightitem_tree.do" key="formList" cssStyle="formList" theme="simple" method="post">

		 <div class="waytree_div" >
	        <script type="text/javascript">        			
				<%if(rootId!=null && !"非法数据".equals(rootName)) { %>
					var tree = new WebFXLoadTree("<%=rootName%>","<%=topChildrenURL%>","");
				<% }else { %>							
					var tree = new WebFXLoadTree("<%=rootName%>","<%=topChildrenURL%>");
				<%}%>
				document.write(tree);
	        </script>
	  	</div>
</s:form>
</body>
</html>