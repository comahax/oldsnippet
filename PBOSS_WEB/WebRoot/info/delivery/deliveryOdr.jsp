<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
<jsp:useBean id="constants"  class="com.gmcc.pboss.common.dictionary.ConstantsType" />
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
					<td class="input_label">���͵��ţ�</td>
					<td><input name="parameter.recid" class="text_01" id="recid" /></td>
					<td class="input_label">������ţ�</td>
					<td><input name="parameter.orderid" class="text_01" /></td>
					<td class="input_label">���͵�״̬��</td>
					<td><s:select list="disstate" cssClass="select_3L" name="parameter.disstate" id="disstate"/>&nbsp;&nbsp;
					</td>
					</tr>
				  <tr>
					<td class="input_label">����ʱ��&gt;=��</td>
					<td>
						<s:textfield name="parameter.startDate" id="startDate" cssClass="text_01" >
							<s:param name="value">
								<s:date name="parameter.startDate" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">����ʱ��&lt;=��</td>
					<td>
						<s:textfield name="parameter.endDate" id="endDate" cssClass="text_01" >
							<s:param name="value">
								<s:date name="parameter.endDate" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">�ɷѷ�ʽ��</td>
					<td><s:select list="payType" cssClass="select_3L" name="parameter.paytype" id="disstate" />&nbsp;&nbsp;
					</td>
					</tr>
				  <tr>
					<td class="input_label">�ֹ�˾��</td>
					<td><s:select list="cntyComd" cssClass="select_3L" name="parameter.cntyComd" id="disstate" />&nbsp;&nbsp;
					</td>
					<td colspan="4" align="left">
						<input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
						<input name="btnExport" type="button" id="btnExport" value="����" class="btn_blue_75" />&nbsp;&nbsp;
						<input name="btnRest" type="reset" id="btnQuery" value="����" class="btn_blue_75" />
					</td>
				  </tr>
				</table>
			</div>
			</s:form>
			<div class="listboxlist">
			<div style="width:100%; padding-bottom:5px;" align="right">
			<input name="btnOpenDis" type="button" id="btnOpenDis" value="��������" class="btn_blue_75" style="width:100px;" disabled="disabled" />
			<input name="btnFinishDis" type="button" id="btnFinishDis" value="�������" class="btn_blue_75" style="width:100px;" disabled="disabled" /></div>
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
                 <div class="reminder">
                   ���͵���ѯ�����Զԡ������͡������͵����С��������͡��������ԡ������С������͵����С�������ɡ����� </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                 <div class="reminder">
					 <p>1������ù���ҳ��ʱϵͳĬ�ϲ�ѯʱ��Ϊ��ǰ�¡�</p>
					 <p>2����������͵��š����ߡ�������š��鿴������Դ��ϸ��</p>
					 <p>3����ѡ������͵�״̬ȫ�ǡ������͡�ʱ������ʹ�á��������͡����ܡ�</p>
					 <p>4����ѡ������͵�״̬ȫ�ǡ������С�ʱ������ʹ�á�������ɡ����ܡ�</p>
                  </div>
               </div>
          </div>
		</div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<div style="display:none" id="selDisstate">
��ѡ��Ҫ�޸ĵ�״̬��
<table width="100%" border="0" cellpadding="5" cellspacing="3">
	<tr>
	<td align="left">
		<s:radio list="mdyDisstate" name="parameter.disstate" id="disstate"/>
	</td>
	</tr>
	<tr>
		<td style="padding-top:10px;" align="center">
		<INPUT TYPE="button" VALUE="ȷ��" ONCLICK="doDisstateMdf();" class="btn_blue_75" onmouseover="this.className='btn_blue_75_02';" onmouseout="this.className='btn_blue_75';">&nbsp;&nbsp;
		<INPUT TYPE="button" VALUE="ȡ��" ONCLICK="closeDisstateMdf();" class="btn_blue_75"  onmouseover="this.className='btn_blue_75_02';" onmouseout="this.className='btn_blue_75';">
		</td>
	</tr>
</table>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<iframe name="content" style="display: none;"></iframe>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/delivery/delivery.js"></script>
<SCRIPT type="text/javascript">
function selectCheck() {
	var scheck = $("#selectCheck").attr("checked");
	$("input[name='recids']").each(function(){
		if($(this).attr("disabled") != true){
			$(this).attr("checked", scheck);
		}
	});
}
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
//�����͡�������
var WAITDIS = "${constants.DISSTATE_WAITDIS}",DISING="${constants.DISSTATE_DISING}";
//������ɡ�����
var DISOVER = "${constants.DISSTATE_DISOVER}",CANCEL ="${constants.DISSTATE_CANCEL}";

//ת���ֹ�ָ��var nonShow = ${nonShowDisstate};
var nonShow = [DISOVER,CANCEL];
//-->
</SCRIPT>
</html>