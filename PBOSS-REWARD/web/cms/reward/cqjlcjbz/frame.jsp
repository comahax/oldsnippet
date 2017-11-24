<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";//省级酬金管理令牌
	String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC";//市级酬金管理令牌
%>
<html>
	<head>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body onload="loadforiframe();">

		<div class="table_container">

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				  	<s:RewardPurChk controlid="<%=ID_2%>">
				    	addmenu('<%=contextPath%>/cms/reward/cqjlcjbz/list.jsp','市公司长期激励酬金标准设置');
				    </s:RewardPurChk>
				    <s:RewardPurChk controlid="<%=ID_1%>">
				    	addmenu('<%=contextPath%>/cms/reward/stdrewardcq/list.jsp','长期激励酬金标准上限设置');
				    </s:RewardPurChk>
					addmenuright();
				  addmenumore();
				</script>
			</div>

		 <div class="table_div">
        <table class="table_style">
            <tr class="table_style_head">
       		
			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/cms/reward/cqjlcjbz/list.jsp" height="100%" scrolling="auto"></iframe>
			</div>
			</tr>
			</table>
		
			</div>
		</div>
	</body>
</html>
