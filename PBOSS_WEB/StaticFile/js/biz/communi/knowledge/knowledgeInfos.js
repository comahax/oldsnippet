//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key == "title"){
		rtn = "<a href=\"javascript:f_openDetl('"+ contextRootPath +"/communi/showKnowledge.do?parameter.advinfoid="+
		 oRecord.advinfoid +"&parameter.type="+$("#advType").val()+"','֪ʶ��');\" >"+ oData +"</a>";
	}
	if(oColumnSet.key=="releasetime"){
		rtn = handlerdate(oData, 1);
	}
	return rtn;
}

var doQuery = function() {
	$("#showTbl").queryTable(optin);
}

$(document).ready(function() { 
	//�󶨰�ť
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);
	//���ڿؼ�
	initDate("selStartDate");
	initDate("selAccountDate");
	//f_showMenu(1,1,1)
	//ҳ��������ť
	queryBtn.attr("disabled",false);
	//��ҳ��Ĭ�ϲ�ѯ
	doQuery();
});