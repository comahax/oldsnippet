<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
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
			
			<s:form action="ajaxQuery" method="POST" id="frmQuery">
			<div class="listboxtitle">��ѯ����</div>
            <table class="tb02" width="100%">
			  <tr>
				<td class="input_label">������ţ�</td>
				<td><input name="parameter.orderid" class="text_01" /></td>
				<td class="input_label">��ѯʱ�䣺</td>
				<td><select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select></td>
				<td class="input_label">����״̬��</td>
				<td><s:select list="orderstate" cssClass="select_2L" name="parameter.orderstate" id="orderstate"/></td>
				</tr>
			  <tr>
				<td valign="top" class="input_label">&nbsp;</td>
				<td colspan="5" align="left"><input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;<input name="btnRest" type="reset" id="btnQuery" value="����" class="btn_blue_75" /></td>
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
            <!--������Ϣ��ʼ-->
            <div class="column">
                 <div class="listboxtitle">����˵����</div>
                 <div class="reminder">
                   ������Ϣ��ѯ�� </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                 <div class="reminder">
					 <p>1������ù���ҳ��ʱϵͳĬ�ϲ�ѯʱ��Ϊ��ǰ�¡�</p>
					 <p>2�����������ţ��鿴������Դ��ϸ��</p>
                  </div>
               </div>
          </div>
		</div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/salesRpt/salesOdr.js"></script>
<SCRIPT type="text/javascript">
//<!--
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
	queryFrom: $("#frmQuery")//��ѯ��
};

document.getElementById("orderstate").setAttribute("list","#{'FINISHED':'�����'}");
//-->
</SCRIPT>
</html>