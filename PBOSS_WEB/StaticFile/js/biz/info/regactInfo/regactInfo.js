//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
//	if(oColumnSet.key=="id"){
//		//rtn = "<a href=\"Load.do?user.id="+ oData +"\" >"+ oData +"</a>";
//	}
	if(oColumnSet.key=="acttime"){
		rtn = handlerdate(oData, 2);
	}
	if(oColumnSet.key=="createtime"){
		rtn = handlerdate(oData, 2);
	}
	if(oColumnSet.key=="datas.noactActTime"){
		rtn = handlerdate(oData, 2);
	}
	return rtn;
}

var doQuery = function() {
	//验证输入
	if ($("#opnname").val() == ""){
		alert("请输入业务名称!");
		return;
	}
	//验证手机
	var oprMobile = $("#mobile").val();
	if (oprMobile != ""){
		if (!$.Validation.fIsNumeric(oprMobile)){
			alert("套卡号码只能是数字!");
			return;
		}
	}
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
//	getMouthSelect($("#selMonth"),3,true);
	getMouthSelect($("#selMonth"),3,true);
	//<!-- 显示第几个菜单内容 -->
	//f_showMenu(1,1,1)
	//页面启动按钮
	queryBtn.attr("disabled",false);
	//打开页面默认查询
	doQuery();
});