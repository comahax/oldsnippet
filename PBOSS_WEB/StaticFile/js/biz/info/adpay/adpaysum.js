//elCell - ��Ԫ�����(JQ),oRecord - ����Դ,oData - ԭ����,oColumnSet - ��ʾ�ж��� 
//@@����һ��Ҫ��ʹ��֮ǰ
var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="operation"){
		//rtn = '<input type="button" class="btn_blue" value="�鿴����" onclick="openDtl(\''+contextRootPath+'/adpay/detail.do?parameter.sumid='+oRecord.sumid+'\')" >\n';
		if(oRecord.state == "WAITSUBMIT"){
			rtn = '<input type="button" class="btn_blue" value="�ύ" onclick="f_submitState(\''+oRecord.state+'\','+oRecord.sumid+')" >';
		}			
		else if(oRecord.state == "CONFIRMED"){
			rtn = '<input type="button" class="btn_blue" value="֧��" onclick="f_submitState(\''+oRecord.state+'\','+oRecord.sumid+')" >';
		}else {
			//rtn = '<input type="button" class="btn_blue" value="�ύ" disabled="disabled">';
			rtn = "";
		}
	}else if(oColumnSet.key=="beginTime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="endTime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="submitTime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="confirmTime"){
		rtn = handlerdate(oData, 2);
	}else if(oColumnSet.key=="sumid"){
		rtn = "<a href=\"javascript:openDtl('"+ contextRootPath +"/adpay/detail.do?parameter.sumid="+ oData +"');\" >"+ oData +"</a>";
	}
	return rtn;
}
//���ˢ��֮��
var successFncn = function(jsonObj){
	if (jsonObj.datas.length > 0){
		setMdfBtn(false);//�ָ�����
	}
	changeStyle();
}

var openDtl=function(url){
	openDlg(url,"���ʵ���ϸ",800,500,true);
};

var doQuery = function() {
	if($("#sumid").val()!=""){
		if(isNaN($("#sumid").val())){
			f_showEMsg("���ʻ��ܵ��ű���Ϊ����");
			$("#sumid").val("");
			return ;
		}
		if($("#sumid").val().indexOf(".")>-1){
			f_showEMsg("���ʻ��ܵ��ű���Ϊ����");
			$("#sumid").val("");
			return ;
		}
	}
	setMdfBtn(true);//���ΰ�ť
	$("#showTbl").queryTable(optin);
}

$(document).ready(function() { 
	var queryBtn = $("#btnQuery");
	queryBtn.click(doQuery);
	$("#btnExport").click(f_exportExcel);
	//������������
	initDate("createTimeFrom");
	initDate("createTimeTo");
	doQuery();
});

var changeStyle = function(){
	$('#showTbl .btn_blue').hover(function() {
		this.className='btn_blue_02';
	}, function() {
		this.className='btn_blue';
	});
}

//�޸İ�ť������
var setMdfBtn = function(setBln){
	$("#btnQuery").attr("disabled",setBln);//���ΰ�ť
}

function f_submitState(stateValue,sumidValue){
	if("WAITSUBMIT"==stateValue || "CONFIRMED"==stateValue){
		var _o_li = f_showPlan("�����У����Ժ�");
		var successFunction = function(msg){
			if(msg.retCode>100){
				_o_li.close();
				//f_showEMsg("�û��ܵ����ǡ����ύ״̬������ȷ��״̬��!");//"�û��ܵ����ǡ����ύ״̬��!"
				f_showEMsg(msg.message);
				return;
			}else if(msg.isSuccess){
				_o_li.close();
				alert("�����ɹ�");//"�ύ�ɹ�"
				doQuery();
				return;
			}else{
				f_showEMsg("ϵͳæ�����Ժ�����!");
			}
		}
		$.ajax({
	   type:"POST",
	   url:"ajaxSubmit.do",
	   data:{"parameter.sumid":sumidValue,"parameter.state":stateValue},
	   dataType:"json",
	   success:successFunction
		});
	}
}

function f_exportExcel(){
	if($("#sumid").val()!=""){
		if(isNaN($("#sumid").val())){
			f_showEMsg("���ʻ��ܵ��ű���Ϊ����");
			$("#sumid").val("");
			return ;
		}
		if($("#sumid").val().indexOf(".")>-1){
			f_showEMsg("���ʻ��ܵ��ű���Ϊ����");
			$("#sumid").val("");
			return ;
		}
	}
	sumbitExportExcel("exportExcel.do","content");
}