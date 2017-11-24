<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A1A" />
</jsp:include>

<%
	  String ID_1 = "CH_PW_AREACENTER_QUERY";
      String ID_2 = "CH_PW_CITYCOM_QUERY";
      String ID_3 = "CH_PW_COUNTYCOM_QUERY";
      String ID_4 = "CH_PW_SVC_QUERY";
      String ID_5 = "CH_PW_MA_QUERY";
    
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

<body onload="if(window.loadforiframe) loadforiframe();">	 

    <div class="table_container">
    
	    <div class="iframetop">
	    	 <bean:message bundle="index" key="areainfoTitle"/>
	    </div>
	    
	    <div class="iframemenu">
			<script language="javascript">
			    <s:PurChk2 controlid="<%=ID_1%>"> addmenu("<%=contextPath%>/cms/areacenter.do","<bean:message bundle="index" key="areacenter"/>");</s:PurChk2>
			    <s:PurChk2 controlid="<%=ID_2%>"> addmenu("<%=contextPath%>/cms/citycompany/frame.jsp","组织结构管理");</s:PurChk2>
			</script>
		</div>
		
		<div class="iframewindow" id="message">
			<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"  src="<%=contextPath%>/cms/areacenter.do" height="100%"></iframe>
		</div>
		
	</div>

</body>
</html>