<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "CH_PW_MENDREGISTER_VIEW";
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
				    addmenu('<%=contextPath%>/cms/reward/registersimvw.do?CMD=SHOW','�׿��Ǽ���ϸ��ѯ');
				    addmenu('<%=contextPath%>/cms/reward/registersimcnt.do?CMD=SHOW','�׿��Ǽǻ���');
				    addmenu('<%=contextPath%>/cms/regnewwayemp.do?CMD=SHOW','��ҵ��Ǽ���ϸ��ѯ');
				    addmenu('<%=contextPath%>/cms/regnewwayemptotal.do?CMD=SHOW','��ҵ��Ǽǻ���');
				    <s:PurChk2 controlid="<%=ID_1%>">
				    addmenu('<%=contextPath%>/cms/mendregister.do?CMD=SHOW','�׿����۲��Ǽ�');
				    </s:PurChk2>
					addmenuright();
				  addmenumore();
				</script>
			</div>

		 <div class="table_div">
        <table class="table_style">
            <tr class="table_style_head">
       		
			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/cms/reward/registersimvw.do?CMD=SHOW" height="100%" scrolling="auto"></iframe>
			</div>
			</tr>
			</table>
		
			</div>
		</div>
	</body>
</html>
