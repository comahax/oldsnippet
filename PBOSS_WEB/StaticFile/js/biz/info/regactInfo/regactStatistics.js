//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="desc"){
		rtn = "总体";
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
	//生成日期下拉
	getMouthSelectChkNow($("#selMonth"),3,10,true);
	//<!-- 显示第几个菜单内容 -->
	//f_showMenu(1,1,1)
	//页面启动按钮
	queryBtn.attr("disabled",false);
	//打开页面默认查询
	doQuery();
});