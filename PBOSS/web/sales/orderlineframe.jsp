<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
String pk = request.getParameter("param._pk");
 %>
<html>
	<head>
		<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>

		<div class="table_container">
			

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/sales/order_edit.do?param._pk=<%=pk%>','������Ϣ'); 
					addmenu('<%=contextPath%>/sales/ordercomcate_list.do?param._se_orderid=<%=pk%>', '������Ʒ������Ϣ');
					addmenu('<%=contextPath%>/sales/orderresdet_list.do?param._se_orderid=<%=pk%>&param._se_ordercomtype=CUSTORDER','��Դ��ϸ��Ϣ'); 
					addmenu('<%=contextPath%>/sales/orderresdet_list.do?param._se_orderid=<%=pk%>&param._se_ordercomtype=SYSTIEIN','������Դ��ϸ��Ϣ'); 
					addmenu('<%=contextPath%>/sales/orderresdet_list.do?param._se_orderid=<%=pk%>&param._se_ordercomtype=SYSGIFT','������Դ��ϸ��Ϣ');
					addmenu('<%=contextPath%>/sales/orderplan_list.do?param._se_orderid=<%=pk%>', '��������������Ϣ');
					/*
					addmenu('<%=contextPath%>/sales/order_appList.do?param._se_orderid=<%=pk%>', '�������');
					addmenu('<%=contextPath%>/sales/orderresdet_drawList.do?param._se_orderid=<%=pk%>', '������Դ��ȡ');
					*/
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/sales/order_edit.do?param._pk=<%=pk%>" height="100%" scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
