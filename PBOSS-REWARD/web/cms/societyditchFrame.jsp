<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A5E" />
</jsp:include>

<%
	  String ID_1 = "2B1A5E" + "BT1";
    String ID_2 = "2B1A5E" + "BT2";
    
	  String contextPath = request.getContextPath();
%>

<html>
<head>
<script type="text/javascript" language="javascript">
    var contextPath = "<%=contextPath %>";
</script>
<script type="text/javascript" src="<%=contextPath %>/js/baseframe.js"></script>
<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/interfacebase.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/navigate.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/common.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/button.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/table.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body  onload="if(window.loadforiframe) loadforiframe();">	 

    <div class="table_iframe">  
    
	    <div class="iframetop">
	    	 <bean:message bundle="employee" key="societytitle"/>
	    </div>
	    
	    <div class="iframemenu">
			<c:choose>
				<c:when test="${station eq 'G'}">
					<script language="javascript">
						location.href="<%=contextPath%>/cms/employee.do?CMD=SOCIETYSHOW&KIND=G";
					</script>
				</c:when>
				<c:otherwise>
					<script language="javascript">
			    		location.href="<%=contextPath%>/cms/employee.do?CMD=SOCIETYSHOW";
			    	</script>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div class="iframewindow" id="message">
			<iframe framespacing="0" frameborder="NO" Scrolling="no"  name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"  src="<%=contextPath%>/cms/postinfo.do"></iframe>
		</div>
		
	</div>

</body>
</html>