//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
//var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
//	var rtn = oData;
//	if(oColumnSet.key=="commond"){
//	rtn = "�鿴��ϸ";
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

function doLoadDetail(o,a,b){//,c
	//alert(o);
//	f_setValueById("_se_employeename",o);
	if(o=='null')
		o='';
	f_setValueById("_se_employeeid",o);
	if(a=='null')
		a='';
	f_setValueById("_se_officetel",a);
	if(b=='null')
		b='';
	f_setValueById("_se_brand",b);
	var dt1 = document.all('startoprtime').value;
	var dt2 = document.all('endoprtime').value;
	var dt3 = document.all('startactivedate').value;
	var dt4 = document.all('endactivedate').value;
	f_setValueById("_se_startoprtime",dt1);
	f_setValueById("_se_endoprtime",dt2);
	f_setValueById("_se_startactivedate",dt3);
	f_setValueById("_se_endactivedate",dt4);
	
	document.doAction.action = "/lowsalescardstotaldetail/showdetail.do";
	document.doAction.submit();
}
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="commond"){
//rtn = "<a href=\"javascript:doLoadDetail('"+  oRecord.employeename +"','"+oRecord.officetel+"','"+oRecord.brand //ͨ��employeeid����ѯ
rtn = "<a href=\"javascript:doLoadDetail('"+  oRecord.employeeid +"','"+oRecord.officetel+"','"+oRecord.brand
+"')\"><font color=\"#0000FF\">�鿴��ϸ</font></a>";	
//	,'"+oRecord.wayid+"','"+oRecord.countyid+"'
	}
	
	return rtn;
}

function f_employeeSelect(content){
	var url="/salesDetail/employeeSelect.do";
	var rtn=window.showModalDialog(url , content , "dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("oprcode").value = rtn[0];
	   document.getElementById("employeename").value = rtn[1];
	   return rtn;
	}
}

 function f_opnSelect(content){
	var url="/salesDetail/opnselect.do?opntype=1";//
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
	// �Ǽ���ʼʱ�䲻��Ϊ��
	if ($("#startoprtime").val() == ""){
		alert("������Ǽ���ʼʱ��!");
		return;
	}
	// �Ǽǽ���ʱ�䲻��Ϊ��
	if ($("#endoprtime").val() == ""){
		alert("������Ǽǽ���ʱ��!");
		return;
	}
	var startdate = $("#startoprtime").val();
	var enddate = $("#endoprtime").val();
	if (startdate > enddate) {
		alert("�Ǽ���ʼʱ�䲻�ܴ��ڵǼǽ���ʱ��!");
		return;
	}
	var cnt = DateDiff(startdate, enddate);
	if (cnt > 30) {
		alert("�Ǽ���ʼʱ�䣦�Ǽǽ���ʱ�䲻�ܳ���31��!");
		return;
	}
	// ������ʼʱ�䲻��Ϊ��
	
	if ($("#startactivedate").val() == ""){
		if ($("#endactivedate").val() != ""){
		alert("�����뼤����ʼʱ��!");
		return;
	}
	}
	
	if ($("#startactivedate").val() != ""){
		if ($("#endactivedate").val() == ""){
		alert("�����뼤�����ʱ��!");
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
			alert("������ʼʱ�䲻�ܴ��ڼ������ʱ��!");
			return;
		}
		var cnt = DateDiff(startactivedate, endactivedate);
		if (cnt > 30) {
			alert("������ʼʱ�䣦�������ʱ�䲻�ܳ���31��!");
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
	//�󶨰�ť
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);
	
	//�����ļ�
	$("#btnExportExcel").click(f_exportExcel);
	
	initDate("startoprtime");
	initDate("endoprtime");
	initDate("startactivedate");
	initDate("endactivedate");
	
	//������������
	//getMouthSelectChkNow($("#selMonth"),3,10,true);
	//<!-- ��ʾ�ڼ����˵����� -->
	//f_showMenu(1,1,1)
	//ҳ��������ť
	queryBtn.attr("disabled",false);
	//��ҳ��Ĭ�ϲ�ѯ
	doQuery();
});