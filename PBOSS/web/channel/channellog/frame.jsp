<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body onload="loadforiframe();">

		<%
			String pk = request.getParameter("pk");
		 %>
		<div class="table_container">
			<div class="table_top">
		<div class="table_topleft"></div>
		<div class="table_toparea_w">
			<s:i18n name="public">
			<span class="table_toparea"><s:text name="currentPos"/> </span>
			<span class="table_toparea_xi">></span>
			<span class="table_toparea"><s:text name="channel"/> </span>
			<span class="table_toparea_xi">></span>
			</s:i18n>
			<span class="table_toparea_h">渠道资料日志查询</span>
		</div>
	</div>

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/channel/waylog_listag.do','社会网点信息日志查询'); 
					addmenu('<%=contextPath%>/channel/employeelog_list.do', '社会渠道人员日志查询');
					addmenu('<%=contextPath%>/channel/employeelog_listmg.do', '渠道经理日志查询');
					addmenu('<%=contextPath%>/channel/waylog_listdis.do', '连锁经营合作商日志查询');
					addmenu('<%=contextPath%>/channel/waylog_listlogs.do', '配送商日志查询');
					addmenu('<%=contextPath%>/channel/bchcontlog_list.do', '网点联系资料日志查询');
					addmenu('<%=contextPath%>/channel/waycompctlog_list.do', '网点合同资料日志查询');
					addmenu('<%=contextPath%>/channel/wayacctlog_list.do', '网点账户资料日志查询');
					addmenu('<%=contextPath%>/channel/wayapplylog_list.do', '网点审批日志查询');
					addmenu('<%=contextPath%>/channel/employeeapplylog_list.do', '店员审批日志查询');
					addmenu('<%=contextPath%>/channel/changelog_list.do', '渠道变动记录查询');
					
					addmenuright();
				  addmenumore();
				</script>
			</div>

		 <div class="table_div">
        <table class="table_style">
            <tr class="table_style_head">
       		
			<div class="iframewindow" id="message">
				<iframe framespacing="10" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/channel/waylog_listag.do" height="100%" scrolling="auto"></iframe>
			</div>
			</tr>
			</table>
		
			</div>
		</div>
	</body>
</html>
