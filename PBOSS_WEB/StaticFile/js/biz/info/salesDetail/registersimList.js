//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	//var o = oRecord.employeeid;
	//if(oColumnSet.key=="oper"){
	//	rtn = "<a href=\"javascript:doLoadEmployee('"+ o +"')\"><font color=\"#0000FF\">�鿴</font></a>" ;
	//}
	return rtn;
}

function f_exportExcel(){
	sumbitExportExcel("exportExcelRegSim.do","content");
}

function f_exportTxt(){
	sumbitExportExcel("exportTxtRegSim.do","content");
}

function f_opnSelect(content){
	var url="/salesDetail/opnselect.do?opntype=1";
	var rtn=window.showModalDialog(url , content , "dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("opnid").value = rtn;
	   return rtn;
	}
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

function  DateDiff(sDate1, sDate2){  //sDate1 and sDate2 is 2006-12-18model
    var aDate, oDate1, oDate2, iDays  
    //aDate = sDate1.split("-") 
    aDate = sDate1.replace(/-/g,"/");
    oDate1 = new Date(aDate) //change to 12-18-2006model  
    //aDate = sDate2.split("-")  
    aDate = sDate2.replace(/-/g,"/");
    //oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0])  
    oDate2 = new Date(aDate)  
    //alert(oDate2);
    iDays = parseInt(Math.abs(oDate1 - oDate2)/1000/60/60/24)  //day  
    return iDays  
} 

   
//���ò�ѯ
var doQuery = function() {
	var timeFrom = $('#timeFrom').val();
	var timeTo = $('#timeTo').val();
	var activeFrom = $('#activeFrom').val();
	var activeTo = $('#activeTo').val();
	if(timeFrom == "" && timeTo != ""){
		alert("�Ǽ���ʼʱ�䲻��Ϊ��!");
		return;
	}
	if(timeFrom != "" && timeTo==""){
		alert("�Ǽǵ���ʱ�䲻��Ϊ��!");
		return;
	}
	if (timeFrom > timeTo) {
		alert("�Ǽ���ʼʱ�䲻�ܴ��ڵǼǽ���ʱ��!");
		return;
	}
	var differ1 = DateDiff(timeFrom, timeTo);
	if (differ1 > 30) {
		alert("�Ǽ���ʼʱ�䣦�Ǽǽ���ʱ�䲻�ܳ���31��!");
		return;
	}
	
	if(activeFrom == "" && activeTo != ""){
		alert("������ʼʱ�䲻��Ϊ��!");
		return;
	}
	if(activeFrom != "" && activeTo == ""){
		alert("�������ʱ�䲻��Ϊ��!");
		return;
	}
	if(activeFrom > activeTo){
		alert("������ʼʱ�䲻�ܴ��ڼ������ʱ��!");
		return;
	}
	var differ2 = DateDiff(activeFrom, activeTo);
	if(differ2 > 30){
		alert("������ʼʱ��&�������ʱ�䲻�ܳ���31��!");
		return;
	}
	
	$("#showTbl").queryTable(optin);
}
//ҳ���ʼ�����ʱ����
$(document).ready(function() {
	//f_showMenu(4,2,0);
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	
	//�����ļ�
	$("#btnExportExcel").click(f_exportExcel);
	$("#btnExportTxt").click(f_exportTxt);
	
	//������������
	initDate("timeFrom");
	initDate("timeTo");
	initDate("activeFrom");
	initDate("activeTo");
	
	$("#showTbl").queryTable(optin);
});