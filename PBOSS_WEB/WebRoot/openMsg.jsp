<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<!-- ������̬�ļ� -->
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
<!--��׼���ݿ�ʼ-->
<div style="100%">
	<div style="width:20%;float:left;">
		<IMG SRC="/images/img/messages.jpg" ALT="��Ϣ��ʾ">
	</div>
	<div >
		<div class="listboxtitle">��Ϣ��ʾ</div>
		<div class="messageshow">
			<ul>
				<li>${message}</li>
			</ul>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn_blue_75"  onmouseover="shover(this,'btn_blue_75_02')" onMouseOut="shover(this,'btn_blue_75')" onClick="window.parent.closePage();">�� ��</button>
				
		</div>
	</div>
</div>
<!--��׼���ݽ���-->
</body>
</html>