<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
<%@ include file="/common/meta_js.jsp"%>
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
<!--标准内容开始-->
<div style="100%">
	<div style="width:20%;float:left;">
		<IMG SRC="/images/img/messages.jpg" ALT="信息提示">
	</div>
	<div >
		<div class="listboxtitle">信息提示</div>
		<div class="messageshow">
			<ul>
				<li>${message}</li>
			</ul>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn_blue_75"  onmouseover="shover(this,'btn_blue_75_02')" onMouseOut="shover(this,'btn_blue_75')" onClick="window.parent.closePage();">关 闭</button>
				
		</div>
	</div>
</div>
<!--标准内容结束-->
</body>
</html>