//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="datas.noactActTime"){
		rtn = handlerdate(oData, 2);
	}
	return rtn;
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
	//�󶨰�ť
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);
	//ҳ��������ť
	queryBtn.attr("disabled",false);
	//��ҳ��Ĭ�ϲ�ѯ
	initDate("startoprtime");
	initDate("endoprtime");
	doQuery();
});