//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="title"){
		rtn = "<a href='#' onclick=\"javascript:f_readPendingTask('"+oRecord.advinfoid+"');\" >"+ oData +"</a>";
	}
	if(oColumnSet.key=="releasetime"){
		rtn = handlerdate(oData, 1);
	}
	if(oColumnSet.key=="plantime"){
		rtn = handlerdate(oData,1);
	}
	return rtn;
}

var doQuery = function() {
	$("#showTbl").queryTable(optin);
}

$(document).ready(function() { 
	//�󶨰�ť
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);
	//���ڿؼ�
	initDate("selStartDate");
	initDate("selAccountDate");
	//f_showMenu(1,1,1)
	//ҳ��������ť
	queryBtn.attr("disabled",false);
	//��ҳ��Ĭ�ϲ�ѯ
	doQuery();
});

var _o_li = null;
function f_readPendingTask(advinfoid){
	_o_li = f_showPlan("�����У����Ժ�");
	$.post("readPendingTask.do",{"parameter.advinfoid":advinfoid},handleResponse,"json");
}

function handleResponse(json){
	if(!json.isSuccess){
		if(_o_li != null)
			_o_li.close();
		f_showMsg(json.message);
	}
	else
		f_jumpToURL(json.rtnObject);

}