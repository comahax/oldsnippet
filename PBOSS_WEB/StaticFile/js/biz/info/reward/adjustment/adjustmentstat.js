var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	return rtn;
}

function doSubmit(){// onsubmit="return doSubmit();"
	var month = $('#rewardmonth').val(); 
	var supportPaymonth = $('#supportPaymonth').val(); 
	if(supportPaymonth=='true'){
		var paymonth = $('#paymonth').val();
		if( (month==null || month=='') && (paymonth==null || paymonth=='') ){
			alert("[结算月份]、[付款月份]不能同时为空");
			return false;
		}
	}else{
		if(month==null || month==''){ 
			alert("[结算月份]不能为空。");		
			return false;
		}
	}
	return true;
}


//调用查询
var doQuery = function() {
    var month = $('#rewardmonth').val(); 
	var supportPaymonth = $('#supportPaymonth').val();  
	 if(supportPaymonth=='true'){
		var paymonth = $('#paymonth').val();
		if( (month==null || month=='') && (paymonth==null || paymonth=='') ){
			alert("[结算月份]、[付款月份]不能同时为空");
			return;
		}
	  }else{
		if(month==null || month==''){ 
			alert("[结算月份]不能为空。");		
			return;
		}
	} 
	$("#showTbl").queryTable(optin);
}

//页面初始化完成时调用
$(document).ready(function() {
	//f_showMenu(4,2,0);
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	$("#showTbl").queryTable(optin);
});