<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A1A" />
</jsp:include>
<%
	  String ID_1 = "CH_PW_SOTYWAY_QUERY";
	  String contextPath = request.getContextPath();
%>


<html>
<head>
<script type="text/javascript" language="javascript">
    var contextPath = "<%=contextPath %>";
</script>
<script type="text/javascript" src="<%=contextPath %>/js/baseframe.js"></script>
<script type="text/javascript" src="<%=contextPath %>/js/pub/util.js"></script>
<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/interfacebase.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/navigate.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/common.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/button.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/table.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=contextPath%>/css/css_1/menu.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body onload="loadforiframe();">	 

    <div>  
    
	    <div class="iframetop">
	    	 <bean:message bundle="index" key="diswaytitle"/>
	    </div>
	    
	    <div class="iframemenu">
			<script language="javascript">			
			addmenuleft();
			    <s:PurChk2 controlid="<%=ID_1%>"> addmenu("<%=contextPath%>/cms/disway/frame.jsp","<bean:message bundle="index" key="diswaybase"/>");</s:PurChk2>
			    <s:PurChk2 controlid="<%=ID_1%>"> addmenu("<%=contextPath%>/cms/disbchcontact.do?CMD=LIST&WAYSUBTYPE=DIS","<bean:message bundle="index" key="diswaycon"/>");</s:PurChk2>
			    <s:PurChk2 controlid="<%=ID_1%>"> addmenu("<%=contextPath%>/cms/diswaycompact.do?CMD=LIST&WAYSUBTYPE=DIS","<bean:message bundle="index" key="diswaycom"/>");</s:PurChk2>
			    <s:PurChk2 controlid="<%=ID_1%>"> addmenu("<%=contextPath%>/cms/diswayaccount.do?CMD=LIST&WAYSUBTYPE=DIS","<bean:message bundle="index" key="diswayacc"/>");</s:PurChk2>
		 	addmenuright();
		  	addmenumore();  
			</script>
		</div>
		
		<div id="message">
			<iframe framespacing="0" frameborder="NO" Scrolling="no"  name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"  src="<%=contextPath%>/cms/disway.do?CMD=LIST&WAYSUBTYPE=DIS"></iframe>
		</div>
		
	</div>

</body>
</html>