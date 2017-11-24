<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<jsp:include page="/inc/acl.jsp">
  	<jsp:param name="PID" value="2B1A1A" />
</jsp:include>
<%
	String contextPath = request.getContextPath();
	String pk = (String)request.getAttribute("pk");
	pk = pk==null?"":pk;
%>


<html>
<head>
<script type="text/javascript" language="javascript">
    var contextPath = "<%=contextPath %>";
</script>
<script type="text/javascript" src="<%=contextPath %>/js/baseframe.js"></script>
<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>	 

    <div>  
    
	    <div class="iframetop">
	    	 <bean:message bundle="saleway" key="titleList"/>
	    </div>
	    
		<div class="table_div">
			<table width="100%" class="error_text">
				<s:Msg />
			</table>
		</div>
	    <div class="iframemenu">
			<script language="javascript">
			    addmenu("<%=contextPath%>/cms/saleway/saleway.do?CMD=EDIT&PK=<%=pk%>","<bean:message bundle="saleway" key="basecontent"/>");
			    addmenu("<%=contextPath%>/cms/saleway/contact.do?CMD=EDIT&PK=<%=pk%>","<bean:message bundle="saleway" key="contactcontent"/>");
			    addmenu("<%=contextPath%>/cms/saleway/compact.do?CMD=EDIT&PK=<%=pk%>","<bean:message bundle="saleway" key="compactcontent"/>");
			    addmenu("<%=contextPath%>/cms/saleway/account.do?CMD=EDIT&PK=<%=pk%>","<bean:message bundle="saleway" key="accountcontent"/>");
			</script>
		</div>
		
		<div id="message">
			<iframe framespacing="0" frameborder="NO" Scrolling="no"  name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"  src="<%=contextPath%>/cms/saleway/saleway.do?CMD=EDIT&PK=<%=pk%>"></iframe>
		</div>
	</div>

</body>
</html>