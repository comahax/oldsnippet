var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	return rtn;
}

function f_waySelect(){
	var url="/magSaleDetail/waySelect.do";
	var rtn=window.showModalDialog(url,null,"dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("wayid").value = rtn;//[0]
	   return rtn;
	}
}
function doSubmit(){// onsubmit="return doSubmit();"
	var wayid = $('#wayid').val();
	if(wayid==null || wayid==''){
		alert("[��������]����Ϊ�ա�");	
		return false;
	}
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












