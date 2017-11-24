//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="id"){
		rtn = "<a href=\"Load.do?user.id="+ oData +"\" >"+ oData +"</a>";
	}
	if(oColumnSet.key=="runtime"){
		rtn = handlerdate(oData, 1);
	}
	return rtn;
}


var doQuery = function() {
	//修改部分：只对页面相关的量进行修改
	if ($("#realrewardtype").val() == ""){
		alert("请选择酬金类型");
		return;
	}
	$("#showTbl").queryTable(optin);
}

$(document).ready(function() { 
	//绑定按钮
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();

	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	//生成日期下拉
	getMouthSelect($("#selMonth"),3);
	//ac
	cusAc($("#opnname"),$("#opnid"),{type:"${jqac.OPERATION}"})
	//<!-- 显示第几个菜单内容 -->
	//f_showMenu(4,2,2)
});