<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">���۷������Ĳ�ѯ</span>
			</div>
			
			<s:form action="ajaxQuery" method="POST" id="frmQuery">
			<div class="listboxtitle">��ѯ����</div>
			<input type="hidden" name="parameter.countyid" id="countyid" value="${parameter.countyid}">
            <table class="tb02" width="74%">
			  <tr>
			    <td class="input_label">���۷������ı��룺</td>
			    <td><input name="parameter.svccode" class="select_3L" id="svccode" orgval="${parameter.svccode}" size="11"  maxlength="30"/></td>
			    <td class="input_label">���۷����������ƣ�</td>
			    <td><input name="parameter.svcname" id="svcname" class="text_01" value="${parameter.svcname}" size="30"  maxlength="30" /></td>
			    </tr>
			  <tr>
			    <td valign="top" class="input_label">&nbsp;</td>
			    <td colspan="3" align="left"><input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" disabled="disabled" /></td>
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
                   ���۷������Ĳ�ѯ�� </div>
               </div>
          </div>
		</div>
    </div>
<!--/div-->
</body>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/servcent/servcent.js"></script>
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
	width:"74%",
	queryFrom: $("#frmQuery")//��ѯ��
};
var jaacOPERATION = "${jqac.OPERATION}";
//-->
</SCRIPT>
</html>