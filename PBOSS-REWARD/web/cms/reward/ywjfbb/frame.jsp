<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
   String ID_1 = "CJJGDC_ZS_SELECT";
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
				  <s:PurChk2 controlid="<%=ID_1%>">
				    addmenu('<%=contextPath%>/cms/reward/ywjfbb/list.jsp','ҵ����ֱ���');
				  	addmenu('<%=contextPath%>/cms/reward/xjjlywjfmx/list.jsp','ҵ����ֽ�����ϸ��');
				  </s:PurChk2>
				    addmenu('<%=contextPath%>/cms/reward/ywjfjlmxb.do?CMD=SHOW','�Ǽ�����ҵ�������ϸ');
					addmenuright();
				  addmenumore();
				</script>
			</div>

		 <div class="table_div">
        <table class="table_style">
            <tr class="table_style_head">
       		
			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/cms/reward/ywjfbb/list.jsp" height="100%" scrolling="auto"></iframe>
			</div>
			</tr>
			</table>
		
			</div>
		</div>
	</body>
</html>
