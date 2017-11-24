<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<% String ID = "CH_ADT_CARDREWDET_AUDIT"; %>
<html>
	<head>
		<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body onload="loadforiframe();">

		<div class="table_container">

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/rewardlocal/rewardlocal/rewardlocal_doListPage.do','本地酬金查询');
				     <j:purChk permid="<%=ID%>">    	 
					addmenu('<%=contextPath%>/cardrewdettotal/cardrewdettotal_show.do', '客户质量发展奖励酬金汇总');
					 </j:purChk>
					addmenuright();
				  addmenumore();
				</script>
			</div>
			<div class="table_div">
	        	<table class="table_style">
	            <tr class="table_style_head">
	       		
				<div class="iframewindow" id="message">
					<iframe framespacing="9" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
						src="<%=contextPath%>/rewardlocal/rewardlocal/batch.jsp" height="100%" scrolling="auto"></iframe>
				</div>
				</tr>
				</table>
		
			</div>
		 
		</div>
	</body>
</html>
