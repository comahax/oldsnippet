<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
	<title>����ѡ��</title>
	<!-- ������̬�ļ� -->
	<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<div class="divspan">
			<s:form action="wayAjax.do" method="POST" id="frmQuery">
			<div class="listboxtitle">��ѯ����</div>
			<input type="hidden" name="popup" value="${true}" id="popup"/>
			<table class="tb02" width="100%">
 <tr>
 	<td class="input_label">�������룺</td>
 	<td>
	<input name="wayid" id="wayid" class="text_01" onFocus="shover(this,'text_01_02')" onBlur="shover(this,'text_01')" 
				   value="${wayid}" size="22"  maxlength="22" />
	</td>
	<td class="input_label">�������ƣ�</td>
	<td>
	<input name="wayname" id="wayname" class="text_01" onFocus="shover(this,'text_01_02')" onBlur="shover(this,'text_01')" 
				   value="${wayname}" size="22"  maxlength="22" />
	</td>
</tr>
<tr>
	<td valign="top" class="input_label">&nbsp;</td>
	<td colspan="5" align="left">
		<input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" onMouseOver="shover(this,'btn_blue_75_02')" onMouseOut="shover(this,'btn_blue_75')"/>
		<input name="btnRest" type="reset" id="btnQuery" value="����" class="btn_blue_75" />
	</td>
</tr>
			</table>
			</s:form>
			<div class="listboxlist">
			<div class="listboxtitle">��ѯ���</div>
			<span id="showTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="navigation"></td>
				</tr>
			</table>
            <br>
          </div>
          <div class="column">
                 <div class="listboxtitle">����˵����</div>
                 <div class="reminder">
                  	 ���Ը��������������������ģ����ѯ�� </div>
          </div>
	</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/salesDetail/wayselect.js"></script>
<SCRIPT type="text/javascript">
//<!--
// ��ѯ��ʾ����Ϣ
var showCols = ${ShowColsPopup};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
//�����������
var optin = {
	showCols:showCols,//��ʾ��
	fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:10,//ҳ�ڴ�С
	navigation:$("#navigation"),//��ҳλ�� jq����
	unableBtu:$('#btnQuery'),
	width:"100%",
	queryFrom: $("#frmQuery")//��ѯ��
};
//-->
</SCRIPT>
</html>