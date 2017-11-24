<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.commons.integration.IntegrationBean"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<jsp:include page="/inc/acl.jsp">
			<jsp:param name="PID" value="3C3C1AAA" />
		</jsp:include>

		<%
			String ID_1 =  "CH_PW_REWARD || CH_PW_REWARD_PROVINCIAL";
			String ID_2 = "";
			String ID_3 ="";

		%>

		<%
					User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			String parameter = request
					.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
			String opnidStr = request.getParameter("opnid");
			
			String opnid = !StringUtils.isBlank(parameter) ? parameter
					: null;
			if (opnid == null)
				opnid = !StringUtils.isBlank(opnidStr) ? opnidStr : "";

			//link for product functions of Sunrise	
			String urlParams = opnid == null ? "" : "&_se_opnid="
					+ opnid + "&opnid=" + opnid + "&PK=" + opnid;

			urlParams += "&lockOject=true";

		%>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>

		<div class="table_container">
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="operation" key="titleList" />
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

			<div class="iframemenu">
				<script language="javascript">
		  addmenuleft();	
		     addmenu('<%=contextPath%>/cms/operation.do?CMD=EDIT<%=urlParams%>','ҵ�������Ϣ'); 
		     addmenu('<%=contextPath%>/cms/reward/stdrewardbj.do?CMD=SHOW<%=urlParams%>', '�Ƽ������������');
		     addmenu('<%=contextPath%>/cms/reward/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>', '�й�˾�Ƽ������������');
		     addmenu('<%=contextPath%>/cms/reward/rule2.do?CMD=LIST<%=urlParams%>', '������Ч�Թ����ѯ');
			 <s:RewardPurChk controlid="<%=ID_1%>" >
			 	addmenu('<%=contextPath%>/cms/rewardrulequery.do?CMD=SHOW', 'ҵ��������ѯ');
			 </s:RewardPurChk>
			addmenuright();
		  addmenumore();
		</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/cms/operation.do?CMD=EDIT<%=urlParams%>" height="100%"></iframe>
			</div>
		</div>
	</body>
</html>
