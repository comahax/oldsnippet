<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page
	import="com.sunrise.boss.ui.commons.integration.IntegrationBean"%>

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
			String ID_1 = "CH_PW_REWARD || CH_PW_REWARD_PROVINCIAL";
			String ID_2 = "";
			String ID_3 = "";
		%>

		<link href="<%=contextPath%>/css/css_1/iframemenu.css"
			rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>

		<div class="table_container">
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="zjtydataquery" key="titleList" />
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
		     addmenu('<%=contextPath%>/cms/zjty/zjtydataquery.do?CMD=Bosssucc','����ҵ������У����Ч����б�'); 
		     addmenu('<%=contextPath%>/cms/zjty/zjtydataquery.do?CMD=Bossfail','����ҵ������У����Ч����б�'); 
		     addmenu('<%=contextPath%>/cms/zjty/zjtydataquery.do?CMD=Bossjlsucc','����ҵ�������У��ɹ��б�'); 
		     addmenu('<%=contextPath%>/cms/zjty/zjtydataquery.do?CMD=Bossjlfail','����ҵ�������У��ʧ���б�');
		     addmenu('<%=contextPath%>/cms/zjty/zjtydataquery.do?CMD=Salesucc','��׼������������У����Ч����б�');
		     addmenu('<%=contextPath%>/cms/zjty/zjtydataquery.do?CMD=Salefail','��׼������������У����Ч����б�');
		     addmenu('<%=contextPath%>/cms/zjty/zjtydataquery.do?CMD=Tmnalsucc','�����ն���������У����Ч����б�');
		     addmenu('<%=contextPath%>/cms/zjty/zjtydataquery.do?CMD=Tmnalfail','�����ն���������У����Ч����б�');
			 addmenuright();
		  addmenumore();
		</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN"
					id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/cms/zjty/zjtydataquery.do?CMD=Bosssucc"
					height="100%" scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
