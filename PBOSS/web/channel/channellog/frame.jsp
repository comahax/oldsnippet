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
			<span class="table_toparea_h">����������־��ѯ</span>
		</div>
	</div>

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				    addmenu('<%=contextPath%>/channel/waylog_listag.do','���������Ϣ��־��ѯ'); 
					addmenu('<%=contextPath%>/channel/employeelog_list.do', '���������Ա��־��ѯ');
					addmenu('<%=contextPath%>/channel/employeelog_listmg.do', '����������־��ѯ');
					addmenu('<%=contextPath%>/channel/waylog_listdis.do', '������Ӫ��������־��ѯ');
					addmenu('<%=contextPath%>/channel/waylog_listlogs.do', '��������־��ѯ');
					addmenu('<%=contextPath%>/channel/bchcontlog_list.do', '������ϵ������־��ѯ');
					addmenu('<%=contextPath%>/channel/waycompctlog_list.do', '�����ͬ������־��ѯ');
					addmenu('<%=contextPath%>/channel/wayacctlog_list.do', '�����˻�������־��ѯ');
					addmenu('<%=contextPath%>/channel/wayapplylog_list.do', '����������־��ѯ');
					addmenu('<%=contextPath%>/channel/employeeapplylog_list.do', '��Ա������־��ѯ');
					addmenu('<%=contextPath%>/channel/changelog_list.do', '�����䶯��¼��ѯ');
					
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
