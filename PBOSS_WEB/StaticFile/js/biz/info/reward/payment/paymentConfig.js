//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData, oColumnSet) { 
	var rtn = oData;

	return rtn;
}

function updateFlag(){
	var frmQuery = document.getElementById("frmQuery");
	frmQuery.action = "/gdView/paymentConfigUpdate.do";
	frmQuery.submit();
	frmQuery.action = "/gdView/paymentConfigAjax.do";
}

//��ֵ
var doQuery = function() {
	$("#showTbl").queryTable(optin);
}

//��ֵ
function doQuery2(){
	$("#showTbl").queryTable(optin);
}

//ҳ���ʼ�����ʱ����
$(document).ready(function() { 
	//�󶨰�ť
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);

	$("#btnSave").click(updateFlag);
	
	//ҳ��������ť
	//queryBtn.attr("disabled",false);
	
	//��ҳ��Ĭ�ϲ�ѯ
	doQuery();
});
