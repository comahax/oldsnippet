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
			/*	staffNo 操作员工号
			 staffName 操作员姓名
			 cityID 区域ID
			 orgID  组织ID
			 secretString 特殊标识，固定值“GMCC”
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
		  <s:PurChk controlid="<%=ID_1%>">   addmenu('<%=contextPath%>/zifee/fixfeedisc.do?CMD=LIST<%=urlParams%>','固定费优惠管理'); </s:PurChk> 
		  <s:PurChk controlid="<%=ID_2%>">   addmenu('<%=contextPath%>/zifee/plandisccode.do?CMD=LIST<%=urlParams%>','计费优惠代码设置');  </s:PurChk> 
		  <s:PurChk controlid="<%=ID_3%>">   addmenu('<%=contextPath%>/zifee/feedisc.do?CMD=LIST<%=urlParams%>','资费优惠配置管理');  </s:PurChk> 
		 									 addmenu('<%=contextPath%>/zifee/minconsume.do?CMD=LIST<%=urlParams%>','最低消费优惠管理');
		  <s:PurChk controlid="<%=ID_6%>">   addmenu('<%=contextPath%>/zifee/feediscmonth.do?CMD=LIST<%=urlParams%>','月底帐务优惠设置');  </s:PurChk>
		  <s:PurChk controlid="<%=ID_4%>">   addmenu('<%=contextPath%>/zifee/eboxdisc.do?CMD=LIST<%=urlParams%>','帐户预存优惠管理');  </s:PurChk> 
		  								 	 addmenu('<%=contextPath%>/zifee/yxplanpresnt.do?CMD=LIST<%=urlParams%>','附加帐务赠送信息管理'); 
		  <s:PurChk controlid="<%=ID_5%>">   addmenu('<%=contextPath%>/zifee/yxplansplitscale.do?CMD=LIST<%=urlParams%>','列帐拆分管理');  </s:PurChk> 		  
  	   									     addmenu('<%=contextPath%>/zifee/prodservset.do?CMD=LIST<%=urlParams%>','产品分级服务设置');
  	   									     addmenu('<%=contextPath%>/zifee/prodpresent.do?CMD=LIST<%=urlParams%>','标准商品账目抵扣管理');
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
		  addmenu('<%=huaweiContextPath%>/product/privilegeFeeAction.do?<%=urlParams2%>','营业资费方案');
		  addmenu('<%=huaweiContextPath%>/product/privilegeLargessAction.do?<%=urlParams2%>','赠品营销方案');
		  addmenu('<%=huaweiContextPath%>/product/privilegeScoreAction.do?<%=urlParams2%>','赠送积分');
		  addmenu('<%=huaweiContextPath%>/product/privilegeConsumeAction.do?<%=urlParams2%>','积分消费');
		  addmenu('<%=huaweiContextPath%>/product/privilegeSellAction.do?<%=urlParams2%>','商品销售优惠方案');
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeRelationAction.do?<%=urlParams2%>','营销方案关系');
		  addmenu('<%=huaweiContextPath%>/product/privilegeTelPattenAction.do?<%=urlParams2%>','营销方案号码模式');
		  addmenu('<%=huaweiContextPath%>/product/privilegeCustTypeAction.do?<%=urlParams2%>','客户类型关系');
		  addmenu('<%=huaweiContextPath%>/product/privilegeChannelAction.do?<%=urlParams2%>','受理渠道');
		  addmenu('<%=huaweiContextPath%>/product/privilegeRightAction.do?<%=urlParams2%>','使用权限');
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeAttachBusiAction.do?<%=urlParams2%>','对应业务');		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeBanBusiAction.do?<%=urlParams2%>','允许(禁止)业务');
		  addmenu('<%=huaweiContextPath%>/product/privilege/detail.jsp?<%=urlParams3%>','使用渠道');
		  addmenu('<%=huaweiContextPath%>/product/privilegeChannelAction.do?<%=urlParams4%>','使用渠道(列表)');
		  addmenu('<%=huaweiContextPath%>/product/privilegeNetFeeAction.do?<%=urlParams2%>','智能网资费方案');
		  addmenu('<%=huaweiContextPath%>/product/privilegeExtraInfoAction.do?<%=urlParams2%>','附加属性');
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeScoreConsumeAction.do?<%=urlParams2%>','积分消费条件');		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeGroupMemberAction.do?<%=urlParams2%>','集团成员限制');
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeProductAction.do?<%=urlParams2%>','营销方案可选主体产品'); 
		  addmenu('<%=huaweiContextPath%>/product/privilegeProdListAction.do?<%=urlParams2%>','上架产品列表'); 
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeCustGroupAction.do?<%=urlParamsCustGroupAllow%>','指定客户群'); 
		  addmenu('<%=huaweiContextPath%>/product/privilegeCustGroupAction.do?<%=urlParamsCustGroupForbid%>','禁止客户群');
		  
		  addmenu('<%=huaweiContextPath%>/product/privilegeUserDefineConfigAction.do?<%=urlParamsUserdefine%>','用户自定义条件');
		  addmenu('<%=huaweiContextPath%>/product/privilegeOperWkgrpAction.do?<%=urlOperWkgrp%>','指定工号/工作组');
		  
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
