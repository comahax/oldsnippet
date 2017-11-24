<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A5E" />
</jsp:include>

<%
	  String ID_1 = "CH_PW_EMPLOYEE_QUERY";
    String ID_2 = "CH_PW_WAYMANAGER_QUERY";
    
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

    <div>  
    
	    <div class="iframetop">
	    	 移动渠道人员信息管理
	    </div>
	    
	    <div class="iframemenu">
			<script language="javascript">			
				<s:PurChk2 controlid="<%=ID_1%>">addmenu("<%=contextPath%>/cms/servehallemployee/frame.jsp","服务厅人员信息管理");</s:PurChk2>
			   <s:PurChk2 controlid="<%=ID_2%>">addmenu("<%=contextPath%>/cms/ditchmgremployee/frame.jsp","渠道经理信息管理");</s:PurChk2>
			</script>
		</div>
		
		<div id="message">
			<iframe framespacing="0" frameborder="NO" Scrolling="no"  name="IFRM_MAIN" style="height:100%;width:100%" id="IFRM_MAIN" class="IFRM_MAIN_on"  src="<%=contextPath%>/cms/servehallemployee.do?CMD=SHOW"></iframe>
		</div>
		
	</div>

</body>
</html>