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
<form action="ajaxOrderDtl.do" method="POST" id="frmResdetsQuery">
<input type="hidden" name="sumid" value="${adpaysum.sumid}">
</form>
				<!-- ����������Ϣ Begin-->
                 <div class="listboxtitle">���ʻ��ܵ�������Ϣ</div>
				<table class = "tb02" width="100%">
						<tr>
						  <td class="textRight">���ܵ��ţ�</td>
						  <td>${adpaysum.sumid}</td>
							<td class="textRight">������</td>
					        <td>${adpaysum.orderAmt}</td>
						</tr>
   						<tr>
   							<td class="textRight">�˵���</td>
								<td width="35%" >${adpaysum.cancelAmt}</td>
					      <td width="15%"  class="textRight">Ӧ�ս�</td>
   						   <td >${adpaysum.recAmt}</td>
   						</tr>
   						<tr>
   						  <td class="textRight">�ύʱ�䣺</td>
   						  <td><s:date name="adpaysum.submitTime" format="yyyy-MM-dd HH:mm" /></td>
   						  <td  class="textRight">ȷ���ˣ�</td>
   						  <td >${adpaysum.confirmCode}</td>
						  </tr>
   						<tr>
   						  <td class="textRight">��ʼʱ�䣺</td>
   						  <td><s:date name="adpaysum.beginTime" format="yyyy-MM-dd HH:mm" /></td>
   						  <td class="textRight">����ʱ�䣺</td>
   						  <td><s:date name="adpaysum.endTime" format="yyyy-MM-dd HH:mm" /></td>
				  		</tr>
   						<tr>
   						  <td class="textRight">ȷ��ʱ�䣺</td>
   						  <td><s:date name="adpaysum.confirmTime" format="yyyy-MM-dd HH:mm" /></td>
   						  <td class="textRight">ȷ��״̬��</td>
   						  <td id="stateTd">
   						  	${adpaysum.strState}
   						  	<s:if test="adpaysum.state=='WAITSUBMIT'"><input type="button" 
   						  	class="btn_blue_75" value="�ύ" onclick="f_submitState('${adpaysum.state }',${adpaysum.sumid})"/></s:if>
   						  	<s:if test="adpaysum.state=='CONFIRMED'"><input type="button" 
   						  	class="btn_blue_75" value="֧��" onclick="f_submitState('${adpaysum.state }',${adpaysum.sumid})"/></s:if>
   						  </td>
				  		</tr>
					</table>
			<div class="listboxtitle">������Դ��ϸ��</div>				
			<span id="showResdetsTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="resdetsNavigation"></td>
				</tr>
			</table>
				<!-- ����������Ϣ End-->
        <BR> 
				<div style="text-align:center;">
				<input type="button" class="btn_blue_75" value="�� ��" onClick="window.parent.closePage();"></div>
		</div>
</body>
<!-- ����JS�ļ� -->
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/adpay/adpaydtl.js"></script>
<script type="text/javascript">
// ������Դ��ϸ����Ϣ
var showResdetsCols = ${orderdtlColsString};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
//�����������
var optin = {
	showCols:showResdetsCols,//��ʾ��
	fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:5,//ҳ�ڴ�С
	navigation:$("#resdetsNavigation"),//��ҳλ�� jq����
	width:"100%",
	queryFrom: $("#frmResdetsQuery")//��ѯ��
};
</script>
</html>