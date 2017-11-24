<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/commons" prefix="s"%>
<%@ include file="/inc/listhead.inc"%>
<jsp:include page="/inc/acl.jsp">
	<jsp:param name="PID" value="2B1A6F" />
</jsp:include>
<%String ID_1 = "2B1A6F" + "BT1";
			String ID_2 = "CH_PW_AREACENTER_LOGQUERY";
			String ID_3 = "CH_PW_CITYCOM_LOGQUERY";
			String ID_4 = "CH_PW_COUNTYCOM_LOGQUERY";
			String ID_5 = "2B1A6F" + "BT5";
			String ID_6 = "2B1A6F" + "BT6";
			String ID_7 = "2B1A6F" + "BT7";
			String ID_8 = "2B1A6F" + "BT8";
			String ID_9 = "2B1A6F" + "BT9";
			String ID_10 = "2B1A6F" + "BT10";

			String ID_11 = "2B1A6F" + "BT11";
			String ID_12 = "2B1A6F" + "BT12";
			String ID_13 = "2B1A6F" + "BT13";
			String ID_14 = "2B1A6F" + "BT14";
			String ID_15 = "2B1A6F" + "BT15";
			String ID_16 = "2B1A6F" + "BT16";
			String ID_17 = "2B1A6F" + "BT17";
			String ID_18 = "2B1A6F" + "BT18";
			String ID_19 = "2B1A6F" + "BT19";
			String ID_20 = "2B1A6F" + "BT20";

			String ID_21 = "2B1A6F" + "BT21";
			String ID_22 = "2B1A6F" + "BT22";
			String ID_23 = "2B1A6F" + "BT23";
			String ID_24 = "2B1A6F" + "BT24";
			
			String ID_25 = "2B1A6F" + "BT25";
			
			String ID_26="2B1A6F" + "BT26";
			String ID_27="2B1A6F" + "BT27";
			String ID_28="2B1A6F" + "BT28";
			String ID_29="2B1A6F" + "BT29";
			String ID_30="2B1A6F" + "BT30";
			String ID_31="2B1A6F" + "BT31";
			String ID_32="CH_PW_SOTYWAY_LOGQUERY";
			String ID_33 = "CH_PW_EMPLOYEE_LOGQUERY";
			String ID_34 = "CH_PW_WAYMANAGER_LOGQUERY";
			String ID_35 = "CH_PW_ADA_LOGQUERY";
			String ID_36 = "CH_PW_SVC_LOGQUERY";
			String ID_37 = "CH_PW_MA_LOGQUERY";
			String ID_38 = "CH_PW_SALEWAY_LOGQUERY";

			pageContext.setAttribute("contextPath", contextPath);
%>

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
							<bean:message bundle="logquery" key="waylogquery" />
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

			<c:set var="defaultURL" value="${contextPath}/cms/waylog.do?CMD=LIST" />
			<div class="iframemenu">
				<script language="javascript">
		  
		  addmenuleft();
		  <s:PurChk controlid="<%=ID_1%>"> addmenu('<%=contextPath%>/cms/waylog.do?CMD=LIST','<bean:message bundle="logquery" key="waylog"/>'); </s:PurChk>
		  <s:PurChk2 controlid="<%=ID_35%>"> addmenu('<%=contextPath%>/cms/adimarealog.do?CMD=LIST','<bean:message bundle="adimarealog" key="titleList"/>');</s:PurChk2>
		  <s:PurChk2 controlid="<%=ID_2%>"> addmenu('<%=contextPath%>/cms/areacterlog.do?CMD=LIST','<bean:message bundle="logquery" key="areacenterlog"/>'); </s:PurChk2>
		  <s:PurChk2 controlid="<%=ID_3%>"> addmenu('<%=contextPath%>/cms/citycomlog.do?CMD=LIST','<bean:message bundle="logquery" key="citycomlog"/>'); </s:PurChk2>
		  <s:PurChk2 controlid="<%=ID_4%>"> addmenu('<%=contextPath%>/cms/cntycomlog.do?CMD=LIST','<bean:message bundle="logquery" key="countycomlog"/>'); </s:PurChk2>
		  <s:PurChk2 controlid="<%=ID_36%>">addmenu('<%=contextPath%>/cms/servcentlog.do?CMD=LIST','<bean:message bundle="servcentlog" key="titleList"/>');</s:PurChk2>
		  <s:PurChk2 controlid="<%=ID_37%>">addmenu('<%=contextPath%>/cms/microarealog.do?CMD=LIST','<bean:message bundle="microarealog" key="titleList"/>');</s:PurChk2>
		  //<s:PurChk controlid="<%=ID_5%>"> addmenu('<%=contextPath%>/cms/waytypelog.do?CMD=LIST','<bean:message bundle="logquery" key="waytypelog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_6%>"> addmenu('<%=contextPath%>/cms/custwtypelog.do?CMD=LIST','<bean:message bundle="logquery" key="custwaytypelog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_7%>"> addmenu('<%=contextPath%>/cms/bchtypelog.do?CMD=LIST','<bean:message bundle="logquery" key="custbchtypelog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_8%>"> addmenu('<%=contextPath%>/cms/postinfolog.do?CMD=LIST','<bean:message bundle="logquery" key="postinfolog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_9%>"> addmenu('<%=contextPath%>/cms/employeelog.do?CMD=LIST','<bean:message bundle="logquery" key="employeelog"/>'); </s:PurChk>
		  
		  <s:PurChk controlid="<%=ID_25%>"> addmenu('<%=contextPath%>/cms/employeelog.do?CMD=SOCIETYLIST','<bean:message bundle="logquery" key="societyemployeelog"/>'); </s:PurChk>
		  <s:PurChk2 controlid="<%=ID_33%>"> addmenu('<%=contextPath%>/cms/employeelog.do?CMD=SERVERHALLLIST','<bean:message bundle="logquery" key="serverhallmployeelog"/>'); </s:PurChk2>
		  <s:PurChk2 controlid="<%=ID_34%>"> addmenu('<%=contextPath%>/cms/employeelog.do?CMD=DITCHMGRLIST','<bean:message bundle="logquery" key="ditchmgremployeelog"/>'); </s:PurChk2>
		  
		  <s:PurChk controlid="<%=ID_10%>"> addmenu('<%=contextPath%>/cms/wayunitlog.do?CMD=LIST','<bean:message bundle="logquery" key="wayunitlog"/>'); </s:PurChk>
		  
		  <s:PurChk controlid="<%=ID_11%>"> addmenu('<%=contextPath%>/cms/waylicenlog.do?CMD=LIST','<bean:message bundle="logquery" key="waylicenlog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_12%>"> addmenu('<%=contextPath%>/cms/agentcontlog.do?CMD=LIST','<bean:message bundle="logquery" key="agentcontlog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_13%>"> addmenu('<%=contextPath%>/cms/bchcontlog.do?CMD=LIST','<bean:message bundle="logquery" key="bchcontlog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_14%>"> addmenu('<%=contextPath%>/cms/agentbchlog.do?CMD=LIST','<bean:message bundle="logquery" key="agentbchlog"/>'); </s:PurChk>
		  
		  <s:PurChk controlid="<%=ID_15%>"> addmenu('<%=contextPath%>/cms/entitybchlog.do?CMD=LIST','<bean:message bundle="logquery" key="entitybchlog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_16%>"> addmenu('<%=contextPath%>/cms/waycompctlog.do?CMD=LIST','<bean:message bundle="logquery" key="waycompctlog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_17%>"> addmenu('<%=contextPath%>/cms/wayacctlog.do?CMD=LIST','<bean:message bundle="logquery" key="wayacctlog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_18%>"> addmenu('<%=contextPath%>/cms/wayguaratlog.do?CMD=LIST','<bean:message bundle="logquery" key="wayguaratlog"/>'); </s:PurChk>
		 
		  <s:PurChk controlid="<%=ID_19%>"> addmenu('<%=contextPath%>/cms/wayfctylog.do?CMD=LIST','<bean:message bundle="logquery" key="wayfctylog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_20%>"> addmenu('<%=contextPath%>/cms/waybsarealog.do?CMD=LIST','<bean:message bundle="logquery" key="waybsarealog"/>'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_21%>"> addmenu('<%=contextPath%>/cms/wayseatlog.do?CMD=LIST','<bean:message bundle="logquery" key="wayseatlog"/>'); </s:PurChk>		  

           <s:PurChk controlid="<%=ID_12%>"> addmenu('<%=contextPath%>/cms/rvwaycptlog.do?CMD=SHOW','竞争对手渠道信息日志管理'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_23%>"> addmenu('<%=contextPath%>/cms/rvwaycptlog.do?CMD=SHOW2','竞争对手签约社会渠道合同信息日志查询'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_24%>"> addmenu('<%=contextPath%>/cms/rvwaycntlog/rvwaycntlog.do?CMD=LIST','竞争对手自营渠道建设信息日志查询'); </s:PurChk>	
		  
		  <s:PurChk controlid="<%=ID_26%>"> addmenu('<%=contextPath%>/cms/svwayinfolog.do?CMD=SHOW','自营渠道基本信息管理日志查询'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_27%>"> addmenu('<%=contextPath%>/cms/svwayinvlog.do?CMD=SHOW','自营渠道投资信息管理日志查询'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_28%>"> addmenu('<%=contextPath%>/cms/svwaycnstrlog.do?CMD=SHOW','自营渠道建设信息管理日志查询'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_29%>"> addmenu('<%=contextPath%>/cms/svwaycostlog.do?CMD=SHOW','自营渠道日常成本费用信息管理日志查询'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_31%>"> addmenu('<%=contextPath%>/cms/svwayequiplog.do?CMD=SHOW','自助设备配置日志查询'); </s:PurChk>	  
		  
      <s:PurChk controlid="<%=ID_32%>"> addmenu('<%=contextPath%>/cms/waylog.do?CMD=DISLIST','连锁经营合作商日志管理'); </s:PurChk>
		  <s:PurChk controlid="<%=ID_32%>"> addmenu('<%=contextPath%>/cms/waylog.do?CMD=LOGISLIST','物流商日志查询'); </s:PurChk>		
		  <s:PurChk controlid="<%=ID_38%>"> addmenu('<%=contextPath%>/cms/waylog.do?CMD=SALEWAYLIST','<bean:message bundle="waylog" key="salewaylist"/>'); </s:PurChk>		
				
		  addmenuright();
		  addmenumore();
		</script>
			</div>

			<div class="iframewindow" id="message">
				<s:PurChk controlid="<%=ID_1%>">
					<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on" src="<c:out value='${defaultURL}'/>" height="100%"></iframe>
				</s:PurChk>
			</div>
		</div>
	</body>
</html>
