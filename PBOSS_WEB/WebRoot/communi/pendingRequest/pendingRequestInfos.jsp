<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@page import="com.gmcc.pboss.biz.communi.CPDictionary"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
<!-- ͷ�� -->
<%@ include file="/common/include/inc_head.jsp"%>	
<!--��׼���ݿ�ʼ-->
<div class="divspan">
<!-- ��������-->
<%@ include file="/common/include/inc_menu.jsp"%>
<div class="context">
<div class="listmyposition">
	<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
</div>

<s:form action="queryInfos" method="POST" id="frmQuery">
	<div class="listboxtitle">��ѯ����</div>
	<table class="tb02" width="100%" >
	<tr>
	  <td class="input_label" >����ʱ�䣺</td>
	  <td>
	  	<input name="parameter.startDate" id="selStartDate" class="text_01" style="width:80px;"
	  	value="${parameter.startDate }" /></td>
	  <td class="input_label">����</td>
	  <td>
	  	<input name="parameter.accountDate" id="selAccountDate" class="text_01" style="width:80px;"
	  	value="${parameter.accountDate }" /></td>
	  <td>
		<input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
	  	<input name="btnRest" type="reset" id="btnReset" value="����" class="btn_blue_75" />
	  </td>
	</tr>

<input type="hidden" name="parameter.type" value="<%=CPDictionary.PENDING_REQUEST %>" />

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
    <!--������Ϣ��ʼ-->
    <div class="column">
		<div class="listboxtitle">����˵����</div>
        <div class="reminder"></div>
	</div>
    <div class="column">
    	<div class="listboxtitle">��ܰ���ѣ�</div>
        <div class="reminder"></div>
    </div>
</div>
</div>
</div>
<!--��׼���ݽ���-->
<%@ include file="/common/include/inc_foot.jsp"%>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/communi/pendingRequest/pendingRequestInfos.js"></script>
<SCRIPT type="text/javascript">
<!--
// ��ѯ��ʾ����Ϣ
var showCols = ${pendingRequestColsString};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
//�����������
var optin = {
	showCols:showCols,//��ʾ��
	fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:4,//ҳ�ڴ�С
	navigation:$("#navigation"),//��ҳλ�� jq����
	unableBtu:$('#btnQuery'),
	width:"100%",
	queryFrom: $("#frmQuery")//��ѯ��
};
var jaacOPERATION = "${jqac.OPERATION}";
//-->
</SCRIPT>
</html>