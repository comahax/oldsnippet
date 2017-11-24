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
					addmenu('<%=contextPath%>/sales/waystocksnpt_stocklistsmp.do', '网点库存量统计');
					addmenu('<%=contextPath%>/sales/waystockrecord_list.do', '网点库存量明细');
					//addmenu('<%=contextPath%>/sales/waystocksnpt_stocklistcard.do', '网点充值卡库存量统计');
					//addmenu('<%=contextPath%>/sales/waystocksnpt_stockrecordcard.do', '网点充值卡库存明细');
					addmenu('<%=contextPath%>/sales/waystocksnpt_salesmplist.do', '网点套卡销售量统计');
					addmenu('<%=contextPath%>/sales/waystocksnpt_salerecordsmp.do', '网点套卡销售量明细');
					addmenu('<%=contextPath%>/sales/waystocksnpt_salecardlist.do', '网点充值卡销售量统计');
					addmenu('<%=contextPath%>/sales/waystocksnpt_salerecordcard.do', '网点充值卡销售量明细');
					
					//addmenu('<%=contextPath%>/sales/waystocksnpt_activelistsmp.do', '网点套卡激活量统计');
					addmenu('<%=contextPath%>/sales/waystocksnpt_activelistsmplist.do', '网点套卡激活量统计');
					addmenu('<%=contextPath%>/sales/waystocksnpt_activesmprecord.do', '网点套卡激活量明细');
					
					addmenu('<%=contextPath%>/sales/waystocksnpt_salestatistic.do', '网点空白SIM卡销售量统计');
					addmenu('<%=contextPath%>/sales/waystocksnpt_salerecord.do', '网点空白SIM卡销售量明细');
					addmenu('<%=contextPath%>/sales/waystocksnpt_usedstatistic.do', '网点空白SIM卡使用量统计');
					addmenu('<%=contextPath%>/sales/waystocksnpt_usedrecord.do', '网点空白SIM卡使用量明细');
					
					addmenu('<%=contextPath%>/resource/wayrcstat_reallist.do','实时统计');
					addmenu('<%=contextPath%>/resource/wayrcstat_historylist.do', '历史统计');
					
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
