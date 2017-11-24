var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	return rtn;
}

function doSubmit(){// onsubmit="return doSubmit();" 
	    var month = $('#rewardmonth').val(); 
       // var repairmonth =  $('#repairmonth').val();
		if( (month==null || month=='')){
			alert("[结算月份]不能为空");
			return false;
		}  
	return true;
}


//调用查询
var doQuery = function() { 
     
       var month = $('#rewardmonth').val();  
      // var repairmonth =  $('#repairmonth').val(); 
	   if( (month==null || month=='') ){
			alert("[结算月份]不能为空");
			return;
		}  
	$("#showTbl").queryTable(optin);
}

//页面初始化完成时调用
$(document).ready(function() {
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	//$("#showTbl").queryTable(optin);
	$("#btnExportExcel").click(doExportExcel)
		//生成日期下拉
	getMouthSelect($("#rewardmonth"),3);
	//getMouthSelect($("#repairmonth"),3);
	
});

var doExportExcel = function(){
	sumbitExportExcel(contextRootPath+"/reward/rewardAdSucExcel.do","content");
}
