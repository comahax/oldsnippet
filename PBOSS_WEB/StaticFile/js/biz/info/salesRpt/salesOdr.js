//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="orderid"){
		rtn = "<a href=\"javascript:openDtl('"+ contextRootPath +"/salesOrder/detail.do?orderid="+ oData +"');\" >"+ oData +"</a>";
	}else if(oColumnSet.key=="createtime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="recamt" || oColumnSet.key=="actamt"){
		rtn = oData + 'Ԫ';
	}
	return rtn;
}

var openDtl=function(url){
	openDlg(url,"������ϸ",800,600,true);
};

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
	//f_showMenu(3,2,0)
	//ҳ��������ť
	queryBtn.attr("disabled",false);
	
	//��ҳ��Ĭ�ϲ�ѯ
	doQuery();
});

var plsQuery=false;

//�Ӵ��ڹر�ʱ�����ò�ѯ
function closePage(){//�ر�
	//submitDlg.hide();
	submitDlg.close();
	if (plsQuery){		
		doQuery();
	}
}
