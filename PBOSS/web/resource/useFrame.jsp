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
				    addmenu('<%=contextPath%>/resource/comressmp/resuseUpdate.jsp','�׿���;��������'); 
					addmenu('<%=contextPath%>/resource/comressmp/storareaUpdate.jsp', '�׿�������������');
					addmenu('<%=contextPath%>/resource/comressmp/boxnumUpdate.jsp','�׿�������������');
					addmenu('<%=contextPath%>/resource/comrescard/wayidUpdate.jsp','��ֵ����������'); 
					addmenu('<%=contextPath%>/resource/comressmp/wayidUpdate.jsp','�׿���������'); 
					addmenu('<%=contextPath%>/resource/emptysim/wayidUpdate.jsp','�հ�SIM����������'); 
					
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
