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
			String ID_1 =  "CH_B2M_REWARD||CH_B2M_REWARD_PROVINCIAL";
			String ID_2 = "CH_B2M_REWARD||CH_B2M_REWARD_CIVIC||CH_B2M_REWARD_PROVINCIAL";
			String ID_3 ="";

		%>

		<%
					User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			String parameter = request
					.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
			String opnidStr = request.getParameter("opnid");
			String busibelong = request.getParameter("busibelong");
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
		     addmenu('<%=contextPath%>/cms/bbc/operation.do?CMD=EDIT<%=urlParams%>','ҵ�������Ϣ'); 
		     <%
		     	if(busibelong.equals("ACTV")){//���ҵ�����Ϊ��Ծ��,����Ҫ��������ҳ��
		     %>
		     	<s:RewardPurChk controlid="<%=ID_1%>">
		     		<%
		     			if(opnid.equals("030100047")){
		     		%>
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOW<%=urlParams%>&ACTV=_NEW&OSSRC=0', '������վ��Ծ�ͻ�����׼ҳ��');
			   		<%
		     			}else if(opnid.equals("030100048")){
		     		%>
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOW<%=urlParams%>&ACTV=_E100&OSSRC=0', 'e100��Ծ�ͻ�����׼ҳ��');
			   		<%
		     			}
		     		%>
			   	</s:RewardPurChk>
			   	<s:RewardPurChk controlid="<%=ID_2%>">
			   		<%
		     			if(opnid.equals("030100047")){
		     		%>
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&ACTV=_NEW&OSSRC=0', '�й�˾������վ��Ծ�ͻ�����׼����');
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&ACTV=_NEW&OSSRC=1', '������������վ��Ծ�ͻ�����׼����');
			   		<%
		     			}else if(opnid.equals("030100048")){
		     		%>
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&ACTV=_E100&OSSRC=0', '�й�˾e100��Ծ�ͻ�����׼����');
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&ACTV=_E100&OSSRC=1', '������e100��Ծ�ͻ�����׼����');
			   		<%
		     			}
		     		%>
			   	</s:RewardPurChk>
			 <%  		
		     	}else if(busibelong.equals("SELL")||busibelong.equals("CZ")||busibelong.equals("DATABUSI")){//���ҵ�����Ϊ������,��Ҳ��Ҫ��������ҳ��
		     %>	
		     	<s:RewardPurChk controlid="<%=ID_1%>">
			     	addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOW<%=urlParams%>&SELL=null&OSSRC=0', '���������׼ҳ��');
			    </s:RewardPurChk>
			   	<s:RewardPurChk controlid="<%=ID_2%>">
			     	addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&SELL=null&OSSRC=0', '�й�˾���������׼����');
			     	addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&SELL=null&OSSRC=1', '���������������׼����');
			    </s:RewardPurChk>
		     <%	
		     	}else {
		     %>
		     		//��ʱ������ѯ�������
		     		//addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOW<%=urlParams%>&QUER=_???', '��ѯ�����׼ҳ��');
		     <%	
		     	}
		     %>
			addmenuright();
		  addmenumore();
		</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/cms/bbc/operation.do?CMD=EDIT<%=urlParams%>" height="100%" scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
