//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData, oColumnSet) { 
	var rtn = oData;

	return rtn;
}

function checkFlag(){
	var frmQuery = document.getElementById("frmQuery");
	frmQuery.action = "/gdView/paymentManageCheck.do";
	frmQuery.submit();
	frmQuery.action = "/gdView/paymentManageAjax.do";
}

function batchCheckFlag(){
	var frmQuery = document.getElementById("frmQuery");
	frmQuery.action = "/gdView/paymentManageBatchCheck.do";
	frmQuery.submit();
	frmQuery.action = "/gdView/paymentManageAjax.do";
}

function rollbackFlag(){
	var frmQuery = document.getElementById("frmQuery");
	frmQuery.action = "/gdView/paymentManageRollback.do";
	frmQuery.submit();
	frmQuery.action = "/gdView/paymentManageAjax.do";
}

function batchRollbackFlag(){
	var frmQuery = document.getElementById("frmQuery");
	frmQuery.action = "/gdView/paymentManageBatchRollback.do";
	frmQuery.submit();
	frmQuery.action = "/gdView/paymentManageAjax.do";
}

//��ֵ
var doQuery = function() {
	$("#showTbl").queryTable(optin);
}

//��ֵ
function doQuery2(){
	$("#showTbl").queryTable(optin);
}

function setBtnDisabled(tabId,state){
    document.getElementById(tabId).disabled=state;
}

function f_payeeSelect(content){
	var url="/gdView/paymentPayeePop.do";
	var rtn=window.showModalDialog(url, content, "dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("payee").value = rtn;
	   return rtn;
	}
}

function f_wayidSelect(content){
    var url="/gdView/paymentWayPop.do";
	var rtn=window.showModalDialog(url,null,"dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("wayid").value = rtn;//[0]
	   return rtn;
	}
}

function f_ltypeSelect(content){
	var url="/gdView/paymentLtypePop.do";
	var rtn=window.showModalDialog(url, content, "dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("ltype").value = rtn;
	   return rtn;
	}
}

function f_stypeSelect(content){
	var url="/gdView/paymentStypePop.do";
	var rtn=window.showModalDialog(url, content, "dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("stype").value = rtn;
	   return rtn;
	}
}

//ҳ���ʼ�����ʱ����
$(document).ready(function() { 
	//�󶨰�ť
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	
	getMouthSelect($("#paymonth"),12);
	
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);

	$("#btnCheck").click(checkFlag);
	$("#btnBatchCheck").click(batchCheckFlag);
	
	$("#btnRollback").click(rollbackFlag);
	$("btnBatchRollback").click(batchRollbackFlag);	
	
	//ҳ��������ť
	//queryBtn.attr("disabled",false);
	
	//��ҳ��Ĭ�ϲ�ѯ
	//doQuery();
});
