<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="j" uri="/jop-tags" %>
<%@ taglib prefix="p" uri="/pboss-tags"%>
<%@ taglib prefix="aa" uri="http://ajaxanywhere.sourceforge.net/" %>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName()	+ ":" + request.getServerPort() + contextPath + "/";
	
	String currentTheme = "default";
%>
<base href="<%=basePath%>" target="_self">

<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
<meta name="author" content="www.sunrise.com" />
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/> 
<meta http-equiv="Expires" content="0"/>
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
	var contextRootPath = "<%=contextPath%>";
</script>
</s:i18n>

<link href="<%= contextPath %>/css/interfacebase.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/navigate.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/common.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/form.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/button.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/table.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/top.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/left.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/bottom.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/biaodan.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/other.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/weebox/weebox.css" rel="stylesheet" type="text/css" media="all" />



<%--<link href="<%= contextPath %>/css/<%=currentTheme%>/menu.css" rel="stylesheet" type="text/css" media="all" />--%>

<!-- struts2-jquery -->
<script type="text/javascript" src="<%= contextPath %>/struts/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="<%= contextPath %>/struts/js/jquery-ui-1.7.2.min.js"></script>
<script type="text/javascript" src="<%= contextPath %>/struts/js/jquery.form.min.js"></script>
<script type="text/javascript" src="<%= contextPath %>/struts/js/jquery.cookie.min.js"></script>
<script type="text/javascript" src="<%= contextPath %>/struts/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript" src="<%= contextPath %>/struts/js/jquery.subscribe.1.1.min.js"></script>
<script type="text/javascript" src="<%= contextPath %>/struts/js/jquery.struts2.min.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/datepicker/ui.datepicker.min.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/weebox/weebox.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/weebox/wee_dlg.js"></script>

<script type="text/javascript" src="<%= contextPath %>/js/baseframe.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/check.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/mcheck.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/util.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/picker.js"></script> 
<script type="text/javascript" src="<%= contextPath %>/js/aa.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/JMpopup.js"></script>

<!--script type="text/javascript" src="<%= contextPath %>/js/pub/print.js"></script-->

<link rel="stylesheet" href="<%= contextPath %>/themes/cupertino/ui.theme.css" type="text/css"/>
<script type="text/javascript" src="<%= contextPath %>/js/My97DatePicker/WdatePicker.js" defer="defer"></script>

