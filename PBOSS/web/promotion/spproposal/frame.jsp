<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body onload="loadforiframe();">

		<%
			String pk = request.getParameter("pk");
			String isActive = null;
			if (request.getParameter("isActive")==null){
				
				isActive = "";
			}else{
				isActive = request.getParameter("isActive");
			}
		 %>
		<div class="table_container">
			<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="promotion"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">促销方案管理</span>
		</div>
	</div>

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/promotion/spproposal_edit.do?param._pk=<%=pk%>&VIEW=DISABLED','促销方案'); 
					addmenu('<%=contextPath%>/promotion/ppzlnrule_list.do?param._pk=<%=pk%>&isActive=<%=isActive%>', '方案与规则');
					addmenu('<%=contextPath%>/promotion/ppzlnptnr_list.do?param._pk=<%=pk%>&isActive=<%=isActive%>', '方案与渠道');
					addmenu('<%=contextPath%>/promotion/ppzlncom_list.do?param._pk=<%=pk%>&isActive=<%=isActive%>', '方案与商品种类');
					addmenu('<%=contextPath%>/promotion/ppzlnres_list.do?param._pk=<%=pk%>&isActive=<%=isActive%>', '方案与资源');
					addmenuright();
				  addmenumore();
				</script>
			</div>

		 <div class="table_div">
        <table class="table_style">
            <tr class="table_style_head">
       		
			<div class="iframewindow" id="message">
				<iframe framespacing="10" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/promotion/spproposal_edit.do?param._pk=<%=pk%>&VIEW=DISABLED" height="100%" scrolling="auto"></iframe>
			</div>
			</tr>
			</table>
		
			</div>
		</div>
	</body>
</html>
