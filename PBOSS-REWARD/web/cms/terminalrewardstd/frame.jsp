<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/head.inc"%>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.sunrise.boss.ui.commons.User"%>
<%@ page import="com.sunrise.boss.ui.cms.bbc.vstdreward.VstdrewardAction"%>
<%

String ID_PRO = "CH_TERREWARDTYPE_PRO";

String ID_CITY = "CH_TERREWARDTYPE_CITY";
	
%>
<html>
	<head>
	<%-- 
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<title>�������</title>
		--%>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>

	<body onload="loadforiframe();">
	<div class="table_container">
	<%-- 
		<div class="table_div">
			<table class="top_table">
				<tr>
					<td>�������</td>
				</tr>
			</table>
		</div>
		--%>

		
		<div class="iframemenu">
			<script language="javascript">
			<s:RewardPurChk controlid="<%=ID_PRO%>">
			    addmenu('<%=contextPath%>/cms/terminalrewardstd.do?CMD=LIST&region=999', '�ն˳���׼����ʡ��˾����');
			</s:RewardPurChk>
			<s:RewardPurChk controlid="<%=ID_CITY%>">
			    addmenu('<%=contextPath%>/cms/terminalrewardstd.do?CMD=LIST&region=000', '�ն˳���׼�����й�˾����');
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
