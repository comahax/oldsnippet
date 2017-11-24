//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="orderid"){
		rtn = "<a href=\"javascript:openDtl('"+ contextRootPath +"/salesOrder/detail.do?orderid="+ oData +"');\" >"+ oData +"</a>";
	}else if(oColumnSet.key=="createtime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="recamt" || oColumnSet.key=="actamt"){
		rtn = oData + '元';
	}
	return rtn;
}

var openDtl=function(url){
	openDlg(url,"订单明细",800,600,true);
};

var doQuery = function() {
	//验证输入
//	if ($("#opnname").val() == ""){
//		alert("请输入业务名称!");
//		return;
//	}
//	//验证手机
//	var oprMobile = $("#mobile").val();
//	if (oprMobile != ""){
//		if (!f_isMobile(oprMobile)){
//			alert("人员手机号只能是移动手机号码!");
//			return;
//		}
//	}
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
	//f_showMenu(3,2,0)
	//页面启动按钮
	queryBtn.attr("disabled",false);
	
	//打开页面默认查询
	doQuery();
});

var plsQuery=false;

//子窗口关闭时，调用查询
function closePage(){//关闭
	//submitDlg.hide();
	submitDlg.close();
	if (plsQuery){		
		doQuery();
	}
}
