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
				    addmenu('<%=contextPath%>/sales/orderuplimit_listforemptysim.do','�հ�SIM�����Ԥ������'); 
				    addmenu('<%=contextPath%>/sales/simstockalarm_list.do',' �հ�SIM�����Ԥ�����ã�����)'); 
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/sales/orderuplimit_listforemptysim.do" height="100%"  scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
