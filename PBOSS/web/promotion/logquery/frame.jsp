<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<html>
	<head>
		<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body onload="loadforiframe();">

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
			<span class="table_toparea_h">������־��ѯ</span>
		</div>
	</div>

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				  	addmenu('<%=contextPath%>/promotion/elmttmpllog_list.do','Ԫ��ģ����־��ѯ'); 
				  	addmenu('<%=contextPath%>/promotion/elmtinstlog_list.do','Ԫ��ʵ����־��ѯ');
				    addmenu('<%=contextPath%>/promotion/spproposallog_list.do','����������־��ѯ'); 
					addmenu('<%=contextPath%>/promotion/ppzlnrulelog_list.do', '�����������־��ѯ');
					addmenu('<%=contextPath%>/promotion/rulelog_list.do', '������־��ѯ');
					addmenu('<%=contextPath%>/promotion/ruleitemlog_list.do', '������ϸ��־��ѯ');
					addmenu('<%=contextPath%>/promotion/pquantitylog_list.do', '��������־��ѯ');
					addmenu('<%=contextPath%>/promotion/presentingalog_list.do', '����(�ۺ�)��־��ѯ');
					addmenu('<%=contextPath%>/promotion/presentingblog_list.do', '����(��ǰ)��־��ѯ');
					addmenu('<%=contextPath%>/promotion/rewardstdlog_list.do', '����׼��־��ѯ');
					addmenu('<%=contextPath%>/promotion/tieinsalelog_list.do', '������־��ѯ');
					addmenu('<%=contextPath%>/promotion/ppzlnptnrlog_list.do', '������������־��ѯ');
					addmenu('<%=contextPath%>/promotion/ppzlncomlog_list.do', '��������Ʒ������־��ѯ');
					addmenu('<%=contextPath%>/promotion/ppzlnreslog_list.do', '��������Դ��־��ѯ');
					addmenuright();
				  addmenumore();
				</script>
			</div>

		 <div class="table_div">
        <table class="table_style">
            <tr class="table_style_head">
       		
			<div class="iframewindow" id="message">
				<iframe framespacing="10" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="<%=contextPath%>/promotion/elmttmpllog_list.do" height="100%" scrolling="auto"></iframe>
			</div>
			</tr>
			</table>
		
			</div>
		</div>
	</body>
</html>
