//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var sPaln = null;
var chkRadix=-1;//��������
var fmtLink = function(elCell, oRecord, oData,oColumnSet) {
	var rtn = oData;
	var o = oRecord.batchNo;
	if(oColumnSet.key=="addCar"){
		//���ڲ�ѯ��ֻ������ź����κ�
		//saveGoods.id=oRecord.id&saveGoods.name=oRecord.name&saveGoods.comType=oRecord&saveGoods.orderCount=oRecord
		rtn = '<SPAN id="link_'+ oRecord.id +"-"+oRecord.name +'" style="display:'+ (oRecord.inCar?'none':'block')  +'"><a href="#shopping" onclick="doAdd(\''+oRecord.id+'\',\''+oRecord.name+'\',\''+oRecord.comType+'\',\''+oRecord.orderCount
			+'\')"><img src="/images/shopping.jpg" alt="���빺�ﳵ" border="0"></a></span>';
		rtn += '<SPAN id="linked_'+ oRecord.id +"-"+oRecord.name +'" style="display:'+ (oRecord.inCar?'block':'none')  +'"><img src="/images/shopping.jpg" alt="�����ظ��ӵ����ﳵ" border="0"></span>';
	}
	if(oColumnSet.key=="type"){
		//������
		rtn = '<SPAN id="type_'+ oRecord.id +"-"+oRecord.name +'"'+ (oRecord.inCar?' class="red_01"':'') +'>' + oData +'</SPAN>'
	}
	if (oColumnSet.key=="name"){
		//����
		rtn = '<SPAN id="name_'+ oRecord.id +"-"+oRecord.name +'"'+ (oRecord.inCar?' class="red_01"':'') +'>' + oData +'</SPAN>'
	}
	return rtn;
}
var querySuccees = function(josnObj){
	if (josnObj["isSuccess"]){
		$('#showTips').show();
	}
}

var openDtl=function(url){
	openDlg(url,"��Ʒ��ϸ",600,400,true);
};
//���ò�ѯ
var doQuery = function() {
	if (!canOrder) return;
	//��֤ѡ��
	if ($("#comType").val() == ""){
		alert("��ѡ����Ʒ����!");
		$("#comType").focus();
		return;
	}
	optin.succeesFn = querySuccees;
	var qorderCount= $("#orderCount").val();
	if (chkOrderCount(qorderCount)) 
		$("#showTbl").queryTable(optin);
	else
		 $("#orderCount").focus();
};

var chkOrderCount = function(qorderCount){
	if (qorderCount == ''){
		alert("��������ֻ�������֣�")
		return false;
	}
	if(!$.Validation.fIsAllNumeric(qorderCount)){
		alert("��������ֻ�������֣�")
		return false;
	}
	if (chkRadix>0){
		if (qorderCount%chkRadix!=0){
			alert("��������ֻ����"+ chkRadix +"�ı�����")
			return false;
		}
	};

	return true;
}
var setToTable = function(datas,stats){
		var setTbl = $("#showGoodsDtls");
		var setObj = $("#setDtls tr");
		setTbl.empty();
		for (var i =0; i<datas.length; i++){
			var good = datas[i];
			var row = setObj.clone();
			row.find("#showGdsType").html(good.type);
			row.find("#showGdsId").html('<a href="javascript:openDtl(\''+ contextRootPath
				+'/goods/goodsDetail.do?carKey='+ good.key +'\');" >'+good.name+'</a>');
			row.find("#showOrderCount").html(good.orderCount);
			var imgObj = row.find("#showGdsImg")
			var imgHtml = imgObj.html();
			while(imgHtml.indexOf("$[key]")>-1){
				imgHtml = imgHtml.replace("$[key]", good.key);
			}
			while(imgHtml.indexOf("$[id]")>-1){
				imgHtml = imgHtml.replace("$[id]", good.id);
			}
			while(imgHtml.indexOf("$[packageNo]")>-1){
				imgHtml = imgHtml.replace("$[packageNo]", good.name);
			}
			imgObj.html(imgHtml);
			//��ӵ������
			row.appendTo(setTbl);
		}//for
		setTbl.show();
		
		var setStatTbl = $("#setGoodsStats");
		var setStatObj = $("#setStatsData tr");
		setStatTbl.empty();
		var allPckgCnt=0,allDtlCnt=0;
		for (var i =0; i<stats.length; i++){
			var stat = stats[i];
			var row = setStatObj.clone();
			row.find("#showType").html(stat.type + '��');
			row.find("#showDesc").html('<font class="red_01">'+ stat.pckgCnt  +'</font>����<font class="red_01">'+ stat.dtlCnt +'</font>�ף�');
			allPckgCnt += stat.pckgCnt;
			allDtlCnt += stat.dtlCnt;
			//��ӵ������
			row.appendTo(setStatTbl);
		}//for
		if (stats.length>0){
			var row = setStatObj.clone();
			row.find("#showType").html('����ѡ���ˣ�');
			row.find("#showDesc").html('<font class="red_01">'+ allPckgCnt +'</font>����<font class="red_01">'+ allDtlCnt +'</font>�ף�');
			//��ӵ������
			row.appendTo(setStatTbl);
		}
		setStatTbl.show();
}
var setMarkResoure = function(action,id,packageNo){
	//�������κ�
	//debugger;
	var type = $("#type_"+id+"-"+packageNo);
	var name = $("#name_"+id+"-"+packageNo);
	var link = $("#link_"+id+"-"+packageNo);
	var linked = $("#linked_"+id+"-"+packageNo);
	var sClass = "";
	if (action == 'add'){
		sClass = "red_01";
	}
	if (type.length>0){
		//������λ��
		type[0].className = sClass;
	}
	if (name.length>0){
		//����λ��
		name[0].className = sClass;
	}
	//���ӵ����ﳵͼ��
	if (action == 'add'){
		link.hide();
		linked.show();
	}else{
		link.show();
		linked.hide();
	}

};
var doAjax = function(url,action,id,name){
	$.ajax({
		type: "POST",	//�ύ��ʽ
		url:url ,
		cache: false,		//��ʹ��IE����
		dataType: "json",	
		success: function(json){
			if (json["isSuccess"]){
				var datas = json["datas"];
				var stats = json["stats"];
				setToTable(datas,stats);
				setMarkResoure(action,id,name);
			}else{
				alert(json.message);
			}
			if (sPaln != null){
				sPaln.close();
			}
		}
	});
}
//�ӵ����ﳵ��
//batchNo - ���κţ�id��,packageNo - ���ţ�name��,comType,orderCount
var doAdd = function(batchNo,packageNo,comType,orderCount){
//	addGoods.do?saveGoods.id='+ oRecord.id +'&saveGoods.name='+ oRecord.name+'&saveGoods.comType='+ oRecord.comType +'&saveGoods.orderCount=
//	$.getJSON('addGoods.do?saveGoods.id='+batchNo+'&saveGoods.name='+ packageNo +'&saveGoods.comType='+ comType +'&saveGoods.orderCount='+ orderCount, 
//		function(json){
//	  alert('dd');
//	});

	if (!canOrder) return;
	sPaln = f_showPlan("���ڴ����У����Ժ�");
	doAjax('addGoods.do?saveGoods.id='+batchNo+'&saveGoods.name='+ packageNo +'&saveGoods.comType='+ comType +'&saveGoods.orderCount='+ orderCount,
		'add',batchNo,packageNo);
}
var doDel = function(key,id,packageNo){
	
	if (!canOrder) return;
	sPaln = f_showPlan("���ڴ����У����Ժ�");
	doAjax('delGoods.do?saveGoods.key='+key,'del',id,packageNo);
}

var doSumnit = function(){
	if (!canOrder) return;
	var carAll = $("#showGoodsDtls tr").length;
	if (carAll<1){
		f_showEMsg("���ﳵ����Ϊ�գ�");
		return;
	}
	sPaln = f_showPlan("���ڴ����У����Ժ�");
	window.location='submit.do';
}

var doGoodsPriceRadix = function(){
	if (!canOrder) return;
	var selComType = $("#comType");
	var qBtn = $("#btnQuery");
	var aBtn = $("#btnAddToCar");
	var qTxt = $("#orderCount");
	selComType.attr("disabled",true);
	qBtn.attr("disabled",true);
	aBtn.attr("disabled",true);
	qTxt.attr("disabled",true);
	var selComTypeVal = selComType.val();
	//@@ ����
	//qTxt.val('');

	if (selComTypeVal && selComTypeVal!='' ){
		$('#comTypeDscrp').html('��ѯ�У����Ե�...');
		//@@ δ���ϻ��洦��
		//ajax����
		$.ajax({
			type: "POST",	//�ύ��ʽ
			url:'getPriceRadix.do?comType='+selComTypeVal ,//���ص�ַ
			cache: false,		//��ʹ��IE����
			dataType: "json",	
			success: function(json){
				if (json["isSuccess"]){
					var goodsInfo = json["rtnObject"];
					var str = '���ۣ�<font class="red_01">'+ goodsInfo.price +'</font>Ԫ��';
					if (goodsInfo.radix >0){
						str += '��������������<font class="red_01">'+ goodsInfo.radix +'</font>�ı�����';
					}//if
					$('#comTypeDscrp').html("��"+ str +"��");
					chkRadix=goodsInfo.radix ;//���ü�����
					if (isQuery){
						if (goodsInfo.comrescard){//��ֵ��ʱ����ȥ�飬ֱ����
							$("#queryDiv").hide();
							$("#addDiv").show();
						}else{
							//�ǳ�ֵ��ʱ
							$("#queryDiv").show();
							$("#addDiv").hide();
						}
					}//if
					qBtn.attr("disabled",false);
					aBtn.attr("disabled",false);
					qTxt.attr("disabled",false);
				}else{
					$('#comTypeDscrp').html('����ѡ����Ʒ����!��');
					alert(json.message);
				}
			}
		});//ajax
	}	
	qTxt.val('');
	selComType.attr("disabled",false);
}
var doAddToCar = function(){
	if (!canOrder) return;
	var comType = $("#comType").val();
	//��֤ѡ��
	if (comType == ""){
		alert("��ѡ����Ʒ����!");
		$("#comType").focus();
		return;
	}
	
	var qorderCount= $("#orderCount").val();

	if (chkOrderCount(qorderCount)){
		sPaln = f_showPlan("���ڴ����У����Ժ�");//��ʾ��ʾ��
		doAjax('addGoods.do?saveGoods.comType='+ comType +'&saveGoods.orderCount='+ qorderCount);	
	} 

}
//ҳ���ʼ�����ʱ����
$(document).ready(function() {
	//f_showMenu(1,0,0);
	//��ʾ���
	dTable = getTable($("#showTbl"),optin);
	var _tBodyMark = dTable.find("#jqTblBodyMark tr td");
	_tBodyMark.hide();

	//�󶨰�ť
	$("#btnQuery").click(doQuery);
	$("#btnAddToCar").click(doAddToCar);//���Ӱ�ť
	$("#comType").change(doGoodsPriceRadix);
});