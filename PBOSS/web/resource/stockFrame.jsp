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
				    addmenu('<%=contextPath%>/resource/comressmp_stat.do?param.queryAll=true&param._se_countyid=${USER.cityid}','Ì×¿¨¿â´æÍ³¼Æ'); 
					addmenu('<%=contextPath%>/resource/comrescard_stat.do?param.queryAll=true&param._se_countyid=${USER.cityid}', '³äÖµ¿¨¿â´æÍ³¼Æ');
				    addmenu('<%=contextPath%>/resource/emptysim_stat.do','¿Õ°×SIM¿¨¿â´æÍ³¼Æ'); 
				    addmenu('<%=contextPath%>/resource/emptysimbad_list.do','¿Õ°×SIM¿¨»µ¿¨Â¼Èë');
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/resource/comressmp_stat.do?param.queryAll=true&param._se_countyid=${USER.cityid}" height="100%" scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
