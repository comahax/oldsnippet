//调用查询
var doQuery = function() {	
	$("#showTbl").queryTable(optin);
}
//页面初始化完成时调用
$(document).ready(function() {
	//f_showMenu(4,2,0);
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
		
	//生成业务发生时间下拉
	initDate("oprtimeFrom");
	initDate("oprtimeTo");
	
	$("#showTbl").queryTable(optin);
});