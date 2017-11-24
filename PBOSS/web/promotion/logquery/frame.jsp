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
			<span class="table_toparea_h">促销日志查询</span>
		</div>
	</div>

			<div class="iframemenu">
				<script language="javascript">
				  addmenuleft();	
				  	addmenu('<%=contextPath%>/promotion/elmttmpllog_list.do','元素模版日志查询'); 
				  	addmenu('<%=contextPath%>/promotion/elmtinstlog_list.do','元素实例日志查询');
				    addmenu('<%=contextPath%>/promotion/spproposallog_list.do','促销方案日志查询'); 
					addmenu('<%=contextPath%>/promotion/ppzlnrulelog_list.do', '方案与规则日志查询');
					addmenu('<%=contextPath%>/promotion/rulelog_list.do', '规则日志查询');
					addmenu('<%=contextPath%>/promotion/ruleitemlog_list.do', '规则明细日志查询');
					addmenu('<%=contextPath%>/promotion/pquantitylog_list.do', '订货量日志查询');
					addmenu('<%=contextPath%>/promotion/presentingalog_list.do', '赠送(售后)日志查询');
					addmenu('<%=contextPath%>/promotion/presentingblog_list.do', '赠送(售前)日志查询');
					addmenu('<%=contextPath%>/promotion/rewardstdlog_list.do', '酬金标准日志查询');
					addmenu('<%=contextPath%>/promotion/tieinsalelog_list.do', '搭售日志查询');
					addmenu('<%=contextPath%>/promotion/ppzlnptnrlog_list.do', '方案与渠道日志查询');
					addmenu('<%=contextPath%>/promotion/ppzlncomlog_list.do', '方案与商品种类日志查询');
					addmenu('<%=contextPath%>/promotion/ppzlnreslog_list.do', '方案与资源日志查询');
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
