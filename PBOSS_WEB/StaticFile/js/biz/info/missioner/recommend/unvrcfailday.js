//���ò�ѯ
var doQuery = function() {
	$("#showTbl").queryTable(optin);
}
//ҳ���ʼ�����ʱ����
$(document).ready(function() {
	//f_showMenu(4,2,0);
	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
		
	//����ҵ����ʱ������
	initDate("oprtimeFrom");
	initDate("oprtimeTo");
	
	$("#showTbl").queryTable(optin);
});