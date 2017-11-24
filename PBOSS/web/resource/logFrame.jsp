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
				    addmenu('<%=contextPath%>/resource/comressmplog_list.do','套卡资源日志'); 
					addmenu('<%=contextPath%>/resource/comrescardlog_list.do', '充值卡资源日志');
					addmenu('<%=contextPath%>/resource/emptysimlog_list.do','空白SIM卡资源日志'); 
					addmenu('<%=contextPath%>/resource/comcategoryrelalog_list.do', '商品种类组合日志');
					addmenu('<%=contextPath%>/resource/numtypedeflog_list.do','号码类型日志'); 
					addmenu('<%=contextPath%>/resource/numsortrulelog_list.do', '号码分类规则日志');
					addmenu('<%=contextPath%>/resource/resloadparamlog_list.do', '资源入库参数日志');
					addmenu('<%=contextPath%>/resource/compacklog_list.do', '商品包日志');
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/resource/comressmplog_list.do" height="100%"  scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
