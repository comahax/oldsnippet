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
					addmenu('<%=contextPath%>/sales/waystocksnpt_stocklistsmp.do', '��������ͳ��');
					addmenu('<%=contextPath%>/sales/waystockrecord_list.do', '����������ϸ');
					//addmenu('<%=contextPath%>/sales/waystocksnpt_stocklistcard.do', '�����ֵ�������ͳ��');
					//addmenu('<%=contextPath%>/sales/waystocksnpt_stockrecordcard.do', '�����ֵ�������ϸ');
					addmenu('<%=contextPath%>/sales/waystocksnpt_salesmplist.do', '�����׿�������ͳ��');
					addmenu('<%=contextPath%>/sales/waystocksnpt_salerecordsmp.do', '�����׿���������ϸ');
					addmenu('<%=contextPath%>/sales/waystocksnpt_salecardlist.do', '�����ֵ��������ͳ��');
					addmenu('<%=contextPath%>/sales/waystocksnpt_salerecordcard.do', '�����ֵ����������ϸ');
					
					//addmenu('<%=contextPath%>/sales/waystocksnpt_activelistsmp.do', '�����׿�������ͳ��');
					addmenu('<%=contextPath%>/sales/waystocksnpt_activelistsmplist.do', '�����׿�������ͳ��');
					addmenu('<%=contextPath%>/sales/waystocksnpt_activesmprecord.do', '�����׿���������ϸ');
					
					addmenu('<%=contextPath%>/sales/waystocksnpt_salestatistic.do', '����հ�SIM��������ͳ��');
					addmenu('<%=contextPath%>/sales/waystocksnpt_salerecord.do', '����հ�SIM����������ϸ');
					addmenu('<%=contextPath%>/sales/waystocksnpt_usedstatistic.do', '����հ�SIM��ʹ����ͳ��');
					addmenu('<%=contextPath%>/sales/waystocksnpt_usedrecord.do', '����հ�SIM��ʹ������ϸ');
					
					addmenu('<%=contextPath%>/resource/wayrcstat_reallist.do','ʵʱͳ��');
					addmenu('<%=contextPath%>/resource/wayrcstat_historylist.do', '��ʷͳ��');
					
					addmenuright();
					addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/sales/waystocksnpt_stocklistsmp.do" height="100%" scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
