//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	//var o = oRecord.employeeid;
	//if(oColumnSet.key=="oper"){
	//	rtn = "<a href=\"javascript:doLoadEmployee('"+ o +"')\"><font color=\"#0000FF\">查看</font></a>" ;
	//}
	return rtn;
}

//调用查询
var doQuery = function() {
	$("#showTbl").queryTable(optin);
};

//首次进入页面不调用查询
$(document).ready(function() {
	//f_showMenu(4,2,0);
	$("#btnQuery").click(doQuery);
	//$('#btnQuery').attr("disabled",false);
	
	//生成日期下拉
	initDate("activeFrom");
	initDate("activeTo");
	initDate("rechargeFrom");
	initDate("rechargeTo");
	
	//$("#showTbl").queryTable(optin);
});