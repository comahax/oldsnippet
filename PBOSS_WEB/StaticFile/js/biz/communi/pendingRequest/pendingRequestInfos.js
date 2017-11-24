//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声明一定要在使用之前
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
	//绑定按钮
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);
	//日期控件
	initDate("selStartDate");
	initDate("selAccountDate");
	//f_showMenu(1,1,1)
	//页面启动按钮
	queryBtn.attr("disabled",false);
	//打开页面默认查询
	doQuery();
});

var _o_li = null;
function f_readPendingTask(advinfoid){
	_o_li = f_showPlan("处理中，请稍候。");
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