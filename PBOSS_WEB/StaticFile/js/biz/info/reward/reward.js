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
//ȥ���ַ������˵Ŀո�
function trim(str){   
    return str.replace(/^(\s|\u00A0)+/,'').replace(/(\s|\u00A0)+$/,'');   
}

var doQuery = function() {
	/*//��֤����
	if ($("#opnname").val() == ""){
		alert("������ҵ������!");
		return;
	}
	/*��֤�ֻ�
	var oprMobile = $("#opermobile").val();
	if (oprMobile != ""){
		if (!f_isMobile(oprMobile)){
			alert("��Ա�ֻ���ֻ�����ƶ��ֻ�����!");
			return;
		}
	}
	* */
	var opnname = f_getValueById('opnname');
	opnname=trim(opnname);
	if (opnname==null||opnname==''){
		f_setValueById('opnid',"");
	}
	$("#showTbl").queryTable(optin);
}

var doExportExcel = function(){
	sumbitExportExcel(contextRootPath+"/reward/exportExcel.do","content");
}

//���ݡ�������ࡱ��ѡ����ת��Ӧ����
var changeView = function(){
	var rewardType = f_getValueById('wayType');
	if(rewardType==1){
		window.location = '/reward/rewardRecordQuery.do';
	}
	else if(rewardType==2){
		//window.location = '/reward/bbcrewardRecord.do?wayType='+rewardType;
		window.location = '/reward/bbcrewardRecord.do';
	}
	else{
		window.location = '/reward/bbcrewardRecordUNPB.do';
	}
}

$(document).ready(function() { 
	//�󶨰�ť
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();

	$("#btnQuery").click(doQuery);
	$("#btnExportExcel").click(doExportExcel);
	$('#btnQuery').attr("disabled",false);
	//������������
	getMouthSelect($("#selMonth"),3);
	//ac
	cusAc($("#opnname"),$("#opnid"),{type:jaacOPERATION})
	//<!-- ��ʾ�ڼ����˵����� -->
	//f_showMenu(4,2,1);
	$("#showTbl").queryTable(optin);
});