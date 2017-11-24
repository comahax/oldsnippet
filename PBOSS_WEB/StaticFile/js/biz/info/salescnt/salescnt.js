//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="datas.noactActTime"){
		rtn = handlerdate(oData, 2);
	}
	return rtn;
}

var doQuery = function() {
	// 登记起始时间不能为空
	if ($("#startoprtime").val() == ""){
		alert("请输入登记起始时间!");
		return;
	}
	// 登记结束时间不能为空
	if ($("#endoprtime").val() == ""){
		alert("请输入登记结束时间!");
		return;
	}
	var startdate = $("#startoprtime").val();
	var enddate = $("#endoprtime").val();
	if (startdate > enddate) {
		alert("登记起始时间不能大于登记结束时间!");
		return;
	}
	var cnt = DateDiff(startdate, enddate);
	if (cnt > 30) {
		alert("登记起始时间＆登记结束时间不能超出31天!");
		return;
	}
	
	$("#showTbl").queryTable(optin);
}

 function  DateDiff(sDate1, sDate2){  //sDate1 and sDate2 is string
       var aDate, oDate1, oDate2, iDays  
       aDate = sDate1.replace(/-/g,"/");
       oDate1 = new Date(aDate) //change to date  
       aDate = sDate2.replace(/-/g,"/"); 
       oDate2 = new Date(aDate)  
       iDays = parseInt(Math.abs(oDate1 - oDate2)/1000/60/60/24)  //day  
       return iDays  
   }   
   
$(document).ready(function() { 
	//绑定按钮
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);
	//页面启动按钮
	queryBtn.attr("disabled",false);
	//打开页面默认查询
	initDate("startoprtime");
	initDate("endoprtime");
	doQuery();
});