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
			String PID = "3C3C1AAA";
			String ID_1 = PID + "BT1";
			String ID_2 = PID + "BT2";
			String ID_3 = PID + "BT3";
			String ID_4 = PID + "BT4";
			String ID_5 = PID + "BT5";
			String ID_6 = PID + "70";
		%>

		<%
					User user = (User) request.getSession().getAttribute(
					WebConstant.SESSION_ATTRIBUTE_USER);
			String parameter = request
					.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
			String yxplanidStr = request.getParameter("yxplanid");
			String areacode = request.getParameter("areacode") == null ? ""
					: request.getParameter("areacode").toString();
			String yxplanid = !StringUtils.isBlank(parameter) ? parameter
					: null;
			if (yxplanid == null)
				yxplanid = !StringUtils.isBlank(yxplanidStr) ? yxplanidStr : "";

			//link for product functions of Sunrise	
			String urlParams = yxplanid == null ? "" : "&_ne_yxplanid="
					+ yxplanid + "&yxplanid=" + yxplanid + "&PK=" + yxplanid
					+ "&areacode=" + areacode;

			urlParams += "&lockOject=true";

			//link for product functions of Huawei
			/*	staffNo ����Ա����
			 staffName ����Ա����
			 cityID ����ID
			 orgID  ��֯ID
			 secretString �����ʶ���̶�ֵ��GMCC��
			 */
			String staffNo = user.getOpercode();
			String staffName = user.getOpername();
			String cityid = user.getCityid();
			String orgID = user.getWayid();
			String secretString = "GMCC";
			String sourceURL = request.getRequestURL().toString();

			StringBuffer rightInfoString = new StringBuffer(60).append(
					"&staffNo=").append(staffNo).append("&staffName=").append(
					staffName).append("&orgID=").append(orgID).append(
					"&cityid=").append(cityid).append("&secretString=").append(
					secretString).append("&sourceURL=").append(sourceURL);

			String urlParams2 = yxplanid == null ? ""
					: "actionType=queryInit&yxplanid=" + yxplanid;
			String urlParams3 = yxplanid == null ? ""
					: "treeType=channelTree&yxplanid=" + yxplanid
					+ "&privilegeID=" + yxplanid;
			
			String urlParamsCustGroupAllow = yxplanid == null ? ""
					: "actionType=queryInitAllow&yxplanid=" + yxplanid;
			String urlParamsCustGroupForbid = yxplanid == null ? ""
					: "actionType=queryInitForbid&yxplanid=" + yxplanid;
			String urlParamsUserdefine = yxplanid == null ? ""
					: "actionType=queryInit&yxplanid=" + yxplanid;
			String urlOperWkgrp = yxplanid == null ? ""
					: "actionType=queryInit&yxplanid=" + yxplanid;
			String urlParams4 = yxplanid == null ? ""
					: "actionType=queryInitByTable&yxplanid=" + yxplanid
					+ "&privilegeID=" + yxplanid;
			urlParamsCustGroupAllow = urlParamsCustGroupAllow
					+ rightInfoString.toString();
			urlParamsCustGroupForbid = urlParamsCustGroupForbid
					+ rightInfoString.toString();
			urlParams2 = urlParams2 + rightInfoString.toString();
			urlParams3 = urlParams3 + rightInfoString.toString();
			urlParams4 = urlParams4 + rightInfoString.toString();
			urlParamsUserdefine = urlParamsUserdefine
					+ rightInfoString.toString();
			urlOperWkgrp = urlOperWkgrp + rightInfoString.toString();
			pageContext.setAttribute("yxplanid", yxplanid);
			pageContext.setAttribute("urlParams", urlParams);
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
							<bean:message bundle="yxplan" key="yxplanmag" />
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
		  <s:PurChk controlid="<%=ID_1%>">   addmenu('<%=contextPath%>/zifee/fixfeedisc.do?CMD=LIST<%=urlParams%>','�̶����Żݹ���'); </s:PurChk> 
		  <s:PurChk controlid="<%=ID_2%>">   addmenu('<%=contextPath%>/zifee/plandisccode.do?CMD=LIST<%=urlParams%>','�Ʒ��Żݴ�������');  </s:PurChk> 
		  <s:PurChk controlid="<%=ID_3%>">   addmenu('<%=contextPath%>/zifee/feedisc.do?CMD=LIST<%=urlParams%>','�ʷ��Ż����ù���');  </s:PurChk> 
		 									 addmenu('<%=contextPath%>/zifee/minconsume.do?CMD=LIST<%=urlParams%>','��������Żݹ���');
		  <s:PurChk controlid="<%=ID_6%>">   addmenu('<%=contextPath%>/zifee/feediscmonth.do?CMD=LIST<%=urlParams%>','�µ������Ż�����');  </s:PurChk>
		  <s:PurChk controlid="<%=ID_4%>">   addmenu('<%=contextPath%>/zifee/eboxdisc.do?CMD=LIST<%=urlParams%>','�ʻ�Ԥ���Żݹ���');  </s:PurChk> 
		  								 	 addmenu('<%=contextPath%>/zifee/yxplanpresnt.do?CMD=LIST<%=urlParams%>','��������������Ϣ����'); 
		  <s:PurChk controlid="<%=ID_5%>">   addmenu('<%=contextPath%>/zifee/yxplansplitscale.do?CMD=LIST<%=urlParams%>','���ʲ�ֹ���');  </s:PurChk> 		  
  	   									     addmenu('<%=contextPath%>/zifee/prodservset.do?CMD=LIST<%=urlParams%>','��Ʒ�ּ���������');
  	   									     addmenu('<%=contextPath%>/zifee/prodpresent.do?CMD=LIST<%=urlParams%>','��׼��Ʒ��Ŀ�ֿ۹���');
		  //below for huawei
		  <% 
			IntegrationBean integrationBean = new IntegrationBean(user);
			
		  	String huaweiIP = integrationBean.getHuaweiIP();
			String huaweiPort = integrationBean.getHuaweiPort();
			String huaweiWebRoot = integrationBean.getHuaweiWebRoot();
			
			if(huaweiWebRoot == null) huaweiWebRoot = "/boss";
		  	String huaweiContextPath = huaweiIP!=null ? "http://"+huaweiIP : "" ;  /* fixed value by huawei */ 
		  	if(huaweiIP!=null && huaweiPort!=null && !"80".equals(huaweiPort)) huaweiContextPath = huaweiContextPath + ":" + huaweiPort ;
		  	huaweiContextPath =  huaweiContextPath + huaweiWebRoot;
		  %>
		  addmenu('<%=huaweiContextPath%>/product/privilegeFeeAction.do?<%=urlParams2%>','Ӫҵ�ʷѷ���');
		  addmenu('<%=huaweiContextPath%>/product/privilegeLargessAction.do?<%=urlParams2%>','��ƷӪ������');
		  addmenu('<%=huaweiContextPath%>/product/privilegeScoreAction.do?<%=urlParams2%>','���ͻ���');
		  addmenu('<%=huaweiContextPath%>/product/privilegeConsumeAction.do?<%=urlParams2%>','��������');
		  addmenu('<%=huaweiContextPath%>/product/privilegeSellAction.do?<%=urlParams2%>','��Ʒ�����Żݷ���');
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeRelationAction.do?<%=urlParams2%>','Ӫ��������ϵ');
		  addmenu('<%=huaweiContextPath%>/product/privilegeTelPattenAction.do?<%=urlParams2%>','Ӫ����������ģʽ');
		  addmenu('<%=huaweiContextPath%>/product/privilegeCustTypeAction.do?<%=urlParams2%>','�ͻ����͹�ϵ');
		  addmenu('<%=huaweiContextPath%>/product/privilegeChannelAction.do?<%=urlParams2%>','��������');
		  addmenu('<%=huaweiContextPath%>/product/privilegeRightAction.do?<%=urlParams2%>','ʹ��Ȩ��');
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeAttachBusiAction.do?<%=urlParams2%>','��Ӧҵ��');		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeBanBusiAction.do?<%=urlParams2%>','����(��ֹ)ҵ��');
		  addmenu('<%=huaweiContextPath%>/product/privilege/detail.jsp?<%=urlParams3%>','ʹ������');
		  addmenu('<%=huaweiContextPath%>/product/privilegeChannelAction.do?<%=urlParams4%>','ʹ������(�б�)');
		  addmenu('<%=huaweiContextPath%>/product/privilegeNetFeeAction.do?<%=urlParams2%>','�������ʷѷ���');
		  addmenu('<%=huaweiContextPath%>/product/privilegeExtraInfoAction.do?<%=urlParams2%>','��������');
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeScoreConsumeAction.do?<%=urlParams2%>','������������');		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeGroupMemberAction.do?<%=urlParams2%>','���ų�Ա����');
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeProductAction.do?<%=urlParams2%>','Ӫ��������ѡ�����Ʒ'); 
		  addmenu('<%=huaweiContextPath%>/product/privilegeProdListAction.do?<%=urlParams2%>','�ϼܲ�Ʒ�б�'); 
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeCustGroupAction.do?<%=urlParamsCustGroupAllow%>','ָ���ͻ�Ⱥ'); 
		  addmenu('<%=huaweiContextPath%>/product/privilegeCustGroupAction.do?<%=urlParamsCustGroupForbid%>','��ֹ�ͻ�Ⱥ');
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeUserDefineConfigAction.do?<%=urlParamsUserdefine%>','�û��Զ�������');
		  addmenu('<%=huaweiContextPath%>/product/privilegeOperWkgrpAction.do?<%=urlOperWkgrp%>','ָ������/������');
		  
		  addmenuright();
		  addmenumore();
		</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN"
					id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/zifee/fixfeedisc.do?CMD=LIST<%=urlParams%>"
					height="100%"></iframe>
			</div>
		</div>
	</body>
</html>
