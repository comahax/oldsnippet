<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
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
			<IMG SRC="/images/img/messages.jpg" ALT="��Ϣ��ʾ">
		</div>
		<div class="context">
			<div class="listboxtitle">��Ϣ��ʾ</div>
			<div class="messageshow">
				<ul>
					<li>��Ҫ���ص��ļ������ڣ�</li>
				</ul>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn_blue_75"  onmouseover="shover(this,'btn_blue_75_02')" onMouseOut="shover(this,'btn_blue_75')" onClick="javascript:window.history.back();">����</button>
			</div>
			<div class="messageshowbutton"></div>
		</div>
	</div>
</body>
<%@include file="/common/meta_js.jsp"%>
</html>