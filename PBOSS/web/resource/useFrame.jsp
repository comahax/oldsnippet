<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>

		<div class="table_container">
			

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/resource/comressmp/resuseUpdate.jsp','套卡用途批量更新'); 
					addmenu('<%=contextPath%>/resource/comressmp/storareaUpdate.jsp', '套卡库区批量更新');
					addmenu('<%=contextPath%>/resource/comressmp/boxnumUpdate.jsp','套卡包号批量更新');
					addmenu('<%=contextPath%>/resource/comrescard/wayidUpdate.jsp','充值卡批量调拨'); 
					addmenu('<%=contextPath%>/resource/comressmp/wayidUpdate.jsp','套卡批量调拨'); 
					addmenu('<%=contextPath%>/resource/emptysim/wayidUpdate.jsp','空白SIM卡批量调拨'); 
					
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/resource/comressmp/resuseUpdate.jsp" height="100%" scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
