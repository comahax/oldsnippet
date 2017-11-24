<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.cms.bbc.vstdreward.VstdrewardAction"%>
<%
String PK = (String) request.getAttribute(WebConstant.REQUEST_ATTRIBUTE_PK);
if (null == PK || "null".equalsIgnoreCase(PK)) {
	PK = "";
}
String pks[] = StringUtils.splitPreserveAllTokens(PK, "|");

String right = (String) request.getAttribute("RIGHT");

String ID_PRO = "CH_B2M_REWARD_PROVINCIAL";

String ID_CITY = "CH_B2M_REWARD_CIVIC";
	
%>
<html>
	<head>
	<%-- 
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>酬金设置</title>
		--%>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>

	<body onload="loadforiframe();">
	<div class="table_container">
	<%-- 
		<div class="table_div">
			<table class="top_table">
				<tr>
					<td>酬金设置</td>
				</tr>
			</table>
		</div>
		--%>

		
		<div class="iframemenu">
			<script language="javascript">
			<s:RewardPurChk controlid="<%=ID_CITY%>">
			    addmenu('<%=contextPath%>/cms/bbc/vstdreward.do?CMD=EDIT&region=000&PK=<%=PK%>', '市公司酬金标准设置');
			</s:RewardPurChk>
			<s:RewardPurChk controlid="<%=ID_PRO%>">
			    addmenu('<%=contextPath%>/cms/bbc/vstdreward.do?CMD=EDIT&region=999&PK=<%=PK%>', '省公司酬金标准设置');
			</s:RewardPurChk>
			</script>
		</div>
		
		
		
		 <div class="table_div">
        	<table class="table_style">
            <tr class="table_style_head">
       		
			<div class="iframewindow" id="message">
			<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on" height="100%">
				
			</div>
			</tr>
			</table>
		
			</div>
		
		
	</div>
	<body>
</html>
