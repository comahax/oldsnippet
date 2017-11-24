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
				    addmenu('<%=contextPath%>/sales/sellnotice_wayList.do','网点销售进度查询');
				    addmenu('<%=contextPath%>/sales/sellnotice_wayMagList.do','渠道经理销售进度查询');
				    addmenu('<%=contextPath%>/sales/sellnotice_mareacodeList.do','微区域销售进度查询');
				    addmenu('<%=contextPath%>/sales/sellnotice_countyList.do','分公司销售进度查询');
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/sales/sellnotice_wayList.do" height="100%" scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
