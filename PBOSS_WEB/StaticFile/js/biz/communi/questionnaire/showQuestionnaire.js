//�����������
alert(222);
var optin = {
	showCols:showCols,//��ʾ��
	pageSize:5,//ҳ�ڴ�С
	fmtLink:fmtLink,
	navigation:$("#navigation"),//��ҳλ�� jq����
	width:"100%",
	showTable:false,
	queryFrom: $("#queryReply")//��ѯ��
};

function doQuery(){
alert(123);
	$("#showTbl").queryTable(optin);
}

$(document).ready(function() {
	doQuery();
});