<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_REWARD||CH_PW_REWARD_PROVINCIAL";//ʡ������������
	String ID_2 = "CH_PW_REWARD||CH_PW_REWARD_CIVIC";//�м�����������
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
				    	addmenu('<%=contextPath%>/cms/reward/cqjlcjbz/list.jsp','�й�˾���ڼ�������׼����');
				    </s:RewardPurChk>
				    <s:RewardPurChk controlid="<%=ID_1%>">
				    	addmenu('<%=contextPath%>/cms/reward/stdrewardcq/list.jsp','���ڼ�������׼��������');
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
