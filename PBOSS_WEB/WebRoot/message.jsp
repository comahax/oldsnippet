<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- 头部导航条 -->
	<%@ include file="/common/include/inc_head.jsp"%>
	<div class="divspan">
		<!--标准内容开始-->		
		<div class="menu">
			<IMG SRC="/images/img/messages.jpg" ALT="信息提示">
		</div>
		<div class="context">
			<div class="listboxtitle">信息提示</div>
			<div class="messageshow">
				<ul>
					<li>${message}</li>
				</ul>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="button" class="btn_blue_75"  onmouseover="shover(this,'btn_blue_75_02')" onMouseOut="shover(this,'btn_blue_75')" onClick="f_jumpToURL('<%=request.getAttribute(HttpDictionary.BACK_URL) %>');">返回</button>
					
			</div>
			<div class="messageshowbutton">
			
			</div>
		</div>
			<!--标准内容结束-->
	</div>
	<%@ include file="/common/include/inc_foot.jsp"%>
</body>
<%@include file="/common/meta_js.jsp"%>
</html>