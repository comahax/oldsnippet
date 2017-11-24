
<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + contextPath + "/";
%>
<base href="<%=basePath%>" target="_self">

<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<meta name="author" content="www.sunrise.com" />
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/>
<!-- css and javascript -->

<script type="text/javascript" language="javascript">
	var msgIllegalFormat = "<bean:message bundle="public" key="msgIllegalFormat"/>"
	var msgMonthOutRange = "<bean:message bundle="public" key="msgMonthOutRange"/>"
	var msgInvalidNumberFormat = "<bean:message bundle="public" key="msgInvalidNumberFormat"/>"
	var msgNumberTooBig = "<bean:message bundle="public" key="msgNumberTooBig"/>"
	var msgNumberTooSmall = "<bean:message bundle="public" key="msgNumberTooSmall"/>"
	var msgInput = "<bean:message bundle="public" key="msgInput"/>"
	var msgInputCorrectEmail = "<bean:message bundle="public" key="msgInputCorrectEmail"/>"
	var msgTimeRangeError = "<bean:message bundle="public" key="msgTimeRangeError"/>"
	var msgInputNotNull ="<bean:message bundle="public" key="msgInputNotNull"/>"
	var msgInvalidDate = "<bean:message bundle="public" key="msgInvalidDate"/>"
	var msgInvalidDateYyyymmdd = "<bean:message bundle="public" key="msgInvalidDateYyyymmdd"/>"
	var msgInvalidTime = "<bean:message bundle="public" key="msgInvalidTime"/>"
	var msgInvalidTimeHHMM = "<bean:message bundle="public" key="msgInvalidTimeHHMM"/>"
	var msgStringOutRange = "<bean:message bundle="public" key="msgStringOutRange"/>"
	var msgStringOutRangeInfo = "<bean:message bundle="public" key="msgStringOutRangeInfo"/>"
	var msgIntegerTooLong = "<bean:message bundle="public" key="msgIntegerTooLong"/>"
	var msgDecimalTooLong = "<bean:message bundle="public" key="msgDecimalTooLong"/>"
	var msgIntTooLong = "<bean:message bundle="public" key="msgIntTooLong"/>"
	var msIntMustBe = "<bean:message bundle="public" key="msIntMustBe"/>"
	var msgPotinInfo = "<bean:message bundle="public" key="msgPotinInfo"/>"
	var contextPath = "<%= contextPath %>";
</script>

<%--<link href="<%= contextPath %>/css/css_1/interfacebase.css" rel="stylesheet" type="text/css" media="all" />--%>
<%--<link href="<%= contextPath %>/css/css_1/input.css" rel="stylesheet" type="text/css" media="all" />--%>
<%--<script type="text/javascript" src="<%= contextPath %>/js/baseframe.js"></script>--%>

<link href="<%= contextPath %>/css/css_1/interfacebase.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/css_1/navigate.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/css_1/common.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/css_1/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/css_1/button.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/css_1/table.css" rel="stylesheet" type="text/css" media="all" />
<%--<link href="<%= contextPath %>/css/css_1/menu.css" rel="stylesheet" type="text/css" media="all" />--%>

<script type="text/javascript" src="<%= contextPath %>/js/baseframe.js"></script>
<%--<script type="text/javascript"  src="<%= contextPath %>/js/otherwin.js"></script>--%>
<%--<script type="text/javascript" src="<%= contextPath %>/js/title.js"></script>--%>
<%--<script type="text/javascript" src="<%= contextPath %>/js/rightclick.js"></script>--%>

<script type="text/javascript" src="<%= contextPath %>/js/pub/check.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/mcheck.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/util.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/print.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/My97DatePicker/WdatePicker.js" defer="defer"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/JMpopup.js"></script>

