//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
//	if(oColumnSet.key=="id"){
//		//rtn = "<a href=\"Load.do?user.id="+ oData +"\" >"+ oData +"</a>";
//	}
	if(oColumnSet.key=="createtime"){
		rtn = handlerdate(oData, 2);
	}
	return rtn;
}

var doQuery = function() {
	//��֤����
//	if ($("#opnname").val() == ""){
//		alert("������ҵ������!");
//		return;
//	}
//	//��֤�ֻ�
//	var oprMobile = $("#mobile").val();
//	if (oprMobile != ""){
//		if (!f_isMobile(oprMobile)){
//			alert("��Ա�ֻ���ֻ�����ƶ��ֻ�����!");
//			return;
//		}
//	}

	//��֤�ֻ�
	var oprMobile = $("#mobile").val();
	if (oprMobile != ""){
		if (!$.Validation.fIsNumeric(oprMobile)){
			alert("�׿�/��ֵ������ֻ��������!");
			return;
		}
	}

	$("#showTbl").queryTable(optin);
}

$(document).ready(function() { 
	//�󶨰�ť
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);
	//������������
//	getMouthSelect($("#selMonth"),3,true);
	getMouthSelect($("#selMonth"),3,true);
	//<!-- ��ʾ�ڼ����˵����� -->
	//f_showMenu(3,1,0)
	//ҳ��������ť
	queryBtn.attr("disabled",false);
	
	//��ҳ��Ĭ�ϲ�ѯ
	doQuery();
});