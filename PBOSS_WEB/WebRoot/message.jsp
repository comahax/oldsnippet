<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- ͷ�������� -->
	<%@ include file="/common/include/inc_head.jsp"%>
	<div class="divspan">
		<!--��׼���ݿ�ʼ-->		
		<div class="menu">
			<IMG SRC="/images/img/messages.jpg" ALT="��Ϣ��ʾ">
		</div>
		<div class="context">
			<div class="listboxtitle">��Ϣ��ʾ</div>
			<div class="messageshow">
				<ul>
					<li>${message}</li>
				</ul>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn_blue_75"  onmouseover="shover(this,'btn_blue_75_02')" onMouseOut="shover(this,'btn_blue_75')" onClick="f_jumpToURL('<%=request.getAttribute(HttpDictionary.BACK_URL) %>');">����</button>
					
			</div>
			<div class="messageshowbutton">
			
			</div>
		</div>
			<!--��׼���ݽ���-->
	</div>
	<%@ include file="/common/include/inc_foot.jsp"%>
</body>
<%@include file="/common/meta_js.jsp"%>
</html>