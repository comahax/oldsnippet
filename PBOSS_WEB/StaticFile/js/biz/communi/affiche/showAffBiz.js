
//�����������
var optin = {
	showCols:showCols,//��ʾ��
	pageSize:5,//ҳ�ڴ�С
	fmtLink:fmtLink,
	navigation:$("#navigation"),//��ҳλ�� jq����
	width:"100%",
	showTable:false,
	queryFrom: $("#queryReply")//��ѯ��
};

function doQuery(){
	$("#showTbl").queryTable(optin);
}

$(document).ready(function() {
	doQuery();
});

var _o_li = null;
var doReply=function(){
	if($.trim($("#replyContent").val())==""){
		f_showEMsg("�ظ�����Ϊ�����");
		return;
	}
	$('#saveFrm').attr("action","reply.do");
	_o_li = f_showPlan("�����У����Ժ�");
	var a = {dataType:'json',success:ReplyHandleResponse};
	$('#saveFrm').ajaxSubmit(a);
}

var doRead=function(){
	$('#saveFrm').attr("action","read.do");
	_o_li = f_showPlan("�����У����Ժ�");
	var a = {dataType:'json',success:ReadHandleResponse};
	$('#saveFrm').ajaxSubmit(a);
}

function ReplyHandleResponse(json){
	if(!json.isSuccess){
		if(_o_li != null)
			_o_li.close();
		f_showMsg(json.message);
	}
	else{
		_o_li.close();
		$("#replyContent").val("");
		doQuery();
	}
}

function ReadHandleResponse(json){
	if(!json.isSuccess){
		if(_o_li != null)
			_o_li.close();
		f_showMsg(json.message);
	}
	else{
		_o_li.close();
		window.parent.closePage();
	}
}