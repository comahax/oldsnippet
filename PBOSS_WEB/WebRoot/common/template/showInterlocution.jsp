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
    
    <div class="listboxtitle">答复信息：</div>
    <table class = "tb02" width="100%">
		<tr>
			<td class="textRight" width="25%">2009-09-09 12:00:00 </td>
			<td width="15%">xxx回复：</td>
			<td width="60%">请准时参加。谢谢！</td>
		</tr>
		<tr>
			<td class="textRight" width="25%">2009-09-09 12:00:00 </td>
			<td width="15%">xxx回复：</td>
			<td width="60%">请准时参加。谢谢！</td>
		</tr>
	</table>
    
    <table width="96%">
		<tr valign=middle>
			<td align=left height=30>&nbsp;&nbsp;</td>
			<td align=right style="font-size:12px;">
			总计<font color="red">1</font>页&nbsp;
			当前第<font color="red">1</font>页
			<a href="javascript:void(0)" style="text-decoration:none" >
			<img border="0" src="/images/frist.gif" alt="第一页" />
			</a> 
			<a href="javascript:void(0)" style="text-decoration:none" >
			<img border="0"  src="/images/pre.gif" alt="前一页" />
			</a>
			
			<a href="javascript:void(0)" style="text-decoration:none" >
			<img border="0"  src="/images/next.gif" alt="下一页" />
			</a>
			<a href="javascript:void(0)" style="text-decoration:none" >
			<img border="0"  src="/images/last.gif" alt="最后一页" />
			</a>
			&nbsp; 跳转至
			<input name="param.goto_page" type="text" size="2" ID="goto_page" value="1">
			页<a href="#"><img src="/images/go.gif" alt="跳转至" width="16" height="14" border="0"></a>
			</td>
		</tr>
	</table>
	
	<div class="listboxtitle">${_PBOSS_WEB_USER.employeename}：</div>
    <table class = "tb02" width="100%">
		<tr>
			<td class="textRight" width="15%">输入：</td>
			<td width="85%">
			<textarea name="textarea" class="textarea_01" id="textarea"></textarea>
			<font color="#FF0000">*</font>
			</td>
		</tr>
	</table>
				
	<div style="text-align:right">
	<input type="button" class="btn_blue_75" value="提 交" onClick="window.parent.closePage();"> &nbsp;
	<input type="button" class="btn_blue_75" value="关闭提问" onClick="window.parent.closePage();"> &nbsp;
	<input type="button" class="btn_blue_75" value="返 回" onClick="window.parent.closePage();"> &nbsp;
	 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	</div>
</div>
</body>
<!-- 公共JS文件 -->
<%@ include file="/common/meta_js.jsp"%>
</html>