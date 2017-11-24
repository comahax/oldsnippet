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
           
			<form action="/gdView/paymentManageAjax.do" method="POST" id="frmQuery"> 
			  <div class="listboxtitle">��ѯ����</div>
			  <input type="hidden" name="_switchflag" value="<s:property value="#request.switchflag" />"/>
			  <table class="tb02" width="100%">
			      <tr>
					<td class="input_label" align="right">���У�</td>
					<td><s:select list="cityMap" name="cityid" id="cityid"/></td>
					<td class="input_label" align="right">ҵ�����ͣ�</td>
					<td><s:select list="optypeMap" name="optype" id="optype"/></td>
				  </tr>
				  <tr>
					<td class="input_label" align="right">�Թ�/��˽��</td>
					<td>
					  <select id="pubpri" name="pubpri">
                         <option VALUE="" selected="selected"></option>
                         <option VALUE="��˽">��˽</option>
                         <option VALUE="�Թ�">�Թ�</option>
                      </select>
					</td>
					<td class="input_label" align="right">��˱�ʶ��</td>
					<td>
					  <select id="checkedflag" name="checkedflag">
					     <option VALUE="" selected="selected"></option>
                         <option VALUE="ischecked">�����</option>
                         <option VALUE="notchecked">δ���</option>
                      </select>
					</td>
				  </tr>
				  
				  <tr>
					<td class="input_label" align="right">�տλ��</td>
					<td>
					  <s:textfield cssClass="style_input" name="payee" id="payee"/>
					  <input type="button" class="" value="..." id="btnPayeeSelect" onclick="f_payeeSelect(this)"/>
					</td>
					<td class="input_label" align="right">�������룺</td>
					<td>
					  <s:textfield cssClass="style_input" name="wayid" id="wayid"/>
					  <input type="button" class="" value="..." id="btnWayidSelect" onclick="f_wayidSelect(this)"/>
					</td>
				  </tr>
				  
				  <tr>
					<td class="input_label" align="right">�����ࣺ</td>
					<td>
					   <s:textfield cssClass="style_input" name="ltype" id="ltype"/>
					  <input type="button" class="" value="..." id="btnLtypeSelect" onclick="f_ltypeSelect(this)"/>
					</td>
					<td class="input_label" align="right">���С�ࣺ</td>
					<td>
					  <s:textfield cssClass="style_input" name="stype" id="stype"/>
					  <input type="button" class="" value="..." id="btnStypeSelect" onclick="f_stypeSelect(this)"/>
					</td>
				  </tr>
				  
				  <tr>
					<td class="input_label" align="right">�����·ݣ�</td>
					<td><select name="paymonth" class="select_3L" id="paymonth" orgval="${rewardmonth}"></select></td>
					<td class="input_label" align="right">���Σ�</td>
					<td>
					  <s:textfield cssClass="style_input" name="batch" id="batch"/>
					</td>
				  </tr>
			  <tr>
				<td class="input_label">&nbsp;</td>
				<td colspan="2" align="center">
				    <input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" />&nbsp;&nbsp;
				    <input name="btnCheck" type="button" id="btnCheck" value="���" class="btn_blue_75" />&nbsp;&nbsp;
				    <input name="btnBatchCheck" type="button" id="btnBatchCheck" value="�������" class="btn_blue_75" />&nbsp;&nbsp;
				    <input name="btnRollback" type="button" id="btnRollback" value="����" class="btn_blue_75" />&nbsp;&nbsp;
				    <input name="btnBatchRollback" type="button" id="btnBatchRollback" value="��������" class="btn_blue_75" >
				</td>
				<td class="input_label">&nbsp;</td>
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
<script type="text/javascript" src="${ctx}/js/biz/info/reward/payment/paymentManage.js"></script> 
<SCRIPT type="text/javascript">
<!--
// ��ѯ��ʾ����Ϣ
var showCols = ${ShowCols};//ȡ��̨�����������飬��Ӧ���� 
// ҵ�����͡� ���С�ࡢ �տλ�� �������� �������� �������˺š� ��Ӧ���˵��� ���ֹ�˾��
// �����·� ��ʵ����� �����Ρ� �Թ���˽ ����˽�����۴���˰�ʡ��ۼ����
// �������� ���ϴ����š� ��˱�ʶ

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

var switchflag = document.getElementById("_switchflag").value;
// δ������˱�ʶ����ť����ѯ�����Ϊ��ɫ
if(switchflag=="0"){
	setBtnDisabled("btnCheck",true);
	setBtnDisabled("btnBatchCheck",true);
	setBtnDisabled("btnRollback",true);
	setBtnDisabled("btnBatchRollback",true);
}
//-->
</SCRIPT> 

</html>