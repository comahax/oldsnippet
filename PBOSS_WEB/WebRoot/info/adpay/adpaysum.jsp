<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
<form action="ajaxModify.do" method="POST" id="frmModify">
<INPUT TYPE="hidden" NAME="parameter.recids" value="">
<INPUT TYPE="hidden" NAME="parameter.disstate" value="">
</form>
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
		<div class="listboxtitle">��ѯ����</div>
			<s:form action="ajaxQuery" method="POST" id="frmQuery">
				<div class="listboxform">
					<table border="0" width="100%">
					  <tr>
							<td class="input_label">���ܵ��ţ�</td>
							<td><input name="parameter.sumid" id="sumid" class="text_01" /></td>
							<td class="input_label">״̬��</td>
							<td>
								<s:select list="sumstate" cssClass="select_2L" name="parameter.state" />
							</td>
					  </tr>
					  <tr>
							<td class="input_label">����ʱ�䣺</td>
							<td colspan="3">
								<s:textfield name="parameter.createTimeFrom" id="createTimeFrom" cssClass="text_01" >
									<s:param name="value">
										<s:date name="parameter.createTimeFrom" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>��
								<s:textfield name="parameter.createTimeTo" cssClass="text_01" id="createTimeTo" >
									<s:param name="value">
										<s:date name="parameter.createTimeTo" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>
							</td>
						</tr>
					  <tr>
							<td valign="top" class="input_label">&nbsp;</td>
							<td colspan="3" align="left">
								<input type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
								<input type="button" id="btnExport" value="����" class="btn_blue_75" />&nbsp;&nbsp;
								<input type="reset" id="btnReset" value="����" class="btn_blue_75" />
							</td>
					  </tr>
					</table>
				</div>
			</s:form>
		<div class="listboxlist">
			<div style="width:100%; padding-bottom:5px;" align="right">
				
			</div>
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
        <div class="reminder">���ʻ��ܵ���ѯ�����Զԡ����ύ���ĵ��ʵ�Ԫ����С��ύ�������� </div>
      </div>
			<div class="column">
      	<div class="listboxtitle">��ܰ���ѣ�</div>
        <div class="reminder">
					 <p>1������ù���ҳ��ʱϵͳĬ�ϲ�ѯʱ��Ϊ��ǰ�¡�</p>
					 <p>2����������ܵ��š����ߡ��鿴���顱��Ť�����Դ򿪶�����Դ��ϸҳ�档</p>
					 <p>3�����ܵ�״̬Ϊ�����ύ��ʱ������ͨ�����ύ����ť�����ύ������</p>
					 <p>3�����ܵ�״̬Ϊ����ȷ�ϡ�ʱ������ͨ����֧������ť����֧��������</p>
        </div>
      </div>
    </div>
	</div>
<!--��׼���ݽ���-->
<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/adpay/adpaysum.js"></script>
<SCRIPT type="text/javascript">
<!--
// ��ѯ��ʾ����Ϣ
var showCols = ${ShowCols};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
//�����������
var optin = {
	showCols:showCols,//��ʾ��
	fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:10,//ҳ�ڴ�С
	navigation:$("#navigation"),//��ҳλ�� jq����
	unableBtu:$('#btnQuery'),
	width:"100%",
	succeesFn:successFncn,
	queryFrom: $("#frmQuery")//��ѯ��
};
//-->
</SCRIPT>
</html>