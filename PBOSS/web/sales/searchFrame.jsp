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
				  	addmenu('<%=contextPath%>/sales/vrealtimeamt_list.do', '�����̶�����ʵʱ��ѯ');
				    addmenu('<%=contextPath%>/sales/monorderinfo_list.do','�������¶�������ѯ'); 
					addmenu('<%=contextPath%>/sales/canorderinfo_list.do','�����̿ɶ�������ѯ');
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/sales/vrealtimeamt_list.do" height="100%"  scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
