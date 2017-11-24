<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B5E1A" />
</jsp:include>

<%
	  String ID_1 = "2B5E1A" + "BT1";
    String ID_2 = "2B5E1A" + "BT2";
	  String ID_3 = "2B5E1A" + "BT3";
    String ID_4 = "2B5E1A" + "BT4";
       
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

<body>	 

    <div class="table_iframe">  
    
	    <div class="iframetop">
	    	 <bean:message bundle="contractelem" key="tipsname"/>
	    </div>
	    
	    <div class="iframemenu">
			<script language="javascript">
			    <s:PurChk controlid="<%=ID_1%>"> addmenu("<%=contextPath%>/cms/message.do?CMD=LIST","<bean:message bundle="contractelem" key="tipsview"/>");</s:PurChk>
			    <s:PurChk controlid="<%=ID_2%>"> addmenu("<%=contextPath%>/cms/message.do?CMD=NEW","<bean:message bundle="contractelem" key="tipsadd"/>");</s:PurChk>
			</script>
		</div>
		
		<div class="iframewindow" id="message">
			<iframe framespacing="0" frameborder="NO" Scrolling="no"  name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"  src="<%=contextPath%>/cms/message.do?CMD=LIST"></iframe>
		</div>
		
	</div>

</body>
</html>