<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ����CSS�ļ� -->
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
	<!-- ͷ�������� -->
<div style="width:100%;text-align:left;">
	
	<div class="listboxtitle">��Ϣ���ݣ�</div>			
	<table class = "tb02" width="100%">
		<tr>
			<td class="textRight" width="15%">��Ϣ���⣺</td>
			<td width="85%">��ñ���</td>
		</tr>
		<tr>
			<td class="textRight" width="15%">����ʱ�䣺</td>
			<td width="85%">2009-09-09</td>
		</tr>
		<tr>
			<td class="textRight" width="15%">��Ϣ���ݣ�</td>
			<td width="85%" >
				<textarea name="textarea" class="textarea_01" id="textarea">���ǃ���</textarea>
			</td>
		</tr>
	</table>
    
    <div class="listboxtitle">������Ϣ��</div>
    <table class = "tb02" width="100%">
		<tr>
			<td class="textRight" width="15%">����1��</td>
			<td width="85%">ѡ�Ź����뷽��1.doc</td>
		</tr>
		<tr>
			<td class="textRight" width="15%">����2��</td>
			<td width="85%">ѡ�Ź����뷽��2.doc</td>
		</tr>
		<tr>
			<td class="textRight" width="15%">����3��</td>
			<td width="85%">ѡ�Ź����뷽��3.doc</td>
		</tr>
	</table>
    
				
	<div style="text-align:right">
	<input type="button" class="btn_blue_75" value="�� ��" onClick="window.parent.closePage();"> &nbsp;
	 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	</div>
</div>
</body>
<!-- ����JS�ļ� -->
<%@ include file="/common/meta_js.jsp"%>
</html>