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

//���ò�ѯ
var doQuery = function() {
	$("#showTbl").queryTable(optin);
};
//ҳ���ʼ�����ʱ����
$(document).ready(function() {
	//f_showMenu(4,2,0);
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	
	//������������
	//initDate("timeFrom");
	//initDate("timeTo");
	
	$("#showTbl").queryTable(optin);
});