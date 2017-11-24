//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
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

//赋值
var doQuery = function() {
	$("#showTbl").queryTable(optin);
}

//赋值
function doQuery2(){
	$("#showTbl").queryTable(optin);
}

//页面初始化完成时调用
$(document).ready(function() { 
	//绑定按钮
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);

	$("#btnSave").click(updateFlag);
	
	//页面启动按钮
	//queryBtn.attr("disabled",false);
	
	//打开页面默认查询
	doQuery();
});
