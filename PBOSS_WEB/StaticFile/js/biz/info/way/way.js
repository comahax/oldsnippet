//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="wayid"){
		var wayid = oRecord.wayid;
		if (wayid == "") {
			wayid="��ֵ";
		}
		rtn = "<a href=\"#\"><font color=\"#0000FF\">"+wayid+"</font></a>" ;
		elCell.bind('click',oRecord,function(event){
			var a = new Array(2);
			a[0] =event.data.wayid; 
			a[1] =event.data.wayname;
			window.returnValue = a[0]; 
			window.close();
		});
	return rtn;	
	}
	
	if(oColumnSet.key=="datas.noactActTime"){
		rtn = handlerdate(oData, 2);
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
	//ҳ��������ť
	queryBtn.attr("disabled",false);
	//��ҳ��Ĭ�ϲ�ѯ
	doQuery();
});