
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
       var wayid = $('#wayid').val();
	   	if(wayid==null || wayid==''){
	   		alert("[��������]����Ϊ�ա�");	
	   		return false;
	   	}
	   if( month==null || month=='' ){
			alert("[�����·�]����Ϊ��");
			return;
		} 
			document.frmQuery.submit();
}

//ҳ���ʼ�����ʱ����
$(document).ready(function() { 
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	//$("#showTbl").queryTable(optin);
	$("#btnExportExcel").click(doExportExcel)
		//������������
	getMouthSelect($("#selMonth"),7); 
});

var doExportExcel = function(){
	sumbitExportExcel(contextRootPath+"/managerView/monthRemunerationExcel.do","content");
}













