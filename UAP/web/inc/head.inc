<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="aa" uri="http://ajaxanywhere.sourceforge.net/" %>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>

<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName()	+ ":" + request.getServerPort() + contextPath + "/";
	String basePath2 = request.getScheme() + "://" + request.getServerName()	+ ":" + request.getServerPort();

	String currentTheme = "default";
	currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<base href="<%=basePath%>">

<meta name="author" content="www.sunrise.com" />
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- css and javascript -->

<s:i18n name="public">
<script type="text/javascript" language="javascript">
	var msgIllegalFormat = "<s:text name="msgIllegalFormat"/>"
	var msgMonthOutRange = "<s:text name="msgMonthOutRange"/>"
	var msgInvalidNumberFormat = "<s:text name="msgInvalidNumberFormat"/>"
	var msgNumberTooBig = "<s:text name="msgNumberTooBig"/>"
	var msgNumberTooSmall = "<s:text name="msgNumberTooSmall"/>"
	var msgInput = "<s:text name="msgInput"/>"
	var msgInputCorrectEmail = "<s:text name="msgInputCorrectEmail"/>"
	var msgTimeRangeError = "<s:text name="msgTimeRangeError"/>"
	var msgInputNotNull ="<s:text name="msgInputNotNull"/>"
	var msgInvalidDate = "<s:text name="msgInvalidDate"/>"
	var msgInvalidDateYyyymmdd = "<s:text name="msgInvalidDateYyyymmdd"/>"
	var msgInvalidTime = "<s:text name="msgInvalidTime"/>"
	var msgInvalidTimeHHMM = "<s:text name="msgInvalidTimeHHMM"/>"
	var msgStringOutRange = "<s:text name="msgStringOutRange"/>"
	var msgStringOutRangeInfo = "<s:text name="msgStringOutRangeInfo"/>"
	var msgIntegerTooLong = "<s:text name="msgIntegerTooLong"/>"
	var msgDecimalTooLong = "<s:text name="msgDecimalTooLong"/>"
	var msgIntTooLong = "<s:text name="msgIntTooLong"/>"
	var msIntMustBe = "<s:text name="msIntMustBe"/>"
	var msgPotinInfo = "<s:text name="msgPotinInfo"/>"
    var sameNewOldPwd="<s:text name="sameNewOldPwd"/>";
    var notSameNewPwd="<s:text name="notSameNewPwd"/>";
	var contextPath = "<%=contextPath%>";
	var basePath2 = "<%=basePath2%>";
</script>
</s:i18n>

<link href="<%= contextPath %>/css/<%=currentTheme%>/form.css" rel="stylesheet" type="text/css"/>
<link href="<%= contextPath %>/css/<%=currentTheme%>/button.css" rel="stylesheet" type="text/css"/>
<link href="<%= contextPath %>/css/<%=currentTheme%>/table.css" rel="stylesheet" type="text/css"/>
<link href="<%=contextPath%>/up/common/css/layout.css" rel="stylesheet" type="text/css" />
<link href="<%=contextPath%>/up/common/css/css.css" rel="stylesheet" type="text/css" />
<link href="<%=contextPath%>/up/common/css/form.css" rel="stylesheet" type="text/css"/>
<link href="<%=contextPath%>/up/common/css/innerpage.css" rel="stylesheet" type="text/css" />
<link href="<%= contextPath %>/up/common/css/ui/drawdownbutton.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="<%= contextPath %>/js/pub/check.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/mcheck.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/util.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/picker.js"></script> 
<script type="text/javascript" src="<%= contextPath %>/js/aa.js"></script>
<script type="text/JavaScript" src="<%= contextPath %>/js/WdatePicker/WdatePicker.js"></script>

<script type="text/javascript" src="<%= contextPath%>/js/form-defaultvalue.js"></script>
<script type="text/javascript" src="<%= contextPath%>/up/lidl/js/tab.js"></script>
<script type="text/javascript" src="<%=contextPath %>/up/common/js/lib/zhcode.core.js" ></script>
<script type="text/javascript" src="<%=contextPath %>/up/common/js/lib/zhcode.ui.core.js"></script>
<script type="text/javascript">
	var $su = window.$;
</script>
<script type="text/javascript" src="<%= contextPath%>/js/jquery-treeview/lib/jquery.js"></script>
<script type="text/javascript" src="<%= contextPath%>/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="<%= contextPath%>/js/jquery.form.js"></script>
<script type="text/javascript" src="<%=contextPath %>/up/common/js/lib/sunrise/component/all.js"></script>
