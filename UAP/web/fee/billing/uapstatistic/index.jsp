<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/inc/head.inc" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>统计分析页面</title>

<script type="text/javascript" src="<%=basePath%>up/common/js/lib/sunrise/component/all.js"></script>
<script type="text/javascript" src="<%=basePath%>up/common/js/lib/sunrise/component/zhcodeUtil.js"></script>

</head>
	
<body>
<s:form name="formList" id="formList" theme="simple"  action="#">
<div class="widgetL">
<div class="wCenter"> 
<div class="content">
	<div class="con" id="tags2">
		<ul class="tags">
			<li class="selectTag"><a href="javascript:void(0)">统计结果界面</a></li>
			<li><a href="javascript:void(0)">分析结果界面</a></li>
		</ul>
		<div id="tagContent">
			<div class="tagContent selectTag" style="height: 100%">
				<div class="tab_t">
					<iframe id="ifrmals" src="<%=basePath%>fee/billing/uapstatistic_list.do?logid=<%=request.getParameter("logid") %>&req_type=<%=request.getParameter("req_type") %>"
				    scrolling="no" width="100%" frameborder="0" height="600"></iframe>
				</div>
			</div>
			
			<div class="tagContent" style="height: 100%">
				<iframe id="ifrmstc" src="<%=basePath%>fee/billing/uapanalyse_list.do?logid=<%=request.getParameter("logid") %>&req_type=<%=request.getParameter("req_type") %>"
				    scrolling="no" width="100%" frameborder="0" height="600"></iframe>
			</div>
		</div>
	</div>

</div>
</div>
</div>
</s:form>
</body>
</html>
<script type="text/javascript">
/*
var tags = $su("tags1"),
	tabConfig = 
	{
		contentClass : "tagContent",
		contentSelectedClass : "selectTag",
		tabSelectedClass : "selectTag"
	};

tags.component("sunrise.ui.tab", tabConfig);
*/

var tags = $su("tags2"),
	tabConfig = 
	{
		contentClass : "tagContent",
		contentSelectedClass : "selectTag",
		tabSelectedClass : "selectTag"
	};

tags.component("sunrise.ui.tab", tabConfig);
</script>
