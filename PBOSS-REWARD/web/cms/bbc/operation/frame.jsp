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
		     addmenu('<%=contextPath%>/cms/bbc/operation.do?CMD=EDIT<%=urlParams%>','业务基本信息'); 
		     <%
		     	if(busibelong.equals("ACTV")){//如果业务归属为活跃类,则需要生成两个页面
		     %>
		     	<s:RewardPurChk controlid="<%=ID_1%>">
		     		<%
		     			if(opnid.equals("030100047")){
		     		%>
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOW<%=urlParams%>&ACTV=_NEW&OSSRC=0', '新增网站活跃客户酬金标准页面');
			   		<%
		     			}else if(opnid.equals("030100048")){
		     		%>
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOW<%=urlParams%>&ACTV=_E100&OSSRC=0', 'e100活跃客户酬金标准页面');
			   		<%
		     			}
		     		%>
			   	</s:RewardPurChk>
			   	<s:RewardPurChk controlid="<%=ID_2%>">
			   		<%
		     			if(opnid.equals("030100047")){
		     		%>
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&ACTV=_NEW&OSSRC=0', '市公司新增网站活跃客户酬金标准设置');
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&ACTV=_NEW&OSSRC=1', '互联网新增网站活跃客户酬金标准设置');
			   		<%
		     			}else if(opnid.equals("030100048")){
		     		%>
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&ACTV=_E100&OSSRC=0', '市公司e100活跃客户酬金标准设置');
			   				addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&ACTV=_E100&OSSRC=1', '互联网e100活跃客户酬金标准设置');
			   		<%
		     			}
		     		%>
			   	</s:RewardPurChk>
			 <%  		
		     	}else if(busibelong.equals("SELL")||busibelong.equals("CZ")||busibelong.equals("DATABUSI")){//如果业务归属为销售类,则也需要生成两个页面
		     %>	
		     	<s:RewardPurChk controlid="<%=ID_1%>">
			     	addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOW<%=urlParams%>&SELL=null&OSSRC=0', '销售类酬金标准页面');
			    </s:RewardPurChk>
			   	<s:RewardPurChk controlid="<%=ID_2%>">
			     	addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&SELL=null&OSSRC=0', '市公司销售类酬金标准设置');
			     	addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOWCITY<%=urlParams%>&SELL=null&OSSRC=1', '互联网销售类酬金标准设置');
			    </s:RewardPurChk>
		     <%	
		     	}else {
		     %>
		     		//暂时不做查询类酬金界面
		     		//addmenu('<%=contextPath%>/cms/bbc/stdrewardbj.do?CMD=SHOW<%=urlParams%>&QUER=_???', '查询类酬金标准页面');
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
