function doLoadEmployee(o){
	//alert(o);
	f_setValueById("employeeid",o);
	document.doAction.action = "/managerView/assistantLoad.do";
	document.doAction.submit();
	//document.doLoad.submit();
}
//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	var o = oRecord.employeeid;
	if(oColumnSet.key=="oper"){
		rtn = "<a href=\"javascript:doLoadEmployee('"+ o +"')\"><font color=\"#0000FF\">�鿴</font></a>" ;
	}
	return rtn;
}

//���ò�ѯ
var doQuery = function() {
	//var m = f_getValueById('officeTel');
	
	//if(f_isMobile(m)){
	//	$("#showTbl").queryTable(optin);
	//}
	//else{
	//	f_showMsg("��������ȷ���ƶ��ֻ����롣");
	//}
	$("#showTbl").queryTable(optin);
};
//ҳ���ʼ�����ʱ����
$(document).ready(function() {
	//f_showMenu(4,2,0);
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	$("#showTbl").queryTable(optin);
});