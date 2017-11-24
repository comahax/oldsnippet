<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共CSS文件 -->
<%@ include file="/common/meta_allcss.jsp"%>

<style type="text/css">
<!--
body {
background-image:none;
padding-left:20px;
}
-->
</style>
</head>
<body>
	<!-- 头部导航条 -->
<div style="width:100%;text-align:left;">
	
	<div class="listboxtitle">信息內容：</div>			
	<table class = "tb02" width="100%">
		<tr>
			<td class="textRight" width="15%">信息标题：</td>
			<td width="85%">你好标题</td>
		</tr>
		<tr>
			<td class="textRight" width="15%">发布时间：</td>
			<td width="85%">2009-09-09</td>
		</tr>
		<tr>
			<td class="textRight" width="15%">信息内容：</td>
			<td width="85%" >
				<textarea name="textarea" class="textarea_01" id="textarea">我是內容</textarea>
			</td>
		</tr>
	</table>
    
    <div class="listboxtitle">附件信息：</div>
    <table class = "tb02" width="100%">
		<tr>
			<td class="textRight" width="15%">附件1：</td>
			<td width="85%">选号规则与方案1.doc</td>
		</tr>
		<tr>
			<td class="textRight" width="15%">附件2：</td>
			<td width="85%">选号规则与方案2.doc</td>
		</tr>
		<tr>
			<td class="textRight" width="15%">附件3：</td>
			<td width="85%">选号规则与方案3.doc</td>
		</tr>
	</table>
    
				
	<div style="text-align:right">
	<input type="button" class="btn_blue_75" value="返 回" onClick="window.parent.closePage();"> &nbsp;
	 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	</div>
</div>
</body>
<!-- 公共JS文件 -->
<%@ include file="/common/meta_js.jsp"%>
</html>