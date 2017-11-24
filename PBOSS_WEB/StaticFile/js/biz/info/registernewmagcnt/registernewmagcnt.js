//elCell - 单元格对象(JQ),oRecord - 数据源,oData - 原数据,oColumnSet - 显示列对象 
//@@声用一定要在使用之前
function doLoadRegNew(a,b,c,d){
	//alert(o);
	if (a=='null') a='';
	if (b=='null') b='';
	if (c=='null') c='';
	if (d=='null') d='';
	f_setValueById("_se_employeename",a);
	f_setValueById("_se_officetel",b);
	f_setValueById("_se_brand",c);
	f_setValueById("_se_opnid",d);
	var dt1 = document.all('parameter.startoprtime').value;
	var dt2 = document.all('parameter.endoprtime').value;
	f_setValueById("_se_startoprtime",dt1);
	f_setValueById("_se_endoprtime",dt2);
	
	document.doAction.action = "/registernewmagcntd/show.do";
	document.doAction.submit();
}
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="oper"){
		rtn = "<a href=\"javascript:doLoadRegNew('"+ oRecord.employeename +"','"+oRecord.officetel+"','"+oRecord.brand+"','"+oRecord.opnid+"')\"><font color=\"#0000FF\">查看明细</font></a>";
	}
	if(oColumnSet.key=="datas.noactActTime"){
		rtn = handlerdate(oData, 2);
	}
	return rtn;
}

function showSelect(control) {
	var url = "/way/list.do";
	var rtn = window.showModalDialog(url, control, "dialogWidth=530px;dialogHeight=430px;status:no;scroll=yes;");
	if (rtn != null) {
		document.all('wayid').value = rtn;
		return rtn;
	}
}

function showOpnid(content){
	var url="/salesDetail/opnselect.do?opntype=2";
	var rtn=window.showModalDialog(url , content , "dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.all("opnid").value = rtn;
	   return rtn;
	}
}

function showName(content){
	var url="/magSaleDetail/employeeSelect.do";
	var rtn=window.showModalDialog(url , content , "dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   //document.getElementById("oprcode").value = rtn[2];
	   document.all("employeename").value = rtn[1];
	   return rtn;
	}
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
   
function f_exportExcel(){
	sumbitExportExcel("exportExcel.do","content");
}

$(document).ready(function() { 
	//绑定按钮
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);
	$("#btnExport").click(f_exportExcel);
	//页面启动按钮
	queryBtn.attr("disabled",false);
	initDate("startoprtime");
	initDate("endoprtime");
	//打开页面默认查询
	doQuery();
});