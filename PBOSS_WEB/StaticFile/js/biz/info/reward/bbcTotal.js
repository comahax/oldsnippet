//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="id"){
		rtn = "<a href=\"Load.do?user.id="+ oData +"\" >"+ oData +"</a>";
	}
	if(oColumnSet.key=="runtime"){
		rtn = handlerdate(oData, 1);
	}
	return rtn;
}


var doQuery = function() {
	//�޸Ĳ��֣�ֻ��ҳ����ص��������޸�
	if ($("#realrewardtype").val() == ""){
		alert("��ѡ��������");
		return;
	}
	$("#showTbl").queryTable(optin);
}

$(document).ready(function() { 
	//�󶨰�ť
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();

	$("#btnQuery").click(doQuery);
	$('#btnQuery').attr("disabled",false);
	//������������
	getMouthSelect($("#selMonth"),3);
	//ac
	cusAc($("#opnname"),$("#opnid"),{type:"${jqac.OPERATION}"})
	//<!-- ��ʾ�ڼ����˵����� -->
	//f_showMenu(4,2,2)
});