var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	return rtn;
}

function doSubmit(){// onsubmit="return doSubmit();" 
	    var month = $('#rewardmonth').val(); 
        var repairmonth =  $('#repairmonth').val();
		if( (month==null || month=='')  &&  (repairmonth==null || repairmonth=='')  ){
			alert("[�����·�]��[�����·�]����ͬʱΪ��");
			return false;
		}  
	return true;
}


//���ò�ѯ
var doQuery = function() { 
	 var wayid = $('#wayid').val();
	   	if(wayid==null || wayid==''){
	   		alert("[��������]����Ϊ�ա�");	
	   		return false;
	   	}
       var month = $('#rewardmonth').val();  
       var repairmonth =  $('#repairmonth').val(); 
	   if( (month==null || month=='') && (repairmonth==null || repairmonth=='')  ){
			alert("[�����·�]��[�����·�]����ͬʱΪ��");
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
	getMouthSelect($("#rewardmonth"),3);
	getMouthSelect($("#repairmonth"),3);
	
});

var doExportExcel = function(){
	sumbitExportExcel(contextRootPath+"/cityView/rewardTdSucExcel.do","content");
}



function getMouthSelect($setSelect,length,incThisMm,setDate){
	var nowDate = new Date();
	if (!$.isUndefined(setDate)){
		nowDate = new Date(setDate);
	}
	var isIncThisMm = !(typeof incThisMm === 'undefined') && incThisMm;
	var giYear = nowDate.getFullYear();
	var giMonth = nowDate.getMonth()+1; 
	var srtn = "<option value=''></option>",setVal;
	var getYear,getMonth,isSelectd = "",nowMonth;
	var orgValue = $setSelect.attr("orgval"); //��ȡԭֵ 
	var hasInit = true
//	debugger;
	for (var i=length;i>0;i--){
		getYear = giYear;
		getMonth = giMonth-i;
	 
		while(getMonth<=0){
			getMonth = 12 + getMonth;
			getYear--;
		}//while ������ת
		nowMonth = getMonth;//������ǰ�£���������ִ��������ݶ�ʧ
		//debugger;
		if (!hasInit && (giMonth-length)>1){
			//���ɵ�ǰ��
			for (var j=1;j<giMonth-length;j++){
				getMonth = ("0"+j); 
				getMonth = getMonth.substring(getMonth.length,getMonth.length-2);
				setVal = getYear + getMonth;
				 
				if (orgValue == setVal|| ((i==1 && orgValue == "") && !isIncThisMm) ){
					isSelectd = " selected";
				}else{
					isSelectd = "";
				}
				srtn += "<option value='"+ setVal+"'"+ isSelectd +">"+ getYear + "��" + getMonth+"��</option>\n"; 
			}//for
		}//if

		hasInit = true;
		//���λ��
		//getMonth = giMonth-i;
		getMonth = ("0"+nowMonth); 
		getMonth = getMonth.substring(getMonth.length,getMonth.length-2);
		setVal = getYear + getMonth;
		//if ( (orgValue == setVal)|| ((i==1 && orgValue == "") && !isIncThisMm) ) {
		//	isSelectd = " selected";
	//	}else{
	//		isSelectd = "";
	//	} 
		//alert(srtn);
		srtn += "<option value='"+ setVal+"'>"+ getYear + "��" + getMonth+"��</option>\n"; 
	}//for
	if (isIncThisMm){
		getMonth = ("0"+giMonth); 
		getMonth = getMonth.substring(getMonth.length,getMonth.length-2);
		setVal = giYear + getMonth;
		if ((orgValue == setVal) || (orgValue == "") ){
			isSelectd = " selected";
		}else{
			isSelectd = "";
		}
		srtn += "<option value='"+ setVal+"'"+ isSelectd +">"+ giYear + "��" + getMonth+"��</option>\n"; 
	}
	$setSelect.html(srtn);
}









