//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="id"){
		rtn = "<a href=\"Load.do?user.id="+ oData +"\" >"+ oData +"</a>";
	}
	if(oColumnSet.key=="oprtime"){
		rtn = handlerdate(oData, 1);
	}
	return rtn;
}


var doQuery = function() {
	//��֤����
//		if ($("#opnname").val() == ""){
//			alert("������ҵ������");
//			return;
//		}
	if ($("#realrewardtype").val() == ""){
		alert("��ѡ��������");
		return;
	}
	//�޸Ĳ��֣�ֻ��ҳ����ص��������޸�
	$("#showTbl").queryTable(optin);
}

function f_exportExcel(){
	sumbitExportExcel("bbcrewardVerifiedExcel.do","content");
}

$(document).ready(function() { 
	//�󶨰�ť
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	
	//�����ļ�
	$("#btnExportExcel").click(f_exportExcel);

	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	//������������
	getMouthSelect($("#selMonth"),3);
	//ac
	cusAc($("#opnname"),$("#opnid"),{type:bbcoperation})	
	//<!-- ��ʾ�ڼ����˵����� -->
	//f_showMenu(4,2,1);
	//��ҳ��Ĭ�ϲ�ѯ
	doQuery();
});