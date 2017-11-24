<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="com.sunrise.boss.ui.cms.way.*" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3C" />
</jsp:include>
<%
	WayAction action=new WayAction();
	action.doTreepage(request);
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

<html:form action="/cms/way.do?CMD=Tree" styleId="formList" method="post" >
	<div class="table_div" align="left">
				<table class="table_button_list">
					<tr>
                        <td>
							<nobr>&nbsp;&nbsp;显示失效渠道</nobr>
						</td>
						<td>
							<c:choose>
							<c:when test="${requestScope['showDisabled'] eq 'true'}">
							<input type="checkbox" name="showDisabled" title="选中可以显示禁用的渠道" checked="checked"/>
							</c:when>
							<c:otherwise>
							<input type="checkbox" name="showDisabled" title="选中可以显示禁用的渠道"/>
							</c:otherwise>
							</c:choose>  
						</td>  
						<td> 
							<img style="vertical-align:bottom;" src="<%=contextPath%>/images/b_preview.gif" onclick="query();">	
						</td>
				</tr>
			</table>
	</div>
	<div class="waytree_div" align="left">
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
	
</script>
 
<script  type="text/javascript">	
	function query() {	
		var form=document.forms[0];
		form.action="<%=request.getRequestURI()%>?waytype=<%=request.getParameter("waytype")==null?"":request.getParameter("waytype")%>&waysubtype=<%=request.getParameter("waysubtype")==null?"":request.getParameter("waysubtype")%>";
		document.formList.submit();
	}
	
	function exportWays() {
		alert();
	}
</script>
</body>
</html>