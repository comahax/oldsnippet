var _o_li = null;
var doSubmit=function(){
	if($.trim($("#title").val())==""){
		f_showEMsg("����Ϊ�����");
		return;
	}
	if($.trim($("#content").val())==""){
		f_showEMsg("����Ϊ�����");
		return;
	}
	_o_li = f_showPlan("�����У����Ժ�");
	var a = {dataType:'json',success:handleResponse};
	$('#saveFrm').ajaxSubmit(a);
}

function handleResponse(json){
	if(!json.isSuccess){
		if(_o_li != null)
			_o_li.close();
		f_showMsg(json.message);
	}
	else
		f_jumpToURL(json.rtnObject);
}

$(document).ready(function() {
	$("#btnSave").bind("click",doSubmit); 

});