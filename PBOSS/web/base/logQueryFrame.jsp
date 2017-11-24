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
				  	addmenu('<%=contextPath%>/base/rolelog_list.do','角色管理日志');	
				  	addmenu('<%=contextPath%>/base/operrolelog_list.do','操作员角色设置日志');	
				  	addmenu('<%=contextPath%>/base/functionitemlog_list.do','菜单管理日志');	
				  	addmenu('<%=contextPath%>/base/rolefunctionlog_list.do','角色菜单授权日志');	
				  	addmenu('<%=contextPath%>/base/rolerightlog_list.do','角色令牌授权日志');	
				  	addmenu('<%=contextPath%>/base/operfunctionlog_list.do','操作员菜单授权日志');	
				  	addmenu('<%=contextPath%>/base/operrightlog_list.do','操作员令牌授权日志');	
				  	addmenu('<%=contextPath%>/base/sysparamlog_list.do','系统参数管理日志');	
				  	addmenu('<%=contextPath%>/base/dictitemlog_list.do','固定参数管理日志');
				  addmenuright();
				  addmenumore();
				</script>
			</div>


			<div class="table_div">
        	<table class="table_style">
            <tr class="table_style_head">
			<div class="iframewindow" id="message">
				<iframe framespacing="10" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/base/rolelog_list.do" height="100%" scrolling="auto"></iframe>
			</div>
			</tr>
			</table>
		
			</div>
		</div>
	</body>
</html>