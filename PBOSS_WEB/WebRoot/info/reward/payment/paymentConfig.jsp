<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<title>���һ�廯����</title>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_gdhead.jsp"%>
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
		<!-- ��������-->
		<%@ include file="/common/include/inc_citymenu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
           
			<form action="/gdView/paymentConfigAjax.do" method="POST" id="frmQuery"> 
			  <table class="tb02" width="100%">
			  <tr>
				<td class="input_label" align="right">������˿��أ�</td>
				<td>
				   <select id="chkswitch" name="chkswitch">
                       <option VALUE="open" selected="selected">����</option>
                       <option VALUE="close">�ر�</option>
                   </select>
				</td>
			  </tr>
			  <tr>
				<td valign="top" class="input_label">&nbsp;</td>
				<td colspan="2" align="left">
				    <input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" />&nbsp;&nbsp;
				    <input name="btnSave" type="button" id="btnSave" value="����" class="btn_blue_75" />
				</td>
			  </tr>
			</table>
			</form>
			
            <!--������Ϣ��ʼ-->
            <div class="listboxlist">
			    <div class="listboxtitle">��ѯ���</div>
			    <span id="showTbl"></span>
			    <table class="page_table">
				    <tr valign="middle">
					    <td align="left" height="30">&nbsp;&nbsp;</td>
					    <td align="right" style="font-size:12px;" id="navigation"></td>
				    </tr>
			    </table>
			</div>    
            <!--������Ϣ����-->

	    </div>
	
	<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/payment/paymentConfig.js"></script> 
<SCRIPT type="text/javascript">
<!--
// ��ѯ��ʾ����Ϣ
var showCols = ${ShowCols};//ȡ��̨�����������飬��Ӧ����  key,value,explain
//�����������
var optin = {
	showCols:showCols,//��ʾ��
	fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:10,//ҳ�ڴ�С
	navigation:$("#navigation"),//��ҳλ�� jq����
	unableBtu:$("#btnQuery"),
	width:"100%",
	queryFrom: $("#frmQuery")//��ѯ��
};
var jaacOPERATION = "${jqac.OPERATION}";
//-->
</SCRIPT> 

</html>