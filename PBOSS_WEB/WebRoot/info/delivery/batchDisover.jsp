<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
<!-- ͷ�������� -->
<%@ include file="/common/include/inc_deliveryhead.jsp"%>	
<!--��׼���ݿ�ʼ-->
<div class="divspan">
<!-- ��������-->
<%@ include file="/common/include/inc_menu.jsp"%>
<div class="context">
<div class="listmyposition">
	<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
</div>

<s:form action="/delivery/batchDisover.do" method="POST" id="frmQuery" onsubmit="return doSubmit();">
	<input type="hidden" name="parameter.type" id="type" value="1"/>
	<div class="listboxtitle">�����������</div>
    <table class="tb02" width="100%">
	  <tr>
		<td class="input_label">���͵����룺</td>
		<td>
			<textarea id="content" name="parameter.content" rows="10" cols="80">${parameter.content}</textarea>
		</td>
	  </tr>
	  <tr>
		<td>&nbsp;</td>
		<td colspan="4"  align="left">
			<input type="submit" id="submit" value="�� ��" class="btn_blue_75" />&nbsp;&nbsp;
			<input type="button" id="reset" value="�� ��" class="btn_blue_75" onclick="doReset()"/>
		</td>
	  </tr>
	</table>
</s:form>

<div class="column">
<s:actionmessage/>
<div class="listboxtitle">������</div>
<s:if test="%{processResults.size > 0}">
<table class = "tb_comn" width="100%">	
	<thead >
		<tr align="center">
			<td>���͵�����</td>
			<td>��ʾ��Ϣ</td>
		</tr>
	</thead>
	
	<s:iterator value="processResults">
		<tr align="center" onMouseMove="this.bgColor='F0F5F9'" onMouseOut="this.bgColor='#ffffff'">
			<td><s:property value="recid"/></td>
			<td><s:property value="message"/></td>
		</tr>
	</s:iterator>
</table>
</s:if>
</div>
<br>
<!--������Ϣ��ʼ-->
<div class="column">
	<div class="listboxtitle">����˵����</div>
    <div class="reminder">
        <p>1. ͨ���������͵������������������͡�</p>
    </div>
</div>
<div class="column">
   <div class="listboxtitle">��ܰ���ѣ�</div>
   <div class="reminder">
       <p>1.������͵����ð�Ƕ��Ÿ��������磺<font color="red">100234,100211,100333</font></p>
       <p>2.��಻�����볬��<font color="red">500</font>�����͵����롣</p>
   </div>
</div>

</div>
<!--��׼���ݽ���-->
<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript">
function doSubmit(){
	var content = $.trim($('#content').val());
	if(content=='' || content==null){
		return false;
	}
	var ids = content.split(',');
	if(ids.length>500){
		alert("������࣬���ܳ���500�����");
		return false;
	}
	return true;	
}
function doReset(){
	$("#content").val("");
}
</script>

</html>