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
			alert("[�����·�]��[�����·�]����ͬʱΪ��");
			return false;
		}
	}else{
		if(month==null || month==''){ 
			alert("[�����·�]����Ϊ�ա�");		
			return false;
		}
	}
	return true;
}


//���ò�ѯ
var doQuery = function() {
    var month = $('#rewardmonth').val(); 
	var supportPaymonth = $('#supportPaymonth').val();  
	 if(supportPaymonth=='true'){
		var paymonth = $('#paymonth').val();
		if( (month==null || month=='') && (paymonth==null || paymonth=='') ){
			alert("[�����·�]��[�����·�]����ͬʱΪ��");
			return;
		}
	  }else{
		if(month==null || month==''){ 
			alert("[�����·�]����Ϊ�ա�");		
			return;
		}
	} 
	$("#showTbl").queryTable(optin);
}

//ҳ���ʼ�����ʱ����
$(document).ready(function() {
	//f_showMenu(4,2,0);
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	$("#showTbl").queryTable(optin);
});