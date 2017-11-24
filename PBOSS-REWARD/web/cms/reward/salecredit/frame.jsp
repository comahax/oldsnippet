<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body onload="loadforiframe();">

		<div class="table_container">

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/cms/reward/salecredit/list.jsp','销售业务明细积分查询');
				    addmenu('<%=contextPath%>/cms/reward/credittotal/list.jsp','月度考核分数汇总查询');
				    addmenu('<%=contextPath%>/cms/reward/salecreditstd/list.jsp','销售业务积分标准设置');
				    <%-- addmenu('<%=contextPath%>/cms/reward/creditstd/list.jsp','市公司酬金标准管理');--%>
				    addmenu('<%=contextPath%>/cms/reward/chadtimportrecord.do?CMD=LIST','地市办理业务导入数据查询');
				    <%-- addmenu('<%=contextPath%>/cms/reward/creditstdpro/list.jsp','省公司酬金标准管理');--%>
				    
					addmenuright();
				  addmenumore();
				</script>
			</div>

		 <div class="table_div">
        <table class="table_style">
            <tr class="table_style_head">
       		
			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/cms/reward/salecredit/list.jsp" height="100%" scrolling="auto"></iframe>
					<%-- src="<%=contextPath%>/cms/reward/registersimvw.do?CMD=SHOW" height="100%" scrolling="auto"></iframe>--%>
			</div>
			</tr>
			</table>
		
			</div>
		</div>
	</body>
</html>
