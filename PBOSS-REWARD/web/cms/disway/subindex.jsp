<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A1A" />
</jsp:include>
<%
	  String ID_1 = "CH_PW_SOTYWAY_QUERY";
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
	    	 <bean:message bundle="index" key="diswaytitle"/>
	    </div>
	    
	    <div class="iframemenu">
			<script language="javascript">
			    <s:PurChk2 controlid="<%=ID_1%>"> addmenu("<%=contextPath%>/cms/disbchcontact.do?CMD=EDIT&PK=<c:out value="${param.wayid}"/>","<bean:message bundle="index" key="diswaycon"/>");</s:PurChk2>
			    <s:PurChk2 controlid="<%=ID_1%>"> addmenu("<%=contextPath%>/cms/diswaycompact.do?CMD=EDIT&PK=<c:out value="${param.wayid}"/>","<bean:message bundle="index" key="diswaycom"/>");</s:PurChk2>
			    <s:PurChk2 controlid="<%=ID_1%>"> addmenu("<%=contextPath%>/cms/diswayaccount.do?CMD=LIST&WAYSUBTYPE=DIS&WAYID=<c:out value="${param.wayid}"/>","<bean:message bundle="index" key="diswayacc"/>");</s:PurChk2>
			</script>
      
		</div>
		
		<div class="iframewindow" id="message">
			<iframe framespacing="0" frameborder="NO" Scrolling="no"  name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"  src="<%=contextPath%>/cms/disbchcontact.do?CMD=EDIT&PK='${param.wayid}'"></iframe>
		</div>
		
	</div>

</body>
</html>