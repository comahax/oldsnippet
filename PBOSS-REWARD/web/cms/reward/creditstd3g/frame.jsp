<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
		<%
			String ID_1 = "CH_CREDITSTD3G_PRO";
			String ID_2 = "CH_CREDITSTD3G_CITY";
			String ID_3 = "CH_SALECREDITSTD3G_CITY";
		%>
	</head>
	<body onload="loadforiframe();">

		<div class="table_container">

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();
				  	<s:RewardPurChk controlid="<%=ID_1%>" >
				    	addmenu('<%=contextPath%>/cms/reward/creditstd3g/list.jsp','��Ȧ�ŵ겹�������������');
						addmenu('<%=contextPath%>/cms/reward/creditstd3g/liststdview.jsp','��Ȧ�ŵ겹������׼չ��');
				    </s:RewardPurChk>
				    <s:RewardPurChk controlid="<%=ID_2%>" >
				    	addmenu('<%=contextPath%>/cms/reward/creditstd3g.do?CMD=LISTSTDSET','��Ȧ�ŵ겹������׼����');						
				    </s:RewardPurChk>
				    <s:RewardPurChk controlid="<%=ID_3%>" >
				    	addmenu('<%=contextPath%>/cms/reward/salecreditstd3g/list.jsp','��Ȧ�ŵ겹�����ֱ�׼����');			    
				    </s:RewardPurChk>				    
					addmenuright();
				  addmenumore();
				</script>
			</div>

		 <div class="table_div">
        <table class="table_style">
            <tr class="table_style_head">
       		
			<div class="iframewindow" id="message">
				<s:RewardPurChk controlid="<%=ID_1%>" >
					<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/cms/reward/creditstd3g/list.jsp" height="100%" scrolling="auto"></iframe>
				 </s:RewardPurChk>
				 <s:RewardPurChk controlid="<%=ID_2%>" >
				 	<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/cms/reward/creditstd3g.do?CMD=LISTSTDSET" height="100%" scrolling="auto"></iframe>
				 </s:RewardPurChk>
			</div>
			</tr>
			</table>
		
			</div>
		</div>
	</body>
</html>