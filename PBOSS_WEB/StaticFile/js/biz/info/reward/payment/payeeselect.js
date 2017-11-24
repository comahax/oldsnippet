//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	var o = oRecord.payee;
	if(oColumnSet.key=="payee"){
	    //rtn = "<a href=\"javascript:doLoadEmployee('"+ o +"')\"><font color=\"#0000FF\">查看</font></a>" ;
		rtn = "<a href=\"#\"><font color=\"#0000FF\">"+o+"</font></a>" ;
		elCell.bind('click',oRecord,function(event){
			var a = new Array(2);
			a[0] =event.data.cityid; 
			a[1] =event.data.payee;
			window.returnValue = a[1]; 
			window.close();
		});
	}
	return rtn;
}

//function selectCode(code,name) {
//   var a = new Array(2);
//    a[0] =code; 
//    a[1] =name;
//    	    
//    window.returnValue = a[0]; 
//	window.close();
//}

//调用查询
var doQuery = function() {
	$("#showTbl").queryTable(optin);
};
//页面初始化完成时调用
$(document).ready(function() {	
	//f_showMenu(4,2,0);
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	$("#showTbl").queryTable(optin);
	
	//打开页面默认查询
	//doQuery();
});