var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	return rtn;
}

function doSubmit(){// onsubmit="return doSubmit();" 
	
	   var month = $('#selMonth').val(); 
		if( month==null || month=='' ){
			alert("[�����·�]����Ϊ��");
			return false;
		} 
		 
	return true;
}


//���ò�ѯ
var doQuery = function() { 
       var month = $('#selMonth').val();  
	   if( month==null || month=='' ){
			alert("[�����·�]����Ϊ��");
			return;
		} 
	$("#showTbl").queryTable(optin);
}

//ҳ���ʼ�����ʱ����
$(document).ready(function() { 
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	//$("#showTbl").queryTable(optin);
	$("#btnExportExcel").click(doExportExcel)
		//������������
	getMouthSelect($("#selMonth"),3); 
});

var doExportExcel = function(){
	sumbitExportExcel(contextRootPath+"/reward/saleMonthExcel.do","content");
}













