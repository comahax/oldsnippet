<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<jsp:include page="/inc/acl.jsp">
			<jsp:param name="PID" value="3C3C1AAA" />
		</jsp:include>

		<%
			String ID_1 = "CH_AUDITFOREXAMINE";
			
		%>

		
		<link href="<%=contextPath%>/css/css_1/iframemenu.css"
			rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>

		<div class="table_container">
			<div class="table_div">
				<table class="top_table">
					<tr>
						<td>
							<bean:message bundle="itemgraded" key="itemgradedFrame" />
						</td>
					</tr>
				</table>
			</div>

			<div class="table_div">
				<table width="100%" class="error_text">
					<html:errors />
					<s:Msg />
				</table>
			</div>

			<div class="iframemenu">
				<script language="javascript">
				addmenuleft();	
		  		addmenu('<%=contextPath%>/cms/examine/itemgraded.do?CMD=LIST','∆¿∑÷µ«º«');
		  		if("<c:out value='${sysparamvalue}' />"=='1'){
		  		<s:RewardPurChk controlid="<%=ID_1%>">
		 		 addmenu('<%=contextPath%>/cms/examine/exmnaudit.do?CMD=LIST','∆¿∑÷…Û∫À');
		 		 </s:RewardPurChk>
		 
		  		}
		 		 addmenuright();
		  		addmenumore();
		</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN"
					id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/cms/examine/itemgraded.do?CMD=LIST"
					height="100%"></iframe>
			</div>
		</div>
	</body>
</html>
