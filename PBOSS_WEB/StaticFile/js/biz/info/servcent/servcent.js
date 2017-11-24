//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="svccode"){
		var svccode = oRecord.svccode;
		if (svccode == "") {
			svccode="空值";
		}
		rtn = "<a href=\"#\"><font color=\"#0000FF\">"+svccode+"</font></a>" ;
		elCell.bind('click',oRecord,function(event){
			var a = new Array(2);
			a[0] =event.data.svccode; 
			a[1] =event.data.svcname;
			window.returnValue = a[0]; 
			window.close();
		});
	return rtn;	
	}
	
	if(oColumnSet.key=="datas.noactActTime"){
		rtn = handlerdate(oData, 2);
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
	//页面启动按钮
	queryBtn.attr("disabled",false);
	//打开页面默认查询
	doQuery();
});