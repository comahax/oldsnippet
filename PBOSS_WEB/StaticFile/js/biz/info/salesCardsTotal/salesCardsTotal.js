//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
//var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
//	var rtn = oData;
//	if(oColumnSet.key=="commond"){
//	rtn = "查看明细";
//	}
//	return rtn;
//}
function showSelect(control) {
	var url = "/way/list.do";
	var rtn = window.showModalDialog(url, control, "dialogWidth=530px;dialogHeight=430px;status:no;scroll=yes;");
	if (rtn != null) {
		document.all('wayid').value = rtn;
		return rtn;
	}
}

function showSvccode(control) {
	var countyid = document.all('countyid').value;
	if (countyid == "") {
		alert('请先输入分公司！');
		document.all('svccode').value = "";
		return;
	}
	var url = "/servcent/list.do?_se_countyid="+countyid;
	var rtn = window.showModalDialog(url, control, "dialogWidth=530px;dialogHeight=430px;status:no;scroll=yes;");
	if (rtn != null) {
		document.all('svccode').value = rtn;
		return rtn;
	}
}

function doLoadDetail(o,a,b){
	//alert(o);
	f_setValueById("_se_wayid",o);
	f_setValueById("_se_countyid",a);
	if(b=='null')
		b='';
	f_setValueById("_se_starlevel",b);
	var dt1 = document.all('startoprtime').value;
	var dt2 = document.all('endoprtime').value;
	var dt3 = document.all('startactivedate').value;
	var dt4 = document.all('endactivedate').value;
	var svccode = document.all('svccode').value;
	var brand = document.all('brand').value;
	f_setValueById("_se_startoprtime",dt1);
	f_setValueById("_se_endoprtime",dt2);
	f_setValueById("_se_startactivedate",dt3);
	f_setValueById("_se_endactivedate",dt4);
	f_setValueById("_se_svccode",svccode);
	f_setValueById("_se_brand",brand);
	
	document.doAction.action = "/salescardstotaldetail/showdetail.do";
	document.doAction.submit();
}
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;	
	
	if(oColumnSet.key=="commond"){
	
		rtn = "<a href=\"javascript:doLoadDetail('"+  oRecord.wayid +"','"+oRecord.countyid+"','"+oRecord.starlevel +"')\"><font color=\"#0000FF\">查看明细</font></a>";
	}
	
	return rtn;
}

 function f_opnSelect(content){
	var url="/magSaleDetail/opnselect.do";
	var rtn=window.showModalDialog(url , content , "dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("opnid").value = rtn;
	   return rtn;
	}
}


function f_exportExcel(){
	sumbitExportExcel("exportExcel.do","content");
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
	// 激活起始时间不能为空
	
	if ($("#startactivedate").val() == ""){
		if ($("#endactivedate").val() != ""){
		alert("请输入激活起始时间!");
		return;
	}
	}
	
	if ($("#startactivedate").val() != ""){
		if ($("#endactivedate").val() == ""){
		alert("请输入激活结束时间!");
		return;
	}
	}
//	alert(($("#startactivedate").val() != "")&&($("#endactivedate").val() != ""));
	if(($("#startactivedate").val() != "")&&($("#endactivedate").val() != "")){
		 var startactivedate = $("#startactivedate").val();
		var endactivedate = $("#endactivedate").val();
//		alert( $("#startactivedate").val());
//		alert( $("#endactivedate").val());
		if (startactivedate > endactivedate) {
			alert("激活起始时间不能大于激活结束时间!");
			return;
		}
		var cnt = DateDiff(startactivedate, endactivedate);
		if (cnt > 30) {
			alert("激活起始时间＆激活结束时间不能超出31天!");
			return;
		}
		 
	}
	
	$("#showTbl").queryTable(optin);
}

function  DateDiff(sDate1, sDate2){  //sDate1 and sDate2 is 2006-12-18model
       var aDate, oDate1, oDate2, iDays  
       aDate = sDate1.split("-")  
       oDate1 = new  Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]) //change to 12-18-2006model  
       aDate = sDate2.split("-")  
       oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0])  
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
	
	//导出文件
	$("#btnExportExcel").click(f_exportExcel);
	
	initDate("startoprtime");
	initDate("endoprtime");
	initDate("startactivedate");
	initDate("endactivedate");
	
	//生成日期下拉
	//getMouthSelectChkNow($("#selMonth"),3,10,true);
	//<!-- 显示第几个菜单内容 -->
	//f_showMenu(1,1,1)
	//页面启动按钮
	queryBtn.attr("disabled",false);
	//打开页面默认查询
	doQuery();
});