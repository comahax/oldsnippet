<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="/js/common.js" ></script>
<style>
.div {
	width:100%;
	margin:0 auto 0 auto;
}
</style>
</head>
<body>
	<div class="div">
		<div class="menu">
			<IMG SRC="/images/img/messages.jpg" ALT="信息提示">
		</div>
		<div class="context">
			<div class="listboxtitle">信息提示</div>
			<div class="messageshow">
				<ul>
					<li>需要下载的文件不存在！</li>
				</ul>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn_blue_75"  onmouseover="shover(this,'btn_blue_75_02')" onMouseOut="shover(this,'btn_blue_75')" onClick="javascript:window.history.back();">返回</button>
			</div>
			<div class="messageshowbutton"></div>
		</div>
	</div>
</body>
<%@include file="/common/meta_js.jsp"%>
</html>