<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "";
%>
<html>
	<head>
		<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body onload="loadforiframe();">

		<div class="table_container">

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/cms/bbc/allsalesday.do?CMD=STATISTIC','ҵ������ͳ��');
				    addmenu('<%=contextPath%>/cms/bbc/allsalesday.do?CMD=STATISTICBUSIDETAIL','��ҵ���Ӧ������');
				    addmenu('<%=contextPath%>/cms/bbc/allsalesday.do?CMD=STATISTICWAYBUSIDETAIL','������ҵ������');
					addmenuright();
				  addmenumore();
				</script>
			</div>

		 <div class="table_div">
        <table class="table_style">
            <tr class="table_style_head">
       		
			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/cms/bbc/allsalesday.do?CMD=STATISTIC" height="100%" scrolling="auto"></iframe>
			</div>
			</tr>
			</table>
		
			</div>
		</div>
	</body>
</html>
