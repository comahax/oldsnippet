<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/contenthead.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant,java.util.*"%>
<%
String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL"; //ʡ������������
String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC"; //�м�����������
String EDIT = (String) request.getAttribute(WebConstant.COMMAND_STRING_EDIT);
int listSize = ((List) request.getSession().getAttribute("NEWLIST")).size();
%>
<html>
	<head>
		<title><bean:message bundle="stdrewardbj" key="titleServ" /></title>
<script type="text/javascript" src="<%=contextPath%>/js/pub/list.js"></script>
<script language="JavaScript">

function ev_checkval() {
	return checkval(window);
}

</script>
	</head>
	<body onload="loadforiframe();">
		<div class="table_container">
			<html:form action="/cms/reward/stdrewardbj.do?CMD=SAVE" styleId="formItem" method="post">
				<html:hidden property="cmdState" />
				<html:hidden property="_orderby" />
				<html:hidden property="_desc" />
				<html:hidden property="_pageno" />
				<html:hidden property="_pagesize" />
				<c:set var="edtState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT' or param.CMD eq 'NEW')}" />
				<c:set var="updateState" scope="request" value="${!empty param.CMD and (param.CMD eq 'EDIT')}" />

				<!--##################################��ӱ�������##################################################-->
				<div class="table_div">
					<table class="top_table">
						<tr>
							<td>
								�����ö�Ӧ�ġ�ҵ���������ʾҳ��
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

				<div class="table_div">
					<table>
						<tr>
							<td>
								<input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);" name="btnReturn"
									onfocus="buttonover(this)" onblur="buttonout(this)" value="<bean:message bundle="public" key="button_return"/>"
									class="close" onclick="doReturnInFrame('/cms/operation.do?CMD=LIST')">
							</td>
						</tr>
					</table>
				</div>
			</html:form>
		</div>
	</body>
</html>
