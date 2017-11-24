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
//去掉字符串两端的空格
function trim(str){   
    return str.replace(/^(\s|\u00A0)+/,'').replace(/(\s|\u00A0)+$/,'');   
}  

var doQuery = function() {
	/*验证输入
	if ($("#opnname").val() == ""){
		alert("请输入业务名称");
		return;
	}
	if ($("#realrewardtype").val() == ""){
		alert("请选择酬金类型");
		return;
	}
	*/
	//修改部分：只对页面相关的量进行修改
	var opnname = f_getValueById('opnname');
	opnname=trim(opnname);
	if (opnname==null||opnname==''){
		f_setValueById('opnid',"");
	}
	$("#showTbl").queryTable(optin);
}

//根据“酬金种类”的选择跳转相应界面
var changeView = function(){
	var rewardType = f_getValueById('wayType');
	if(rewardType==1){
		window.location = '/reward/rewardRecordQuery.do';
	}
	else if(rewardType==2){
		//window.location = '/reward/bbcrewardRecord.do?wayType='+rewardType;
		window.location = '/reward/bbcrewardRecord.do';
	}
	else{
		window.location = '/reward/bbcrewardRecordUNPB.do';
	}
}

var doBbcExportExcel = function(){
	sumbitExportExcel("/reward/bbcExportExcel.do","content");
}

$(document).ready(function() { 
	//绑定按钮
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();

	$("#btnQuery").click(doQuery);
	$("#btnBbcExportExcel").click(doBbcExportExcel);
	$('#btnQuery').attr("disabled",false);
	//生成日期下拉
	getMouthSelect($("#selMonth"),3);
	//ac
	cusAc($("#opnname"),$("#opnid"),{type:bbcoperation});
	//<!-- 显示第几个菜单内容 -->
	//f_showMenu(4,2,1)
	
	$("#showTbl").queryTable(optin);
});