var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	return rtn;
}

function doSubmit(){// onsubmit="return doSubmit();" 
	    var month = $('#rewardmonth').val(); 
        var repairmonth =  $('#repairmonth').val();
		if( (month==null || month=='')  &&  (repairmonth==null || repairmonth=='')  ){
			alert("[结算月份]、[补算月份]不能同时为空");
			return false;
		}  
	return true;
}


//调用查询
var doQuery = function() { 
	 var wayid = $('#wayid').val();
	   	if(wayid==null || wayid==''){
	   		alert("[渠道编码]不能为空。");	
	   		return false;
	   	}
       var month = $('#rewardmonth').val();  
       var repairmonth =  $('#repairmonth').val(); 
	   if( (month==null || month=='') && (repairmonth==null || repairmonth=='')  ){
			alert("[结算月份]、[补算月份]不能同时为空");
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
	var orgValue = $setSelect.attr("orgval"); //提取原值 
	var hasInit = true
//	debugger;
	for (var i=length;i>0;i--){
		getYear = giYear;
		getMonth = giMonth-i;
	 
		while(getMonth<=0){
			getMonth = 12 + getMonth;
			getYear--;
		}//while 日期跳转
		nowMonth = getMonth;//保留当前月，以免下面执行造成数据丢失
		//debugger;
		if (!hasInit && (giMonth-length)>1){
			//生成当前年
			for (var j=1;j<giMonth-length;j++){
				getMonth = ("0"+j); 
				getMonth = getMonth.substring(getMonth.length,getMonth.length-2);
				setVal = getYear + getMonth;
				 
				if (orgValue == setVal|| ((i==1 && orgValue == "") && !isIncThisMm) ){
					isSelectd = " selected";
				}else{
					isSelectd = "";
				}
				srtn += "<option value='"+ setVal+"'"+ isSelectd +">"+ getYear + "年" + getMonth+"月</option>\n"; 
			}//for
		}//if

		hasInit = true;
		//组件位数
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
		srtn += "<option value='"+ setVal+"'>"+ getYear + "年" + getMonth+"月</option>\n"; 
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
		srtn += "<option value='"+ setVal+"'"+ isSelectd +">"+ giYear + "年" + getMonth+"月</option>\n"; 
	}
	$setSelect.html(srtn);
}









