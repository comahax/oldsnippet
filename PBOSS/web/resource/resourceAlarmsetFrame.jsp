<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
String paramvalue = (String) request.getAttribute("paramvalue");
%>
<html>
	<head>
		<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet"
			type="text/css" media="all" />
	</head>
	<body>
		<div class="table_container">
			<%
			if ("1".equals(paramvalue)) {
			%>

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/resource/stkalarmct_toList.do','�ֹ�˾���Ԥ��'); 
					addmenuright();
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN"
					id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/resource/stkalarmct_toList.do" height="100%"
					scrolling="auto"></iframe>
			</div>
			<%
			} else {
			%>
			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/resource/resalarmrule_list.do','Ԥ����������'); 
				    addmenu('<%=contextPath%>/resource/resalarminfo_list.do','Ԥ����Ϣ��ѯ');				   
					addmenuright();+
				  addmenumore();
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN"
					id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/resource/resalarmrule_list.do" height="100%"
					scrolling="auto"></iframe>
			</div>
			<%
			}
			%>
		</div>
	</body>
</html>
