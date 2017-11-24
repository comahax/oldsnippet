<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="/inc/head.inc" %>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>页面标题</title>

<script type="text/javascript" src="<%=basePath%>up/common/js/lib/sunrise/component/all.js"></script>
<script type="text/javascript" src="<%=basePath%>up/common/js/lib/sunrise/component/zhcodeUtil.js"></script>
</head>
	
<body>
<s:form name="formList" id="formList" theme="simple"  action="/account/accountga_doSearchGroupInfo.do?flag=1">
	
<div class="widgetL">
<div class="wCenter"> 
<div class="content">
	<div class="mt20"></div> 
		内容的大小是固定的，加上固定高度的设置： <font color=green>style="height:250px;"</font>
	<div class="mt10"></div>
	<div class="con" id="tags1">
		<ul class="tags">
			<li class="selectTag"><a onclick="autoTabsHeight(this,'tags1')" href="javascript:void(0)">Tab标签1</a></li>
			<li><a onclick="autoTabsHeight(this,'tags1')" href="javascript:void(0)">Tab标签2</a></li>
			<!--这里的onclick="autoTabsHeight(this,'tags2','ifrm3')"，'ifrm6'对应内容的iframe。-->
			<li><a onclick="autoTabsHeight(this,'tags1','ifrm3')" href="javascript:void(0)">Tab标签3</a></li>
		</ul>
		<div id="tagContent" style="height:250px;">
			<div class="tagContent selectTag">
				<div class="tab_t">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th>行一列一：</th>
							<td>111111111111</td>
							<th>行一列二：</th>
							<td>一一一一一一</td>
						</tr>
						<tr>
							<th>行二列一：</th>
							<td>88888.008</td>
							<th>行二列二：</th>
							<td>88888.008</td>
						</tr>
						<tr>
							<th>行三列一：</th>
							<td>88888.008</td>
							<th>行三列二：</th>
							<td>88888.008</td>
						</tr>
						<tr>
							<th>行四列一：</th>
							<td>88888.008</td>
							<th>行四列二：</th>
							<td>88888.008</td>
						</tr>
						<tr>
							<th>行五列一：</th>
							<td>88888.008</td>
							<th>行五列二：</th>
							<td>88888.008</td>
						</tr>
						<tr>
							<th>行六列一：</th>
							<td>88888.008</td>
							<th>行六列二：</th>
							<td>88888.008</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="tagContent">
			<div style=" width: 100%;height:230px;">
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第二个页面的内容。</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第二个页面的内容。</p>
			</div>
			</div>
			<div class="tagContent">
				<iframe id="ifrm3" onload="resetAllWinHeight(this);" src='<%=basePath%>demo/component/tabPage.jsp?pp=999'
				    scrolling="no" width="100%" frameborder="0" height="230"></iframe>
			</div>
		</div>
	</div>






	<div class="mt20"></div>
	内容的大小是根据内容动态改变的。
	<div class="mt10"></div>
	<div class="con" id="tags2">
		<ul class="tags">
			<li class="selectTag"><a onclick="autoTabsHeight(this,'tags2')" href="javascript:void(0)">Tab标签1</a></li>
			<li><a onclick="autoTabsHeight(this,'tags2');" href="javascript:void(0)">Tab标签2</a></li>
			<!--这里的onclick="autoTabsHeight(this,'tags2','ifrm6')"，'ifrm6'对应内容的iframe。-->
			<li><a onclick="autoTabsHeight(this,'tags2','ifrm6')" href="javascript:void(0)">Tab标签3</a></li>
		</ul>
		<div id="tagContent">
			<div class="tagContent selectTag">
				<div class="tab_t">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th>行一列一：</th>
							<td>111111111111</td>
							<th>行一列二：</th>
							<td>一一一一一一</td>
						</tr>
						<tr>
							<th>行二列一：</th>
							<td>88888.008</td>
							<th>行二列二：</th>
							<td>88888.008</td>
						</tr>
						<tr>
							<th>行三列一：</th>
							<td>88888.008</td>
							<th>行三列二：</th>
							<td>88888.008</td>
						</tr>
						<tr>
							<th>行四列一：</th>
							<td>88888.008</td>
							<th>行四列二：</th>
							<td>88888.008</td>
						</tr>
						<tr>
							<th>行五列一：</th>
							<td>88888.008</td>
							<th>行五列二：</th>
							<td>88888.008</td>
						</tr>
						<tr>
							<th>行六列一：</th>
							<td>88888.008</td>
							<th>行六列二：</th>
							<td>88888.008</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="tagContent" style="height:10px;">
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第二个页面的内容。</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第二个页面的内容3。</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第二个页面的内容。</p>
				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;第二个页面的内容3。</p>
			</div>
			<div class="tagContent" style="height:10px;">
				<iframe id="ifrm6" onload="resetAllWinHeight(this);" src='<%=basePath%>demo/component/tabPage.jsp'
				    scrolling="no" width="100%" frameborder="0"></iframe>
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

var tags = $su("tags1"),
	tabConfig = 
	{
		contentClass : "tagContent",
		contentSelectedClass : "selectTag",
		tabSelectedClass : "selectTag"
	};

tags.component("sunrise.ui.tab", tabConfig);


var tags = $su("tags2"),
	tabConfig = 
	{
		contentClass : "tagContent",
		contentSelectedClass : "selectTag",
		tabSelectedClass : "selectTag"
	};

tags.component("sunrise.ui.tab", tabConfig);
/**/
</script>
