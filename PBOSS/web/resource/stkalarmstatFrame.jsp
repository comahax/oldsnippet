<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body onload="loadforiframe();">

		<div class="table_container">

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/resource/stkalarmstat_listdetail.do','网点预警信息明细'); 
				    addmenu('<%=contextPath%>/resource/stkalarmstat_liststat.do','网点预警信息统计'); 
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="table_div">
        	<table class="table_style">
          	<tr class="table_style_head">
			<div class="iframewindow" id="message">
				<iframe framespacing="10" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/resource/stkalarmstat_listdetail.do" height="100%" scrolling="auto"></iframe>
			</div>
			</tr>
			</table>
			</div>
		</div>
	</body>
</html>
