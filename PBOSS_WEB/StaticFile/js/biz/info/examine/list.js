var doQuery = function() {
	//�޸Ĳ��֣�ֻ��ҳ����ص��������޸�
	var optin = {
		//showCols:showCols,//��ʾ��
		pageSize:3,//ҳ�ڴ�С
		//navigation:$("#navigation"),//��ҳλ�� jq����
		queryFrom: $("#frmQuery"),//��ѯ��
		unableBtu:$('#btnQuery'),
		//�Զ���������
		getTbaleFn:setTable,//��ȡ�����
		getTbodyFn:setBody
	};
	$("#showRtsl").queryTable(optin);
}

var setTable = function ($div,_optn){
	var shTable = $div.find("#showTbl");
	shTable.hide();
	$div.find("#markTbl").html("���ݼ�����...");
	$div.find("#markTbl").show();
	$div.show();
	//
	$div.find("#allMsg").hide();
	return shTable;
}
var setBody = function (jsonObjs,shTable,$div,jsonAllObj){
	var jsonSize = jsonObjs.length;
	if (jsonSize<1) {
		$div.find("#markTbl").html("û������!");
		return;
	}
	$div.find("#markTbl").hide();
	//��ȡ�ܷ�
	var allMark = jsonAllObj.allMark;
	var allMsgObj = $div.find("#allMsg");
	//allMsgObj.find("#msgValue").html(allMark);
	allMsgObj.show()
	//���ñ��
	//var showdtl = shTable.find("td")
	var showdtl = shTable;
	var newRow=null;
	showdtl.empty();
	for (var i=0;i< jsonSize;i++){
		newRow=null;
		var useObj = $("#datas").clone();
		useObj.css("float","left");
		//if (i < (jsonSize-1)) 
		//useObj.css("margin-right","8px");
		useObj.css("margin-bottom","5px");
		useObj.removeAttr("id");//ɾ��ID����,���������ȡ��ͻ
		useObj.show();
		useObj.appendTo(showdtl);
		//��������
		var useTrObj = useObj.find("#context");
		var firstTr = useObj.find("tr:first");//���ҵ�һ��
		firstTr.find("#exmnname").html("��������");
		firstTr.find("#exmnnameValue").html(jsonObjs[i].exmnname);
		
		firstTr.find("#exmnmark").html("�����ܷ�");
		firstTr.find("#exmnmarkValue").html(jsonObjs[i].exmnmark);
		var jsonDtlList = jsonObjs[i].dtlList;

		for (var j=0;j<jsonDtlList.length;j++){
			newRow = useTrObj.clone();
			newRow.show();
			newRow.find("#showName1").html(jsonDtlList[j].exmnstdname);
			newRow.find("#showValue1").html(jsonDtlList[j].exmnmark);
			//�޴�ʵ�ַ���
			j++;
			if (j<jsonDtlList.length){
				newRow.find("#showName2").html(jsonDtlList[j].exmnstdname);
				newRow.find("#showValue2").html(jsonDtlList[j].exmnmark);
			}
			j++;
			if (j<jsonDtlList.length){
				newRow.find("#showName3").html(jsonDtlList[j].exmnstdname);
				newRow.find("#showValue3").html(jsonDtlList[j].exmnmark);
			}
			j++;
			if (j<jsonDtlList.length){
				newRow.find("#showName4").html(jsonDtlList[j].exmnstdname);
				newRow.find("#showValue4").html(jsonDtlList[j].exmnmark);
			}
			newRow.appendTo(useObj);
		}//��ϸ����
		//ʹ���µķ���������ϸ


		useTrObj = null;
	}//for

	useObj = null,newRow =null;

	//debugger;	
	shTable.show();
}
$(document).ready(function() { 
	//<!-- ��ʾ�ڼ����˵����� -->
	//f_showMenu(5,0,0)
	//������������
	getMouthSelect($("#selMonth"),3);
	//Ĭ�ϲ鵱Ȼ��
	doQuery();
});