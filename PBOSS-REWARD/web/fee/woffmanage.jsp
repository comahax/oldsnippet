<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>

<%
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
	    	 销帐管理
	    </div>
	    
	    <div class="iframemenu">
			<script language="javascript">
				addmenu("<%=contextPath%>/fee/woff/acct.do","帐单科目管理");
			    addmenu("<%=contextPath%>/fee/woff/acctset.do","帐目组管理");
			    addmenu("<%=contextPath%>/fee/woff/eboxunit.do","帐本科目管理");
			    addmenu("<%=contextPath%>/fee/woff/woffrule.do","销帐规则管理");
			    addmenu("<%=contextPath%>/fee/woff/recfeecalrul.do","应缴费用规则管理");
			</script>
		</div>
		
		<div class="iframewindow" id="message">
			<iframe framespacing="0" frameborder="NO" Scrolling="no"  name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"  src="<%=contextPath%>/fee/woff/acct.do"></iframe>
		</div>
		
	</div>

</body>
</html>