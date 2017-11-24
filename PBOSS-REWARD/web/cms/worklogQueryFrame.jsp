<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<script type="text/javascript" language="javascript">
    		var contextPath = "<%= contextPath %>";    
		</script>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/button.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/form.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%=contextPath%>/css/css_1/table.css" rel="stylesheet" type="text/css" media="all" />
		<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
		<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
	</head>
	<body>
		<div class="table_container">
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="logquery" key="worklogquery" />
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<table width="100%" class="error_text">
					<html:errors />
					<s:Msg />
				</table>
			</div>

			<c:set var="defaultURL" value="${contextPath}/cms/operationlog.do?CMD=LIST" />
			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();
				  addmenu('<%=contextPath%>/cms/operationlog.do?CMD=LIST','<bean:message bundle="operationlog" key="titleList"/>');
				  //addmenu('<%=contextPath%>/cms/workloglog.do?CMD=LIST','<bean:message bundle="workloglog" key="titleList"/>');
				  //addmenu('<%=contextPath%>/cms/workcommselllog.do?CMD=LIST','<bean:message bundle="workcommselllog" key="titleList"/>');
				  //addmenu('<%=contextPath%>/cms/workserviceslog.do?CMD=LIST','<bean:message bundle="workserviceslog" key="titleList"/>');
				  //addmenu('<%=contextPath%>/cms/workyxschemelog.do?CMD=LIST','<bean:message bundle="workyxschemelog" key="titleList"/>');
				  addmenu('<%=contextPath%>/cms/commissionlog.do?CMD=LIST','<bean:message bundle="commissionlog" key="titleList"/>');
				  addmenuright();
				  addmenumore();
				</script>
			</div>
			<div class="iframewindow" id="message">
  				  <iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on" src="<%=contextPath%>/cms/operationlog.do?CMD=LIST" height="100%"></iframe>
			</div>
		</div>
	</body>
</html>
