
//调用查询
var doQuery = function() { 
		//sumbitExportExcel(contextRootPath+"/gdView/paymentAjax.do","content");
	frmQuery.submit();

}

//页面初始化完成时调用
$(document).ready(function() { 
	$("#btnQuery").click(doQuery);
		//生成日期下拉
	getMouthSelect($("#selMonth"),12); 
	//初始化日期插件
//	initDate("rewardmonth");
});
