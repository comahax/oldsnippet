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
				    addmenu('<%=contextPath%>/base/smstmpl_list.do','短信模版管理'); 
				    addmenu('<%=contextPath%>/base/batchsmsrc_list.do','激活量短信下发接收号码设置');
					addmenu('<%=contextPath%>/base/limitsms_list.do','短信过滤设置');
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/base/smstmpl_list.do" height="100%" scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
