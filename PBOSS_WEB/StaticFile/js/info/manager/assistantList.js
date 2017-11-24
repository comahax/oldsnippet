function doLoadEmployee(o){
	//alert(o);
	f_setValueById("employeeid",o);
	document.doAction.action = "/managerView/assistantLoad.do";
	document.doAction.submit();
	//document.doLoad.submit();
}
//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	var o = oRecord.employeeid;
	if(oColumnSet.key=="oper"){
		rtn = "<a href=\"javascript:doLoadEmployee('"+ o +"')\"><font color=\"#0000FF\">查看</font></a>" ;
	}
	return rtn;
}

//调用查询
var doQuery = function() {
	//var m = f_getValueById('officeTel');
	
	//if(f_isMobile(m)){
	//	$("#showTbl").queryTable(optin);
	//}
	//else{
	//	f_showMsg("请输入正确的移动手机号码。");
	//}
	$("#showTbl").queryTable(optin);
};
//页面初始化完成时调用
$(document).ready(function() {
	//f_showMenu(4,2,0);
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	$("#showTbl").queryTable(optin);
});